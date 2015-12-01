package crackingthecoding;


public class A1_5StringCompression {
    
    public static void main (String [] args) {
        
        String str = "aabcccccaaad";
        
        System.out.println(compress(str));
        
    }
    
    static String compress (String str) {
        
        if (str.isEmpty()) return str;
        
        
        StringBuilder s = new StringBuilder();

        int count = 1;
        char ch = str.charAt(0);
        
        for (int i = 1; i<str.length(); i++) {
            
            if (ch != str.charAt(i)) {
                s.append(ch).append(count);
                count = 1; 
                ch = str.charAt(i);
            } else {
                count++;
            }
            
            if (i == str.length()-1) {
                s.append(ch).append(count);
            }
        }
        
        return s.length() < str.length()? s.toString() : str;
    }
}
