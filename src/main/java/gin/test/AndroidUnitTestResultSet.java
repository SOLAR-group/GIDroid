package gin.test;

import gin.Patch;
import gin.util.TestExecutionMemory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AndroidUnitTestResultSet {

    private final List<AndroidTestResult> results;
    private final Patch patch;
    private final boolean patchValid;


    public AndroidUnitTestResultSet(Patch patch, boolean patchValid, List<AndroidTestResult> results) {
        this.patch = patch;
        this.results = results;
        this.patchValid = patchValid;

    }

    public boolean isPatchValid() {
        return patchValid;
    }


    public Double getMemoryUsage() {
        ArrayList<Float> memMaxes = new ArrayList<>();
        for (AndroidTestResult result : results) {
            memMaxes.add((Float.valueOf(result.getExecutionMemory())));
        }
        return Double.valueOf(TestExecutionMemory.median(memMaxes));
    }

    public Double getExecutionTime() {
        ArrayList<Double> execTimes = new ArrayList<>();
        for (AndroidTestResult result : results) {
            execTimes.add(result.getCPUTime());
        }
        return Double.valueOf(median(execTimes));
    }

    public List<AndroidTestResult> getResults() {
        return results;
    }

    public float getNetworkUsage() {
        if (results.size() == 0) {
            return Float.MAX_VALUE;
        }
        ArrayList<Float> use = new ArrayList<>();
        for (AndroidTestResult result : results) {
            use.add((float) result.getNetworkUsed());
        }
        return Collections.max(use);
    }

    public static Double median(ArrayList<Double> values) {
        Collections.sort(values);
        if (values.size() == 0) {
            return 0d;
        }
        if (values.size() % 2 == 1)
            return values.get((values.size() + 1) / 2 - 1);
        else {
            double lower = values.get(values.size() / 2 - 1);
            double upper = values.get(values.size() / 2);

            return (lower + upper) / 2.0f;
        }
    }
}
