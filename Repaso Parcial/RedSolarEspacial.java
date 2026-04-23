package Repaso

import tp3.GeneralTree;

// Parcial;

public class RedSolarEspacial {
    private GeneralTree<Panel> arbol;

    public double minimoSuministroEnergia(double energiaTotal, String panelInicial){
        if (arbol != null || arbol.isEmpty())
            return -1;

        GeneralTree<Panel> nodoPanel = encontrarNodo(arbol, panelInicial);
        if (nodoPanel!=null && nodoPanel.getData().getEstado()){
            return calcularMinimo(nodoPanel, energiaTotal);
        }

        return -1;
    }

    private GeneralTree<Panel> encontrarNodo(GeneeralTree<Panel> nodo, String panelInicial){
        if (nodo.getData().getNombre().equals(panelInicial))
            return nodo;

        GeneralTree<Panel> aux = null;
        for(GeneraTree<Panel> next: nodo.getChildren()){
            aux = encontrarNodo(next, panelInicial);
            if(aux != null) return aux;
        }
        return aux;
    }

    private double calcularMinimo(GeneralTree<Panel> nodo, double energia){
        double res = energia;
        int cantActivos = 0;
        for(GeneralTree<Panel> next: nodo.getChildren()){
            if (next.getData().getEstado())
                cantActivos++;   
        }
        for(GeneralTree<Panel> next: nodo.getChildren()){
            if (next.getData().getEstado()){
                double aux = calcularMinimo(next, energia/cantActivos);
                if (aux<rta){
                    rta = aux;
                }
            }
        }
        return res;
    }
}