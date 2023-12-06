package app;

import Controller.EstoqueControll;
import View.EstoquePainel;
import View.JanelaPrincipal;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
            janelaPrincipal.run();

            EstoqueControll gerenciadorEstoque = new EstoqueControll();
            EstoquePainel janelaEstoque = new EstoquePainel(gerenciadorEstoque);

            // Adicione o EstoquePainel à guia "Estoque" na JanelaPrincipal
            janelaPrincipal.adicionarTabEstoque(janelaEstoque);
        });
    }
}
