package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroPainel extends JPanel {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton cadastrarButton;

    private CadastroListener cadastroListener;

    public CadastroPainel() {
        initComponents();
        configureLayout();
    }

    private void initComponents() {
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        cadastrarButton = new JButton("Cadastrar");

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cadastroListener != null) {
                    String username = usernameField.getText();
                    char[] password = passwordField.getPassword();
                    cadastroListener.onCadastrar(username, password);
                    // Limpar os campos após o cadastro
                    usernameField.setText("");
                    passwordField.setText("");
                }
            }
        });
    }

    private void configureLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(cadastrarButton);
    }

    public void setCadastroListener(CadastroListener cadastroListener) {
        this.cadastroListener = cadastroListener;
    }

    public interface CadastroListener {
        void onCadastrar(String username, char[] password);
    }
}
