package Model;

// Tarefa.java
public class Tarefas {
    private String descricao;
    private boolean concluida;
    private int tempoDecorrido;
   
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public boolean isConcluida() {
        return concluida;
    }
    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
    public int getTempoDecorrido() {
        return tempoDecorrido;
    }
    public void setTempoDecorrido(int tempoDecorrido) {
        this.tempoDecorrido = tempoDecorrido;
    }
    
    // getters e setters
    
}