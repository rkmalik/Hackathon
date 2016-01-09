package leetcode.prob231;
public class Solution {
    
    public static void main (String [] args) {
        
        System.out.println(isPowerOfTwo(-16));
        
    }
    
    public static boolean isPowerOfTwo(int num) {
        
        if (num==0) 
            return false;
            
        if (num <0) {
            num = num*(-1);
        }
        
        if (num==1) 
            return true;
        while ( num > 1) {
            if (num%2 != 0)
                return false;
            num = num/2;
        }
        
        return true;
    }
}