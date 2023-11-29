package Controller;

import Model.Produto;
import Connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdutoDAO {
    private static final String INSERIR_PRODUTO = "INSERT INTO produtos (codigo_barra, nome, quantidade, preco) VALUES (?, ?, ?, ?)";

    private Connection connection; // Adicione essa declaração

    // Construtor para inicializar a conexão
    public ProdutoDAO() {
        this.connection = ConnectionFactory.getConnection();
        criarTabelaProdutos(); // Chama o método para criar a tabela (se não existir)
    }
    // Método para adicionar um produto
    public void adicionarProduto(Produto produto) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERIR_PRODUTO)) {

            preparedStatement.setString(1, produto.getCodigoBarra());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setInt(3, produto.getQuantidade());
            preparedStatement.setDouble(4, produto.getPreco());

            // Executa a inserção
            preparedStatement.executeUpdate();
            System.out.println("Produto adicionado com sucesso!");

        } catch (SQLException e) {
            // Tratamento de exceção
            System.err.println("Erro ao adicionar produto.");
            e.printStackTrace();
        }
    }

    // Método para criar a tabela de produtos (se não existir)
    private void criarTabelaProdutos() {
        String sql = "CREATE TABLE IF NOT EXISTS produtos (" +
                "codigo_barra VARCHAR(20) PRIMARY KEY," +
                "nome VARCHAR(255) NOT NULL," +
                "quantidade INT NOT NULL," +
                "preco DOUBLE NOT NULL" +
                ")";

        try (Statement stmt = connection.createStatement()) {
            // Executa a criação da tabela
            stmt.execute(sql);
            System.out.println("Tabela 'produtos' criada com sucesso.");

        } catch (SQLException e) {
            // Tratamento de exceção
            System.err.println("Erro ao criar tabela 'produtos'.");
            e.printStackTrace();
        }
    }

    // Outros métodos relacionados a produtos, se necessário

    public void fecharConexao() {
        ConnectionFactory.closeConnection(this.connection);
    }

    // ...

}
