package exercise.exercise1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Exercise1{


    private List<Integer> givenList;

    public Exercise1(List<Integer> l) {
       this.givenList = l;
    }

    // TODO Exercise #1 a) Compute sum and get the min and the max from givenList, iterating through it using ListIterator
    public List<Integer> iterateUsingListIterator(){

        // This List is used only for testing so you don't have to modify it
        List<Integer> testValues = new ArrayList<Integer>();
        int sum = 0;
        int max = Integer.MIN_VALUE ;
        int min = Integer.MAX_VALUE;

        Iterator<Integer> it = givenList.iterator();
        while ( it.hasNext())
        {
            Integer k = it.next();
            if( k < min )
            {
                min = k;
            }
            if(k > max)
            {
                max = k;
            }

            sum +=k;
        }



        // TODO Exercise #1 a1) In order to pass the tests, you need to name your variables sum, min and max or if
        // TODO Exercise #1 a1) you want to name them differently you need to modify them when you add them to testValues



        // TODO Exercise #1 a2) Uncomment the following three lines in order to check your computed values using tests
        testValues.add(sum);
        testValues.add(min);
        testValues.add(max);

        return  testValues;
    }

    // TODO Exercise #1 b) Compute the sum and get the min and the max from the even (RO: pare) positions in the list,
    // TODO Exercise #1 b) iterating through it using classic for loop
    public List<Integer> iterateUsingForLoop(){

        // This List is used only for testing so you don't need to modify it
        List<Integer> testValues = new ArrayList<Integer>();
        int sum = 0;
        int min = 0;
        int max = 0;
        for ( int i = 0 ; i < givenList.size();i++)
        {
            if ( i % 2 == 0)
            {
                if( testValues.get(i) < min )
                {
                    min = testValues.get(i);
                }
                if( testValues.get(i) > max)
                {
                    max = testValues.get(i);
                }
                sum +=testValues.get(i);
            }
        }


        // TODO Exercise #1 b1) In order to pass the tests, you need to name your variables sum, min and max or if
        // TODO Exercise #1 b1) you want to name them differently you need to modify them when you add them to testValues



        // TODO Exercise #1 b2) Uncomment the following three lines in order to check your computed values using tests
        testValues.add(sum);
        testValues.add(min);
        testValues.add(max);

        return testValues;
    }

    // TODO Exercise #1 c) Compute the sum and get the min and the max from the odd (RO: impare) elements of the list
    // TODO Exercise #1 c) iterating through it using foreach loop
    public List<Integer> iterateUsingForEachLoop(){

        // This List is used only for testing so you don't need to modify it
        List<Integer> testValues = new ArrayList<Integer>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for ( Integer i : givenList)
        {
            if ( i % 2 == 1)
            {
                if ( i < min)
                {
                    min = i;
                }
                if(i > max)
                {
                    max = i;
                }
                sum+=i;

            }
        }


        // TODO Exercise #1 c1) In order to pass the tests, you need to name your variables sum, min and max or if
        // TODO Exercise #1 c1) you want to name them differently you need to modify them when you add them to testValues



        // TODO Exercise #1 c2) Uncomment the following three lines in order to check your computed values using tests
        testValues.add(sum);
        testValues.add(min);
       testValues.add(max);

        return testValues;
    }
}
