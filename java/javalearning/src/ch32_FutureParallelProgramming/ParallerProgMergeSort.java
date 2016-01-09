package ch32_FutureParallelProgramming;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;


public class ParallerProgMergeSort {
	
	
	
	public static void main (String args []) {
		
		int SIZE = 10000000;
		Random rand = new Random ();
		
		
		int list1 [] = new int [SIZE];
		int list2 [] = new int [SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			list2[i] = list1[i] = rand.nextInt(SIZE);
		}
		
		long startTime = System.currentTimeMillis();
		MergeSort.sort(list1);
/*		for (int i = 0; i < list1.length; i++) {
			System.out.print(list1[i] + ", ");
			if (i%50==0)
				System.out.println("");
		}
*/		long endTime = System.currentTimeMillis();
		System.out.println("\nSequential time with " + Runtime.getRuntime().availableProcessors() +
		" processors is " + (endTime - startTime) + " milliseconds");
		
		
		startTime = System.currentTimeMillis();
		processTask (list2);
		endTime = System.currentTimeMillis();
		
		/*for (int i = 0; i < list2.length; i++) {
			System.out.print(list2[i] + ", ");
			if (i%50==0)
				System.out.println("");
		}*/
		
		System.out.println("\nParallel time with " + Runtime.getRuntime().availableProcessors() +
		" processors is " + (endTime - startTime) + " milliseconds");
		
	}
	
	
	private static void processTask (int [] list) {
		
		RecursiveAction task = new SortTask(list);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);
	}

}
