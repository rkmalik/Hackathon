package leetcode.prob52;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    private int x[];
    private List<List<String>> r;

    public List<List<String>> solveNQueens(int n) {
        
        x = new int [n];
        r = new ArrayList<List<String>>();
        
        nQueen(0, n);
        
        return r;
    }
    
    void initOutput () {
        
        List<String> list = new ArrayList<>();
        
        
        for (int i = 0; i < x.length; i++) {
            String output="";
            
            for (int j = 0; j < x.length; j++){
                
                if (j == x[i]) {
                    output += "Q";
                } else {
                    output += ".";
                }
            }
            list.add(output);
        }
        
        r.add(list);
    }
    
    void nQueen (int row, int size) {
        
        for (int col = 0; col < size; col++) {
            
            if (place(row, col)) {
                
                x[row] = col;
                if (row == size-1) {
                    initOutput();
                } else {
                    nQueen (row+1, size);
                }
            }
        }
    }
    
    boolean place (int r, int c) {
        
        for (int i = 0; i <= r-1; i++) {
            if (x[i] == c || (Math.abs(r-i) == Math.abs(x[i] - c)))
                return false;
        }
        
        return true;
    }
}