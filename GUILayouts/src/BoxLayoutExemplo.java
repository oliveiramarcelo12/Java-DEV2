import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

public class BoxLayoutExemplo extends JFrame {
    public BoxLayoutExemplo() {
        // configuarando o Layout do Frame
        super("Exemplo Box Layout");
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        // criar 2 paineis
        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();
        // adicionar os paineis ao frame
        this.add(painel1, BorderLayout.WEST);
        this.add(painel2, BorderLayout.SOUTH);
        painel1.setLayout(new BoxLayout(painel1, BoxLayout.Y_AXIS));
        painel2.setLayout(new BoxLayout(painel2, BoxLayout.X_AXIS));
       //adicionar elementos aos Paineis
        for (int i = 0; i < 5; i++) {
            painel1.add(new JButton(""+i+1));
            painel2.add(new JButton(""+i+1));
            
        }
        //set do frame
        this.setDefaultCloseOperation(2);
        this.pack();
        this.setVisible(true);
        
    }


}
