package Grafo;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.Filter;

public class Grafo {

	private List<Integer> Nodos;
	private List<Edge> Arcos;
	private static Logger logger;

	public Grafo() {
		
		Nodos = new ArrayList<Integer>();
		Arcos = new ArrayList<Edge>();

		if (logger == null){
			
			logger = Logger.getLogger(Grafo.class.getName());
			
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);
			
			logger.setLevel(Level.WARNING);
			
			Logger rootLogger = logger.getParent();
			for (Handler h : rootLogger.getHandlers()){
				h.setLevel(Level.OFF);
			}
		}
		
	}

	public void addNode(int node) {
		boolean estaNodo = Nodos.contains(node);
		
		if (!estaNodo) {
			Nodos.add(node);
			logger.info("El nodo " + node + " fue agregado al grafo.");
		}
		else {
			logger.warning("El nodo " + node + " ya pertenece al grafo.");
		}
		
	}
	
	public void addEdge(int node1, int node2) {
		
		boolean estaNodo1 = Nodos.contains(node1);
		boolean estaNodo2 = Nodos.contains(node2);
		boolean encontre = false;
		int i = 0;
		Edge arco = new Edge(node1, node2);
		
		if ( estaNodo1 && estaNodo2 ) {
			while (i < Arcos.size() && !encontre) {
				if (Arcos.get(i).getNodo1() == node1 && Arcos.get(i).getNodo2() == node2 ) {
					encontre = true;
					logger.warning("El arco del nodo " + node1 + " al nodo " + node2 + " ya pertenece al grafo.");	
				}
				i++;
			}
			if (!encontre) {
				Arcos.add(arco);
				logger.info("Un arco del nodo " + node1 + " al nodo " + node2 + " ha sido agregado." );
			}	
		}
		else {
			if (!estaNodo1 && estaNodo2)
				logger.warning("El nodo " + node1 + " no pertenece al grafo.");
			else {
				if (estaNodo1 && !estaNodo2)
					logger.warning("El nodo " + node2 + " no pertenece al grafo.");
				else
					logger.warning("Los nodos " + node1 + " y " + node2 + " no pertenecen al grafo.");
			}
		}
		
	}

	public void removeNode(int node) {
		
		boolean estaNodo= Nodos.contains(node);
		int indice;
		Edge arco;
		
		if (estaNodo) {
			indice = Nodos.indexOf(node);
			Nodos.remove(indice);
			for (int i = Arcos.size()-1; i >= 0; i--) {
				arco = Arcos.get(i);
				if (arco.getNodo1() == node || arco.getNodo2() == node) {
					Arcos.remove(arco);
				}				
			}
			logger.info("El nodo " + node + " fue eliminado junto a todos sus arcos incidentes y emergentes.");
		}
		else {
			logger.warning("El nodo " + node + " no pertenece al grafo.");
		}
	
	}

	public void removeEdge(int node1, int node2) {

		boolean estaNodo1 = Nodos.contains(node1);
		boolean estaNodo2 = Nodos.contains(node2);
		boolean encontre = false;
		int i = 0;
		
		if (estaNodo1 && estaNodo2) {
			while (i < Arcos.size() && !encontre) {
				if (Arcos.get(i).getNodo1() == node1 && Arcos.get(i).getNodo2() == node2) {
					encontre = true;
					Arcos.remove(i);
					logger.info("El arco del nodo " + node1 + " al nodo " + node2 + " ha sido eliminado.");
				}
				i++;
			}
			if (!encontre)
				logger.warning("El arco del nodo " + node1 + " al nodo " + node2 + " no pertenece al grafo.");
		}
		else {
			if (!estaNodo1 && estaNodo2)
				logger.warning("El nodo " + node1 + " no pertenece al grafo.");
			else {
				if (estaNodo1 && !estaNodo2)
					logger.warning("El nodo " + node2 + " no pertenece al grafo.");
				else
					logger.warning("El nodo " + node1 + " y el nodo " + node2 + " no pertenecen al grafo.");
			}
		}
		
	}

}