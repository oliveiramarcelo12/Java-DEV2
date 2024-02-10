package View;

import Controller.TarefaControl;

import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame {
    private CardLayout cardLayout;
    private JPanel cards;
    private TarefaControl tarefaControl;

    public JanelaPrincipal() {
        super("Janela Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Inicializa o CardLayout
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        // Inicializa o TarefaControl
        tarefaControl = new TarefaControl();

        // Cria instâncias dos painéis
        TarefaPainel tarefaPainel = new TarefaPainel();
        CadastroUsuarioPainel cadastroUsuarioPainel = new CadastroUsuarioPainel();

        // Adiciona os painéis ao CardLayout
        cards.add(tarefaPainel, "Tarefa");
        cards.add(cadastroUsuarioPainel, "CadastroUsuario"); // Adiciona o CadastroUsuarioPainel

        // Adiciona o CardLayout à janela principal
        add(cards);

        // Define a janela principal para ser visível
        setVisible(true);
    }

    // Métodos para obter e definir o TarefaControl
    public TarefaControl getTarefaControl() {
        return tarefaControl;
    }

    public void setTarefaControl(TarefaControl tarefaControl) {
        this.tarefaControl = tarefaControl;
    }

    // Método para iniciar a execução da janela
    public void run() {
        // Implemente aqui qualquer lógica de inicialização necessária
    }

    // Método para adicionar uma nova guia de tarefas ao CardLayout
    public void adicionarTabTarefas(TarefaPainel tarefaPainel) {
        cards.add(tarefaPainel, "Tarefa");
    }

    // Método para adicionar uma nova guia de cadastro de usuário ao CardLayout
    public void adicionarTabCadastroUsuario(CadastroUsuarioPainel cadastroUsuarioPainel) {
        cards.add(cadastroUsuarioPainel, "CadastroUsuario");
    }
}
