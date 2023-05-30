package POOInterface;

public class Quadrado implements FigurasGeometrica {
    int lado;

    public Quadrado(int lado) {
        this.lado = lado;
    }

    public int getLados() {
        return lado;
    }

    public void setLados(int lado) {
        this.lado = lado;
    }
//métodos da classe FigurasGeometricas(interface)
    @Override
    public double getArea() {
       int area=lado*lado;
        return area;
    }

    @Override
    public String getNomeFigura() {
        return "Quadrado";
    }

    @Override
    public double getPerimetro() {
        int perimetro=lado*4;
        return perimetro;
    }
    

    
}
