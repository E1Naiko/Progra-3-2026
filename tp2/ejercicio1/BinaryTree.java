package tp2.ejercicio1;

import Tp1.Ej8.Queue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
		int res = contador(this, 0);
		return res;
	}
		
	private	int contador(BinaryTree<T> nodo, int act){
		if (!nodo.hasLeftChild() &&  !nodo.hasRightChild()){
			act++;
		}

		if (nodo.hasLeftChild()){
			act += contador(nodo.leftChild, act);
		}

		if (nodo.hasRightChild()){
			act += contador(nodo.rightChild, act);
		}
		
		return act;
	}
    	 
    public BinaryTree<T> espejo(){
		BinaryTree<T> nodo = this;
		reflejar(nodo);
 	    return nodo;
    }

	private void reflejar(BinaryTree<T> nodo){
		BinaryTree<T> aux = null;
		
		if (nodo.hasLeftChild()){
			reflejar(nodo.leftChild);
		}

		if (nodo.hasRightChild()){
			reflejar(nodo.rightChild);
		}

		aux = nodo.leftChild;
		nodo.leftChild = nodo.rightChild;
		nodo.rightChild = aux;
	}

	// 0<=n<=m
	/*
	public void porNiveles() {
		encolar(raíz);
		mientras (cola no se vacíe) {
			desencolar(v);
			imprimir (dato de v);
			si (tiene hijo_izquierdo)
				encolar(hijo_izquierdo);
			si (tiene hijo_derecho)
				encolar(hijo_derecho);
		}
	}

	public void printLevelTraversal() {
    	BinaryTree<T> ab = null;
    	Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
    	
		cola.enqueue(this);
    	cola.enqueue(null);
    	
		while (!cola.isEmpty()) {
    		ab = cola.dequeue();
    		if (ab != null) {
    			System.out.print(ab.getData());
    			
				if (ab.hasLeftChild()) {
    				cola.enqueue(ab.getLeftChild());
    			}
    				if (ab.hasRightChild()) {
    				cola.enqueue(ab.getRightChild());
    			}
    		} else if (!cola.isEmpty()) {
    			System.out.println();
    			cola.enqueue(null);
    		}
    	}
	}
	*/
	public void entreNiveles(int n, int m){
		int cont = 0;
		BinaryTree<T> nodo = null;
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();

		// encolo la raiz del arbol
		cola.enqueue(this);
		cola.enqueue(null);
 
		while (!cola.isEmpty()){
			// desencolo nodo actual
			nodo = cola.dequeue();

			// subo de nivel
			if (nodo != null){
				cont++;
				// ESPECIFICO PARA EL EJ: si n<=cont<=m imprimo
				if (cont < n && cont <= m){
					System.out.println(nodo.getData());
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
			else if(!cola.isEmpty()){
				System.out.println();
				cont--;
				cola.enqueue(null);
			}
		}
   	}

}

