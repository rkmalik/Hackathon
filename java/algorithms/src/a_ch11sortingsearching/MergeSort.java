package a_ch11sortingsearching;

import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {

		int arr[] = { 22, 11, 4, 7, 15, 32, 23 };

		for (int i : arr) {
			System.out.print(i + " ");
		}

		System.out.println();

		sort(arr);

		for (int i : arr) {
			System.out.print(i + " ");
		}

	}
	public static void sort(int[] arr) {
		int helper[] = new int[arr.length];
		mergeSort(arr, helper, 0, arr.length - 1);
	}
	public static void mergeSort(int[] arr, int[] helper, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(arr, helper, low, mid);
			mergeSort(arr, helper, mid + 1, high);
			merge(arr, helper, low, mid, high);
		}
	}
	public static void merge(int[] arr, int[] helper, int low, int mid, int high) {
		// First copy all the elements from the arr to the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = arr[i];
		}
		// merge the two subarray to the arr
		int startLeft = low;
		int startRight = mid + 1;
		int current = low;
		while (startLeft <= mid && startRight <= high) {
			if (helper[startLeft] < helper[startRight]) {
				arr[current++] = helper[startLeft++];
			} else {
				arr[current++] = helper[startRight++];
			}
		}
		// copy the remining left subarray if there is something remaining
		while (startLeft <= mid) {
			arr[current++] = helper[startLeft++];
		}
	}
}
