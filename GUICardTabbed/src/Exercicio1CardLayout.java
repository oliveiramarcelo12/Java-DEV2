import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Exercicio1CardLayout extends JFrame {
    public Exercicio1CardLayout() {
        super("Exercicio1");
        JPanel pMain = new JPanel(); // janela principal
        // add painel principal ao JFrame
        this.add(pMain);
        // criando um botão e um painel de cards
        JButton bNext = new JButton("Next");// botão
        CardLayout cl = new CardLayout();
        JPanel cards = new JPanel(cl);// painel de cards
        // add o botão e o cards ao painel principal
        pMain.add(bNext);
        pMain.add(cards);
        // criar 3 paineis de cards(card1,card2,card3)
        JPanel card1 = new JPanel();
        JPanel card2 = new JPanel();
        JPanel card3 = new JPanel();
        // add os card1,card2, card3 ao cards
        cards.add(card1, "card1");
        cards.add(card2, "card2");
        cards.add(card3, "card3");
        //diferenciando os cards
        card1.add(new JLabel("Card 1"));
        card2.add(new JLabel("Card 2"));
        card3.add(new JLabel("Card 3"));
        //set do frame
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);
        //criar o evento para o  botão
        bNext.addActionListener(e->{
            cl.next(cards); //toda vez que clicar no botão, vai mudar o card(card1,card2,card3)

        });

    }

}