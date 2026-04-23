package Repaso Parcial;

public class Respuesta {
    private double minimo;
    private List<String> camino;
    public double getMinimo() {
        return minimo;
    }
    public void setMinimo(double minimo) {
        this.minimo = minimo;
    }
    public List<String> getCamino() {
        return camino;
    }
    public void setCamino(List<String> camino) {
        this.camino = camino;
    }
    public Respuesta (double minimo, List<String> minimo){
        this.minimo = minimo;
        this.camino = camino;
    }
}
