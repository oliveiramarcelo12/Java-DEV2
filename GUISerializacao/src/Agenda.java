import java.io.Serializable;

public class Agenda implements Serializable {
    private String dataAgendamento;
    private String horaAgendamento;
    private String usuario;
    private String descricao;

    public Agenda(String dataAgendamento, String horaAgendamento, String usuario, String descricao) {
        this.dataAgendamento = dataAgendamento;
        this.horaAgendamento = horaAgendamento;
        this.usuario = usuario; // Atualizado para usar o parâmetro
        this.descricao = descricao;
    }

    public String getDataAgendamento() {
        return dataAgendamento;
    }

    public String getHoraAgendamento() {
        return horaAgendamento;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void atualizarAgendamento(String data, String hora, String usuario, String descricao) {
        this.dataAgendamento = data;
        this.horaAgendamento = hora;
        this.usuario = usuario;
        this.descricao = descricao;
    }

    public void removerAgendamento() {
        dataAgendamento = null;
        horaAgendamento = null;
        usuario = null;
        descricao = null;
    }
}
