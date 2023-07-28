package gin.test;

import gin.Patch;
import gin.util.AndroidConfig;
import gin.util.AndroidDebugBridge;
import gin.util.AndroidProject;
import gin.util.AndroidTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AndroidTestRunner {

    private AndroidDebugBridge adb;
    private final AndroidProject project;
    private List<AndroidTest> tests;
    private String apk;
    private String testapk;
    private String activity;
    private final String fileName;
    private String testAppId;
    private final String testRunner;
    private final String appName;
    public String UID;


    public AndroidTestRunner(AndroidProject project, AndroidConfig config) {
        appName = config.getAppName();
        fileName = config.getFilePath();
        this.project = project;
        testRunner = config.getTestRunner();
        String[] tokens = config.getTargetMethods().get(0).split("\\.");
    }


    //install app, reset all gfxinfo
    public void setUp() {

    }


    public AndroidUnitTestResultSet runTests(Patch patch, int runs) throws IOException, InterruptedException {
        return runTestsLocally(patch, runs, true);
    }


    public AndroidUnitTestResultSet runTestsLocally(Patch patch, int runs, boolean breakOnFail) {
        ArrayList<AndroidTestResult> results = new ArrayList<>();
        if (TestRunner.isPatchedSourceSame(patch.getSourceFile().getSource(), patch.apply())) {
            if (!patch.toString().equals("|")) {
                return new AndroidUnitTestResultSet(patch, false, results);
            }
        }
        patch.writePatchedSourceToFile(fileName);
        if (project.buildUnitTests() != 0) {
            return new AndroidUnitTestResultSet(patch, false, results);
        }

        AndroidTestResult result = project.runLocalTests((ArrayList<AndroidTest>) project.unitTests, runs);
        if (!result.isPassed()) {
            results.add(result);
            System.out.println("test Failed");
            return new AndroidUnitTestResultSet(patch, false, results);
        }
        results.add(result);
        patch.undoWrite(fileName);
        return new AndroidUnitTestResultSet(patch, true, results);
    }


}
