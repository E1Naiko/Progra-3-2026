package Tp1.Ej8;

public class p32026tp1ej8main {
    public static void main(String[] args) {
        Queue<Integer> cola = new Queue<Integer>();
        CircularQueue<Integer> colaCircular = new CircularQueue<Integer>();
        DoubleEndedQueue<Integer> colaDoble = new DoubleEndedQueue<Integer>();

        for (int i=0; i<10; i++){
            cola.enqueue(i);
            colaCircular.enqueue(i);
            colaDoble.enqueue(i);
        }
        cola.enqueue(13);

        mandaleCuete(cola, colaCircular, colaDoble);

        System.out.println();
        System.out.println(cola.dequeue());
        mandaleCuete(cola, colaCircular, colaDoble);


        for (int i=0; i<5; i++) System.out.println(colaCircular.shift());
        mandaleCuete(cola, colaCircular, colaDoble);


        colaDoble.enqueueFirst(57);
        mandaleCuete(cola, colaCircular, colaDoble);
    }

    private static void mandaleCuete(Queue<Integer> cola, CircularQueue<Integer> colaCircular,  DoubleEndedQueue colaDoble){
        System.out.println("C " + cola + ", " + cola.size());
        System.out.println("CC " + colaCircular + ", " +colaCircular.size());
        System.out.println("CDE " + colaDoble + ", " + colaDoble.size());
    }
}
