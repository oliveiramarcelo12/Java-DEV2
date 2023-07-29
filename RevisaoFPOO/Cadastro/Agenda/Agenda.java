package RevisaoFPOO.Cadastro.Agenda;

import RevisaoFPOO.Cadastro.Animal;

public class  Agenda  {
    String nome;
    String proprietario;
    double peso;
    int idade;
    String raca;
    public Agenda(String nome, String proprietario, double peso, int idade, String raca) {
        this.nome = nome;
        this.proprietario = proprietario;
        this.peso = peso;
        this.idade = idade;
        this.raca = raca;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getProprietario() {
        return proprietario;
    }
    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    
    
}
