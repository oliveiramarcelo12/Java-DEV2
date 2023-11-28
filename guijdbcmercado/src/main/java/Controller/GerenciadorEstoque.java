package Controller;

import Model.Estoque;
import Model.Produto;

public class GerenciadorEstoque {
    private Estoque estoque;

    public GerenciadorEstoque() {
        this.estoque = new Estoque();
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        Produto novoProduto = new Produto();
        novoProduto.setNome(nome);
        novoProduto.setQuantidade(quantidade);
        novoProduto.setPreco(preco);

        estoque.adicionarProduto(novoProduto);
    }

    public void removerProduto(Produto produto) {
        estoque.removerProduto(produto);
    }

    public List<Produto> listarProdutos() {
        return estoque.listarProdutos();
    }
}
