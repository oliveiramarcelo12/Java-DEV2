import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExemploGridLayout {
    public ExemploGridLayout() {
        JFrame janela1 = new JFrame("Exemplo Grid Layout");
        JPanel painel1 = new JPanel();
        GridLayout grid = new GridLayout(4, 4);
        painel1.setLayout(grid);
        // adicionar Jpanel ao JFrame
        janela1.getContentPane().add(painel1);
        // add componentes ao painel
        painel1.add(new JButton("1"));
        painel1.add(new JButton("2"));
        painel1.add(new JButton("3"));
        painel1.add(new JButton("4"));
        painel1.add(new JButton("5"));
        painel1.add(new JButton("6"));
        painel1.add(new JButton("7"));
        painel1.add(new JButton("8"));
        painel1.add(new JButton("9"));
        painel1.add(new JButton("0"));
        
        // config janela1
        janela1.setBounds(550, 500, 500, 500);
        janela1.setDefaultCloseOperation(2);
        janela1.setVisible(true);

    }

}
