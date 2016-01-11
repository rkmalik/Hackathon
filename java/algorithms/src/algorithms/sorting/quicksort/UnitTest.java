package algorithms.sorting.quicksort;

import algorithms.utilities.RandomDataGenerator;

public class UnitTest {
    
    public static void main(String args[]) {
        test1();
        
        //test2();
        
        //test3();
    }
    
    private static void test3() {
        
        int arr [] = new int [1];
        System.out.println("UnSorted Array:");
        for (int i = 0; i < 1; i++) {
            arr[i] = RandomDataGenerator.getRandomInteger(100);
            System.out.print(arr[i]  + " ");
        }
        
        QuickSort qs = new QuickSort();
        
        qs.sort(arr);
        
        System.out.println("\nSorted Array:");
        for (int i = 0; i < 1; i++) {
            System.out.print(arr[i]  + " ");
        }
        System.out.println("\n*************************************\n");
    }
    
    private static void test1() {
        
        int arr [] = new int [10];
        System.out.println("UnSorted Array:");
        for (int i = 0; i < 10; i++) {
            arr[i] = RandomDataGenerator.getRandomInteger(100);
            System.out.print(arr[i]  + " ");
        }
        
        QuickSort qs = new QuickSort();
        
        int a[] = { 22, 11, 4, 7, 15, 32, 23, 11, 11 };
        qs.sort(a);
        
        System.out.println("\nSorted Array:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]  + " ");
        }
        System.out.println("\n*************************************\n");        
    }
    
    private static void test2() {
        
        int arr [] = new int [20];
        System.out.println("UnSorted Array:");
        for (int i = 0; i < 20; i++) {
            arr[i] = RandomDataGenerator.getRandomInteger(100);
            System.out.print(arr[i]  + " ");
        }
        
        QuickSort qs = new QuickSort();
        
        qs.sort(arr);
        
        System.out.println("\nSorted Array:");
        for (int i = 0; i < 20; i++) {
            System.out.print(arr[i]  + " ");
        }
        System.out.println("\n*************************************\n");        
    }
}
