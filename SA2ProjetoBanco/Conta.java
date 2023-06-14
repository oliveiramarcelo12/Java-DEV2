package SA2ProjetoBanco;

import javax.swing.JOptionPane;

public abstract class Conta {
    String nome;
    int nConta;
    double saldo;
    double deposito;
    double emprestimo;
    double saque;
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
    public double getDeposito() {
        return deposito;
    }
    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }
    public double getEmprestimo() {
        return emprestimo;
    }
    public void setEmprestimo(double emprestimo) {
        this.emprestimo = emprestimo;
    }
    
    //métodos opcionais
    public void saque() {
        double saque = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor do Saque"));
        saldo -=saque;
    } 
    public void deposito() {
        double deposito = Integer.parseInt(JOptionPane.showInputDialog("informe o valor do Depósito"));
        saldo +=deposito;
        
    }
    public double getSaque() {
        return saque;
    }
    public void setSaque(double saque) {
        this.saque = saque;
    }   
    
}
