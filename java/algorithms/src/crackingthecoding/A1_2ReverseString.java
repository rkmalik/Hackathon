package crackingthecoding;


public class A1_2ReverseString {
    
    public static void main (String [] arg) {
        
        System.out.println(isPermutation("rohit", "ohitm"));
        
    }

    static boolean isPermutation (String a, String b) {
        
        if (a.length() != b.length()) return false;
        
        int charcounts [] = new int [256];
        
        for (int i = 0; i < a.length(); i++) {
           charcounts[a.charAt(i)]++;
        }
        
        for (int i = 0; i < a.length(); i++) {
            
            charcounts[b.charAt(i)]--;
            if (charcounts[b.charAt(i)] < 0) return false;
        }
        
        return true;
    }
}
