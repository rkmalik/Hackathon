package leetcode.prob205;

import java.util.HashMap;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if (s.length() != t.length()) 
            return false;
        
        HashMap<Character, Character> map = new HashMap<Character, Character> ();
        
        for (int i = 0; i < s.length(); i++) {
            
           char sc = s.charAt(i);
           char tc = t.charAt(i);
           
           if (map.containsKey(sc)) {
               
               if (map.get(sc) != tc)
                   return false;
           }
              
           
           // second case is that the source key is not present, but the value is present
           // that means it is associated with some other key. 
           // that means this dont pass isomorphic property
           
           else if (map.containsValue(tc))
               return false;
           
           map.put(sc, tc);
           
        }
        
        return true;
    }
}