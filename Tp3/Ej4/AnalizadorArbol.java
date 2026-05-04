package Tp3.Ej4;

import java.util.LinkedList;
import java.util.List;

import Tp1.Ej8.Queue;
import Tp3.GeneralTree;

public class AnalizadorArbol {
    public int devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol){
        if (arbol == null || arbol.isEmpty())
            return -1;
        
        int promedioMax = -1,
            promedioAct = 0;
        Queue<GeneralTree<AreaEmpresa>> cola = new Queue<>();

        cola.enqueue(arbol);
        
        while (!cola.isEmpty()){
            GeneralTree<AreaEmpresa> nodo = cola.dequeue();

            if (nodo.hasChildren()){

            }
            else if (!cola.isEmpty()){
                cola.enqueue(null);
            }
        }

        return promedioMax;
    }
}
