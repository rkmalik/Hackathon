package leetcode.prob7;

public class Solution {

    public int reverse(
            int x) {

        long num = x;
        double result = 0;
        boolean isN = false;

        if (x < 0) {
            isN = true;
            num = -num;
        }

        while (num != 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }

        if (isN)
            result = -result;

        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            result = 0;
        } 

        return (int) result;
    }
}