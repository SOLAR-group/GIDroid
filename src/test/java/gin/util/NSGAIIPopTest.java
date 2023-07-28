package gin.util;

import gin.util.NSGA.NSGAIIInd;
import gin.util.NSGA.NSGAIIPop;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class NSGAIIPopTest{

    private ArrayList<Double> pfitness;
    private ArrayList<Double> qfitness;

    @Before
    public void setUp(){
        pfitness = new ArrayList<>();
        qfitness = new ArrayList<>();
    }

    @Test
    public void testDomination(){
        pfitness.add(1d);
        pfitness.add(2d);
        qfitness.add(2d);
        qfitness.add(2d);
        NSGAIIInd p = new NSGAIIInd(pfitness);
        NSGAIIInd q = new NSGAIIInd(qfitness);
        NSGAIIPop pop = new NSGAIIPop(2);
        assert (pop.dominates(q,p));
    }

}