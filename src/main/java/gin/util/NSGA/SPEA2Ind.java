package gin.util.NSGA;

import gin.Patch;

import java.util.ArrayList;

public class SPEA2Ind extends NSGAInd {

    public int strength;
    public int rawFitness;
    public float density;
    public ArrayList<Float> distances;
    public float fitness;

    public SPEA2Ind(Patch patch, ArrayList<Double> fitnesses) {
        super(patch, fitnesses);
    }

    public SPEA2Ind(ArrayList<Double> fitnesses) {
        super(fitnesses);
    }

    public float distanceTo(SPEA2Ind ind) {
        float distance = 0;
        for (int i = 0; i < fitnesses.size(); i++) {
            distance += Math.pow((fitnesses.get(i) - ind.fitnesses.get(i)), 2);
        }
        distance = (float) Math.pow(distance, 0.5);
        return distance;

    }


}
