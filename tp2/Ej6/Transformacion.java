package tp2.Ej6;

import tp2.ejercicio1.BinaryTree;

public class Transformacion {
    private BinaryTree<Integer> arbol;
    public BinaryTree<Integer> suma(){
        postOrder(arbol);
        return arbol;
    }
    private int postOrder(BinaryTree<Integer> nodo){
        int act = nodo.getData(),
            sumIzq = 0,
            sumDer = 0;
        
        if (nodo.hasLeftChild()){
            sumIzq = postOrder(nodo.getLeftChild());
        }

        if (nodo.hasRightChild()){
            sumDer = postOrder(nodo.getRightChild());
        }

        nodo.setData(sumIzq + sumDer);

        return act + sumIzq + sumDer;
    }   
}