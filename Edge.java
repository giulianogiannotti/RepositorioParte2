package Grafo;

public class Edge {
	
	protected Integer nodo1;
	protected Integer nodo2;
	
	public Edge (Integer node1, Integer node2) {
		nodo1 = node1;
		nodo2 = node2;
	}
	
	public Integer getNodo1() {
		return nodo1;
	}
	
	public Integer getNodo2() {
		return nodo2;
	}
	
}