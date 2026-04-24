package Tp3.Ej2a;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Tp1.Ej8.Queue;
import ejercicio1.BinaryTree;
import tp3.GeneralTree;

public class RecorridosAG {
    public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree<Integer> a, Integer n){
        List<Integer> res = new LinkedList<>();
        
        if (a!=null && !a.isEmpty())
            preOrder(a, n, res);

        return res;
    }

    private void preOrder(GeneralTree<Integer> nodo, Integer n, List<Integer> res){
        if (nodo!=null){
            int act = nodo.getData();
            if (act % 2 != 0 && act > n.intValue())
                res.add(act);

            if (nodo.hasChildren()){
                List<GeneralTree<Integer>> children = nodo.getChildren();
                for (GeneralTree<Integer> child: children){
                    preOrder(child, n, res);
                }
            }
        }
    }

    /*

    // --------------- CON ITERATOR ---------------
    private void preOrder(GeneralTree<Integer> nodo, Integer n, List<Integer> res) {
        // 1. Procesar la raíz (Pre-orden)
        int act = nodo.getData();
        if (act % 2 != 0 && act > n) {
            res.add(act);
        }

        // 2. Procesar los hijos usando un Iterator en lugar de foreach [4, 6]
        if (nodo.hasChildren()) {
            List<GeneralTree<Integer>> children = nodo.getChildren();
            
            // Obtenemos el iterador de la lista de hijos [2, 3]
            Iterator<GeneralTree<Integer>> it = children.iterator();
            
            // Recorremos mientras el iterador tenga elementos [2, 3]
            while (it.hasNext()) {
                // Obtenemos el siguiente hijo y hacemos la llamada recursiva [6]
                GeneralTree<Integer> child = it.next();
                preOrder(child, n, res);
            }
        }
    } */

    public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n){
        List<Integer> res = new LinkedList<>();
        
        if (a!=null && !a.isEmpty()){
            inOrder(a, n, res);
            return res;
        }
        return 0;
    }
    
    private void inOrder(GeneralTree<Integer> nodo, Integer n, List<Integer> res){
        if (nodo!=null){
            List<GeneralTree<Integer>> children;
            Iterator<GeneralTree<Integer>> it = null;
            GeneralTree<Integer> child;
            
            if (nodo.hasChildren()){
                children = nodo.getChildren();
                it = children.iterator();
                if (it.hasNext()){
                    child = it.next();
                   inOrder(child, n, res);
                }
            }
            
            int act = nodo.getData();
            if (act % 2 != 0 && act > n.intValue())
                res.add(act);
            
            if (it != null){
                while (it.hasNext()){
                    child = it.next();
                    inOrder(child, n, res);
                }
            }
        }
    }


    public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n){
        List<Integer> res = new LinkedList<>();
        
        if (a!=null && !a.isEmpty())
            postOrder(a, n, res);

        return res;
    }

    private void postOrder(GeneralTree<Integer> nodo, Integer n, List<Integer> res){
        if (nodo!=null){            
            if (nodo.hasChildren()){
                List<GeneralTree<Integer>> children = nodo.getChildren();
                for (GeneralTree<Integer> child: children){
                    postOrder(child, n, res);
                }
            }

            int act = nodo.getData();
            if (act % 2 != 0 && act > n.intValue())
                res.add(act);
        }
    }

    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n){
        if (a!=null && !a.isEmpty())
            LinkedList<Integer> res = porNiveles(a, n);

        return res;
    }

    private List<Integer> porNiveles(GeneralTree <Integer> a, Integer n){
        int aux;
        List<Integer> res = new LinkedList<>();
        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
        cola.enqueue(a);

        while (!cola.isEmpty()){
			GeneralTree<Integer> nodo = cola.dequeue();

            aux = nodo.getData();
			if (aux % 2 != 0 && aux > n.intValue()){
                res.add(aux);
            }

            if (nodo.hasChildren())
			    for (GeneralTree<Integer> child : nodo.getChildren()){
                    cola.enqueue(child);
                }

			else if (!cola.isEmpty()) {
                cola.enqueue(null);
            }
		}

        return res;
    }

    /*
    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n){
        List<Integer> res = new LinkedList<>();

        if (a != null && !a.isEmpty())
            porNiveles(a, n, res);

        return res;
    }

    private void porNiveles(GeneralTree<Integer> a, Integer n, List<Integer> res){
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enqueue(a);

        while (!cola.isEmpty()){
            GeneralTree<Integer> nodo = cola.dequeue();

            int aux = nodo.getData();
            if (aux % 2 != 0 && aux > n){
                res.add(aux);
            }

            if (nodo.hasChildren()){
                for (GeneralTree<Integer> child : nodo.getChildren()){
                    cola.enqueue(child);
                }
            }
        }
    }
     */
}
