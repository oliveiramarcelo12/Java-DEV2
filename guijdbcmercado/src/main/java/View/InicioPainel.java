package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioPainel extends JPanel {

    public InicioPainel(CardLayout cardLayout, JPanel cards) {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Tela de Início");
        add(label, BorderLayout.NORTH);

        JButton irParaCarrinhoButton = new JButton("Ir para Carrinho");
        irParaCarrinhoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "Carrinho");
            }
        });
        add(irParaCarrinhoButton, BorderLayout.CENTER);
    }
}
