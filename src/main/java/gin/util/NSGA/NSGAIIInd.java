package gin.util.NSGA;

import gin.Patch;

import java.util.ArrayList;

public class NSGAIIInd extends NSGAInd {
    private double crowding;

    private int rank;
    private ArrayList<Double> fitnesses;

    public NSGAIIInd(Patch patch, ArrayList<Double> fitnesses) {
        super(patch, fitnesses);


        this.crowding = 0;
    }

    public NSGAIIInd(ArrayList<Double> fitnesses) {
        super(fitnesses);
        this.crowding = 0;
    }

    public void setCrowding(double crowding) {
        this.crowding = crowding;
    }

    public double getCrowding() {
        return crowding;
    }

}
