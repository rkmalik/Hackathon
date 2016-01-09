package a_ch11sortingsearching;


public class BinarySearchIterative {
	
	public static void main (String args []) {


		int arr[] = { 4, 7, 11, 15, 16, 23, 32 };

		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		int num = 15;
		int index = binarySearch (arr, num);
		System.out.println("Found " + num + " at index = " + index);


	}
	
	public static int binarySearch (int arr [], int x) {
		
		int low = 0; 
		int high = arr.length-1;
		
		while (low < high) {
		
			int mid = (high + low)/2;
			
			if (x < arr[mid]) {
				high = mid-1;
			} else if (x > arr[mid]) {
				low = mid+1;			
			} else {
				return mid;
			}
		}
		
		return -1;
	}

}