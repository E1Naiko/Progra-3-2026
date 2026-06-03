package Tp5.ej1;

public interface EdgeP<T> {
    public VertexP<T> target();
    // Retorna el vértice destino de la arista.
    public int getWeight();
    // Retorna el peso de la arista
}
