package TreesAndGraphs;

public class BellmanFord {
	

	public static void main(String args[]) {
		int V = 5; 
	    int E = 8; 
	  
	    
	    int graph[][] = { { 0, 1, -1 }, { 0, 2, 4 }, 
	                    { 1, 2, 3 }, { 1, 3, 2 },  
	                    { 1, 4, 2 }, { 3, 2, 5 },  
	                    { 3, 1, 1 }, { 4, 3, -3 } }; 
	  
	    ShortestByBellmanFord(graph, V, E, 0); 
	    }

	private static void ShortestByBellmanFord(int[][] graph, int v, int e, int source) {
		// initialise array which will keep value of each vertex with max integer value except source
		int distance[] = new int[v];
		for(int i=0; i<distance.length; i++) {
			distance[i] = Integer.MAX_VALUE;	
		}
		distance[source] = 0;
		for(int k=0; k<v-1; k++) {
			for(int j=0; j<e; j++) {
				if(distance[graph[j][0]]+graph[j][2] < distance[graph[j][1]]) {
					distance[graph[j][1]] = distance[graph[j][0]]+graph[j][2];
					
				}
			}
		}
		// if we run one more time distance changes for any vertex then negative cycle present
		for (int i = 0; i < e; i++)  
	    { 
	        int x = graph[i][0]; 
	        int y = graph[i][1]; 
	        int weight = graph[i][2]; 
	        if (distance[x] != Integer.MAX_VALUE && 
	        		distance[x] + weight < distance[y]) 
	            System.out.println("Graph contains negative"
	                    +" weight cycle"); 
	    } 
	  
	    System.out.println("Vertex Distance from Source"); 
	    for (int i = 0; i < v; i++) 
	        System.out.println(i + "\t\t" + distance[i]); 
	} 
		
	} 
		
	
	  
