package leetcode.prob241;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) return false;
        
        
        char [] s1 = s.toCharArray();
        char [] t1 = t.toCharArray();
        //Arrays.sort(s1);
        //Arrays.sort(t1);
        
        int [] match = new int [256];
        
        for (int i = 0; i < s.length(); i++) {
          match[s1[i]]++;  
        }
        
        for (int i = 0; i < s.length(); i++) {
            
            if (match[t1[i]] == 0) 
                return false;
            
            match[t1[i]]--;
        }
        
        return true;
    }
    
   
}