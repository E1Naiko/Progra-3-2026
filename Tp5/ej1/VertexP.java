package Tp5.ej1;

public interface VertexP<T> {
    public T getData();
    // Retorna el dato del vértice.
    
    public void setData(T data);
    // Reemplaza el dato del vértice.
    
    public int getPosition();
    // Retorna la posición del vértice en el grafo.
}
