package leetcode.prob127;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {
    
    public static void  main (String args []) {
        
 
           Set <String> wordList = new HashSet<String>();
           
           wordList.add("hot");
           wordList.add("dot");
           wordList.add("dog");
           wordList.add("lot");
           wordList.add("log");
           
           String beginWord = "hit";
           String endWord = "cog";
           Solution sol = new Solution();
           
           System.out.println(sol.ladderLength(beginWord, endWord, wordList));
    }

}
