package leetcode.prob9;
public class Solution {
    
    public static void main (String args[]) {
        
        
        System.out.println(isPalindrome(1410110141));
    }
    
    
    public static boolean isPalindrome(int x) {
        
        if (x<0) return false;
        if (x/10 == 0) return true;
        
        int digits = 0;
        int n = x;
        
        int div = 1;
        
        while (n/(div)>=10) {
            div*=10;
        }
        
        System.out.println(div);
        
        while (n!=0) {
            if (n/div!=n%10) return false;
            n%=div;
            n/=10;
            div/=100;
        }
/*        
        for (int i = 0; i < digits/2; i++) {
            int divR = (int)Math.pow(10,i);
            int divL = (int)Math.pow(10,digits-1-i);
            
            int digL = (x/divL)%10;
            int digR = (x/divR)%10;
            if (digL!=digR) return false;
        }*/
        
        return true;
    }
}