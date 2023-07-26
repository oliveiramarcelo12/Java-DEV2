package RevisaoFPOO.Cadastro;

public abstract class Animal {
    //atributos
    String nome;
    double peso;
    String especie;
    String proprietario;
    String raca;
    double idade;
    //métodos
    //construtor cheio
  
    //construtor vazio
    public Animal(){}
    public Animal(String nome, double peso, String especie, String proprietario, String raca, double idade) {
        this.nome = nome;
        this.peso = peso;
        this.especie = especie;
        this.proprietario = proprietario;
        this.raca = raca;
        this.idade = idade;
    }
    //sets and gets
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getProprietario() {
        return proprietario;
    }
    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public double getIdade() {
        return idade;
    }
    public void setIdade(double idade) {
        this.idade = idade;
    }
    
    
}
