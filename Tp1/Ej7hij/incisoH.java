import java.util.ArrayList;

public class incisoH {
    public void invertirArrayList(ArrayList<Integer> lista){
        int i = 0;
        int j = lista.size()-1;
        invertirRecursivo(lista, i, j);
    }
    private void invertirRecursivo(ArrayList<Integer> lista, int i, int j){
        if (i<j){
            int aux = lista.get(j);
            //lista.remove(j);
            //lista.add(j, lista.get(i));
            lista.set(j, lista.get(i));
            
            //lista.remove(i);
            //lista.add(i, aux);
            lista.set(i, aux);
            invertirRecursivo(lista, i+1, j-1);
        }
    }
}
