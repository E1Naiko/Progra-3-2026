package Tp1.Ej8;

import java.util.LinkedList;

public class Queue<T> extends Sequence{
    private LinkedList<T> lista;
    
    public Queue(){
        lista = new LinkedList<T>();
    }

    public void enqueue(T dato){
        lista.add(dato);
    }

    public T dequeue(){
        
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }
}
