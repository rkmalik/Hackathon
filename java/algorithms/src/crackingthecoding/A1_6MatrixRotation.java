package crackingthecoding;


public class A1_6MatrixRotation {
    
    /*1 2 3          7 4 1 
    4 5 6    ==>   8 5 2  
    7 8 9          9 6 3

  7,8,9,6,3,2,1,4,


    1 2 3 4         C 9 5 1
    5 6 7 8         D 0 6 2
    9 0 A B   ==>   E A 7 3
    C D E F         F B 8 4*/
    
    public static void main (String [] args) {
        
        //int mat [][] = new int [4][4];
        
        int mat [][] = {{1, 2, 3, 4},
                        {5,6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};
        int col= mat.length;
        int row = mat[0].length;
        
        for (int i = 0; i<row; i++ ) {
            for (int j = 0; j< col; j++) {
                System.out.print(mat[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        
        rotate (mat);
        
        for (int i = 0; i<row; i++ ) {
            for (int j = 0; j< col; j++) {
                System.out.print(mat[i][j] + "  ");
            }
            System.out.println();
        }
    }
    
    static void rotate (int [][] mat) {
        
        int col= mat.length;
        int row = mat[0].length;
        
        int n = mat.length;
        int layers = n/2;
        
        
        for (int l = 0; l < layers; l++) {
            
            int first = l;
            int last = n-l-1;
            
            for (int j = first; j<last; j++) {
                
                int offset = j-first;

                // Column will change
                int top = mat [first][j];
                mat[first][j] = mat[last-offset][first];
                mat[last-offset][first] = mat[last][last-offset];
                mat[last][last-offset] = mat[j][last];
                mat[j][last] = top;
            }
        }
    }

}
