package gin.util.NSGA;

import gin.Patch;
import gin.SourceFile;
import gin.edit.Edit;
import gin.edit.statement.*;
import gin.test.AndroidTestRunner;
import gin.test.AndroidUnitTestResultSet;
import gin.util.AndroidProject;
import org.apache.commons.rng.simple.JDKRandomBridge;
import org.apache.commons.rng.simple.RandomSource;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class NSGAII {
    Map<String, AndroidUnitTestResultSet> book;
    AndroidProject project;
    SourceFile sourceFile;
    AndroidTestRunner testRunner;
    int NO_RUNS = 5;
    File outputFile;
    List<Class<? extends Edit>> editTypes;
    int indNumber = 40;
    int genNumber = 10;
    JDKRandomBridge rng;
    double mutateProbability = 0.5;

    public NSGAII(AndroidProject project, SourceFile sourceFile, AndroidTestRunner testRunner, List<Class<? extends Edit>> editTypes) {
        outputFile = new File("log.txt");
        long seed = Instant.now().getEpochSecond();
        this.testRunner = testRunner;
        this.sourceFile = sourceFile;
        this.editTypes = editTypes;
        this.rng = new JDKRandomBridge(RandomSource.MT, seed);
        this.project = project;
    }


    public void run() {
        book = new HashMap<>();
        //project.unitTests = project.getAllLocalTests();
        Patch empty = new Patch(sourceFile);
        try {
            System.out.println("Profiling original code");
            testRunner.runTestsLocally(empty, 1, false);
            AndroidUnitTestResultSet resultSet = testRunner.runTestsLocally(empty, NO_RUNS, false);
            writePatchNSGAII(empty, resultSet, -1);
            //First Generation
            ArrayList<Integer> dirs = new ArrayList<>();
            dirs.add(-1);
            dirs.add(-1);
            dirs.add(-1);
            NSGAIIPop P = new NSGAIIPop(3, dirs);
            System.out.println("Generating P0");
            for (int i = 0; i < indNumber; i++) {
                Patch patch = mutate(empty);
//                Patch patch = empty;
                System.out.println("Profiling Patch: " + patch);
                resultSet = testRunner.runTestsLocally(patch, NO_RUNS, false);
                writePatchNSGAII(patch, resultSet, -1);
                ArrayList<Double> fitnesses = new ArrayList<>();
                if (resultSet.isPatchValid()) {
                    fitnesses.add(resultSet.getExecutionTime());
                    fitnesses.add(resultSet.getMemoryUsage());
                    fitnesses.add((double) resultSet.getNetworkUsage());
                } else {
                    fitnesses.add(Double.MAX_VALUE);
                    fitnesses.add(Double.MAX_VALUE);
                    fitnesses.add(Double.MAX_VALUE);
                }
                P.addInd(patch, fitnesses);
                System.out.println(i);
            }
            for (int g = 0; g < genNumber; g++) {
                System.out.println("Generating Q");
                NSGAIIPop Q = NSGAIIOffspring(P, empty, g);
                NSGAIIPop R = new NSGAIIPop(P, Q);
                System.out.println("Generating P");
                ArrayList<Patch> patches = R.getNextGen(indNumber);
                P = new NSGAIIPop(3, dirs);
                for (Patch patch : patches) {
                    if (book.containsKey(patch.toString())) {
                        resultSet = book.get(patch.toString());
                    } else {
                        System.out.println("Profiling Patch: " + patch);
                        resultSet = testRunner.runTestsLocally(patch, NO_RUNS, false);
                        book.put(patch.toString(), resultSet);
                    }
                    writePatchNSGAII(patch, resultSet, g);
                    ArrayList<Double> fitnesses = new ArrayList<>();
                    if (resultSet.isPatchValid()) {
                        fitnesses.add(resultSet.getExecutionTime());
                        fitnesses.add(resultSet.getMemoryUsage());
                        fitnesses.add((double) resultSet.getNetworkUsage());
                    } else {
                        fitnesses.add(Double.MAX_VALUE);
                        fitnesses.add(Double.MAX_VALUE);
                        fitnesses.add(Double.MAX_VALUE);
                    }
                    P.addInd(patch, fitnesses);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }


    }


    public NSGAIIPop NSGAIIOffspring(NSGAIIPop pop, Patch origpatch, int g) {
        ArrayList<NSGAInd> population = pop.getPopulation();
        List<Patch> oldPatches = new ArrayList<>();
        for (NSGAInd ind : population) {
            oldPatches.add(ind.getPatch());
        }
        List<Patch> patches = new ArrayList<>();
        //selection
        for (int i = 0; i < population.size(); i++) {
            NSGAInd ind1 = population.get(rng.nextInt(population.size()));
            NSGAInd ind2 = population.get(rng.nextInt(population.size()));
            if (ind1.getRank() < ind2.getRank()) {
                patches.add(ind1.getPatch().clone());
            }
            if (ind1.getRank() > ind2.getRank()) {
                patches.add(ind2.getPatch().clone());
            } else {
                float coinFlip = rng.nextFloat();
                if (coinFlip < 0.5) {
                    patches.add(ind1.getPatch().clone());
                } else {
                    patches.add(ind2.getPatch().clone());
                }
            }
        }
        //crossover
        patches = crossover(patches, origpatch);
        //mutation
        List<Patch> mutatedPatches = new ArrayList<>();
        for (Patch patch : patches) {
            if (rng.nextFloat() < mutateProbability) {
                mutatedPatches.add(mutate(patch));
            }
        }
        patches = mutatedPatches;
        ArrayList<Integer> dirs = new ArrayList<>();
        dirs.add(-1);
        dirs.add(-1);
        dirs.add(-1);
        NSGAIIPop Q = new NSGAIIPop(3, dirs);
        //fitness
        for (Patch patch : patches) {
            AndroidUnitTestResultSet resultSet;
            if (book.containsKey(patch.toString())) {
                resultSet = book.get(patch.toString());
            } else {
                resultSet = testRunner.runTestsLocally(patch, NO_RUNS, false);
                book.put(patch.toString(), resultSet);
            }
            writePatchNSGAII(patch, resultSet, g);
            ArrayList<Double> fitnesses = new ArrayList<>();
            if (resultSet.isPatchValid()) {
                fitnesses.add(resultSet.getExecutionTime());
                fitnesses.add(resultSet.getMemoryUsage());
                fitnesses.add((double) resultSet.getNetworkUsage());
            } else {
                fitnesses.add(Double.MAX_VALUE);
                fitnesses.add(Double.MAX_VALUE);
                fitnesses.add(Double.MAX_VALUE);
            }
            Q.addInd(patch, fitnesses);
        }

        return Q;
    }

    public void writePatchNSGAII(Patch patch, AndroidUnitTestResultSet resultSet, int gen) {
        ZonedDateTime now = ZonedDateTime.now();
        now = now.withZoneSameInstant(ZoneId.of("UTC"));
        String executionTime;
        String memory;
        String bandwidth;
        if (resultSet.isPatchValid()) {
            executionTime = Double.toString(resultSet.getExecutionTime());
            memory = Double.toString(resultSet.getMemoryUsage());
            bandwidth = Double.toString(resultSet.getNetworkUsage());
        } else {
            executionTime = Double.toString(Double.MAX_VALUE);
            memory = Double.toString(Double.MAX_VALUE);
            bandwidth = Double.toString(Double.MAX_VALUE);
        }
        String entry =
                gen + ", " + patch.toString() + ", " +
                        resultSet.isPatchValid() + ", " +
                        executionTime + ", " + memory + ", " + bandwidth + ", " + now + "\n";
        try {
            FileWriter writer = new FileWriter(outputFile, true);
            writer.write(entry);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    protected Patch mutate(Patch oldPatch) {
        Patch patch = oldPatch.clone();
        patch.addRandomEditOfClasses(rng, editTypes);
        return patch;
    }

    protected List<Patch> crossover(List<Patch> patches, Patch origPatch) {

        List<Patch> crossedPatches = new ArrayList<>();

        Collections.shuffle(patches, rng);
        int half = patches.size() / 2;
        for (int i = 0; i < half; i++) {

            Patch parent1 = patches.get(i);
            Patch parent2 = patches.get(i + half);
            List<Edit> list1 = parent1.getEdits();
            List<Edit> list2 = parent2.getEdits();

            Patch child1 = origPatch.clone();
            Patch child2 = origPatch.clone();

            for (int j = 0; j < list1.size(); j++) {
                if (rng.nextFloat() > mutateProbability) {
                    child1.add(list1.get(j));
                }
            }
            for (int j = 0; j < list2.size(); j++) {
                if (rng.nextFloat() > mutateProbability) {
                    child1.add(list2.get(j));
                }
                if (rng.nextFloat() > mutateProbability) {
                    child2.add(list2.get(j));
                }
            }
            for (int j = 0; j < list1.size(); j++) {
                if (rng.nextFloat() > mutateProbability) {
                    child2.add(list1.get(j));
                }
            }

            crossedPatches.add(parent1);
            crossedPatches.add(parent2);
            crossedPatches.add(child1);
            crossedPatches.add(child2);
        }

        return crossedPatches;
    }


    public void testPatches(String patchFile) {
        try {
            Scanner scan = new Scanner(new File(patchFile));
            while (scan.hasNextLine()) {
                String patchStr = scan.nextLine();
                evaluatePatch(patchStr);

            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public void evaluatePatch(String patchString) {
        Patch patch = getPatch(patchString);
        try {
            for (int i = 0; i < 20; i++) {

                AndroidUnitTestResultSet results = testRunner.runTestsLocally(patch, 5, true);
                if (results.isPatchValid()) {
                    ZonedDateTime now = ZonedDateTime.now();
                    FileWriter writer = new FileWriter("Validation.txt", true);
                    String line = project.getProjectDir() + ",," + patchString + ",," + results.getExecutionTime() + ",," + results.getMemoryUsage() + ",," + results.getNetworkUsage() + ",," + now;
                    writer.write(line);
                    writer.write("\n");
                    writer.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    private Patch getPatch(String patch) {
        Patch origPatch = new Patch(sourceFile);
        if (patch.replaceAll("\\s+", "").equals("|")) {
            return origPatch;
        }
        String[] edits = patch.split("\\|");
        for (String edit : edits) {
            if (edit.equals("")) {
                continue;
            }
            String[] editTokens = edit.split(" ");
            String cls = editTokens[1];
            edit = edit.substring(1);
            String[] sourceTokens;
            String[] destTokens;
            switch (cls) {
                case "gin.edit.statement.CopyStatement":
                    origPatch.add(CopyStatement.fromString(edit));
                    break;
                case "gin.edit.statement.DeleteStatement":
                    origPatch.add(DeleteStatement.fromString(edit));
                    break;
                case "gin.edit.statement.ReplaceStatement":
                    origPatch.add(ReplaceStatement.fromString(edit));
                    break;
                case "gin.edit.statement.MoveStatement":
                    origPatch.add(MoveStatement.fromString(edit));
                    break;
                case "gin.edit.statement.SwapStatement":
                    origPatch.add(SwapStatement.fromString(edit));
                    break;
                case "gin.edit.statement.CacheEdit":
                    origPatch.add(CacheEdit.fromString(edit));
                    break;
                case "gin.edit.statement.ClassCacheEdit":
                    origPatch.add(ClassCacheEdit.fromString(edit));
                    break;
            }

        }
        return origPatch;
    }

}
