package TreesAndGraphs;

import java.util.LinkedList;

public class DFSgraph {
	
	static class Graph 
	{ 
		int V; // no of nodes
		LinkedList<Integer> array[]; // type var_name [] = new type[size]; here type is linkedList<Integer>
		Graph( int val){
			this.V = val;
			array = new LinkedList[val]; // important
			for(int i=0; i<val; i++)
				array[i] = new LinkedList<>(); // initialize each index of array with new object of array
			
		}
		
	}

		 public static void addEdge(Graph g, int i, int j) {
			g.array[i].add(j);
			
		}

		 static void DFSUtil(Graph g, int v,boolean visited[]) 
		    { 
		        // Mark the current node as visited and print it 
		        visited[v] = true; 
		        System.out.print(v+" "); 
		  
		        // Recur for all the vertices adjacent to this vertex 
		        for(int a = 0; a < g.V; a++) {
		        	 Integer list = g.array[v].get(a);
		        	 if (!visited[list]) 
			                DFSUtil(g, list, visited); 
			        } 
		    } 
		  
		    // The function to do DFS traversal. It uses recursive DFSUtil() 
		    static void DFS(Graph g, int v) 
		    { 
		        // Mark all the vertices as not visited(set as 
		        // false by default in java) 
		        boolean visited[] = new boolean[g.V]; 
		  
		        // Call the recursive helper function to print DFS traversal 
		        DFSUtil(g, v, visited); 
		    } 
	
	public static void main(String args[]) 
    { 
        Graph g = new Graph(4); 
  
        addEdge(g, 0, 1); 
        addEdge(g, 0, 2); 
        addEdge(g, 1, 2); 
        addEdge(g, 2, 0); 
        addEdge(g, 2, 3); 
        addEdge(g, 3, 3); 
  
        System.out.println("Following is Depth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        DFS(g, 2); 
    } 

}
