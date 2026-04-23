package Tp3.Ej1;

import java.util.ArrayList;
import java.util.List;

public class GeneralTree<T> {
    private List<GeneralTree<T>> children;
    private T data;

    public GeneralTree (T value){
        children = new ArrayList<GeneralTree<T>>();
        data = value;
    }

    public GeneralTree (T data, List<GeneralTree<T>> children){
        this.data = data;
        this.children = children;
    }
    
    public T getData(){
        return data;
    }

    public void addChild(GeneralTree<T> child){
        children.addLast(child);
    }

    public void removeChild(GeneralTree<T> child){
        if (this.hasChildren()){
            if (children.contains(child))
                children.remove(child);
        }
    }

    public boolean hasChildren(){
        return (child != null) || (child.hasChildren());
    }

    public boolean isEmpty(){
        return (child == null) && (!child.hasChildren());
    }

    public void altura(){

    }

    public void nivel(T){

    }

    public void ancho(){

    }
}