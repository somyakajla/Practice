package recursionAnddynamic;

import java.util.ArrayList;

public class RobotinGridRecursive {
	public static class Point{
		int row;
		int col;
		Point(int r, int c){
			row = r;
			col = c;
		}
		
	}
	
	public static void main(String[] args)  
    { 
        int m = 2; 
        int n = 3; 
        int mat[][] = { { 1, 2, 3 },  
                        { 4, 5, 6 } }; 
        int maxLengthOfPath = m + n - 1; 
        ArrayList<Point> a = getPath(mat); 
        for(int i =0; i< a.size(); i++) {
        	Point p = a.get(i);
        	System.out.println(p.row+ " : "+p.col);
        }
    }

	private static ArrayList<Point> getPath(int[][] mat) {
		if(mat == null || mat.length == 0)
			return null;
		ArrayList<Point> path = new ArrayList<Point>();
		if(getPath(mat, mat.length-1, mat[0].length-1, path)) {
			return path;
		}
		return null;
	}

	private static boolean getPath(int[][] mat, int r, int c, ArrayList<Point> path) {
		if(r < 0 || c < 0)
			return false;
		boolean isAtOrigin = (r == 0) && (c == 0);
		if(isAtOrigin || getPath(mat, r, c-1, path) || getPath(mat, r-1, c, path)) {
			
			Point p = new Point(r, c);
			path.add(p);
			return true;
			
		}
		
		
		return false;
	}

	
	

}
