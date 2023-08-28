import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class LayoutCalculadoraGUI {
    public LayoutCalculadoraGUI() {
        //construir Layout Calculadora
        JFrame janelaP = new JFrame("Layout Calculadora", null);
        BorderLayout border = new BorderLayout();
        janelaP.setLayout(border);
        JPanel painelV = new JPanel();
        JPanel painelB= new JPanel();//padrão FlowLayout
        janelaP.getContentPane().add(painelB, BorderLayout.CENTER);
         janelaP.getContentPane().add(painelV, BorderLayout.NORTH);
         //adicionar o text field no painelV
         JTextField caixa1 = new JTextField( 25);
         painelV.add( caixa1);

        janelaP.getContentPane().add(painelB);
        GridLayout grid = new GridLayout(4, 4);
        painelB.setLayout(grid);
        //Vetor com os textos dos botões
        String textBotoes[]={"C","9","8","7","/","6","5","4","x","3","2","1","-","+","0","="};
        for (int i = 0; i < textBotoes.length; i++) {
            painelB.add(new JButton(textBotoes[i]));

        }
        //set do frame
        janelaP.setDefaultCloseOperation(2);
        janelaP.pack();
        janelaP.setVisible(true);


        

    }
    
}
