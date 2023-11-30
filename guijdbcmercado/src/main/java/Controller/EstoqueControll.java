package Controller;

import java.util.List;

import Model.Estoque;
import Model.Produto;

public class EstoqueControll {
    private Estoque estoque;

    public EstoqueControll() {
        this.estoque = new Estoque();
    }

    public void adicionarProduto(String codigoBarra, String nome, int quantidade, double preco) {
        try {
            Produto novoProduto = new Produto(codigoBarra, nome, quantidade, preco);
            estoque.adicionarProduto(novoProduto);
            System.out.println("Produto adicionado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao adicionar produto: " + e.getMessage());
        }
    }

    public void removerProduto(Produto produto) {
        try {
            estoque.removerProduto(produto);
            System.out.println("Produto removido com sucesso!");
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao remover produto: " + e.getMessage());
        }
    }

    public List<Produto> listarProdutos() {
        try {
            return estoque.listarProdutos();
        } catch (Exception e) {
            System.err.println("Erro ao listar produtos: " + e.getMessage());
            return null; // Ou lançar uma exceção apropriada para indicar o erro para a camada superior
        }
    }
}
