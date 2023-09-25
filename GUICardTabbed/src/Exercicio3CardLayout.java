import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class Exercicio3CardLayout extends JFrame {
    public Exercicio3CardLayout() {
        super("Exercicio 3");
        JPanel painelp = new JPanel(); // painel inicial
        // adicionar painel principal ao JFrame
        this.add(painelp);
        JButton bPrincipal = new JButton("Principal"); // botão para ir para tela principal
        JButton bLogin = new JButton("Login");// botão para ir para tela de login
        JButton bRegistro = new JButton("Registro"); // botão para ir para tela de registro

        CardLayout cl = new CardLayout();
        JPanel cards = new JPanel(cl); // painel de cards
        painelp.add(bPrincipal);
        painelp.add(bLogin);
        painelp.add(bRegistro);

        painelp.add(cards);
        // criar 3 paineis de cards(card1,card2,card3)
        JPanel principal = new JPanel();
        JPanel login = new JPanel();
        JPanel registro = new JPanel();

        cards.add(principal, "Principal");
        cards.add(login, "Login");
        cards.add(registro, "Registro");

        JLabel rotuloPrincipal = new JLabel("Seja bem-vindo!");
        JLabel rotuloLogin = new JLabel("Faça o seu Login.");
        JLabel rotuloRegistro = new JLabel("Faça o seu Registro.");

        Font fonteArial = new Font("Arial", Font.PLAIN, 14);
        rotuloPrincipal.setFont(fonteArial);
        // Adicione o rótulo ao painel
        principal.add(rotuloPrincipal);
        // Adicione o painel à janela
        painelp.add(principal, "Principal");
        rotuloLogin.setFont(fonteArial);
        // Adicione o rótulo ao painel
        login.add(rotuloPrincipal);
        // Adicione o painel à janela
        painelp.add(principal, "Principal");

        // Adicione o painel à janela
        painelp.add(registro, "Registro");

        // set do frame
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);
        // criar o evento para o botão
        bPrincipal.addActionListener(e -> {
            cl.show(cards, "Principal");
        });
        bLogin.addActionListener(e -> {
            cl.show(cards, "Login");
        });
        bRegistro.addActionListener(e -> {
            cl.show(cards, "Registro");
        });

    }

}
