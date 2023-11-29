package Controller;
import java.util.List;

import Model.Estoque;
import Model.Produto;

public class GerenciadorEstoque {
    private Estoque estoque;

    public GerenciadorEstoque() {
        this.estoque = new Estoque();
    }

    public void adicionarProduto(String codigoBarra, String nome, int quantidade, double preco) {
        Produto novoProduto = new Produto(codigoBarra, nome, quantidade, preco);
        estoque.adicionarProduto(novoProduto);
    }

    public void removerProduto(Produto produto) {
        estoque.removerProduto(produto);
    }

    public List<Produto> listarProdutos() {
        return estoque.listarProdutos();
    }
}
