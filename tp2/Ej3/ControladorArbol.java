package Ej3;

import java.util.ArrayList;
import java.util.List;

import tp2.ejercicio1.BinaryTree;

public class ControladorArbol {
    private BinaryTree<Integer> arbol;

    public BinaryTree<Integer> getArbol() {
        return arbol;
    }

    public void setArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    private boolean esPar(int i){
        return (i%2==0);
    }

    public List<Integer> numerosParesInOrder(){
        List<Integer> lista = new ArrayList<Integer>();
        inOrder(arbol, lista);
        return lista;
    }

    private void inOrder(BinaryTree<Integer> nodo, List<Integer> lista){
        if (nodo == null) return;
        int act = nodo.getData();
        
        

        if (nodo.hasLeftChild())
            inOrder(nodo.getLeftChild(), lista);

        if (esPar(act))
            lista.add(act);
        
        if (nodo.hasRightChild())
            inOrder(nodo.getRightChild(), lista);
    }

    public List<Integer> numerosParesPostOrder(){
        List<Integer> lista = new ArrayList<Integer>();
        postOrder(arbol, lista);
        return lista;
    }

    private void postOrder(BinaryTree<Integer> nodo, List<Integer> lista){
        if (nodo == null) return;
        int act = nodo.getData();
        
        if (nodo.hasLeftChild())
            postOrder(nodo.getLeftChild(), lista);
        
        if (nodo.hasRightChild())
            postOrder(nodo.getRightChild(), lista);

        if (esPar(act))
            lista.add(act);
    }
}
