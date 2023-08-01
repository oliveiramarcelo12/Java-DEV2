package RevisaoFPOO.Cadastro.Agenda;

import RevisaoFPOO.Cadastro.Animal;

public class  Agenda extends Animal  {
    String nome;
    String proprietario;
    String data;
    String hora;
    String dataHora;
    String servico;
    public Agenda(String nome, String proprietario, String data, String hora, String dataHora, String servico) {
        this.nome = nome;
        this.proprietario = proprietario;
        this.data = data;
        this.hora = hora;
        this.dataHora = dataHora;
        this.servico = servico;
    }
    public Agenda() {
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
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        dataHora= data+hora;
        this.hora = hora;
    }
    public String getDataHora() {
        return dataHora;
    }
    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
    public String getServico() {
        return servico;
    }
    public void setServico(String servico) {
        this.servico = servico;
    }
   
    
}
