package exercise.exercise0;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Create a List (ArrayList or LinkedList), add elements to it and print all of them using ListIterator
 *             for loop and foreach loop.
 *
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughList(){

        List<Integer> x = new LinkedList<Integer>();
        x.add(2);
        x.add(3);
        x.add(4);
        x.add(5);
        x.add(6);
        x.add(7);
        Iterator<Integer> it = x.iterator();
        while ( it.hasNext())
        {
            System.out.println(it.next());
        }
        System.out.println();
        int i;
        for ( i = 0 ; i < x.size();i++)
        {
            System.out.println(x.get(i));
        }
        System.out.println();
        for ( Integer xy : x)
        {
            System.out.println(xy);
        }
        System.out.println();



        // TODO Exercise #0 a) Create a list (ArrayList or LinkedList) and add elements to it
        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)

        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements

        // TODO Exercise #0 c) Iterate through the list using classic for loop and print all its elements

        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements

    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method

        Exercise0 xx = new Exercise0();
        xx.iterateThroughList();
    }
}
