import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class Exercicio3DCardLayout extends JFrame {
    public Exercicio3DCardLayout() {
        super();
        //criar um painel Principal -> CardLayout
        JPanel mainpanel = new JPanel();
        CardLayout cl = new CardLayout();
        mainpanel.setLayout(cl);
        //add painel principal
       this.add(mainpanel);
        //criar os cards da aplicação
        //card-1 tela Início
        JPanel card1= new JPanel();
        card1.add(new JLabel("Tela Inicial - Seja Bem Vindo"));
        JButton but1= new JButton("Ir para o Login");
        JButton but2= new JButton("Ir para Cadastro");
        card1.add(but1);
        card1.add(but2);
        mainpanel.add(card1,"Inicio");
        //card-2 tela Login
        JPanel card2= new JPanel();
        card2.add(new JLabel("Tela Login - Seja Bem Vindo"));
        JButton but3= new JButton("Ir para o Início");
        JButton but4= new JButton("Ir para Cadastro");
        card2.add(but1);
        card2.add(but2);
        mainpanel.add(card2,"Inicio");
         //card-2 tela Cadastro
        JPanel card3= new JPanel();
        card3.add(new JLabel("Tela Cadastro - Seja Bem Vindo"));
        JButton but5= new JButton("Ir para o Início");
        JButton but6= new JButton("Ir para Login");
        card3.add(but5);
        card3.add(but6);
        mainpanel.add(card3,"Cadastro");
        //set do frame
        this.setDefaultCloseOperation(2);//definindo a função do X do Frame
        this.setBounds(100, 100, 300, 300);
        but1.addActionListener(e->{
            cl.show(mainPanel,"Login");
        });
        but2.addActionListener(e->{
            cl.show(mainPanel,"Cadastro");
        });
        but3.addActionListener(e->{
            cl.show(mainPanel,"Inicio");
        });
        but4.addActionListener(e->{
            cl.show(mainPanel,"Cadastro");
        });
        but5.addActionListener(e->{
            cl.show(mainPanel,"Inicio");
        });
        but6.addActionListener(e->{
            cl.show(mainPanel,"Login");
        });
       



        

    }
    
}
