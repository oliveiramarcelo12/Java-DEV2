package POOInterface;

public class Trapezio implements FigurasGeometrica {
    int baseMaior;
    int baseMenor;
    int altura;
    int lado1;
    int lado2;
    public int getBaseMaior() {
        return baseMaior;
    }
    public void setBaseMaior(int baseMaior) {
        this.baseMaior = baseMaior;
    }
    public int getBaseMenor() {
        return baseMenor;
    }
    public void setBaseMenor(int baseMenor) {
        this.baseMenor = baseMenor;
    }
    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }
    public int getLado1() {
        return lado1;
    }
    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }
    public int getLado2() {
        return lado2;
    }
    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }
    public Trapezio(int baseMaior, int baseMenor, int altura, int lado1, int lado2) {
        this.baseMaior = baseMaior;
        this.baseMenor = baseMenor;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
    }
    @Override
    public double getArea() {
     int area= (baseMaior+baseMenor)*altura/2;
        return 0;
    }
    @Override
    public String getNomeFigura() {
       
        return  "Trapézio";
    }
    @Override
    public double getPerimetro() {
        int perimetro= baseMaior+baseMenor+ lado1+lado2;
        return 0;
    }
    
    
    
    
}
