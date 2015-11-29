package google;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Solution4 {
	
	public static void main (String [] args) {
		
		BufferedReader in = null;
		long total=0;
		
		try {
			in = new BufferedReader(new FileReader(new File("/home/rkmalik/Desktop/workspace/programming/competition/Test/src/google/Solutionslab1")));
		}catch(IOException e) {
			e.printStackTrace();
		}
		String s = "";
		
		try {
			s=in.readLine();
		}catch (IOException e) {
			e.printStackTrace();
		}
		for (; s!= null; ) {
			
			try {
				s=in.readLine();
			}catch (IOException e) {
				e.printStackTrace();
			}
			
			total+=Integer.parseInt(s);
		}
		
		System.out.println(total);
	}
}
