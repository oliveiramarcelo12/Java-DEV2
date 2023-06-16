package SA2ProjetoBanco;

import javax.swing.JOptionPane;

public abstract class Conta {
    String nome;
    int nConta;
    double saldo;
    double deposito;
    double emprestimo;

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

    public void saque() {
        double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do Saque"));
        if (valorSaque > 0 && valorSaque <= saldo) {
            saldo -= valorSaque;
        } else {
            JOptionPane.showMessageDialog(null, "Valor de saque inválido");
        }
    }

    public void deposito() {
        double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do Depósito"));
        if (valorDeposito > 0) {
            saldo += valorDeposito;
        } else {
            JOptionPane.showMessageDialog(null, "Valor de depósito inválido");
        }
    }

    public void emprestimo() {
        double valorEmpretimo = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o Valor do Empréstimo"));
        int prazo = Integer.parseInt(JOptionPane.showInputDialog("Informe o prazo de pagamento em meses"));
        double taxaJuros=0.15; //taxa de 15% de juros
        if (valorEmpretimo>0 && prazo >0 ) {
            double valorJuros= valorEmpretimo*taxaJuros*prazo;
            double valorTotal= valorEmpretimo +valorJuros;
            saldo +=valorTotal;
            emprestimo+=valorTotal;
             JOptionPane.showMessageDialog(null, "Empréstimo realizado com sucesso.");
    } 
    else {
        JOptionPane.showMessageDialog(null, "Valor de empréstimo ou prazo inválido");
    }

            
        
        

    }}