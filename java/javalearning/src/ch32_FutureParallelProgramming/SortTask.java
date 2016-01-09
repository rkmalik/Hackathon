package ch32_FutureParallelProgramming;

import java.util.concurrent.*;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class SortTask extends RecursiveAction {

	private final int THRESHOLD = 500;
	private int[] list;
	
	public SortTask (int [] list) {
		this.list = list;
	}

	protected void compute() {

		if (list.length < THRESHOLD)
			java.util.Arrays.sort(list);

		else {
			// Obtain the first half
			int[] firstHalf = new int[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);

			int secondHalfLength = list.length - list.length / 2;
			int[] secondHalf = new int[secondHalfLength];
			System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);

			invokeAll(new SortTask(firstHalf), new SortTask(secondHalf));
			// Merge firstHalf with secondHalf into list
			MergeSort.merge(list, firstHalf, secondHalf);
		}

	}

}
