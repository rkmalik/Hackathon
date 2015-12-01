package prob.medianfind;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionMedianFind {
	
	
	/***
	 * Min Heap will be holding the elements which are greater than the median
	 * Means it will be holding the Higher range integers
	 * 
	 * Max Heap will hold the lower Half of the integers. 
	 * 
	 * 
	 * 1-100 
	 * 
	 * 
	 * Max Heap [1,2,3....50]
	 * Min Heap [51, 52....100]
	 * 
	 * 
	 * */
	
	
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;
	
	Comparator<Integer> minHeapComparator; 
	Comparator<Integer> maxHeapComparator;
	
	public SolutionMedianFind (int size) {
		
		minHeapComparator = new MinHeapComparator();
		maxHeapComparator = new MaxHeapComparator();
		
		maxHeap = new PriorityQueue<>(size - size/2, maxHeapComparator);
		minHeap = new PriorityQueue<>(size/2, minHeapComparator);
		
	}
	
	public void insertRandomWrapper (int random) {
		
		System.out.println("Inserting " + random);
		insertRandomNumberToHeap(random);
		
		System.out.println("Median of the numbers: " + getMedian());
		
		System.out.println("------------");
		
	}
	
	private void insertRandomNumberToHeap (int randomNumber) {
		
		if (maxHeap.size() == minHeap.size()) {
			
			if (minHeap.peek() != null && randomNumber > minHeap.peek()) {
				maxHeap.offer(minHeap.poll());
				minHeap.offer(randomNumber);
			} else {
				maxHeap.offer(randomNumber);
			}
		} else {
			
			if (maxHeap.peek() != null && randomNumber < maxHeap.peek()) {
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(randomNumber);
			} else {
				minHeap.offer(randomNumber);
			}
		}
	}
	
	public float getMedian() {
		
		if (maxHeap.size() == 0) {
			return 0;
		}
		
		float median  = 0;
		
		if (maxHeap.size() == minHeap.size()) {
			float sum = maxHeap.peek() + minHeap.peek();
			System.out.println("Sum == " + sum);
			median = (sum) /2;
		} else {
			System.out.println("peek == " + maxHeap.peek());
			
			median = maxHeap.peek();
		}
		
		return median;
	}
	
	
	
	
}
