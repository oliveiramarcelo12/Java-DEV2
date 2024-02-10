package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroUsuarioPainel extends JPanel {

    private JTextField nomeField, emailField, senhaField;
    private JButton cadastrarUsuarioButton;

    public CadastroUsuarioPainel() {
        setLayout(new BorderLayout());

        // Campos para inserção dos dados do usuário
        nomeField = new JTextField();
        emailField = new JTextField();
        senhaField = new JPasswordField();
        cadastrarUsuarioButton = new JButton("Cadastrar Usuário");

        // Adicionando componentes ao painel de cadastro de usuários
        JPanel formularioPanel = new JPanel(new GridLayout(3, 2));
        formularioPanel.add(new JLabel("Nome: "));
        formularioPanel.add(nomeField);
        formularioPanel.add(new JLabel("Email: "));
        formularioPanel.add(emailField);
        formularioPanel.add(new JLabel("Senha: "));
        formularioPanel.add(senhaField);

        add(formularioPanel, BorderLayout.CENTER);
        add(cadastrarUsuarioButton, BorderLayout.SOUTH);

        // Adicionando ação ao botão "Cadastrar Usuário"
        cadastrarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario();
            }
        });
    }

    private void cadastrarUsuario() {
        // Aqui você pode chamar um método para cadastrar o usuário no sistema
        // Por exemplo, você pode usar o controlador de usuários para adicionar o usuário ao modelo de dados.
        // Você precisará obter os dados dos campos de texto e passá-los como parâmetros para o método de cadastro.
        // Por exemplo:
        // control.cadastrarUsuario(nomeField.getText(), emailField.getText(), senhaField.getText());
        // Depois de cadastrar o usuário, você pode limpar os campos do formulário.
        // Por exemplo:
        // nomeField.setText("");
        // emailField.setText("");
        // senhaField.setText("");
    }
}
