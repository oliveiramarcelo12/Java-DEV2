import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
public class ExercicioCardLayout {
    public ExercicioCardLayout() {
        JPanel painel1 = new JPanel();// janela principal

        String itensCB[] = { "Card 1", "Card 2", "Card 3" };
        JComboBox cb = new JComboBox<>(itensCB);
        JButton jb = new JButton("->");

        painel1.add(cb);
        JPanel cards = new JPanel();
        CardLayout cl = new CardLayout();
        cards.setLayout(cl);
        // criar os cards da pilha
        JPanel card1 = new JPanel();
        card1.add(new JButton("Botão"));
        JPanel card2 = new JPanel();
        card2.add(new JTextField(0));
        JPanel card3 = new JPanel();
        card3.add(new JButton("Botão"));

        cards.add(card1, itensCB[0]);
        cards.add(card2, itensCB[1]);
        cards.add(card2, itensCB[2]);

        painel1.add(cards);
        this.add(painel1);

      
    }
}
