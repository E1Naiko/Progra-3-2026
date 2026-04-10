package tp2.Ej5;

import Tp1.Ej8.Queue;
import tp2.ejercicio1.BinaryTree;

public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> arbol;

    public BinaryTree<Integer> getArbol() {
        return arbol;
    }

    public void setArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public int sumaElementosEnProfundidad(int p){
        return entreNiveles(p, p);
    }

    private int entreNiveles(int n, int m){
		int cont = 0, act=0;
		BinaryTree<Integer> nodo = null;
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();

		// encolo la raiz del arbol
		cola.enqueue(arbol);
		cola.enqueue(null);
 
		while (!cola.isEmpty()){
			// desencolo nodo actual
			nodo = cola.dequeue();

			// subo de nivel
			if (nodo != null){
				// ESPECIFICO PARA EL EJ: si n<=cont<=m sumo
				if (cont >= n && cont <= m){
					act+=nodo.getData();
				}
				// encolo el hijo izq
				if (nodo.hasLeftChild()){
					cola.enqueue(nodo.getLeftChild());
				}
				// encolo el hijo der
				if (nodo.hasRightChild()){
					cola.enqueue(nodo.getRightChild());
				}
			}

			// bajo de nivel
			else if (!cola.isEmpty()) {
                // Se terminó un nivel, incrementamos para el siguiente
                cont++; 
                cola.enqueue(null);
                
                // OPTIMIZACIÓN: Si ya pasamos el nivel máximo 'm', podemos dejar de procesar
                if (cont > m) break; 
            }
		}
        return act;
   	}
}

/*
private int entreNiveles(int n, int m) {
    int cont = 0; // Nivel actual (Raíz = 0)
    int act = 0;  // Acumulador de la suma
    BinaryTree<Integer> nodo = null;
    Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();

    if (arbol == null || arbol.isEmpty()) return 0;

    cola.enqueue(arbol);
    cola.enqueue(null); // Separador del nivel 0

    while (!cola.isEmpty()) {
        nodo = cola.dequeue();

        if (nodo != null) {
            // CORRECCIÓN: Condición inclusiva para sumar el nivel deseado
            if (cont >= n && cont <= m) {
                act += nodo.getData();
            }
            
            if (nodo.hasLeftChild()) cola.enqueue(nodo.getLeftChild());
            if (nodo.hasRightChild()) cola.enqueue(nodo.getRightChild());
        } 
        else if (!cola.isEmpty()) {
            // Se terminó un nivel, incrementamos para el siguiente
            cont++; 
            cola.enqueue(null);
            
            // OPTIMIZACIÓN: Si ya pasamos el nivel máximo 'm', podemos dejar de procesar
            if (cont > m) break; 
        }
    }
    return act;
}
    */