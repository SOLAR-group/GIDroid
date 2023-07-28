package gin.test;


public class AndroidTestResult {
    private final UnitTest test;
    private final int repNumber;
    private long executionMemory;

    private long networkUsed;

    private double cpuTime;


    private boolean passed;

    public AndroidTestResult(UnitTest test, int rep) {
        this.test = test;
        this.repNumber = rep;
        this.cpuTime = Double.MAX_VALUE;
        this.executionMemory = Long.MAX_VALUE;
    }

    public boolean isPassed() {
        return passed;
    }


    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public long getExecutionMemory() {
        return executionMemory;
    }

    public void setExecutionMemory(long executionMemory) {
        this.executionMemory = executionMemory;
    }

    public double getCPUTime() {
        return cpuTime;
    }

    public long getNetworkUsed() {
        return networkUsed;
    }

    public void setNetworkUsed(long networkUsed) {
        this.networkUsed = networkUsed;
    }

    public void setCPUTime(double cpuTime) {
        this.cpuTime = cpuTime;
    }

    public UnitTest getTest() {
        return test;
    }

}
