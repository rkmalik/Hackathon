package leetcode.prob215;
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        if (k > nums.length) return -1;
        
        sort (nums);
        return nums[nums.length-k];
        
    }
    
    int size;

    public void sort(
            int arr[]) {

        size = arr.length-1;

        buildMaxHeap(arr);
        
        /**
         * Loop to sort all the elements in the heap and put them at the correct
         * position.
         * */
        for (int i = size; i > 0; i--) {
            
            /**
             * Swap the first element with the last element as the first element is the
             * largest element of the heap.
             * 
             * Then Again maxHeapify with one lesser element. 
             * */
            
            int temp = arr[0];
            arr[0] = arr[size];
            arr[size] = temp;
            size--;
            maxHeapify(arr, 0);
        }
    }

    private int left(
            int index) {
        return (2 * index+1);
    }

    private int right(
            int index) {
        return (2 * index + 2);
    }

    private int parent(
            int index) {
        return index/2;
    }

    private void buildMaxHeap(
            int[] arr) {
        
        int length = arr.length-1;
        
        for (int i = length/2; i >= 0; i--) {
            maxHeapify(arr, i);
        }
    }

    private void maxHeapify(
            int[] arr, int index) {
        
        int left = left(index);
        int right = right(index);
        
        int largest = index;
        
        if (left<= size && arr[largest] < arr[left]) {
            largest = left;
        }
        
        if (right <= size && arr[largest] < arr[right]) {
            largest = right;
        }
        
        if (largest != index) {
            
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            
            maxHeapify(arr, largest);
        }
    }
}