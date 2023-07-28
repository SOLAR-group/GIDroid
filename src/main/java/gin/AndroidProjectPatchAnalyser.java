package gin;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.sampullara.cli.Args;
import com.sampullara.cli.Argument;
import gin.edit.Edit;
import gin.edit.Edit.EditType;
import gin.test.InternalTestRunner;
import gin.test.UnitTest;
import gin.test.UnitTestResultSet;
import gin.util.AndroidConfig;
import gin.util.AndroidConfigReader;
import gin.util.AndroidProject;
import gin.util.Project;
import org.apache.commons.io.FileUtils;
import org.pmw.tinylog.Logger;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class AndroidProjectPatchAnalyser {


    private static final long serialVersionUID = -3749197264292832819L;

    private static final int REPS = 50;

    @Argument(alias = "p", description = "Required: Patch File", required = true)
    protected String patchFile = null;


    @Argument(alias = "c", description = "Class name")
    protected File configFile;

    @Argument(alias = "cp", description = "Classpath")
    protected String classPath;


    @Argument(alias = "t", description = "Test class name")
    protected String testClassName;


    @Argument(alias = "to", description = "Test class name")
    protected Long timeoutMS = 500l;
    @Argument(alias = "ff", description = "Fail fast. "
            + "If set to true, the tests will stop at the first failure and the next patch will be executed. "
            + "You probably don't want to set this to true for Automatic Program Repair.")
    protected Boolean failFast = false;

    private SourceFileLine sourceFileLine;
    private SourceFileTree sourceFileTree;
    private InternalTestRunner testRunner;

    protected Project project = null;

    protected File source;
    protected String patchText;

    protected List<UnitTest> tests;

    protected String targetClass;

    protected String method;
    String appName;
    String algorithm;
    CSVWriter writer;

    protected Map<String, Map<String, UnitTestResultSet>> results;

    // Instantiate a class and call search
    public static void main(String[] args) {
        try {
            AndroidProjectPatchAnalyser analyser = new AndroidProjectPatchAnalyser(args);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    AndroidProjectPatchAnalyser(String[] args) throws IOException {

        Args.parseOrExit(this, args);
        writer = new CSVWriter(new FileWriter(new File("descriptions.csv")));

        try (CSVReader reader = new CSVReader(new FileReader(patchFile))) {
            List<String[]> r = reader.readAll();
            for (String[] line : r) {

                patchText = line[1];
                algorithm = line[2];
                appName = line[0];

                List<Class<? extends Edit>> editTypes = Edit.parseEditClassesFromString(Edit.EditType.STATEMENT.toString());
                AndroidConfigReader configReader = new AndroidConfigReader(appName + "/config.properties");
                AndroidConfig config = configReader.readConfig();
                List<String> targetMethod = config.getTargetMethods();
                String fileName = config.getFilePath();
                AndroidProject androidProject = new AndroidProject(config);
                SourceFile sourceFile = SourceFile.makeSourceFileForEditTypes(editTypes, fileName, targetMethod, androidProject.getClasspath());
                this.sourceFileLine = new SourceFileLine(fileName, null);
                this.sourceFileTree = (SourceFileTree) sourceFile;

                analyse();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return;
//        try {
//            CSVWriter writer = new CSVWriter(new FileWriter(new File("results.csv")));
//            for (String method : results.keySet()) {
//                Map<String, UnitTestResultSet> patchMap = results.get(method);
//                UnitTestResultSet orig = patchMap.get("|");
//                float origTime = orig.totalExecutionTime();
//                float origMem = orig.totalMemoryUsage();
//                for (String patch : patchMap.keySet()) {
//                    if (patch.equals("|")) {
//                        continue;
//                    }
//                    UnitTestResultSet set = patchMap.get(patch);
//                    float time = set.totalExecutionTime();
//                    float mem = set.totalMemoryUsage();
//                    float timeImp = (origTime - time) / origTime;
//                    float memImp = (origMem - mem) / origMem;
//
//                    String[] row = new String[]
//                            { method, patch, String.valueOf(time), String.valueOf(timeImp), String.valueOf(mem), String.valueOf(memImp),};
//                    writer.writeNext(row);
//                }
//
//            }
//            writer.close();
//
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }

    private void analyse() {

        // Create SourceFile and tester classes, parse the patch and generate patched source.
        source = new File(sourceFileTree.getFilename());

        // Dump statement numbering to a file
        String statementNumbering = sourceFileTree.statementList();
        String statementFilename = source + ".statements";
        try {
            FileUtils.writeStringToFile(new File(statementFilename), statementNumbering, Charset.defaultCharset());
        } catch (IOException e) {
            Logger.error("Could not write statements to " + statementFilename);
            Logger.trace(e);
            System.exit(-1);
        }

        Logger.info("Statement numbering written to: " + statementFilename);

        // Dump block numbering to a file
        String blockNumbering = sourceFileTree.blockList();

        String blockFilename = source + ".blocks";
        try {
            FileUtils.writeStringToFile(new File(blockFilename), blockNumbering, Charset.defaultCharset());
        } catch (IOException e) {
            Logger.error("Could not write blocks to " + blockFilename);
            Logger.trace(e);
            System.exit(-1);
        }
        Logger.info("Block numbering written to: " + blockFilename);

        String origFilename = source + ".original";
        try {
            FileUtils.writeStringToFile(new File(origFilename), sourceFileTree.getSource(), Charset.defaultCharset());
        } catch (IOException e) {
            Logger.error("Could not write patched source to " + origFilename);
            Logger.trace(e);
            System.exit(-1);
        }

        Patch patch = parsePatch(patchText, sourceFileLine, sourceFileTree);
        String patchedSource = patch.apply();

        Logger.info("Evaluating patch for Source: " + source);

        Logger.info("Patch is: " + patchText);

        // Write the patched source to file, for reference
        String patchedFilename = source + ".patched";
        try {
            FileUtils.writeStringToFile(new File(patchedFilename), patchedSource, Charset.defaultCharset());
        } catch (IOException e) {
            Logger.error("Could not write patched source to " + patchedFilename);
            Logger.trace(e);
            System.exit(-1);
        }

        ProcessBuilder processBuilder = new ProcessBuilder();

        // -- Linux --

        // Run a shell command
        processBuilder.command("diff", "-y", source + ".patched", source.toString() + ".original");


        try {

            Process process = processBuilder.start();

            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            System.out.println(output);
            Scanner myObj = new Scanner(System.in);
            String input = "";
            while ((!input.equalsIgnoreCase("y")) && (!input.equalsIgnoreCase("n"))) {
                System.out.println("Genuine? (Y/N)");
                input = myObj.nextLine();
            }
            boolean genuine = input.equalsIgnoreCase("y");
            if (genuine) {
                System.out.println("Change desc?");
                input = myObj.nextLine();
            }
            String desc = input;
            String[] csvLine = new String[5];
            csvLine[2] = patch.toString();
            csvLine[0] = appName;
            csvLine[1] = algorithm;
            csvLine[3] = String.valueOf(genuine);
            csvLine[4] = desc;
            writer.writeNext(csvLine);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        Logger.info("Parsed patch written to: " + patchedFilename);
//
////        // Evaluate original class
////        Logger.info("Timing original class execution...");
////        Patch emptyPatch = new Patch(sourceFileTree);
////        long originalExecutionTime = testRunner.runTests(emptyPatch, REPS).totalExecutionTime();
////        Logger.info("Original execution time: " + originalExecutionTime);
////
////        // Write the original source to file, for easy diff with *.patched file
////        patchedFilename = source + ".original";
////        try {
////            FileUtils.writeStringToFile(new File(patchedFilename), emptyPatch.apply(), Charset.defaultCharset());
////        } catch (IOException e) {
////            Logger.error("Could not write patched source to " + patchedFilename);
////            Logger.trace(e);
////            System.exit(-1);
////        }
////        Logger.info("Parsed patch written to: " + patchedFilename);
//
//        // Evaluate patch
//        Logger.info("Timing patched sourceFile execution...");
//        if (method.equals("org.evosuite.utils.FileIOUtils.recursiveCopy(File,File)")){
//            for (UnitTest test : tests) {
//                test.setTimeoutMS(5000);
//            }
//        }
//        UnitTestResultSet resultSet = testRunner.runTests(patch, REPS);
//        results.get(method).put(patchText, resultSet);
//        // Output test results
////        logTestResults(resultSet);
//
////        Logger.info("Execution time of patched sourceFile: " + resultSet.totalExecutionTime());
////        float speedup = 100.0f * ((originalExecutionTime - resultSet.totalExecutionTime()) /
////                (1.0f * originalExecutionTime));
////        if (resultSet.getValidPatch() && resultSet.getCleanCompile()) {
////            Logger.info("Speedup (%): " + speedup);
////        } else {
////            Logger.info("Speedup (%): not applicable");
////        }

    }

    private static Patch parsePatch(String patchText, SourceFileLine sourceFileLine, SourceFileTree sourceFileTree) {

        if (patchText.equals("|")) {
            Logger.info("No edits to be applied. Running original code.");
            Patch patch = new Patch(sourceFileTree);
            return patch;
        }

        List<Edit> editInstances = new ArrayList<>();

        String patchTrim = patchText.trim();
        String cleanPatch = patchTrim;

        if (patchTrim.startsWith("|")) {
            cleanPatch = patchText.replaceFirst("\\|", "").trim();
        }

        String[] editStrings = cleanPatch.trim().split("\\|");

        boolean allLineEdits = true;
        boolean allStatementEdits = true;

        for (String editString : editStrings) {

            String[] tokens = editString.trim().split("\\s+");

            String editAction = tokens[0];

            Class<?> clazz = null;

            try {
                clazz = Class.forName(editAction);
            } catch (ClassNotFoundException e) {
                Logger.error("Patch edit type unrecognised: " + editAction);
                Logger.trace(e);
                System.exit(-1);
            }

            Method parserMethod = null;
            try {
                parserMethod = clazz.getMethod("fromString", String.class);
            } catch (NoSuchMethodException e) {
                Logger.error("Patch edit type has no fromString method: " + clazz.getCanonicalName());
                Logger.trace(e);
                System.exit(-1);
            }

            Edit editInstance = null;
            try {
                editInstance = (Edit) parserMethod.invoke(null, editString.trim());
            } catch (IllegalAccessException e) {
                Logger.error("Cannot parse patch: access error invoking edit class.");
                Logger.trace(e);
                System.exit(-1);
            } catch (InvocationTargetException e) {
                Logger.error("Cannot parse patch: invocation error invoking edit class.");
                Logger.trace(e);
                System.exit(-1);
            }

            allLineEdits &= editInstance.getEditType() == EditType.LINE;
            allStatementEdits &= editInstance.getEditType() != EditType.LINE;
            editInstances.add(editInstance);

        }

        if (!allLineEdits && !allStatementEdits) {
            Logger.error("Cannot proceed: mixed line/statement edit types found in patch");
            System.exit(-1);
        }

        Patch patch = new Patch(allLineEdits ? sourceFileLine : sourceFileTree);
        for (Edit e : editInstances) {
            patch.add(e);
        }

        return patch;

    }

//    private static void logTestResults(UnitTestResultSet results) {
//
//        Logger.info("Test Results");
//        Logger.info("Number of results: " + results.getResults().size());
//        Logger.info("Valid patch: " + results.getValidPatch());
//        Logger.info("Cleanly compiled: " + results.getCleanCompile());
//        Logger.info("All tests successful: " + results.allTestsSuccessful());
//        Logger.info("Total execution time: " + results.totalExecutionTime());
//        Logger.info("Memory Use: " + results.totalMemoryUsage());
//
//
//        for (UnitTestResult result: results.getResults()) {
//            Logger.info(result);
//        }
//
//    }

}

