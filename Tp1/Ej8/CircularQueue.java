package Tp1.Ej8;

import java.util.NoSuchElementException;

public class CircularQueue<T> extends Queue<T>{
    public CircularQueue(){
        super();
    }

    public T shift(){
        if (super.isEmpty())  throw new NoSuchElementException("Cola Vacia");
        else{
            T cabeza = super.dequeue();
            super.enqueue(cabeza);
            return cabeza;
        }
    }

}
