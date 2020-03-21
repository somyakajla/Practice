package TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

import TreesAndGraphs.BreadthFirstSearch.Graph;

public class PathExists {

	static class Graph {
		int V;
		LinkedList<Integer> list[];

		Graph(int v) {
			this.V = v;
			list = new LinkedList[v];
			for (int i = 0; i < v; i++) {
				list[i] = new LinkedList<Integer>();
			}
		}

		void addElement(int v, int w) {
			list[v].add(w);
		}

		Boolean isReachable(int s, int d) {
			boolean visited[] = new boolean[V];
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(s);
			while (!queue.isEmpty()) {

				int el = queue.poll();
				if(el == d)
					return true;
				else {
					for (int element : list[el]) {
						if( ! visited[element] ) {
							queue.add(element);
							visited[element] = true;
						}

					}
					
				}

				
			}
			return false;
		}

	}

	public static void main(String args[]) {
		Graph g = new Graph(4);
		g.addElement(0, 1); 
        g.addElement(0, 2); 
        g.addElement(1, 2); 
        g.addElement(2, 0); 
        g.addElement(2, 3); 
        g.addElement(3, 3); 
		int u = 1; 
        int v = 3; 
		 if (g.isReachable(u, v)) 
	            System.out.println("There is a path from " + u +" to " + v); 
	        else
	            System.out.println("There is no path from " + u +" to " + v);
		 u = 3; 
	        v = 1; 
	        if (g.isReachable(u, v)) 
	            System.out.println("There is a path from " + u +" to " + v); 
	        else
	            System.out.println("There is no path from " + u +" to " + v);; 
	    
	  

	}

}
