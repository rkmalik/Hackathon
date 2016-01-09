package leetcode.prob51;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    private int x[];
    private int r;
    
    public int totalNQueens(int n) {
        
        x = new int [n];
        r = 0;
        
        nQueen(0, n);
        
        return r;
    }
    
    void nQueen (int row, int size) {
        
        for (int col = 0; col < size; col++) {
            
            if (place(row, col)) {
                
                x[row] = col;
                if (row == size-1) {
                    r++;
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