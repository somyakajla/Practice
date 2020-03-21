package TreesAndGraphs;

import java.util.LinkedList;

class AdjList{
	
	static class Graph{
		
		int V;
		LinkedList<Integer> list[];
		Graph(int v){
			this.V = v;
			list= new LinkedList[V];
			for(int i=0; i<v; i++) {
				list[i] = new LinkedList<Integer>();
			}
		}
		void addElement(int v, int w) {
			list[v].add(w);
		}
		
		void printGraph(Graph g) {
			for(int i =0 ; i< g.V; i++) {
				System.out.println("Adjacency list of vertex : "+i);
				 System.out.print("head ");
				for(int j=0; j<g.list[i].size(); j++) {
					System.out.print(" -> "+g.list[i].get(j));
				}
				System.out.println();
			}
			
		}
		
	}
	
	
	public static void main(String args[]) {
		Graph g = new Graph(7);
		g.addElement(0, 1);
		g.addElement(1, 2);
		g.addElement(2, 0);
		g.addElement(2, 3);
		g.addElement(3, 2);
		g.addElement(4, 6);
		g.addElement(5, 4);
		g.addElement(6, 5);
		g.printGraph(g);
		
		
	}
}


/*public class AdjList {
	
	static class Graph{
		
		int V; //number of vertices in the graph
		LinkedList<Integer> list[]; // Nodes of graph
		
		Graph( int v){
			this.V = v;
			list = new LinkedList[v];
			for(int i=0; i<v; i++) {
				list[i] = new LinkedList<Integer>();
			}	
		}
		void addElement(int a, int w) {
			list[a].add(w);
		}
	}
  private static void printGraph(Graph g) {
	  for(int i =0; i< g.V ; i++) {
		  System.out.println("Adjacency list of vertex : "+i);
		  System.out.print("head ");
		  for(int el : g.list[i])
			  System.out.print("->"+el);
			
		  System.out.println();
		  
	  }
	  
		
	}
	
	public static void main(String args[]) {
		
		Graph g = new Graph(5);
		g.addElement(0, 1); 
        g.addElement(0, 2); 
        g.addElement(1, 2); 
        g.addElement(2, 0); 
        g.addElement(2, 3); 
        g.addElement(3, 3); 
        g.addElement(4, 1);
        g.addElement(4, 3); 
        
         printGraph(g);
		
	}

 

}*/
