package prob3;
public class Solution {
    public int lengthOfLongestSubstring(String s) {
    	
    	
    	// New array with default value of -1
    	int position[] = new int [256];
    	
    	for (int i = 0; i < 256; i++) {
    		position[i] = -1;
    	}
    	
    	// Iterate through the string and initialize the position
    	int length = s.length();
    	int maxLength = 0;
    	int currentLength = 0;
    	int lastRepeatedValueIndex = -1;
    	
    	for (int i = 0; i < length; i++) {
    		
    		// This is to update the latest repeated character index
    		if (position[s.charAt(i)] != -1 && (position[s.charAt(i)] > lastRepeatedValueIndex)) {
    			lastRepeatedValueIndex = position[s.charAt(i)];
    		} 
    		
    		currentLength = i - lastRepeatedValueIndex;
    				
			position[s.charAt(i)] = i;
    		
    		
    		if (currentLength > maxLength) {
    			maxLength = currentLength;
    		}
    	}
    	
    	return maxLength;
    }
}