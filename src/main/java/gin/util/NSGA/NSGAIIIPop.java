package gin.util.NSGA;

import gin.Patch;
import org.uma.jmetal.algorithm.multiobjective.nsgaiii.util.EnvironmentalSelection;
import org.uma.jmetal.algorithm.multiobjective.nsgaiii.util.ReferencePoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class NSGAIIIPop extends ParetoPop {

    ArrayList<ReferencePoint> referencePoints;


    public NSGAIIIPop(int noObj) {
        super(noObj);
    }

    public NSGAIIIPop(int noObj, ArrayList<Integer> fitnessDirs) {
        super(noObj, fitnessDirs);
    }

    public NSGAIIIPop(ParetoPop p, ParetoPop q) {
        super(p, q);
    }

    public NSGAIIIPop(NSGAIIIPop p, NSGAIIIPop q) {
        super(p, q);
    }

    @Override
    public void addInd(Patch patch, ArrayList<Double> fitnesses) {
        if (fitnesses.size() != noObj) {
            throw new IllegalArgumentException("Incorrect number of fitnesses");
        }
        population.add(new NSGAIIIInd(patch, fitnesses));
    }

    @Override
    public ArrayList<Patch> getNextGen(int popSize) {
        ArrayList<Patch> out = new ArrayList<>();
        nonDominatedSort();
        int count = 1;
        for (int front = 1; front <= fronts.size(); front++) {
            if (fronts.get(front).size() < popSize - out.size()) {
                for (NSGAInd ind : fronts.get(front)) {
                    out.add(ind.getPatch().clone());
                }
                count += 1;
            }
        }

        if (out.size() == popSize) {
            return out;
        }

        List<List<NSGAInd.NSGAIndSolution>> jMetalFronts = new ArrayList<>();
        for (int i = 1; i <= fronts.size(); i++) {
            ArrayList<NSGAInd> front = fronts.get(i);
            ArrayList<NSGAInd.NSGAIndSolution> jmetalFront = new ArrayList<>();
            for (NSGAInd ind : front) {
                jmetalFront.add((NSGAInd.NSGAIndSolution) ind.toSolution());
            }
            jMetalFronts.add(jmetalFront);
        }
        List<ReferencePoint<NSGAInd.NSGAIndSolution>> referencePoints = new Vector<>();
        (new ReferencePoint<NSGAInd.NSGAIndSolution>()).generateReferencePoints(referencePoints, noObj, Collections.singletonList(4));
        EnvironmentalSelection<NSGAInd.NSGAIndSolution> selection =
                new EnvironmentalSelection<>(jMetalFronts, popSize - out.size(), referencePoints,
                        noObj);
        List<NSGAInd.NSGAIndSolution> jMetalPop = new ArrayList<>();

        List<NSGAInd.NSGAIndSolution> selected = selection.execute(jMetalFronts.get(count - 1));
        for (NSGAInd.NSGAIndSolution nsgaIndSolution : selected) {
            out.add(nsgaIndSolution.patch);
        }
        return out;
    }


}



