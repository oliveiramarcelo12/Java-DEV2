package View;

import Controller.ClientesControl;

import javax.swing.*;
import java.awt.*;

public class MercadoGUI {
    private JFrame frame;
    private JPanel cards;
    private ClientesControl clientesControl;

    public MercadoGUI() {
        frame = new JFrame("Mercado");
        clientesControl = new ClientesControl();

        // Configurar o CardLayout
        cards = new JPanel(new CardLayout());

        // Adicionar os painéis de cada tela
        CardLayout cardLayout = (CardLayout) cards.getLayout();
        cards.add(new InicioPanel(cardLayout, cards), "Inicio");
        cards.add(new CadastroPanel(cardLayout, cards), "Cadastro");
        cards.add(new CarrinhoPanel(cardLayout, cards), "Carrinho");

        // Adicionar o painel de cartões ao frame
        frame.add(cards);

        // Perguntar se o cliente é VIP ao iniciar a aplicação
        boolean clienteEhVIP = perguntaClienteVIP();
        clientesControl.setClienteVIP(clienteEhVIP);

        // Mostrar a tela inicial ou de cadastro conforme necessário
        if (clienteEhVIP) {
            cardLayout.show(cards, "Inicio");
        } else {
            cardLayout.show(cards, "Cadastro");
        }

        // Configurar a interface gráfica aqui
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    private boolean perguntaClienteVIP() {
        int resposta = JOptionPane.showConfirmDialog(frame,
                "Você é VIP?",
                "Verificação VIP",
                JOptionPane.YES_NO_OPTION);

        return resposta == JOptionPane.YES_OPTION;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MercadoGUI();
            }
        });
    }
}
