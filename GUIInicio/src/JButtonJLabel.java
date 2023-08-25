import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class JButtonJLabel {//não vou usar extemds
    //atributos
    int cont;
    //construtor
    public JButtonJLabel() {
       
       
      //criar um JFrame- Janela Básica para uma aplicação
      JFrame jFrame =new JFrame("Janela Principal");
      JPanel painel=new JPanel();//Painel(container)
      //adicionar o painel ao frame
      jFrame.getContentPane().add(painel);
      //criar Componentes
      JButton button = new JButton("Clique Aqui");
      JLabel text = new JLabel("Esperando Clicar ");
      //adicionar os componentes ao painel
      painel.add(button);
      painel.add(text);
      //configurações da janela
      jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jFrame.pack();//organiza o tamanho da janela
      jFrame.setVisible(true);
      //action Listener(ação para o botão)
      button.addActionListener(e ->{
            cont++;
            text.setText("N° de Cliques"+cont);
            jFrame.pack();
            painel.add(new JButton(""+cont));
            jFrame.pack();
          

      });
      



      


    }
    
}
