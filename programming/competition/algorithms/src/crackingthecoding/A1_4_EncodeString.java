package crackingthecoding;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class A1_4_EncodeString {
    
    public static void main (String [] args) {
        
        char [] arr = new char [40];
        //String str = " rohit mohit sohit";
        String str = " ";
        System.arraycopy(str.toCharArray(), 0, arr, 0, str.length());
        encodeString(arr, str.length());
        
        System.out.println(arr);
        System.out.println(arr.length);
    }
    
    static char [] encodeString(char [] str, int len) {

        int count = 0;
        
        for (int i = 0; i < len; i++) {
            if (str[i] == ' ') {
                count++;
            }
        }

        if (count == 0) return str;
        
        int j = len-1;
        int newlen = len+count*2;
        str[newlen] = '\0';
        for (int i = newlen-1; j >=0; ) {
            
            if (str[j] == ' ') {
                str[i--] = '0';
                str[i--] = '2';
                str[i--] = '%';
                j--;
            } else {
                str[i--] = str[j--];
            }
        }
        
        return str;
    }
    
}
