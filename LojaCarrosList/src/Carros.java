import javax.swing.JOptionPane;

/**
 * Carros
 */
public class Carros {
String marca;
String modelo;
String ano;
String cor;
//métodos
//construtor(2 cheio, vazio)
public Carros(String marca, String modelo, String ano, String cor) {
    this.marca = marca;
    this.modelo = modelo;
    this.ano = ano;
    this.cor = cor;
}
public Carros() {
}
//getters and setters
public String getMarca() {
    return marca;
}
public void setMarca(String marca) {
    this.marca = marca;
}
public String getModelo() {
    return modelo;
}
public void setModelo(String modelo) {
    this.modelo = modelo;
}
public String getAno() {
    return ano;
}
public void setAno(String ano) {
    this.ano = ano;
}
public String getCor() {
    return cor;
}
public void setCor(String cor) {
    this.cor = cor;
}

//metódo próprio
public String imprimirLN() {
    String imprimir = marca+"/"+modelo+"/"+ano+"/"+cor+"\n";
    return imprimir;
    
}
public void imprimir() {
    JOptionPane.showMessageDialog(null, marca+"\n"+modelo+"\n"+ano+"\n"+cor);
    
}
    
}