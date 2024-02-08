package Controller;

import Model.Usuario; // Importa a classe Usuario do pacote Model
import View.CadastroPainel; // Importa a classe CadastroPainel do pacote View

import java.util.ArrayList; // Importa a classe ArrayList do pacote java.util
import java.util.List; // Importa a interface List do pacote java.util

import javax.swing.JOptionPane;

public class CadastroControl {
    private CadastroPainel view; // Referência à interface de usuário
    private List<Usuario> usuarios; // Lista de usuários cadastrados

    public CadastroControl(CadastroPainel view) {
        this.view = view;
        this.usuarios = new ArrayList<>();
    }

    // Método para lidar com o evento de cadastro de usuário
    public void cadastrarUsuario(String nome, String email, String senha) {
        if (validarCampos(nome, email, senha)) {
            if (verificarEmailExistente(email)) {
                JOptionPane.showMessageDialog(null, "O email já está cadastrado.");
            } else {
                // Criar e adicionar o usuário à lista
                Usuario novoUsuario = new Usuario(nome, email, senha);
                usuarios.add(novoUsuario);
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!\nNome: " + nome + "\nEmail: " + email);
            }
        }
    }

    // Método para validar os campos de entrada
    private boolean validarCampos(String nome, String email, String senha) {
        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
            return false;
        }
        return true;
    }

    // Método para verificar se o email já está cadastrado
    private boolean verificarEmailExistente(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
