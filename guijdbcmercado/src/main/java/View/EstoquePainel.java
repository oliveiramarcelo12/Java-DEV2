package View;

import Controller.GerenciadorEstoque;
import Model.Produto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EstoquePainel extends JFrame {
    private GerenciadorEstoque gerenciadorEstoque; // Corrigido o tipo para GerenciadorEstoque

    public EstoquePainel(GerenciadorEstoque gerenciadorEstoque) {
        this.gerenciadorEstoque = gerenciadorEstoque;

        JButton listarProdutosButton = new JButton("Listar Produtos");
        listarProdutosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarProdutos();
            }
        });

        JButton adicionarProdutoButton = new JButton("Adicionar Produto");
        adicionarProdutoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarProduto();
            }
        });

        JPanel panel = new JPanel();
        panel.add(listarProdutosButton);
        panel.add(adicionarProdutoButton);

        add(panel);
        setTitle("Gerenciamento de Estoque");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Corrigido o retorno para void
    private void listarProdutos() {
        List<Produto> produtos = gerenciadorEstoque.listarProdutos();
        StringBuilder mensagem = new StringBuilder("Produtos em Estoque:\n");

        for (Produto produto : produtos) {
            mensagem.append(produto.getNome()).append(" - Quantidade: ").append(produto.getQuantidade()).append("\n");
        }

        JOptionPane.showMessageDialog(this, mensagem.toString(), "Produtos em Estoque", JOptionPane.INFORMATION_MESSAGE);
    }

    private void adicionarProduto() {
        String codigoBarra = JOptionPane.showInputDialog(this, "Digite o código de barras do produto:");
        String nome = JOptionPane.showInputDialog(this, "Digite o nome do produto:");
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite a quantidade do produto:"));
        double preco = Double.parseDouble(JOptionPane.showInputDialog(this, "Digite o preço do produto:"));

        gerenciadorEstoque.adicionarProduto(codigoBarra, nome, quantidade, preco); // Corrigido o nome do método
        JOptionPane.showMessageDialog(this, "Produto adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
}
