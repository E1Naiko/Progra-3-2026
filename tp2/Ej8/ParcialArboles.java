package tp2.Ej8;

import Tp1.Ej8.Queue;
import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {
    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        boolean res = true;
        boolean encontre = false;
        if (arbol1 != null && arbol2 != null && !arbol1.isEmpty() && !arbol2.isEmpty()){
            Queue<BinaryTree<Integer>> cola1 = new Queue<BinaryTree<Integer>>();
            Queue<BinaryTree<Integer>> cola2 = new Queue<BinaryTree<Integer>>();
            BinaryTree<Integer> nodo1;
            BinaryTree<Integer> nodo2;

            cola1.enqueue(arbol1);
            cola2.enqueue(arbol2);
            while (!cola1.isEmpty() && !cola2.isEmpty() && ! encontre){
                nodo1 = cola1.dequeue();
                nodo2 = cola2.dequeue();

                if (nodo1 != null && nodo2!= null){
                    if (!esIgual(nodo1, nodo2)){
                        encontre = true;
                        break;
                    }
                    if (!tieneAmbosHijos(nodo1, nodo2)){
                        encontre = true;
                        break;
                    }
                    if (nodo1.hasLeftChild() && nodo2.hasLeftChild()){
                        cola1.enqueue(nodo1.getLeftChild());
                        cola2.enqueue(nodo2.getLeftChild());
                    }
                    if (nodo1.hasRightChild() && nodo2.hasRightChild()){
                        cola1.enqueue(nodo1.getRightChild());
                        cola2.enqueue(nodo2.getRightChild());
                    }
                }
                else if(!cola1.isEmpty() && !cola2.isEmpty()){
                    cola1.enqueue(null);
                    cola2.enqueue(null);
                }
            }
        }
        if (encontre)
            res = false;
        return res;
    }

    private boolean esIgual(BinaryTree<Integer> nodo1, BinaryTree<Integer> nodo2){
        return nodo1.getData().equals(nodo2.getData());
    }
    private boolean tieneAmbosHijos(BinaryTree<Integer> nodo1, BinaryTree<Integer> nodo2){
        boolean res = true;
        if (nodo1.hasLeftChild() && !nodo2.hasLeftChild())
            res = false;
        if (nodo1.hasRightChild() && !nodo2.hasRightChild())
            res = false;
    return res;
}
}
