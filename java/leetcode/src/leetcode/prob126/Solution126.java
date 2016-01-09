package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution126 {
    
    static public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Solution126 sol = new Solution126 ();
        HashSet<String> visited = new HashSet<String>();
        HashSet<String> unvisited = new HashSet<String>();
        List<List<String>> r = new ArrayList<List<String>> ();
        LinkedList<WordLadderNode> queue = new LinkedList<WordLadderNode> ();
        
        wordList.add(endWord);
        
        //WordLadderNode node = new WordLadderNode(beginWord, 1, null);
        queue.add(new WordLadderNode(beginWord, 1, null));
        
        unvisited.addAll(wordList);
        int prevStepNum =0;
        int minStep = 0;
        
        
        while (queue.isEmpty()== false) {
            
                WordLadderNode top = queue.remove();
                int curStepNum = top.level;
                String word = top.word;
                
                if (top.word.equals(endWord)) {
                    if(minStep == 0){
                        minStep = top.level;
                    }
                    // Prepare a list and associate that to the resul
                    if (minStep == top.level && minStep != 0) {
                        List<String> a1 = new ArrayList<String>();
                        WordLadderNode n = top;
                        
                        while (n!= null) {
                            a1.add(0, n.word);
                            n = n.prev;
                        }
                        
                        r.add(a1);
                        continue;
                    }
                }
                
                if(prevStepNum < curStepNum){
                    unvisited.removeAll(visited);
                }
                
                prevStepNum = curStepNum;
                
                char[] arr = word.toCharArray();
                for(int i=0; i<arr.length; i++){
                    for(char c='a'; c<='z'; c++){
                        char temp = arr[i];
                        if(arr[i]!=c){
                            arr[i]=c;
                        }
     
                        String newWord = new String(arr);
                        if(unvisited.contains(newWord)){
                            queue.add(new WordLadderNode(newWord, top.level+1, top));
                            visited.add(newWord);
                        }
     
                        arr[i]=temp;
                    }
                }
            
            
        }
        
        return r;
    }
    
    public static void main (String [] args) {
        
        Set<String> set = new HashSet<String> ();
        
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");
        
        
        List<List<String>> list = findLadders("hit", "cog", set);
        
        System.out.println(list);
    }
}

class WordLadderNode {
    String word;
    int level;
    WordLadderNode prev;
    
    public WordLadderNode (String word, int level, WordLadderNode prev) {
        this.word = word;
        this.level = level;
        this.prev = prev;
    }
}