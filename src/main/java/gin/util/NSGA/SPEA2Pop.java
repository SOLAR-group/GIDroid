package gin.util.NSGA;

import gin.Patch;

import java.util.ArrayList;
import java.util.Collections;

public class SPEA2Pop extends ParetoPop {


    ArrayList<NSGAInd> archive;
    ArrayList<NSGAInd> nextArchive;

    public SPEA2Pop(int noObj) {
        super(noObj);
    }

    public SPEA2Pop(int noObj, ArrayList<Integer> fitnessDirs) {
        super(noObj, fitnessDirs);
        archive = new ArrayList<>();
    }

    @Override
    public void addInd(Patch patch, ArrayList<Double> fitnesses) {
        if (fitnesses.size() != noObj) {
            throw new IllegalArgumentException("Incorrect number of fitnesses");
        }
        population.add(new SPEA2Ind(patch, fitnesses));
    }

    @Override
    public ArrayList<Patch> getNextGen(int popSize) {
        return null;

    }

    public void setNextArchive(int popSize) {
//        fillArchive();
        getStrengths();
        getRawFitness();
        getDistances();
        getFitnesses();
        nextArchive = new ArrayList<>();

        Collections.sort(population, (x, y) -> {
            if (((SPEA2Ind) x).fitness < ((SPEA2Ind) y).fitness) {
                return -1;
            } else if (((SPEA2Ind) x).fitness > ((SPEA2Ind) y).fitness) {
                return 1;
            }
            return 0;
        });
        for (NSGAInd ind : population) {
            if (((SPEA2Ind) ind).fitness <= 1) {
                nextArchive.add(ind);
            } else if (nextArchive.size() < popSize) {
                nextArchive.add(ind);
            }
        }
        if (nextArchive.size() > popSize) {
            Collections.sort(population, (x, y) -> {
                if (((SPEA2Ind) x).distances.get(0) < ((SPEA2Ind) y).distances.get(0)) {
                    return -1;
                } else if (((SPEA2Ind) x).distances.get(0) > ((SPEA2Ind) y).distances.get(0)) {
                    return 1;
                }
                return 0;
            });
            int i = 0;
            while (nextArchive.size() > popSize) {
                nextArchive.remove(population.get(i));
                i++;
            }
        }

        archive = nextArchive;

    }

    public void fillArchive() {
        archive = new ArrayList<>();
        for (NSGAInd ind : population) {
            boolean dominated = false;
            for (NSGAInd ind2 : population) {
                if (dominates(ind2, ind)) {
                    dominated = true;
                }
            }
            if (!dominated) {
                archive.add(ind);
            }
        }
    }

    public void getStrengths() {
        for (NSGAInd ind : population) {
            int strength = 0;
            for (NSGAInd ind1 : population) {
                if (dominates(ind, ind1)) {
                    strength += 1;
                }
            }
            for (NSGAInd ind1 : archive) {
                if (dominates(ind, ind1)) {
                    strength += 1;
                }
            }
            ((SPEA2Ind) ind).strength = strength;
        }
    }

    public void getRawFitness() {
        for (NSGAInd ind : population) {
            int rawFitness = 0;
            for (NSGAInd ind1 : population) {
                if (dominates(ind1, ind)) {
                    rawFitness += ((SPEA2Ind) ind1).strength;
                }
            }
            for (NSGAInd ind1 : archive) {
                if (dominates(ind1, ind)) {
                    rawFitness += ((SPEA2Ind) ind1).strength;
                }
            }
            ((SPEA2Ind) ind).rawFitness = rawFitness;
        }
    }

    public void getDistances() {
        int kth = (int) Math.pow(population.size() + archive.size(), 0.5);
        for (NSGAInd ind : population) {
            ((SPEA2Ind) ind).distances = new ArrayList();
            for (NSGAInd ind1 : population) {
                ((SPEA2Ind) ind).distances.add(((SPEA2Ind) ind).distanceTo((SPEA2Ind) ind1));
            }
            Collections.sort(((SPEA2Ind) ind).distances);
            float kthDistance = ((SPEA2Ind) ind).distances.get(kth);
            ((SPEA2Ind) ind).density = 1 / (kthDistance + 2);
        }

    }


    public void getFitnesses() {
        for (NSGAInd ind : population) {
            ((SPEA2Ind) ind).fitness = ((SPEA2Ind) ind).density + ((SPEA2Ind) ind).rawFitness;
        }
    }


}
