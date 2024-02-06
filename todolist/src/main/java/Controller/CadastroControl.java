package Controller;

import Model.Usuario;
import View.CadastroPainel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CadastroControl {
    private List<Usuario> usuarios;
    private CadastroPainel cadastroView;

    public CadastroControl(CadastroPainel cadastroPainel) {
        this.usuarios = new ArrayList<>();
        this.cadastroPainel = cadastroPainel;

        this.cadastroPainel.setCadastrarUsuarioListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario();
            }
        });

        this.cadastroPainel.setListarUsuariosListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarUsuarios();
            }
        });
    }

    private void cadastrarUsuario() {
        String nome = cadastroPainel.getInputNome();
        String email = cadastroPainel.getInputEmail();
        String senha = cadastroPainel.getInputSenha();

        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            cadastroPainel.mostrarMensagem("Preencha todos os campos.");
            return;
        }

        Usuario novoUsuario = new Usuario(nome, email, senha);
        usuarios.add(novoUsuario);
        cadastroView.mostrarMensagem("Usuário cadastrado com sucesso!");
        cadastroView.limparCampos();
    }

    private void listarUsuarios() {
        if (usuarios.isEmpty()) {
            cadastroView.mostrarMensagem("Nenhum usuário cadastrado.");
        } else {
            StringBuilder lista = new StringBuilder("Lista de Usuários:\n");
            for (Usuario usuario : usuarios) {
                lista.append(usuario).append("\n");
            }
            cadastroView.mostrarMensagem(lista.toString());
        }
    }

    public void run() {
        cadastroView.run();
    }
}
