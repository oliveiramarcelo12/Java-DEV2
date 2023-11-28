package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarrinhoPainel extends JPanel {
    private CardLayout cardLayout;
    private JPanel cards;

    public CarrinhoPainel(CardLayout cardLayout, JPanel cards) {
        this.cardLayout = cardLayout;
        this.cards = cards;

        setLayout(new BorderLayout());

        JLabel label = new JLabel("Tela de Carrinho");
        add(label, BorderLayout.NORTH);

        JButton voltarParaInicioButton = new JButton("Voltar para Início");
        voltarParaInicioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "Inicio");
            }
        });
        add(voltarParaInicioButton, BorderLayout.CENTER);
    }
}
