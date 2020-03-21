package TreesAndGraphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class BreadthFirstSearch {
	
	static class Graph{
		
		int v;
		LinkedList<Integer> list[];
		
		Graph(int a){
			this.v = a;
			list = new LinkedList[v];
			for(int i = 0; i < v; i++) {
				list[i] = new LinkedList<Integer>();
			}
		}
		void addElement(int w, int x) {
			list[w].add(x);
		}
	}
	
	private static void printGraph(Graph g) {
		  for(int i =0; i< g.v ; i++) {
			  System.out.println("Adjacency list of vertex : "+i);
			  System.out.print("head ");
			  for(int el : g.list[i])
				  System.out.print("->"+el);
				
			  System.out.println();
			  
		  }
	}
	/*private static void BFSearch(Graph g, int i) {
		boolean visited[] = new boolean[g.v]; 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        visited[i]=true; 
        queue.add(i); 
        while(queue.size()!=0) {
        	int elm = queue.poll();
        	System.out.print(elm +" "); 
        	int size = g.list[elm].size();
        	for(int j =0 ; j < size; j++) {
        		int element = g.list[elm].get(j);
        		if(!visited[element]) {
        			visited[element] = true;
        		    queue.add(element);
        		}
        	}
        }
		
	}*/
	public static void main(String args[]) {
		//Graph g = new Graph(6);
		Graph g = new Graph(5); 
        
        g.addElement(1, 0); 
        g.addElement(0, 2); 
        g.addElement(2, 1); 
        g.addElement(0, 3); 
        g.addElement(1, 4); 
		/*g.addElement(0, 1); 
        g.addElement(0, 2); 
        g.addElement(1, 2); 
        g.addElement(2, 0); 
        g.addElement(2, 3); 
        g.addElement(3, 3);
        g.addElement(3, 4); 
        g.addElement(3, 5);
        g.addElement(4, 3); 
        g.addElement(5, 3);
        g.addElement(5, 4);*/
        
        printGraph(g);
        
        BFSearch(g, 2);
        DFSSearch(g, 2);
	}
	private static void DFSSearch(Graph g, int i) {
		System.out.println();
		System.out.println("Print DFS");
		boolean visited[] = new boolean[g.v];
		visited[i] = true;
		Stack<Integer> stack = new Stack<>(); 
		stack.push(i);
		while(! stack.isEmpty()) {
			int a = stack.peek(); 
            stack.pop(); 
			System.out.print(a +" ");
			Iterator<Integer> itr = g.list[a].iterator(); 
            
            while (itr.hasNext())  
            { 
                int v = itr.next(); 
                if(!visited[v]) 
                    stack.push(v); 
            } 
			/*for(int el : g.list[a]) {
				if(! visited[el]) {
					stack.push(el);
					visited[el] = true;
					
				}
					
			
			
	}*/
}
}
	private static void BFSearch(Graph g, int i) {
		System.out.println("Print BFS");
		boolean visited[] = new boolean[g.v];
		visited[i] = true;
		Queue<Integer> queue = new LinkedList<>(); 
		queue.add(i);
		while(! queue.isEmpty()) {
			int a = queue.poll();
			System.out.print(a +" ");
			for(int el : g.list[a]) {
				if(! visited[el]) {
					queue.add(el);
					visited[el] = true;
					
				}
					
			}
			
		}
		
		
		
	}
	
	
	

}
