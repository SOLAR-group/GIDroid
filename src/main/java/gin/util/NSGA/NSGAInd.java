package gin.util.NSGA;

import gin.Patch;
import org.uma.jmetal.solution.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class NSGAInd {

    private Patch patch;


    private int rank;
    protected ArrayList<Double> fitnesses;

    public NSGAInd(Patch patch, ArrayList<Double> fitnesses) {
        this.patch = patch;
        this.fitnesses = fitnesses;
    }

    public NSGAInd(ArrayList<Double> fitnesses) {
        this.fitnesses = fitnesses;
    }

    public ArrayList<Double> getFitnesses() {
        return fitnesses;
    }

    public Patch getPatch() {
        return patch;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Solution toSolution() {
        return new NSGAIndSolution(patch, fitnesses);
    }

    public class NSGAIndSolution implements Solution<String> {

        Patch patch;
        Map<Object, Object> attribs;
        private final ArrayList<Double> fitnesses;
        private final int noObj;

        public NSGAIndSolution(Patch patch, ArrayList<Double> fitnesses) {
            this.patch = patch;
            this.fitnesses = fitnesses;
            this.noObj = fitnesses.size();
            attribs = new HashMap<>();
        }

        @Override
        public void setObjective(int index, double value) {
            fitnesses.set(index, value);
        }

        @Override
        public double getObjective(int index) {
            return fitnesses.get(index);
        }

        @Override
        public String getVariableValue(int index) {
            return null;
        }

        @Override
        public void setVariableValue(int index, String value) {

        }


        @Override
        public String getVariableValueString(int index) {
            return null;
        }

        @Override
        public int getNumberOfVariables() {
            return 0;
        }

        @Override
        public int getNumberOfObjectives() {
            return noObj;
        }

        @Override
        public Solution copy() {
            return null;
        }

        @Override
        public void setAttribute(Object id, Object value) {
            attribs.put(id, value);
        }

        @Override
        public Object getAttribute(Object id) {
            return attribs.get(id);
        }

        public NSGAInd toInd() {
            return new NSGAIIInd(patch, fitnesses);
        }
    }

}
