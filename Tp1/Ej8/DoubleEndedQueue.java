package Tp1.Ej8;

public class DoubleEndedQueue<T> extends Queue<T> {
    public DoubleEndedQueue(){
        super();
    }

    public void enqueueFirst(T nue){
        super.data.add(0, nue);
    }
}
