package View;

import Controller.EstoqueControll;
import Model.Produto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EstoquePainel extends JFrame {
    private EstoqueControll gerenciadorEstoque; // Instância do controlador de estoque

    // Construtor da classe EstoquePainel
    public EstoquePainel(EstoqueControll gerenciadorEstoque) {
        this.gerenciadorEstoque = gerenciadorEstoque;

        // Botão para listar produtos
        JButton listarProdutosButton = new JButton("Listar Produtos");
        listarProdutosButton.addActionListener(new ActionListener() {
            // Ação ao clicar no botão
            public void actionPerformed(ActionEvent e) {
                listarProdutos();
            }
        });

        // Adiciona um ouvinte de janela para atualizar a lista de produtos ao fechar a janela
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Atualize a lista de produtos ao fechar a janela
                listarProdutos();
            }
        });

        // Botão para adicionar produto
        JButton adicionarProdutoButton = new JButton("Adicionar Produto");
        adicionarProdutoButton.addActionListener(new ActionListener() {
            // Ação ao clicar no botão
            public void actionPerformed(ActionEvent e) {
                adicionarProduto();
            }
        });

        // Painel contendo os botões
        JPanel panel = new JPanel();
        panel.add(listarProdutosButton);
        panel.add(adicionarProdutoButton);

        // Configurações da janela
        add(panel);
        setTitle("Gerenciamento de Estoque");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Método para configurar ou atualizar o controlador de estoque
    public void setGerenciadorEstoque(EstoqueControll gerenciadorEstoque) {
        this.gerenciadorEstoque = gerenciadorEstoque;
    }

    // Método para listar produtos
    private void listarProdutos() {
        List<Produto> produtos = gerenciadorEstoque.listarProdutos();
        StringBuilder mensagem = new StringBuilder("Produtos em Estoque:\n");

        // Construção da mensagem
        for (Produto produto : produtos) {
            mensagem.append(produto.getNome()).append(" - Quantidade: ").append(produto.getQuantidade()).append("\n");
        }

        // Exibição da mensagem em uma caixa de diálogo
        JOptionPane.showMessageDialog(this, mensagem.toString(), "Produtos em Estoque", JOptionPane.INFORMATION_MESSAGE);
    }

    private void adicionarProduto() {
        // Solicitação de informações ao usuário
        String codigoBarra = JOptionPane.showInputDialog(this, "Digite o código de barras do produto:");
        String nome = JOptionPane.showInputDialog(this, "Digite o nome do produto:");
        String quantidadeStr = JOptionPane.showInputDialog(this, "Digite a quantidade do produto:");
        String precoStr = JOptionPane.showInputDialog(this, "Digite o preço do produto:");

        // Verificação de valores não nulos ou vazios
        if (codigoBarra != null && nome != null && !quantidadeStr.isEmpty() && !precoStr.isEmpty()) {
            try {
                // Conversão para números
                int quantidade = Integer.parseInt(quantidadeStr);
                double preco = Double.parseDouble(precoStr);

                // Chamada do método do controlador para adicionar o produto
                gerenciadorEstoque.adicionarProduto(codigoBarra, nome, quantidade, preco);

                // Exibição de mensagem de sucesso em uma caixa de diálogo
                JOptionPane.showMessageDialog(this, "Produto adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                // Tratamento de erro se a conversão falhar
                JOptionPane.showMessageDialog(this, "Erro ao converter valores para números.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Usuário cancelou a entrada ou forneceu valores nulos/vazios
            JOptionPane.showMessageDialog(this, "Entrada cancelada ou valores inválidos.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

}
