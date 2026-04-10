package tp2.Ej4;

import tp2.ejercicio1.BinaryTree;

// Visto que unicamente es comparar cual de los 2 hijos es mas grande voy a usar el recorrido en profundidad
public class RedBinariaLlena {
    private BinaryTree<Integer> arbol;
    
    private RedBinariaLlena(BinaryTree<Integer> arbol){
        this.arbol = arbol;
    }
    
    public int retardoReenvio(){
        int res = calcularRetardo(arbol);
        return res;
    }
    
    private int calcularRetardo(BinaryTree<Integer> arbol){
        /* // Intento 1: puede ser que los hijos tenga una suma de retrasos mayores
        int act = arbol.getData();
        if (arbol.hasLeftChild() && arbol.hasRightChild()){
            
            if (arbol.getLeftChild().getData() > arbol.getRightChild().getData()){
                act += calcularRetardo(arbol.getLeftChild(), res);
            }
            else{
                act += calcularRetardo(arbol.getRightChild(), res);
            }
        }
        else{
            if (!arbol.hasRightChild()){
                act += calcularRetardo(arbol.getLeftChild(), res);
            }
            
            if (!arbol.hasLeftChild()){
                act += calcularRetardo(arbol.getRightChild(), res);
            }
        }
            
            return res + act;
        }
         */

        if (arbol.isLeaf())
            return arbol.getData();
        else{
            int retrasoIzquierdo = 0, retrasoDerecho = 0;

            if (arbol.hasLeftChild()){
                retrasoIzquierdo = calcularRetardo(arbol.getLeftChild());
            }
            if (arbol.hasRightChild()){
                retrasoDerecho = calcularRetardo(arbol.getRightChild());
            }
            if (retrasoIzquierdo > retrasoDerecho){
                return arbol.getData() + retrasoIzquierdo;
            }
            else{
                return arbol.getData() + retrasoDerecho;
            }
        }
    }
}

/*
package tp2.Ej4;

import tp2.ejercicio1.BinaryTree;

public class RedBinariaLlena {
    private BinaryTree<Integer> arbol;

    // Constructor público para poder instanciarlo desde el Test
    public RedBinariaLlena(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public int retardoReenvio() {
        if (arbol == null || arbol.isEmpty()) return 0;
        return calcularRetardo(arbol);
    }

    private int calcularRetardo(BinaryTree<Integer> nodo) {
        // Caso base: si es hoja, su retardo es su propio dato
        if (nodo.isLeaf()) {
            return nodo.getData();
        }

        int retardoIzquierdo = 0;
        int retardoDerecho = 0;

        // Calculamos el retardo total acumulado de cada rama recursivamente
        if (nodo.hasLeftChild()) {
            retardoIzquierdo = calcularRetardo(nodo.getLeftChild());
        }
        if (nodo.hasRightChild()) {
            retardoDerecho = calcularRetardo(nodo.getRightChild());
        }

        // El retardo máximo desde este nodo es su propio valor + el máximo de sus subárboles
        return nodo.getData() + Math.max(retardoIzquierdo, retardoDerecho);
    }
}
*/