import exercise.exercise1.Exercise1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 */
public class Exercise1Test {
    private Integer[] v = {15, 5, 34, 23, 7, 19, 20, 22, 78, 39, 8, 30, 27, 62, 28, 7};
    private List<Integer> listToTest;
    private List<Integer> expected;
    private List<Integer> expectedFor;
    private List<Integer> expectedForEach;

    private Exercise1 ex1;

    @Before
    public void setUp() throws Exception {
        listToTest = Arrays.asList(v);
        ex1 = new Exercise1(listToTest);
        expected = new ArrayList<Integer>();
        expectedFor = new ArrayList<Integer>();
        expectedForEach = new ArrayList<Integer>();
        expected.add(424); // sum
        expected.add(5); // min
        expected.add(78); // max
        expectedFor.add(217);
        expectedFor.add(7);
        expectedFor.add(78);
        expectedForEach.add(142);
        expectedForEach.add(5);
        expectedForEach.add(39);
    }

    @Test
    public void testIterator() throws Exception {
        List<Integer> testResults = ex1.iterateUsingListIterator();
        Assert.assertEquals("Test sum with iterator", expected.get(0), testResults.get(0));
        Assert.assertEquals("Test min with iterator", expected.get(1), testResults.get(1));
        Assert.assertEquals("Test max with iterator", expected.get(2), testResults.get(2));
    }

    @Test
    public void testFor() throws Exception {
        List<Integer> testResults = ex1.iterateUsingForLoop();
        Assert.assertEquals("Test sum with for", expectedFor.get(0), testResults.get(0));
        Assert.assertEquals("Test min with for", expectedFor.get(1), testResults.get(1));
        Assert.assertEquals("Test max with for", expectedFor.get(2), testResults.get(2));
    }

    @Test
    public void testForEach() throws Exception {
        List<Integer> testResults = ex1.iterateUsingForEachLoop();
        Assert.assertEquals("Test sum with foreach", expectedForEach.get(0), testResults.get(0));
        Assert.assertEquals("Test min with foreach", expectedForEach.get(1), testResults.get(1));
        Assert.assertEquals("Test max with foreach", expectedForEach.get(2), testResults.get(2));
    }
}
