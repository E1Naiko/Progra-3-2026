import java.util.ArrayList;

public class incisoJ {
    private int i;
    private int tot1;
    private int j;
    private int tot2;
    
    public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
        ArrayList<Integer> res = new ArrayList<Integer>();
        i=0;
        tot1 = lista1.size()-1;
        j=0;
        tot2 = lista2.size()-1;
        
        while ((i<tot1) && (j<tot2)){
            combinar(lista1, lista2, res);
        }

        System.out.println("DEBUG " + res);

        while (i<tot1){
            res.add(lista1.get(i));
            i++;
        }
        
        while (j<tot2){
            res.add(lista2.get(j));
            j++;
        }
        
        return res;
        
    }

    private void combinar(ArrayList<Integer> lista1, ArrayList<Integer> lista2, ArrayList<Integer> res){
        if (lista1.get(i) <= lista2.get(j)){
            res.add(lista1.get(i));
            i++;
        }
        else{
            res.add(lista2.get(j));
            j++;
        }
    }
}
