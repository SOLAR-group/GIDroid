package gin.util;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class AndroidDebugBridge {

    private String apk;
    private String err;
    private final String deviceId;
    public String output;
    private File appDir;

    private final String packageName;
    private final String[] envp = {};
    private final String adbPath;

    public AndroidDebugBridge(String deviceId, String packageName, String adbPath) {
        this.packageName = packageName;
        this.deviceId = deviceId;
        this.adbPath = adbPath;

    }


    public void installApp(String apk) {
        String cmd = "push " + apk + " /data/local/tmp/";
        runCommand(cmd);
        String[] splitpath = apk.split("/");
        String name = splitpath[splitpath.length - 1];
        cmd = "pm install -t -r \"/data/local/tmp/" + name + "\"";
        System.out.println(cmd);
        runShellCommand(cmd);
    }

    public void runTest(String testName) {

    }

    public int runCommand(String command, boolean captureOut) {
        command = adbPath + " -s " + deviceId + " " + command;
        try {
            ProcessBuilder pb = new ProcessBuilder(command.split(" "));
            pb.directory(appDir);
            if (!captureOut) {
                pb.inheritIO();
            }
            Process p = pb.start();
            output = IOUtils.toString(p.getInputStream(), StandardCharsets.UTF_8);
            p.waitFor();
            return 0;
        } catch (IOException | InterruptedException e) {
            System.out.println("Failed to execute command: " + command);
            e.printStackTrace();
            return 1;
        }
    }

    public int runCommand(String command) {
        return runCommand(command, false);
    }

    public int runShellCommand(String command, boolean captureOutput) {
        return runCommand("shell " + command, captureOutput);
    }

    public int runShellCommand(String command) {
        return runShellCommand(command, false);
    }


}
