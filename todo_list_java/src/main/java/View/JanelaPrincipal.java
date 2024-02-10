package View;

import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame {
    public JanelaPrincipal() {
        super("TodoListApp");

        // Configuração da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Cria um JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Adiciona uma aba para o painel de cadastro
        tabbedPane.addTab("Cadastro", new CadastroPainel());

        // Adiciona uma aba para o painel de tarefas
        tabbedPane.addTab("Tarefas", new TarefasPainel());

        // Adiciona o JTabbedPane à janela
        add(tabbedPane, BorderLayout.CENTER); // Adiciona o JTabbedPane ao centro da janela
    }

    // Método para tornar a janela visível
    public void run() {
        setVisible(true);
    }
}
