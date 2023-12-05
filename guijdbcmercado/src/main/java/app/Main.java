package app;

import Controller.EstoqueControll;
import View.EstoquePainel;
import View.JanelaPrincipal;

public class Main {
    public static void main(String[] args) {
        new JanelaPrincipal().run();
        EstoqueControll gerenciadorEstoque = new EstoqueControll();

        // Crie uma instância de EstoquePainel e configure o controlador de estoque
        EstoquePainel janelaEstoque = new EstoquePainel(gerenciadorEstoque);
        janelaEstoque.setGerenciadorEstoque(gerenciadorEstoque);
    }
}