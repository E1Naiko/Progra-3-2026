
import java.util.List;

import Tp5.ejercicio1.Edge;
import Tp5.ejercicio1.Vertex;

interface GraphP<T> {
    public VertexP<T> createVertex(T data);
    // Crea un vértice con el dato recibido y lo retorna.

    public void removeVertex(VertexP<T> vertex);
    // Elimina el vértice del Grafo.
    // En caso de que el vértice esté relacionado con otros, estas relaciones también se
    // eliminan.
    
    public VertexP<T> search(T data);
    // Busca y retorna el primer vértice cuyo dato es igual al parámetro recibido.
    // Retorna null si no existe tal.
    
    public void connect(VertexP<T> origin, VertexP<T> destination);
    // Conecta el vértice origen con el vértice destino.
    // Verifica que ambos vértices existan, caso contrario no realiza ninguna conexión.
    
    public void connect(VertexP<T> origin, VertexP<T> destination, int weight);
    // Conecta el vértice origen con el vértice destino con peso. Verifica que ambos vértices
    // existan, caso contrario no realiza ninguna conexión.
    
    public void disconnect(VertexP<T> origin, VertexP<T> destination);
    // Desconecta el vértice origen con el destino.
    // Verifica que ambos vértices existan, caso contrario no realiza ninguna desconexión
    // En caso de existir la conexión destino-->origen, esta permanecerá sin cambios.
    
    public boolean existsEdge(VertexP<T> origin, VertexP<T> destination);
    // Retorna true si existe una arista entre el vértice origen y el destino.
    
    public boolean isEmpty();
    // Retorna si el grafo no contiene datos (sin vértices creados).
    
    public List<VertexP<T>> getVertices();
    // Retorna la lista de vértices.
    
    public int weight(VertexP<T> origin, VertexP<T> destination);
    // Retorna el peso entre dos vértices.
    // En caso de no existir la arista retorna 0.
    
    public List<EdgeP<T>> getEdges(VertexP<T> v);
    // Retorna la lista de adyacentes al vértice recibido.
    
    public VertexP<T> getVertex(int position);
    // Obtiene el vértice para la posición recibida.
    
    public int getSize();
    // Retorna la cantidad de vértices del grafo    
}