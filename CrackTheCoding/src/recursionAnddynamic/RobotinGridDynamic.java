package recursionAnddynamic;

import java.util.ArrayList;
import java.util.HashSet;


public class RobotinGridDynamic {
	
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
		HashSet<Point> failedPoints = new HashSet<Point>();
		if(getPath(mat, mat.length-1, mat[0].length-1, path, failedPoints)) {
			return path;
		}
		return null;
	}

	private static boolean getPath(int[][] mat, int r, int c, ArrayList<Point> path, HashSet<Point> failedPoints) {
		if(r < 0 || c < 0)
			return false;
		Point p = new Point(r, c);
		
		if(failedPoints.contains(p))
			return false;
		
		boolean isAtOrigin = (r == 0) && (c == 0);
		
		if(isAtOrigin || getPath(mat, r, c-1, path, failedPoints) || getPath(mat, r-1, c, path, failedPoints)) {
			
			path.add(p);
			return true;
			
		}
		
		failedPoints.add(p); // cache the failed result so that we could go there.
		return false;
	}


}
