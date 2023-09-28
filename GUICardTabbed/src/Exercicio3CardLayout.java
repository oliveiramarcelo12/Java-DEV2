import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercicio3CardLayout extends JFrame {
    private CardLayout cardLayout;
    private JPanel cards;
    private JButton bInicial;
    private JButton bLogin;
    private JButton bRegistro;

    public Exercicio3CardLayout() {
        super("Exercicio 3");

        // Cria um layout de cartões para alternar entre os painéis
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        // Painel de navegação com botões
        JPanel navigationPanel = new JPanel();
        bInicial = new JButton("Inicial");
        bLogin = new JButton("Login");
        bRegistro = new JButton("Registro");

        // Configura ação do botão Inicial
        bInicial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "inicial");
                bInicial.setVisible(false); // Esconde o botão Inicial
                bLogin.setVisible(true);    // Mostra o botão Login
                bRegistro.setVisible(true); // Mostra o botão Registro
            }
        });

        // Configura ação do botão Login
        bLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "Login");
                bInicial.setVisible(true);    // Mostra o botão Inicial
                bLogin.setVisible(false);     // Esconde o botão Login
                bRegistro.setVisible(true);   // Mostra o botão Registro
            }
        });

        // Configura ação do botão Registro
        bRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "Registro");
                bInicial.setVisible(true);    // Mostra o botão Inicial
                bLogin.setVisible(true);      // Mostra o botão Login
                bRegistro.setVisible(false);  // Esconde o botão Registro
            }
        });

        // Adiciona os botões ao painel de navegação
        navigationPanel.add(bInicial);
        navigationPanel.add(bLogin);
        navigationPanel.add(bRegistro);

        // Painel principal que conterá o painel de navegação e os painéis de conteúdo
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.add(navigationPanel);

        // Adiciona o painel de navegação e os painéis de conteúdo ao JFrame
        this.add(painelPrincipal, BorderLayout.NORTH);
        this.add(cards, BorderLayout.CENTER);

        // Painel de conteúdo para a tela Inicial
        JPanel inicial = new JPanel();

        // Painel de conteúdo para a tela de Login
        JPanel login = new JPanel();

        // Painel de conteúdo para a tela de Registro
        JPanel registro = new JPanel();

        // Adiciona os painéis de conteúdo aos cartões com nomes "inicial", "Login" e "Registro"
        cards.add(inicial, "inicial");
        cards.add(login, "Login");
        cards.add(registro, "Registro");

        // Rótulo de boas-vindas para a tela Inicial
        JLabel rotuloInicial = new JLabel("Seja bem-vindo!");

        // Configura a fonte para o rótulo
        Font fonteArial = new Font("Arial", Font.PLAIN, 14);
        rotuloInicial.setFont(fonteArial);

        // Adiciona o rótulo à tela Inicial
        inicial.add(rotuloInicial);

        // Painel de conteúdo para a tela de Login
        JPanel loginPanel = new JPanel(new GridLayout(0, 2)); // GridLayout com duas colunas

        // Botão "Enviar" para a tela de Login
        JButton botaoEnviarLogin = new JButton("Enviar");

        // Configura a ação do botão "Enviar" da tela de Login
        botaoEnviarLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode adicionar a lógica para processar o login
                // Por exemplo, verificar as credenciais e redirecionar se for bem-sucedido
                // Neste exemplo, estamos apenas exibindo uma mensagem
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
            }
        });

        // Adiciona os campos de email e senha à tela de Login
        loginPanel.add(new JLabel("Email: "));
        loginPanel.add(new JTextField(20)); // Campo de email
        loginPanel.add(new JLabel("Senha: "));
        loginPanel.add(new JPasswordField(20)); // Campo de senha
        loginPanel.add(new JLabel()); // Espaço vazio para alinhar o botão "Enviar"
        loginPanel.add(botaoEnviarLogin); // Botão "Enviar"

        // Adiciona o painel de conteúdo da tela de Login ao painel de Login
        login.add(loginPanel);

        // Painel de conteúdo para a tela de Registro
        JPanel registroPanel = new JPanel(new GridLayout(0, 2)); // GridLayout com duas colunas

        // Botão "Enviar" para a tela de Registro
        JButton botaoEnviarRegistro = new JButton("Enviar");

        // Configura a ação do botão "Enviar" da tela de Registro
        botaoEnviarRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode adicionar a lógica para processar o registro
                // Por exemplo, armazenar os dados do usuário
                // Neste exemplo, estamos apenas exibindo uma mensagem
                JOptionPane.showMessageDialog(null, "Registro realizado com sucesso!");
            }
        });

        // Adiciona os campos de nome, email e senha à tela de Registro
        registroPanel.add(new JLabel("Nome: "));
        registroPanel.add(new JTextField(20)); // Campo de nome
        registroPanel.add(new JLabel("Email: "));
        registroPanel.add(new JTextField(20)); // Campo de email
        registroPanel.add(new JLabel("Senha: "));
        registroPanel.add(new JPasswordField(20)); // Campo de senha
        registroPanel.add(new JLabel()); // Espaço vazio para alinhar o botão "Enviar"
        registroPanel.add(botaoEnviarRegistro); // Botão "Enviar"

        // Adiciona o painel de conteúdo da tela de Registro ao painel de Registro
        registro.add(registroPanel);

        // Configurações do JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);

        // Esconde os botões de Login e Registro inicialmente
        bLogin.setVisible(false);
        bRegistro.setVisible(false);
    }

    public static void main(String[] args) {
        // Crie uma instância da classe Exercicio3CardLayout
        new Exercicio3CardLayout();
    }
}
