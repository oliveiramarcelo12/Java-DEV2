package View;

import javax.swing.*;

public class JanelaPrincipal extends JFrame {
    public JanelaPrincipal() {
        super("TodoListApp");

        // Configuração da janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);

        // Cria um JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Adiciona uma aba para o painel de cadastro
        tabbedPane.addTab("Cadastro", new CadastroPainel());
        
        // Cria um TarefasPainel
        TarefasPainel tarefasPainel = new TarefasPainel("Todas");
        
        // Adiciona uma aba para o painel de tarefas
        tabbedPane.addTab("Tarefas", tarefasPainel);

        // Adiciona o JTabbedPane à janela
        this.add(tabbedPane);
    }

    //métodos para tornar a janela visível
public void run(){
this.setVisible(true);
}
}
