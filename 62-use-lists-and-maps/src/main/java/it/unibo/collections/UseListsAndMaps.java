package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {
    private static final int INITIALVALUE = 1000;
    private static final int FINALVALUE = 2000;
    private static final int TOBERED = 10000;
    private static final int ELEM = 100000;
    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final ArrayList<Integer> arrList = new ArrayList<>(1050);


        for( int i = INITIALVALUE; i < FINALVALUE; i++ ) {
            arrList.add(i);
        }

        //Uncomment below for runtime fast debug
        //System.out.println("ARRAY LIST\n" + arrList.toString());

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final LinkedList<Integer> linkList = new LinkedList<>(arrList);

        //Uncomment below for runtime fast debug
        //System.out.println("LINEKD LIST\n" + linkList.toString());

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int firstValue = arrList.getFirst();

        arrList.set(0, arrList.get(arrList.size() - 1));

        arrList.set(arrList.size() - 1, firstValue);

        //Uncomment below for runtime fast debug
        //System.out.println("SWAPPED ELEMENT\n" + arrList.toString());

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        System.out.print("\n[");
        
        for (Integer value : arrList) {
            System.out.print( value + ", " );    
        }

        System.out.print("]\n");

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */

        long time = System.nanoTime();

        for( int i = 0; i < ELEM; i++ ) {
            arrList.addFirst(i);
        }

        time = System.nanoTime() - time;

        System.out.println("Adding " 
        + ELEM + " element in ARRAYLIST took "
        + time + "ns ( " 
        + TimeUnit.NANOSECONDS.toMillis(time) + "ms )");


        time = System.nanoTime();

        for( int i = 0; i < ELEM; i++ ) {
            linkList.addFirst(i);
        }

        time = System.nanoTime() - time;

        System.out.println("Adding " 
        + ELEM + " element in LINKEDLIST took "
        + time + "ns ( " 
        + TimeUnit.NANOSECONDS.toMillis(time) + "ms )");
       

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */


        time = System.nanoTime();

        for( int i = 0; i < TOBERED; i++ ) {
            arrList.get(arrList.size() / 2);
        }

        time = System.nanoTime() - time;

        System.out.println("Reading " 
        + TOBERED + " times the middle element in ARRAYLIST took "
        + time + "ns ( " 
        + TimeUnit.NANOSECONDS.toMillis(time) + "ms )");

        time = System.nanoTime();

        for( int i = 0; i < TOBERED; i++ ) {
            linkList.get(linkList.size() / 2);
        }

        time = System.nanoTime() - time;

        System.out.println("Reading " 
        + TOBERED + " times the middle element in LINKEDLIST took "
        + time + "ns ( " 
        + TimeUnit.NANOSECONDS.toMillis(time) + "ms )");


        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String, Long> map = new HashMap<>();
        
        map.put("Africa", 1_110_635_000L);
        map.put("Americas", 920_005_000L);
        map.put("Antartica", 0L);
        map.put("Asia", 4_298_723_000L);
        map.put("Europe", 742_452_000L);
        map.put("Oceania", 38_304_000L);


        /*
         * 8) Compute the population of the world
         */
        Long totalPopulation = 0L;
        for (Long val : map.values()) {
            totalPopulation = totalPopulation + val;
        }

        System.out.println("La popolazione mondiale corrisponde a "
        + totalPopulation
        + " di persone");
    }
}
