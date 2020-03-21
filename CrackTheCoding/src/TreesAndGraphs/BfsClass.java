package TreesAndGraphs;

import java.util.LinkedList;

public class BfsClass {
	
	static class Graph{
		
		int V;
		LinkedList<Integer> array[];
		
		Graph(int val){
			
			this.V = val;
			array = new LinkedList[V];
			for(int i=0; i<V; i++) {
				array[i] = new LinkedList<>();
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		int V = 5;
		Graph graph = new Graph(V);
		 addEdge(graph, 0, 1); 
	     addEdge(graph, 0, 2); 
	     addEdge(graph, 1, 2); 
	     addEdge(graph, 2, 0); 
	     addEdge(graph, 2, 3); 
	     addEdge(graph, 3, 3); 

		//printGraph(graph);
		System.out.println("Following is Breadth First Traversal "+ 
                "(starting from vertex 2)"); 
		BFS(graph, 2);
	}

	private static void BFS(Graph graph, int i) {
		
		boolean visited[] = new boolean[graph.V]; 
		  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[i]=true; 
        queue.add(i); 
  
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            i = queue.poll(); 
            System.out.print(i+" "); 
            int s = graph.array[i].size(); 
            for(int j=0; j<s; j++) {
 
                int n = graph.array[i].get(j); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        } 
		
	}

	private static void printGraph(Graph graph) {
		
		System.out.println(" Adjacency list is as : ");
		for(int i = 0; i < graph.array.length; i++) {
			System.out.println("Array element is "+graph.array[i]);
			System.out.print(" Head ");
			for(int j=0; j< graph.array[i].size(); j++) {
				
				System.out.print("-> "+graph.array[i].get(j));
				
			}
			System.out.println();
			
		}
		
	}

	private static void addEdge(Graph graph, int source, int destination) {
		graph.array[source].add(destination);
		
	}

}
