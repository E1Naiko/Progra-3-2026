package Tp1.Ej8;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Queue<T> extends Sequence{
    public List<T> data;
    
    public Queue(){
        data = new LinkedList<T>();
    }

    public void enqueue(T dato){
        data.add(dato);
    }

    public T dequeue(){
        if (data.isEmpty()) throw new NoSuchElementException("Cola Vacia");
        else{
            T act = data.getFirst();
            data.remove(act);
            return act;
        }
    }

    public T head(){
        if (data.isEmpty()) throw new NoSuchElementException("Cola Vacia");
        else return data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public String toString(){
        return data.toString();
    }
}
