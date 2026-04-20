package tp2.Ej7;

import Tp1.Ej8.Queue;
import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {
    private BinaryTree<Integer> arbol;

    public BinaryTree<Integer> getArbol() {
        return arbol;
    }
    
    public void setArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public boolean isLeftTree (int num){
        boolean res = false;
        BinaryTree<Integer> nodo = encontrarNodo(arbol, num);
        if (nodo!=null && !nodo.isEmpty()){
            Integer cantIzq = 0, cantDer = 0;
            if (nodo.hasLeftChild()){
                cantIzq = inOrder(nodo.getLeftChild());
            }
            if (nodo.hasRightChild()){
                cantDer = inOrder(nodo.getRightChild());
            }
            System.out.println(cantIzq + " " + cantDer);
            res = cantIzq > cantDer;
        }
        return res;
    }

    private int inOrder(BinaryTree<Integer> nodo){
        int res = 0;
        if (!nodo.isEmpty()){
            if (tieneSoloUnHijo(nodo))
                res++;
            if (nodo.hasLeftChild())
                res += inOrder(nodo.getLeftChild());
            if (nodo.hasRightChild())
                res += inOrder(nodo.getRightChild());
        }
        return res;
    }

    private boolean tieneSoloUnHijo(BinaryTree<Integer> nodo){
        boolean res;
        res = (nodo.hasLeftChild() && !nodo.hasRightChild()) || (!nodo.hasLeftChild() && nodo.hasRightChild());
        return res;
    }

    private BinaryTree<Integer> encontrarNodo(BinaryTree<Integer> arbol, int dato){
        BinaryTree<Integer> res = null;
        if (arbol != null && !arbol.isEmpty()){
            boolean encontre = false;
            Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
            BinaryTree<Integer> nodo;
            cola.enqueue(arbol);
            cola.enqueue(null);

            while (!cola.isEmpty() && !encontre){
                nodo = cola.dequeue();

                if (nodo!= null){
                    if (nodo.getData().equals(dato)){
                        encontre = true;
                        res = nodo;
                    }
                    if (nodo.hasLeftChild())
                        cola.enqueue(nodo.getLeftChild());
                    if (nodo.hasRightChild())
                        cola.enqueue(nodo.getRightChild());
                }
                else if (!cola.isEmpty())
                    cola.enqueue(null);
            }

        }
        return res;
    }
}
