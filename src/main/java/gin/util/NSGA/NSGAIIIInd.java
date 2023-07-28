package gin.util.NSGA;

import gin.Patch;

import java.util.ArrayList;

public class NSGAIIIInd extends NSGAInd {
    public NSGAIIIInd(Patch patch, ArrayList<Double> fitnesses) {
        super(patch, fitnesses);
        for (int i = 0; i < fitnesses.size(); i++) {
            if (fitnesses.get(i).equals(Double.MAX_VALUE)) {
                this.fitnesses.set(i, 1000000d);
            }
        }
    }
}
