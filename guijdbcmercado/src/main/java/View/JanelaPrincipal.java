package View;

import Controller.EstoqueControll;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class JanelaPrincipal extends JFrame {
    private JTabbedPane jTPane;

    public JanelaPrincipal() {
        jTPane = new JTabbedPane();
        add(jTPane);

        // Tab "Clientes"
        ClientesPainel tabClientes = new ClientesPainel();
        jTPane.add("Clientes", tabClientes);

        // Tab "Estoque"
        EstoqueControll gerenciadorEstoque = new EstoqueControll();
        EstoquePainel tabEstoque = new EstoquePainel(gerenciadorEstoque);
        adicionarTabEstoque(tabEstoque);

        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Método para adicionar o EstoquePainel à guia "Estoque"
    public void adicionarTabEstoque(EstoquePainel estoquePainel) {
        jTPane.add("Estoque", estoquePainel);
    }

    public void run() {
        this.setVisible(true);
    }
}
