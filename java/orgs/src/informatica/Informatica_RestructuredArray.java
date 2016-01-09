package informatica;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Informatica_RestructuredArray {
	public static void main (String args []) {
		Scanner scn = new Scanner(System.in);

        int N = scn.nextInt();
        int R = scn.nextInt();
        List<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>> ();
        for (int i=R; i < N; i = i+R) {
            int j=0;
            ArrayList<Integer> myList = new ArrayList<Integer>();
            while (j < R) {
                myList.add(scn.nextInt());
                j++;
            }
            matrix.add(myList);
        }

        int T = scn.nextInt();
        int k =0;

        while (k < T) {
            int r = scn.nextInt();
            int c = scn.nextInt();

            ArrayList<Integer> mList = matrix.get(r-1);
            System.out.println(mList.get(c-1));
            k++;
        }
		
	}

}
