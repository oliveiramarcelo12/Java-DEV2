package View;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class JanelaPrincipal extends JFrame {
    private JTabbedPane jTPane;

    public JanelaPrincipal() {
        jTPane = new JTabbedPane();
        add(jTPane);

        // Adicionando a tab de carros
        CarrosPainel tabCarros = new CarrosPainel();
        jTPane.add("Carros", tabCarros);

        // Adicionando a tab de clientes
        //ClientesPainel tabClientes = new ClientesPainel();
        //jTPane.add("Clientes", tabClientes);

        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void run() {
        this.setVisible(true);
    }
}
