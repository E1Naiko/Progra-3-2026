package tp3;

import java.util.List;

import Tp1.Ej8.Queue;

import java.util.LinkedList;


public class GeneralTree<T> {

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}

	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}

	public boolean hasChildren() {
		return children != null && !children.isEmpty();
	}

	public boolean isEmpty() {
		return this.data == null && !hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren()) {
			List<GeneralTree<T>> children = this.getChildren();
			if (children.contains(child))
				children.remove(child);
		}
	}

	public int altura(){
		return recorrerArbolDevuelveAltura(this, 0);
	}

	private int recorrerArbolDevuelveAltura(GeneralTree<T> nodo, int altAct){
		int may = 0, aux;

		if (nodo.hasChildren()){
			for (GeneralTree<T> child: nodo.getChildren()){
				aux = recorrerArbolDevuelveAltura(child, altAct+1);
				if (aux>may)
					may = aux;
			}
		}

		return (altAct > may) ? altAct : may;
	}

	public int nivel(T dato){
		return recorrerArbolDevuelveNivel(this, dato);
	}

	private int recorrerArbolDevuelveNivel(GeneralTree<T> arbol, T dato){
		int nivel = 0;

		if (arbol == null || arbol.isEmpty())
			return -1;

		if (!arbol.getData().equals(dato)){
			boolean encontre = false;
			Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
			cola.enqueue(arbol);

			while (!cola.isEmpty() && !encontre){
				GeneralTree<T> nodo = cola.dequeue();
				if (nodo.getData().equals(dato)){
					encontre = true;
				}

				if (nodo.hasChildren()){
					for(GeneralTree<T> child : nodo.getChildren()){
						cola.enqueue(child);
					}
				}
			}
			nivel++;
		}
		return nivel;
	}

	public int ancho (){
		return recorrerArbolDevuelveAncho(this)
	}

	private int recorrerArbolDevuelveAncho(GeneralTree<T> arbol){
		int res = 0;
		int ancho = 0;

		if (arbol == null || arbol.isEmpty())
			return -1;

		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(arbol);
		while (!cola.isEmpty()){
			GeneralTree<T> nodo = cola.dequeue();
			if (nodo.hasChildren()){
				for(GeneralTree<T> child : nodo.getChildren()){
					cola.enqueue(child);
					ancho++;
				}
			}
			else {
				if (!cola.isEmpty()){
					if (ancho>res)
						res = ancho;
					ancho = 0;
					cola.enqueue(null);
				}
			}
		}
		return res;
	}
}
