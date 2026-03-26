import java.util.LinkedList;

public class incisoI {
    public int sumarLinkedList(LinkedList<Integer> lista){
        int cont = 0;
        int tamanio = lista.size()-1;
        cont = sumarRecursivo(lista, tamanio);
        return cont;
    }

    private int sumarRecursivo(LinkedList<Integer> lista, int i){
        if (i>=0) return lista.get(i) + sumarRecursivo(lista, i-1);
        return 0;
    }
}
