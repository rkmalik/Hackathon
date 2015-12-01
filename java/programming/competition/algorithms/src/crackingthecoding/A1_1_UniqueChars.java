package crackingthecoding; 


public class A1_1_UniqueChars {
    
    public static void main (String [] args) {
        
        System.out.println(isUniqueCharacters("rohit"));
    }
    
    static boolean isUniqueCharacters(String str) {
        
        boolean isDuplicate [] = new boolean [256];
        
        for (int i = 0; i < str.length(); i++) {
            
            if (isDuplicate[str.charAt(i)] == true) 
                return false;
            else 
                isDuplicate[str.charAt(i)] = true;
        }
        
        return true;
    }
    
}
