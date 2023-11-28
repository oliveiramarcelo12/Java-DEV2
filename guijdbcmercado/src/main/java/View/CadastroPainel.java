package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroPainel extends JPanel {

    public CadastroPainel(CardLayout cardLayout, JPanel cards) {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Tela de Cadastro");
        add(label, BorderLayout.NORTH);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica de cadastro aqui
                cardLayout.show(cards, "Inicio");
            }
        });
        add(cadastrarButton, BorderLayout.CENTER);
    }
}
