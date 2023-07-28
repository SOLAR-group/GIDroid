package gin.util;

import java.util.ArrayList;
import java.util.Collections;

public class TestExecutionMemory {
    private final ArrayList<Float> memoryReadings;

    public TestExecutionMemory() {
        memoryReadings = new ArrayList<>();
    }

    public void addReading(Float reading) {
        memoryReadings.add(reading);
    }

    public Float maxReading() {
        if (memoryReadings.size() > 0) {
            return Collections.max(memoryReadings);
        } else {
            return 0f;
        }
    }

    public Float medianReading() {
        return median(memoryReadings);
    }


    public static Float median(ArrayList<Float> values) {
        Collections.sort(values);
        if (values.size() == 0) {
            return 0f;
        }
        if (values.size() % 2 == 1)
            return values.get((values.size() + 1) / 2 - 1);
        else {
            float lower = values.get(values.size() / 2 - 1);
            float upper = values.get(values.size() / 2);

            return (lower + upper) / 2.0f;
        }
    }
}
