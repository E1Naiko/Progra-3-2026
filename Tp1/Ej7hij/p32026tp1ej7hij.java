import java.util.ArrayList;
import java.util.LinkedList;

public class p32026tp1ej7hij {

    public static void main(String[] args) {
        int [] aux = {1,2,3,4,5,6,7,8,9};
        ArrayList<Integer> listaH = new ArrayList<Integer>();
        LinkedList<Integer> listaI = new LinkedList<Integer>();
        ArrayList<Integer> listaJ1 = new ArrayList<Integer>();
        ArrayList<Integer> listaJ2 = new ArrayList<Integer>();

        for (int i : aux){
            listaH.add(Integer.valueOf(i));
            listaI.add(Integer.valueOf(i));
            listaJ1.add(Integer.valueOf(i));
            listaJ2.add(Integer.valueOf(i*3));
        }
        
        incisoH resversor = new incisoH();
        System.out.println("H " + listaH);
        resversor.invertirArrayList(listaH);
        System.out.println("H " + listaH);

        incisoI sumador = new incisoI();
        System.out.println("I " + sumador.sumarLinkedList(listaI));
        
        incisoJ combinator = new incisoJ();
        System.out.println("J " + listaJ1);
        System.out.println("J " + listaJ2);
        ArrayList<Integer> listaJ3 = combinator.combinarOrdenado(listaJ1, listaJ2);
        System.out.println("J " + listaJ3);


    }
}