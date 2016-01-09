package leetcode.prob8;

public class Solution {

    public int myAtoi(
            String str) {

        str = str.trim();

        double result = 0;

        if (str.isEmpty())
            return 0;

        if (str.length() >= 2 && (str.charAt(0) == '+' || str.charAt(0) == '-')
                && (str.charAt(1) < '0' || str.charAt(1) > '9'))
            return 0;

        long m = 1;
        boolean isNegative = false;

        int i = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+')
            i = 1;

        while (i < str.length() && (str.charAt(i) - '0' >= 0) && (str.charAt(i) - '0' <= 9)) {
            result = result * 10 + str.charAt(i) - '0';
            i++;
        }

        result *= ((str.charAt(0) == '-') ? (-1) : 1);
        if (result < Integer.MIN_VALUE)
            result = Integer.MIN_VALUE;
        else if (result > Integer.MAX_VALUE)
            result = Integer.MAX_VALUE;

        return (int) result;
    }
}