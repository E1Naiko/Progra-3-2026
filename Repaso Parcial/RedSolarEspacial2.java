package Repaso

import java.util.List;

Parcial;

public class RedSolarEspacial2 {
        private GeneralTree<Panel> arbol;

    public double minimoSuministroEnergia(double energiaTotal, String panelInicial){
        if (arbol != null || arbol.isEmpty())
            return -1;

        GeneralTree<Panel> nodoPanel = encontrarNodo(arbol, panelInicial);
        if (nodoPanel!=null && nodoPanel.getData().getEstado()){
            List<String> camino = new ArrayList<>();
            camino.add(panelInicial);
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

    private Respuesta calcularMinimo(GeneralTree<Panel> nodo, double energia, List<String> caminoActual){
        Respuesta res = new Respuesta(energia, caminoActual);
        int cantActivos = 0;
        for(GeneralTree<Panel> next: nodo.getChildren()){
            if (next.getData().getEstado())
                cantActivos++;   
        }
        for(GeneralTree<Panel> next: nodo.getChildren()){
            if (next.getData().getEstado()){
                caminoActual.add(next.getData().getNombre());
                Respuesta aux = calcularMinimo(next, energia/cantActivos, caminoActual);
                double aux = calcularMinimo(next, energia/cantActivos);
                if (aux.getMinimo()<rta.getMinimo()){
                    rta = new Respuesta(aux.getMinimo(), caminoActual);
                }
            }
        }
        return res;
    }
}
