package leetcode.prob151;

public class Solution {
    
    public static void main (String [] args) {
        
        System.out.println(reverseWords(" rohit    kumar"));
        System.out.println(reverseWords("    "));
    }
    public static String reverseWords(String s) {
        
        StringBuilder result = new StringBuilder("");
        String [] arr = s.split(" ");
        
        for (int i = arr.length-1; i >= 0; i--) {
            
            if (arr[i].equals("") == false){
                result.append(arr[i]);
                result.append(" ");
            }
        }
        
        return result.length()==0?"":result.substring(0, result.length()-1);
    }
}