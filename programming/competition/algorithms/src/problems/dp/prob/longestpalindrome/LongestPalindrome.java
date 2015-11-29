package problems.dp.prob.longestpalindrome;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class LongestPalindrome {

    public static void main(
            String[] args) {
        
        String from = "agbdba";
        System.out.println(LPSubSeqItr(from.toCharArray()));
        System.out.println(LPSubSeqReq(from.toCharArray(), 0, from.length()-1));

    }
    
    public static int LPSubSeqReq (char[] s, int start, int end) {
        
        if (start == end) 
            return 1;
        
        if (s[start] == s[end] && end == start+1)
            return 2;
        
        if (s[start] == s[end])
            return LPSubSeqReq(s, start+1, end-1) + 2;
        
        return Math.max(LPSubSeqReq(s,  start+1, end), LPSubSeqReq(s,  start, end-1));
    }

    public static int LPSubSeqItr(char [] s) {
        String result = "";
        
        int len = s.length;

        int a[][] = new int [len][len];        
        
        // This is for the length 1
        for (int i = 0; i < len; i++) {
            a[i][i] = 1;
        }
        
        for (int choosenLength = 2; choosenLength <= len; choosenLength++) {
            
            // Think of iteration based on the length = 1 then 2 and so on.
            
            int iterations = len-choosenLength +1;
            
            // Note: that we are evaluating and filling the matrix from diagonal to above
            
            for (int rowNumber = 0; rowNumber < iterations; rowNumber++) {
                
                int columnNumber = rowNumber + choosenLength -1;
                
                if (s[rowNumber] == s[columnNumber] & choosenLength == 2) {
                    a[rowNumber][columnNumber] = 2;
                } else if (s[rowNumber] == s[columnNumber]) {
                    a[rowNumber][columnNumber] = a[rowNumber+1][columnNumber-1] + 2;
                } else {
                    a[rowNumber][columnNumber] = Math.max(a[rowNumber][columnNumber-1], a[rowNumber+1][columnNumber]);
                }
                
            }
        }
        
        return a[0][len-1];
    }
}
