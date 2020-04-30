package ArrayAndString;

public class RotateMatrix {
	/*
	 * Requirements 
	 * 1. clockwise / anti clockwise 
	 * 2. 
	 */
	
	public static void main(String args[]) {
		
		int N = 4; 
		int matrix[][] = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{ 13, 14, 15, 16}
		};
        // Tese Case 2 
        /* int mat[][] = { 
                            {1, 2, 3}, 
                            {4, 5, 6}, 
                            {7, 8, 9} 
                        }; 
         */
       
        // Tese Case 3 
        /*int mat[][] = { 
                        {1, 2}, 
                        {4, 5} 
                    };*/
		
       // before rotation 
		displayMatrix(N,matrix); 
		
		rotateMatrix(N,matrix); 
	       
        // Print rotated matrix 
        displayMatrix(N,matrix); 
	}

	private static void rotateMatrix(int N, int[][] mat) {
		for (int x = 0; x < N / 2; x++) 
        { 
            
            for (int y = x; y < N-x-1; y++) 
            { 
                int temp = mat[x][y]; 
       
                mat[x][y] = mat[y][N-1-x]; 
       
                mat[y][N-1-x] = mat[N-1-x][N-1-y]; 
       
                mat[N-1-x][N-1-y] = mat[N-1-y][x]; 
       
                mat[N-1-y][x] = temp; 
            } 
        } 
		
	}

	private static void displayMatrix(int n, int[][] matrix) {
		System.out.println();
		System.out.println("new matrix ::");
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(matrix[i][j] +" ");
			}
			System.out.println();
			
		}
		
	}

}
