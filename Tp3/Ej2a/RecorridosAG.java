package Tp3.Ej2a;

import java.util.LinkedList;
import java.util.List;

import tp3.GeneralTree;

public class RecorridosAG {
    public List<Integer> numerosImparesMayoresQuePreOrden (Tp3.Ej1.GeneralTree<T> <Integer> a, Integer n){
        List<Integer> res = new LinkedList<>();
        
        if (a!=null && !a.isEmpty())
            preOrder(a, n, res);

        return res;
    }

    private void preOrder(Tp3.Ej1.GeneralTree<Integer> nodo, Integer n, List<Integer> res){
        if (nodo!=null){
            int act = nodo.getData();
            if (act % 2 == 1 && act > n.intValue())
                res.add(act);

            if (nodo.hasChildren()){
                List<Integer> children = nodo.getChildren();
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
        
        if (a!=null && !a.isEmpty())
            inOrder(a, n, res);

        return res;
    }

    public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n){
        List<Integer> res = new LinkedList<>();
        
        if (a!=null && !a.isEmpty())
            postOrder(a, n, res);

        return res;
    }

    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n){
        List<Integer> res = new LinkedList<>();
        
        if (a!=null && !a.isEmpty())
            porNiveles(a, n, res);

        return res;
    }
}
