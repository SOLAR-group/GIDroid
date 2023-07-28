package gin.util;

import java.util.ArrayList;

public class AndroidConfig {
    private String appName;
    private String appPath;
    private String filePath;
    private String testRunner;
    private String testAppName;
    private String adbPath;
    private String deviceName;
    private String tests;
    private ArrayList<String> targetMethods;
    private String perfTests;
    private String apkPath;
    private String testApkPath;
    private String flavour;
    private String module;


    public AndroidConfig() {
        this.appName = "";
        this.appPath = "";
        this.filePath = "";
        this.testRunner = "";
        this.testAppName = "";
        this.adbPath = "adb";
        this.deviceName = "";
        this.tests = "";
        this.perfTests = "";
        this.apkPath = "";
        this.testApkPath = "";
        this.flavour = "";
        this.module = "app";
        targetMethods = new ArrayList<>();
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public String getApkPath() {
        return apkPath;
    }

    public void setApkPath(String apkPath) {
        this.apkPath = apkPath;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppPath() {
        return appPath;
    }

    public void setAppPath(String appPath) {
        this.appPath = appPath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getTestRunner() {
        return testRunner;
    }

    public void setTestRunner(String testRunner) {
        this.testRunner = testRunner;
    }

    public String getTestAppName() {
        return testAppName;
    }

    public void setTestAppName(String testAppName) {
        this.testAppName = testAppName;
    }

    public String getAdbPath() {
        return adbPath;
    }

    public void setAdbPath(String adbPath) {
        this.adbPath = adbPath;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getTests() {
        return tests;
    }

    public void setTests(String tests) {
        this.tests = tests;
    }

    public String getTestApkPath() {
        return testApkPath;
    }

    public void setTestApkPath(String testApkPath) {
        this.testApkPath = testApkPath;
    }


    public String getPerfTests() {
        return perfTests;
    }

    public void setPerfTests(String perfTests) {
        this.perfTests = perfTests;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public void setTargetMethods(ArrayList<String> targetMethods) {
        this.targetMethods = targetMethods;
    }

    public ArrayList<String> getTargetMethods() {
        return targetMethods;
    }
}
