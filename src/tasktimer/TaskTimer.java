package tasktimer;

import static java.lang.System.out;
import java.util.Scanner;
import java.io.*;
import java.util.function.IntConsumer;
import java.util.function.Consumer;
import java.util.concurrent.atomic.*;  // hack, using AtomicInteger as accumulator

/**
 * Time how long it takes to perform some tasks
 * using different programming constructs.
 * 
 * TODO Improve this code by restructuring it to eliminate duplicate code.
 */
public class TaskTimer {

    /** 
     * Define a customer Consumer class that computes <b>both</b> the average 
     * and count of values.
     * An IntConsumer is a special Consumer interface the has an 'int' parameter 
     * in accept().
     */
    static class IntCounter implements IntConsumer {
        // count the values
        public int count = 0;
        // total of the values
        private long total = 0;
        /** accept consumes an int. In this method, count the value and add it to total. */
        public void accept(int value) { count++; total += value; }
        /** Get the average of all the values consumed. */
        public double average() { 
            return (count>0) ? ((double)total)/count : 0.0;
        }
        public int getCount() { return count; }
    }
    
    /**
     * Print and call run method 
     * @param task is selected task
     */
    public static void exacAndPrint (Runnable task) {  
    	StopWatch stw = new StopWatch();
    	
    	out.println( task.toString() );
    	stw.start();
    	task.run();
    	stw.stop();
    	out.printf( "Elapsed time is %f sec\n", stw.getElapsed() );
    }
        
    /** Run all the tasks. */
    public static void main(String [] args) {
        exacAndPrint( new Task1() );
        exacAndPrint( new Task2() );
        exacAndPrint( new Task3() );
        exacAndPrint( new Task4() );
        exacAndPrint( new Task5() );
        exacAndPrint( new Task6() );
    }
    
}
