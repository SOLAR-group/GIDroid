package gin.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AndroidConfigReader {

    private final String configPath;

    public AndroidConfigReader(String configPath) {
        this.configPath = configPath;
    }

    public AndroidConfig readConfig() {
        AndroidConfig config = new AndroidConfig();
        InputStream inputStream;
        try {
            Properties prop = new Properties();
            inputStream = new FileInputStream(new File(configPath));

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + configPath + "' not found in the classpath");
            }
            config.setAdbPath(prop.getProperty("adbPath"));
            config.setAppName(prop.getProperty("appName"));
            config.setAppPath(prop.getProperty("appPath"));
            config.setDeviceName(prop.getProperty("deviceName"));
            config.setFilePath(prop.getProperty("filePath"));
            config.setTests(prop.getProperty("tests"));
            config.setPerfTests(prop.getProperty("perfTests"));
            config.setTestAppName(prop.getProperty("testAppName"));
            config.setTestRunner(prop.getProperty("testRunner"));
            config.setApkPath(prop.getProperty("apkPath"));
            config.setTestApkPath(prop.getProperty("testApkPath"));
            config.setFlavour(prop.getProperty("flavour"));
            config.setModule(prop.getProperty("module"));
            config.setTargetMethods(new ArrayList(List.of(prop.getProperty("targetMethods").split("!"))));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return config;
    }
}
