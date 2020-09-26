package Grafo;

public class GraphTester {

	public static void main ( String[]args ) {
		
		Grafo grafo = new Grafo();
		
		//Agrego nodos
		grafo.addNode(1);
		grafo.addNode(2);
		grafo.addNode(3);
		grafo.addNode(4);
		grafo.addNode(4);

		
		//Agrego arcos
		grafo.addEdge(1, 3);
		grafo.addEdge(2, 1);
		grafo.addEdge(2, 1);
		grafo.addEdge(1, 4);
	
		//Remuevo arcos
		grafo.removeEdge(2, 4);
		grafo.removeEdge(1, 3);
		grafo.removeEdge(4, 9);
	
		//Remuevo Nodos
		grafo.removeNode(1);
		grafo.removeNode(9);

		
	}
	
}