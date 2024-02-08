package View;
import Controller.CadastroControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CadastroPainel extends JPanel {
    private JTextField campoNome;
    private JTextField campoEmail;
    private JPasswordField campoSenha;
    private JButton botaoCadastrar;
    private CadastroControl control;

    public CadastroPainel() {
        control = new CadastroControl(this); // Instância do controlador

        // Configuração do painel
        setLayout(new GridLayout(4, 2, 5, 5)); // Grade 4x2 com lacunas de 5 pixels
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margens

        // Componentes de interface de usuário
        JLabel labelNome = new JLabel("Nome:");
        campoNome = new JTextField(20);

        JLabel labelEmail = new JLabel("Email:");
        campoEmail = new JTextField(20);

        JLabel labelSenha = new JLabel("Senha:");
        campoSenha = new JPasswordField(20);

        botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario();
            }
        });

        // Adiciona os componentes ao painel
        add(labelNome);
        add(campoNome);
        add(labelEmail);
        add(campoEmail);
        add(labelSenha);
        add(campoSenha);
        add(new JLabel()); // Espaçamento
        add(botaoCadastrar);
    }

    // Método para obter o nome inserido
    public String getNome() {
        return campoNome.getText();
    }

    // Método para obter o email inserido
    public String getEmail() {
        return campoEmail.getText();
    }

    // Método para obter a senha inserida
    public String getSenha() {
        return new String(campoSenha.getPassword());
    }

    // Método para limpar os campos de entrada
    public void limparCampos() {
        campoNome.setText("");
        campoEmail.setText("");
        campoSenha.setText("");
    }

    // Método para lidar com o evento de cadastro de usuário
    private void cadastrarUsuario() {
        String nome = getNome();
        String email = getEmail();
        String senha = getSenha();
        control.cadastrarUsuario(nome, email, senha);
        limparCampos();
    }
}
