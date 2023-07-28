package gin.test;

import gin.util.AndroidTest;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class AndroidTestFileParser {
    private static final String[] kywords = {"public", "private", "protected", "static", "final", "abstract", "native", "synchronized"};

    public static List<AndroidTest> parseFile(File testFile) {
        try {
            String className = FilenameUtils.removeExtension(testFile.getName());
            Scanner scanner = new Scanner(testFile);
            String packageLine = scanner.nextLine();
            while (!StringUtils.startsWith(packageLine, "package")) {
                packageLine = scanner.nextLine();
                if (packageLine.startsWith("import")) {
                    packageLine = "package null";
                    break;
                }

            }
            String packageName = StringUtils.split(packageLine)[1];
            packageName = StringUtils.substringBefore(packageName, ";");
            String line;
            ArrayList<AndroidTest> tests = new ArrayList<>();
            boolean inClass = false;
            while (scanner.hasNextLine()) {

                line = scanner.nextLine();
                if (line.contains("class ")) {
                    inClass = true;
                }
                if (line.trim().startsWith("@") && line.trim().endsWith("Test") && inClass) {
                    String methodLine = scanner.nextLine();
                    while (methodLine.trim().startsWith("@")) {
                        methodLine = scanner.nextLine();
                    }
                    if (methodLine.contains("class ")) {
                        continue;
                    }
                    String methodName = getMethodName((methodLine));
                    if (methodName == null) {
                        continue;
                    }
                    tests.add(new AndroidTest(className, methodName, packageName, testFile.getAbsolutePath()));
                }
            }

            return tests;
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (NoSuchElementException e) {
            System.err.println("File " + testFile + " not parsable");
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    private static String getMethodName(String line) {
        boolean returnType = false;
        String[] splitString = StringUtils.split(line);
        for (String split : splitString) {
            if (!Arrays.asList(kywords).contains(split)) {
                if (returnType) {
                    split = StringUtils.substringBefore(split, "(");
                    return split;
                } else {
                    returnType = true;
                }
            }
        }
        return null;
    }

}
