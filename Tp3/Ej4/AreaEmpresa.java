package Tp3.Ej4;

public class AreaEmpresa {
    private int tiempo;
    
    public AreaEmpresa(){
        tiempo = 0;
    }
    
    public AreaEmpresa(int i){
        tiempo = i;
    }
    
    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
}
