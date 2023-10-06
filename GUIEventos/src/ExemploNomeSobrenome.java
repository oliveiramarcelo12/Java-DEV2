import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.logging.Handler;

public class ExemploNomeSobrenome extends JFrame {
    //atributos
    private JLabel texto;
    private JTextField caixaNome;
    private JTextField caixaSobrenome;
    public ExemploNomeSobrenome() {
        super("Exemplo 1");
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 150);
        //criar um painel -> gridLayout 3x2
        JPanel mainPanel= new JPanel(new GridLayout(3,2));
        //criar os componentes do painel
        mainPanel.add(new JLabel("Nome:"));
        caixaNome = new JTextField();
        mainPanel.add(caixaNome);
        mainPanel.add(new JLabel("Sobrenome:"));
      caixaSobrenome = new JTextField();
        mainPanel.add(caixaSobrenome);
        JButton botao = new JButton("Concatenar");
        mainPanel.add(botao);
        texto = new JLabel();
        mainPanel.add(texto);
        //set do frame
        this.add(mainPanel);
        this.setVisible(true);
        //tratamento de eventos
        //1 forma : e->
        //botao.addActionListener(e->{//ouvinte
             // evento 
        //     texto.setText(caixaNome.getText()+""+caixaSobrenome.getText());
        //     caixaNome.setText("");
         //    caixaSobrenome.setText("");



       // });
        // 2 forma -
       // botao.addActionListener(new ActionListener() {
     
          //  public void actionPerformed(ActionEvent e){
                // evento 
          //  texto.setText(caixaNome.getText()+""+caixaSobrenome.getText());
           // caixaNome.setText("");
          //  caixaSobrenome.setText("");


           // }  
       // });
        // 3 forma - Handler
        //Importar a classe Handler -> botão
        Handler evt = new Handler();
        botao.addActionListener(evt);
       


    }
     public class Handler implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
           // evento 
           texto.setText(caixaNome.getText()+" "+caixaSobrenome.getText());
           caixaNome.setText(" ");
           caixaSobrenome.setText(" ");
            }
        }

    
}
