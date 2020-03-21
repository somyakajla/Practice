package ArrayAndString;

public class ZeroMatrix {
	public static void main(String args[]) {
		int N = 4; 
		int matrix[][] = {
				{1, 2, 3},
				{5, 0, 7},
				{9, 10, 11},
				
		};
		setZeros(matrix);
		displayMatrix(matrix.length,matrix); 
	}
	private static void displayMatrix(int n, int[][] matrix) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(matrix[i][j] +" ");
			}
			System.out.println();
		}
		
	}

	private static void setZeros(int[][] matrix) {

		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix.length];
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		for(int i=0; i<matrix.length; i++) {
			if(row[i]== true) {
				nullifyRow(matrix, i);
			}
		}
		for(int i=0; i<matrix.length; i++) {
			if(row[i]== true) {
				nullifyColumn(matrix, i);
			}
		}
	}

	private static void nullifyColumn(int[][] matrix, int i) {
		for(int j=0; j<matrix[0].length; j++) {
			matrix[j][i] = 0;
			
		}
		
	}

	private static void nullifyRow(int[][] matrix, int i) {
		for(int j=0; j<matrix[0].length; j++) {
				matrix[i][j] = 0;
				
			}
		
	}

}
