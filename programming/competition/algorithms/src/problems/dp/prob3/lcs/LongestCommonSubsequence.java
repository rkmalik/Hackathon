package problems.dp.prob3.lcs;

import java.util.Scanner;

public class LongestCommonSubsequence {

    private static int lcs[][];

    public static void main(
            String[] args) {

        String str1 = "ABACEB";
        String str2 = "ADBAVCEB";
        
        /*String str1 = "XMJYAUZ";
        String str2 = "MZJAWXU";*/

        int len1 = str1.length();
        int len2 = str2.length();

        char str1Arr[] = str1.toCharArray();
        char str2Arr[] = str2.toCharArray();

        lcs = new int[len1 + 1][len2 + 1];

        int result = longestCommonSubsequence(str1Arr, str2Arr);
        String output = "";

        System.out.println("Longest common sequence length is : " + result);
        
        System.out.print("Longest common sequence is : ");
        for (int x =len1, y = len2; x > 0 && y > 0;) {
            
            if (lcs [x][y] == lcs [x][y-1]) {
                y--;
            } else if (lcs [x][y] == lcs [x-1][y]) {
                x--;
            } else {
                x--;
                y--;
                output = str1Arr[x]+ output;
            }
        }
        
        System.out.print(output);
    }

    public static int longestCommonSubsequence(
            char str1[],
            char str2[]) {

        int len1 = str1.length;

        for (int i = 0; i <= len1; i++)
            lcs[i][0] = 0;

        int len2 = str2.length;

        for (int i = 0; i <= len2; i++)
            lcs[0][i] = 0;

        for (int x = 0; x < len1; x++) {

            for (int y = 0; y < len2; y++) {

                if (str1[x] == str2[y]) {
                    lcs[x + 1][y + 1] = lcs[x][y] + 1;
                } else {
                    lcs[x + 1][y + 1] = lcs[x][y + 1] > lcs[x + 1][y] ? lcs[x][y + 1] : lcs[x + 1][y];
                }
            }
        }

        return lcs[len1][len2];
    }
}
