package problems.dp.prob1;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class FibonacciNumberGenerator {

    private static int[] fib;

    public static void main(
            String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the nth number for which you want to get the fibonacci number. : ");

        int n = in.nextInt();

        fib = new int[n+1];

        int result = fibonacci(n);

        System.out.println(n + "th term in fibonacci series is " + result);
        for(int i : fib) {
            System.out.print(i + " ");
        }
    }

    public static int fibonacci(
            int n) {

        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        /**
         * Memoization to store the result to avoid future calculation
         */
        if (fib[n] == 0) {
            fib[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }

        return fib[n];
    }

}
