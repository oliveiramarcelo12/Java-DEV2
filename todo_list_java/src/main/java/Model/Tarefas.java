package Model;

// Tarefa.java
public class Tarefas {
    private String descricao;
    private boolean concluida;
    private int tempoDecorrido;
    private String status;
    private int usuarioId;
    
   
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    
    // getters e setters
    
}