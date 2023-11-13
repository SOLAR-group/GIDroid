package gin.util;

import gin.test.AndroidTestFileParser;
import gin.test.AndroidTestResult;
import gin.test.UnitTest;
import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.gradle.internal.impldep.org.apache.commons.lang.StringUtils;
import org.gradle.internal.impldep.org.apache.commons.lang.SystemUtils;
import org.gradle.tooling.*;
import org.gradle.tooling.model.idea.IdeaContentRoot;
import org.gradle.tooling.model.idea.IdeaModule;
import org.gradle.tooling.model.idea.IdeaProject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.pmw.tinylog.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.*;

public class AndroidProject extends Project {
    private final String gradleVersion = null;
    private List<File> unitTestSourceDirs;
    public List<AndroidTest> unitTests;

    private final String testNames;
    private final String perfTestNames;
    public String flavour;
    public String module;

    public AndroidProject(AndroidConfig config) {
        super(new File(config.getAppPath()), config.getAppName());
        this.testNames = config.getTests();
        this.perfTestNames = config.getPerfTests();
        this.flavour = config.getFlavour();
        this.module = config.getModule();
        if (this.module == null) {
            this.module = "app";
        }
        pruneDirs();
        generateTestSet();
    }


    @Override
    protected void detectDirs() {
        //initialise file lists
        mainSourceDirs = new LinkedList<>();
        unitTestSourceDirs = new LinkedList<>();
        GradleConnector connector = GradleConnector.newConnector().forProjectDirectory(projectDir);

        if (gradleVersion != null) {
            connector.useGradleVersion(gradleVersion);
        }

        // Source Directories
        ProjectConnection connection = connector.connect();
        IdeaProject project = connection.getModel(IdeaProject.class);
        ArrayList<File> moduleDirs = new ArrayList<>();
        for (IdeaModule module : project.getModules()) {
            for (IdeaContentRoot root : module.getContentRoots()) {
                moduleDirs.add(root.getRootDirectory());
            }
        }
        //remove main directory
        ArrayList<File> toRemove = new ArrayList<>();
        for (File modDir1 : moduleDirs) {
            for (File modDir2 : moduleDirs) {
                try {
                    if (FileUtils.directoryContains(modDir1, modDir2)) {
                        toRemove.add(modDir1);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
        for (File modDir : toRemove) {
            moduleDirs.remove(modDir);
        }
        this.moduleDirs = moduleDirs;
        for (File modDir : moduleDirs) {
            try {
                File src = FileUtils.getFile(modDir, "src");
                searchDir(src);
            } catch (IllegalArgumentException e) {
            }
        }
        try {
            File src = FileUtils.getFile("src");
            searchDir(src);
        } catch (IllegalArgumentException e) {
        }

    }

    private void pruneDirs() {
        List<File> keep = new ArrayList<>();
        for (File dir : unitTestSourceDirs) {
            if (dir.getAbsolutePath().contains("/" + module + "/") || dir.getAbsolutePath().contains("\\" + module + "\\") || module.equals("")) {
                keep.add(dir);
            }
        }
        unitTestSourceDirs = keep;
    }

    private void searchDir(File dir) {
        //Find test directories
        String[] EXTENSIONS = {"java", "kt"};
        for (File child : FileUtils.listFiles(dir, EXTENSIONS, true)) {
            File parent = child.getParentFile();
            if (child.getAbsolutePath().contains("test")) {
                if (!unitTestSourceDirs.contains(parent)) {
                    unitTestSourceDirs.add(parent);
                }
            }
        }
    }

    public List<File> getUnitTestSourceDirs() {
        return unitTestSourceDirs;
    }


    @Override
    protected Set<UnitTest> parseGradleTestReportForModule(File moduleDir) {
        Path relativeModulePath = projectDir.toPath().relativize(moduleDir.toPath());
        String moduleName = relativeModulePath.toString();

        Set<UnitTest> tests = new HashSet<>();

        File buildDir = new File(moduleDir, "build");
        File reportsDir = new File(buildDir, "reports");
        File testsDir = new File(reportsDir, "tests");
        File[] flavDirs = testsDir.listFiles();
        if (flavDirs != null) {

            for (File flavDir : flavDirs) {
                File classesDir = new File(flavDir, "classes");
                File[] classesFiles = classesDir.listFiles();

                if (classesFiles != null) {

                    for (File classFile : classesFiles) {
                        // Get classname from filename
                        // Format: package.Class[$InternalClass].html

                        String className = StringUtils.substringBefore(classFile.getName(), ".html");
                        String innerClassName = "";

                        if (className.contains("$")) {
                            innerClassName = StringUtils.substringAfter(className, "$");
                            className = StringUtils.substringBefore(className, "$");
                        }

                        Document doc = null;

                        try {
                            doc = Jsoup.parse(classFile, "UTF-8", "");
                        } catch (IOException e) {
                            Logger.error("Error opening test report file: " + classFile.getAbsolutePath());
                            System.exit(-1);
                        }

                        // Test method names are in the third table in the document
                        // Tables have a header and then the test name is the first item in each row.
                        Elements tables = doc.getElementsByTag("table");
                        Element testTable = tables.get(2);
                        Elements testRows = testTable.getElementsByTag("tr");
                        boolean header = true;
                        for (Element testRow : testRows) {
                            if (header) {
                                header = false;
                            } else {

                                Elements rowEntries = testRow.getElementsByTag("td");
                                Element methodNameEntry = rowEntries.first();
                                String testMethodName = methodNameEntry.text();
                                UnitTest test;
                                if (innerClassName.isEmpty()) {
                                    test = new UnitTest(className, testMethodName, moduleName);
                                } else {
                                    test = new UnitTest(className + '$' + innerClassName, testMethodName, moduleName);
                                }

                                Boolean success = rowEntries.get(2).text().equals("passed");
                                if (!success) {
                                    Logger.warn("Excluding ignored or failed test case: " + test);
                                } else {
                                    tests.add(test);
                                }
                            }
                        }
                    }
                }
            }
        }
        return tests;
    }

    public static String SepWrap(String str) {
        return File.separator + str + File.separator;
    }


    public int buildApp() {
        String task = "assemble" + flavour + "Debug";
        String cmd = gradleCmdForTask(task);
        System.out.println(cmd);
        try {
            ProcessBuilder pb = new ProcessBuilder(cmd.split(" "));
            pb.directory(projectDir);
            pb.environment().putAll(System.getenv());
            pb.inheritIO();
            Process p = pb.start();
            p.waitFor();
            return p.exitValue();
        } catch (IOException | InterruptedException e) {
            System.out.println("Failed to build app");
            e.printStackTrace();
            System.exit(1);
        }
        return 1;
    }


    public void generateTestSet() {
        unitTests = new ArrayList<>();
        ArrayList<String> tests = new ArrayList<>();
        if (testNames != null) {
            for (String testName : testNames.split(",")) {
                tests.add(testName);
            }
        }
        ArrayList<String> perfTests = new ArrayList<>();
        if (perfTestNames != null) {
            System.out.println(perfTestNames);
            for (String testName : perfTestNames.split(",")) {
                perfTests.add(testName);
            }
        }
        ArrayList<String> testClasses = new ArrayList<>();
        for (String test : tests) {
            String testClass = test.split("\\.")[0];
            if (!testClasses.contains(testClass)) {
                testClasses.add(testClass);
            }
        }
        for (String test : perfTests) {
            String testClass = test.split("\\.")[0];
            if (!testClasses.contains(testClass)) {
                testClasses.add(testClass);
            }
        }

        //get local tests
        for (File testDir : unitTestSourceDirs) {
            for (File testFile : testDir.listFiles()) {
                if (testFile.isFile()) {
                    String name = testFile.getName().replace(".java", "").replace(".kt", "");
                    if (!testClasses.contains(name)) {
                        continue;
                    }
                    for (AndroidTest test : getTestsFromFile(testFile, tests)) {
                        unitTests.add(test);
                    }
                    for (AndroidTest test : getTestsFromFile(testFile, perfTests)) {
                        test.setPerformance(true);
                        unitTests.add(test);
                    }
                }
            }
        }
    }

    public ArrayList<AndroidTest> getAllLocalTests() {
        ArrayList<AndroidTest> unitTestsOut = new ArrayList<>();
        for (File testDir : unitTestSourceDirs) {
            for (File testFile : testDir.listFiles()) {
                if (testFile.isFile()) {
                    for (AndroidTest test : AndroidTestFileParser.parseFile(testFile)) {
                        unitTestsOut.add(test);
                    }
                }
            }
        }
        return unitTestsOut;
    }


    public ArrayList<AndroidTest> getTestsFromFile(File testFile, ArrayList<String> tests) {
        ArrayList<AndroidTest> out = new ArrayList<>();
        ArrayList<String> testClasses = new ArrayList<>();
        //get all test class names
        for (String test : tests) {
            String testClass = test.split("\\.")[0];
            if (!testClasses.contains(testClass)) {
                testClasses.add(testClass);
            }
        }
        if (testFile.isFile()) {
            //check if file is relevant
            String name = testFile.getName().replace(".java", "").replace(".kt", "");

            if (!testClasses.contains(name) || testClasses.contains("*")) {
                return new ArrayList<>();
            }
            //get all desired method names
            ArrayList<String> methodNames = new ArrayList<>();
            for (String test : tests) {
                if (name.equals(test.split("\\.")[0])) {
                    String methodName = test.split("\\.")[1];
                    methodNames.add(methodName);
                    System.out.println(methodName);
                }
            }
            //get all tests in file
            ArrayList<AndroidTest> testsForFile = (ArrayList<AndroidTest>) AndroidTestFileParser.parseFile(testFile);
            //wildcard
            if (methodNames.contains("*")) {
                return testsForFile;
            }
            //check for relevant tests
            for (AndroidTest test : testsForFile) {
                if (methodNames.contains(test.getMethodName())) {
                    if (!out.contains(test)) {
                        out.add(test);
                    }
                }
            }
        }
        return out;
    }

    @Override
    public void runUnitTestGradle(UnitTest test, String args) {

        File connectionDir = projectDir;

        if (!test.getModuleName().isEmpty()) {
            connectionDir = new File(projectDir, test.getModuleName());
        }

        GradleConnector connector = GradleConnector.newConnector().forProjectDirectory(connectionDir);

        ProjectConnection connection = connector.connect();

        TestLauncher testLauncher = connection.newTestLauncher();

        Map<String, String> variables = new HashMap<>();
        variables.put("JAVA_TOOL_OPTIONS", args);

        // Workaround for inner classes, see https://github.com/gradle/gradle/issues/5763
        if (test.getInnerClassName().isEmpty()) {
            testLauncher.withJvmTestClasses(test.getTopClassName());
        } else {
            testLauncher.withJvmTestClasses(test.getTopClassName() + "*");
        }

        testLauncher.withJvmTestMethods(test.getMethodName());

        testLauncher.setEnvironmentVariables(variables);

        try {
            testLauncher.run();
        } catch (TestExecutionException exception) {
            Logger.error("TestExecutionException from gradle test launcher");
            Logger.error("Message: " + exception.getMessage());
            Logger.error("Cause: " + exception.getCause());
            System.exit(-1);
        } catch (BuildException exception) {
            Logger.error("BuildException from from gradle test launcher");
            Logger.error("Message: " + exception.getMessage());
            Logger.error("Cause: " + exception.getCause());
            System.exit(-1);
        }

        connection.close();

    }

    public void killDaemon() {
        String command = gradleCmdForTask("--stop");
        try {
            Process testRun = Runtime.getRuntime().exec(command, null, getProjectDir());
            testRun.waitFor();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public String gradleCmdForTask(String task) {
        String cmd;
        if (SystemUtils.IS_OS_LINUX) {
            cmd = "./gradlew " + task;
        } else {
            cmd = projectDir.getAbsolutePath() + "\\gradlew.bat " + task;

        }
        return cmd;
    }


    public int coverageTask() {
        String task = module + ":create" + flavour + "DebugAndroidTestCoverageReport";
        String cmd = gradleCmdForTask(task);
        System.out.println("Running command: " + cmd);
        try {
            ProcessBuilder pb = new ProcessBuilder(cmd.split(" "));
            pb.directory(projectDir);
            pb.environment().putAll(System.getenv());
            pb.inheritIO();
            Process p = pb.start();
            p.waitFor();
            killDaemon();
            return p.exitValue();


        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return 1;
    }


    public int localCoverageTask() {
        String task = "jacocoTestReport" + flavour + "Debug";
        String cmd = gradleCmdForTask(task);
        System.out.println("Running command: " + cmd);
        try {
            ProcessBuilder pb = new ProcessBuilder(cmd.split(" "));
            pb.directory(projectDir);
            pb.environment().putAll(System.getenv());
            pb.inheritIO();
            Process p = pb.start();
            p.waitFor();
            killDaemon();
            return p.exitValue();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return 1;
    }

    public int runLocaltest(AndroidTest test) {
        String cmd = ":" + module + ":test" + flavour + "DebugUnitTest --tests ";
        cmd += test.getFullClassName() + "." + test.getMethodName();
        cmd = gradleCmdForTask(cmd);
        System.out.println("Running command: " + cmd);
        try {
            ProcessBuilder pb = new ProcessBuilder(cmd.split(" "));
            pb.directory(projectDir);
            pb.environment().putAll(System.getenv());
            pb.inheritIO();
            Process p = pb.start();
            p.waitFor();
            return p.exitValue();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return 1;
    }

    public String getClasspath() {
        if (! SystemUtils.IS_OS_LINUX) {
            return  "";
        }
        String cmd = gradleCmdForTask("classpath");
        System.out.println(cmd);
        try {
            ProcessBuilder pb = new ProcessBuilder(cmd.split(" "));
            pb.directory(projectDir);
            pb.environment().putAll(System.getenv());
            Process p = pb.start();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            boolean ready = false;
            while ((line = reader.readLine()) != null) {
                if (ready) {
                    p.destroy();
                    return line;
                }
                if (line.contains("classpath:")) {
                    ready = true;
                }
            }
            return "";
        } catch (IOException e) {
            System.out.println("Failed to get classpath");
            e.printStackTrace();
            System.exit(1);
        }
        return "";
    }

    public AndroidTestResult runLocalTests(ArrayList<AndroidTest> tests, int runs) {

        if (tests.size() == 0) {
            AndroidTestResult res = new AndroidTestResult(new AndroidTest("", "", "", ""), 0);
            res.setPassed(true);
            return res;
        }
        AndroidTestResult result = new AndroidTestResult(new AndroidTest("", "", "", ""), 0);
        result.setPassed(true);
        result.setCPUTime(0);
        result.setNetworkUsed(0);
        result.setExecutionMemory(0);
        String testList = "";
        for (AndroidTest test : tests) {
            if (test.isPerformance()) {
                testList = testList + " --tests " + test.getFullClassName() + "." + test.getMethodName();
            }
        }
        String cmd = ":" + module + ":test" + flavour + "DebugUnitTest" + testList + " -a";
        cmd = gradleCmdForTask(cmd);
        //cmd = "time " + cmd;
        System.out.println("Running command: " + cmd);
        DescriptiveStatistics netSamples = new DescriptiveStatistics();
        DescriptiveStatistics memSamples = new DescriptiveStatistics();
        DescriptiveStatistics timeSamples = new DescriptiveStatistics();

        try {
            for (int i = 0; i < runs; i++) {

                //long netBefore = getNetworkUsed();
                ProcessBuilder pb = new ProcessBuilder(cmd.split(" "));
                pb.directory(projectDir);
                pb.environment().putAll(System.getenv());
                pb.redirectErrorStream(true);
                Process p = pb.start();

//                BufferedReader in = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                BufferedReader stdin = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line = "";
                long pid = p.pid();
                String lines = "";
                boolean inTime = false;
                Double userTime = Double.MAX_VALUE;
                Double systemTime = Double.MAX_VALUE;
                long memory = Long.MAX_VALUE;
                Long netUsed = 0l;
                System.out.print("test PID: ");

                System.out.println(pid);
                memory = 0;

//                memorySampler.setProcId(Long.valueOf(pid));
//                memorySampler.start();
                while ((line = stdin.readLine()) != null) {
                    System.out.println(line);
                    if (line.contains("system") && line.contains("user")) {
                        String[] tokens = line.split(" ");
                        userTime = Double.valueOf(tokens[0].replace("user", ""));
                        systemTime = Double.valueOf(tokens[1].replace("system", ""));
                    }
                    if (line.contains("Gin Memory: ")) {
                        String[] tokens = line.split(" ");
                        memory += Long.parseLong(tokens[tokens.length-1]) / 1000;
                    }
                    if (line.contains("Gin Network: ")) {
                        String[] tokens = line.split(" ");
                        netUsed += Long.parseLong(tokens[tokens.length-1]);
                    }

                }
                p.waitFor();
                p.destroy();
//                netUsed = getNetworkUsed() - netBefore;
                netSamples.addValue(netUsed);
                Double CPUTime = userTime + systemTime;
                timeSamples.addValue(CPUTime);
                memSamples.addValue(memory);
//                Double curCPu = result.getCPUTime();
//                result.setNetworkUsed(netUsed + result.getNetworkUsed());
//                result.setCPUTime(curCPu + CPUTime);
//                result.setExecutionMemory(memory);
                result.setPassed(result.isPassed() && (p.exitValue() == 0));
                FileUtils.deleteDirectory(new File(projectDir + "/" + module + "/build/test-results/"));
            }
            Double curCPu = result.getCPUTime();
            result.setCPUTime(timeSamples.getPercentile(50));
            result.setExecutionMemory((long) memSamples.getPercentile(50));
            result.setNetworkUsed((long) netSamples.getPercentile(50));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
        testList = "";
        for (AndroidTest test : tests) {
            if (!test.isPerformance()) {
                testList = testList + " --tests " + test.getFullClassName() + "." + test.getMethodName();
            }
        }
        if (!result.isPassed()) {
            result.setCPUTime(Double.MAX_VALUE);
            return result;
        }
        cmd = ":" + module + ":test" + flavour + "DebugUnitTest" + testList + " -a";
        cmd = gradleCmdForTask(cmd);
        System.out.println("Running command: " + cmd);
        try {
            ProcessBuilder pb = new ProcessBuilder(cmd.split(" "));
            pb.directory(projectDir);
            pb.environment().putAll(System.getenv());
            pb.redirectErrorStream(true);
            pb.inheritIO();
            Process p = pb.start();
            p.waitFor();
            p.destroy();
            result.setPassed(result.isPassed() && (p.exitValue() == 0));
            FileUtils.deleteDirectory(new File(projectDir + "/" + module + "/build/test-results/"));


        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
        if (!result.isPassed()) {
            result.setCPUTime(Double.MAX_VALUE);
            return result;
        }
        return result;
    }

    public static double processTime(String time) {
        Double minutes = Double.valueOf(time.split("m")[0]);
        Double seconds = Double.valueOf(time.split("m")[1]);
        return 60 * minutes + seconds;
    }


    public static long getNetworkUsed() {
        ProcessBuilder netProc = new ProcessBuilder("cat /proc/net/dev".split(" "));
        Process netP = null;
        long netUsed = 0;
        try {
            netP = netProc.start();
            BufferedReader stdin = new BufferedReader(new InputStreamReader(netP.getInputStream()));
            String line = "";
            int count = 0;
            while ((line = stdin.readLine()) != null) {
                line = line.strip().trim().replaceAll(" +", " ");
                if (line.startsWith("lo")) {
                    continue;
                }
                System.out.println(line);
                count++;
                if (count > 2) {
                    String[] tokens = line.split(" ");
                    netUsed += Long.parseLong(tokens[1]);
                    netUsed += Long.parseLong(tokens[9]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return netUsed;


    }


    public int buildUnitTests() {
        String task = "assemble" + flavour + "DebugUnitTest";
        String cmd = gradleCmdForTask(task);
        System.out.println(cmd);
        try {
            ProcessBuilder pb = new ProcessBuilder(cmd.split(" "));
            pb.directory(projectDir);
            pb.environment().putAll(System.getenv());
            pb.inheritIO();
            Process p = pb.start();
            p.waitFor();
            return p.exitValue();
        } catch (IOException | InterruptedException e) {
            System.out.println("Failed to build app");
            e.printStackTrace();
            System.exit(1);
        }
        return 1;
    }


}
