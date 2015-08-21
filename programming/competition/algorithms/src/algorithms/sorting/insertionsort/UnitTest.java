package algorithms.sorting.insertionsort;

import algorithms.utilities.RandomDataGenerator;

public class UnitTest {
    
    public static void main(String args[]) {
        test1();
        
        test2();
        
        test3();
    }
    
    private static void test3() {
        
        int arr [] = new int [0];
        System.out.println("UnSorted Array:");
        for (int i = 0; i < 0; i++) {
            arr[i] = RandomDataGenerator.getRandomInteger(100);
            System.out.print(arr[i]  + " ");
        }
        
        InsertionSort is = new InsertionSort();
        
        is.sort(arr);
        
        System.out.println("\nSorted Array:");
        for (int i = 0; i < 0; i++) {
            System.out.print(arr[i]  + " ");
        }
    }
    
    private static void test1() {
        
        int arr [] = new int [10];
        System.out.println("UnSorted Array:");
        for (int i = 0; i < 10; i++) {
            arr[i] = RandomDataGenerator.getRandomInteger(100);
            System.out.print(arr[i]  + " ");
        }
        
        InsertionSort is = new InsertionSort();
        
        is.sort(arr);
        
        System.out.println("\nSorted Array:");
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i]  + " ");
        }
    }
    
    private static void test2() {
        
        int arr [] = new int [20];
        System.out.println("UnSorted Array:");
        for (int i = 0; i < 20; i++) {
            arr[i] = RandomDataGenerator.getRandomInteger(100);
            System.out.print(arr[i]  + " ");
        }
        
        InsertionSort is = new InsertionSort();
        
        is.sort(arr);
        
        System.out.println("\nSorted Array:");
        for (int i = 0; i < 20; i++) {
            System.out.print(arr[i]  + " ");
        }
    }
}
