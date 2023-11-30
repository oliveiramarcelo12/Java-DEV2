package View;

import Controller.EstoqueControll; // Certifique-se de ter a importação correta para GerenciadorEstoque
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class JanelaPrincipal extends JFrame {
    // Criação do tabbedPane para incluir as tabs
    private JTabbedPane jTPane;

    public JanelaPrincipal() {
        jTPane = new JTabbedPane();
        add(jTPane);

        // Criando as tabs
        // Tab "Clientes"
        ClientesPainel tabClientes = new ClientesPainel();
        jTPane.add("Clientes", tabClientes);

        // Tab "Estoque"
        EstoqueControll gerenciadorEstoque = new EstoqueControll(); // Crie uma instância válida de GerenciadorEstoque
        EstoquePainel tabEstoque = new EstoquePainel(gerenciadorEstoque); // Passe o GerenciadorEstoque como argumento
        jTPane.add("Estoque", tabEstoque);

        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Métodos para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }
}
