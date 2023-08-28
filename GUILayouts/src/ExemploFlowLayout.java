import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ExemploFlowLayout {
    public ExemploFlowLayout() {
        JFrame janela1 = new JFrame("Janela FlowLayout");
        FlowLayout flow = new FlowLayout();
        janela1.setLayout(flow);

        janela1.add(new JLabel("Nº de Botões: "));
        JTextField campoTexto = new JTextField("Insira um Valor", 25);
        janela1.add(campoTexto);
        JButton enviar = new JButton("Enviar");
        janela1.add(enviar);
        //action ao botão

        enviar.addActionListener(e -> {
            int valor = Integer.parseInt(campoTexto.getText());
            for (int i = 1; i <= valor; i++) {
                janela1.add(new JButton("" + i));
            }
            janela1.pack();
        });

        janela1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela1.pack();
        janela1.setVisible(true);
    }
    
}
