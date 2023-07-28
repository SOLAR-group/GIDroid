package gin.util;

import gin.test.UnitTest;

public class AndroidTest extends UnitTest {

    public String fileName;
    private boolean instrumented;
    private boolean performance;

    public AndroidTest(String className, String methodName, String moduleName, String fileName) {
        super(className, methodName, moduleName);
        this.fileName = fileName;
        instrumented = false;
        performance = false;
    }

    public boolean isInstrumented() {
        return instrumented;
    }

    public void setInstrumented(boolean instrumented) {
        this.instrumented = instrumented;
    }

    public boolean isPerformance() {
        return performance;
    }

    public void setPerformance(boolean performance) {
        this.performance = performance;
    }
}
