package SA2ProjetoBanco;

import javax.swing.JOptionPane;

public abstract class Conta {
    String nome;
    int nConta;
    double saldo;
    //metódos
    //construtor default(vazio)
    //sets e gets

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getnConta() {
        return nConta;
    }
    public void setnConta(int nConta) {
        this.nConta = nConta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    } 
    //métodos opcionais
    public void saque() {
        double saque = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor do Saque"));
        saldo -=saque;
    }    
    
}
