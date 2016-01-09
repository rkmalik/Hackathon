package leetcode.prob127;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        
        List<String> queue = new ArrayList<String> ();
        List<Integer> distq = new ArrayList<Integer> ();
        
        wordList.add(endWord);
        queue.add(beginWord);
        distq.add(1);
        
        while (queue.isEmpty() == false) {
            
            String word = queue.remove(0);
            int dist = distq.remove(0);
            
            if (word.equals(endWord)) {
                return dist;
            }
            
            // Now Loop through the each character and check which all are matching in the dictionary
            
            for (int i = 0; i < word.length(); i++) {
                
                //String sword = word;
                char [] wordArr = word.toCharArray();
                
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    
                    if (wordArr[i] == ch) continue;
                    
                    // Replace the char in the ith Pos in word.
                    wordArr[i] = ch;
                    String newWord = String.valueOf(wordArr);
                    if (wordList.contains(newWord) == true) {
                        
                        queue.add(newWord);
                        distq.add(dist+1);  
                        wordList.remove(newWord);
                    }
                }
            }
        }
        
        return 0;
    }
}