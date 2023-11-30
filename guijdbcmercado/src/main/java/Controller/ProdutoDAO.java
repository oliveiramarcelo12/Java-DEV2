package Controller;

import Model.Produto;
import Connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ProdutoDAO {
    private static final String INSERIR_PRODUTO = "INSERT INTO produtos (codigo_barra, nome, quantidade, preco) VALUES (?, ?, ?, ?)";
    private static final String LIMPAR_TABELA = "DELETE FROM produtos";

    private Connection connection;

    public ProdutoDAO() {
        this.connection = ConnectionFactory.getConnection();
        criarTabelaProdutos();
    }

    public void adicionarProduto(Produto produto) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERIR_PRODUTO)) {
            preparedStatement.setString(1, produto.getCodigoBarra());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setInt(3, produto.getQuantidade());
            preparedStatement.setDouble(4, produto.getPreco());
            preparedStatement.executeUpdate();
            System.out.println("Produto adicionado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar produto.");
            e.printStackTrace();
        }
    }

    private void criarTabelaProdutos() {
        String sql = "CREATE TABLE IF NOT EXISTS produtos (" +
                "codigo_barra VARCHAR(20) PRIMARY KEY," +
                "nome VARCHAR(255) NOT NULL," +
                "quantidade INT NOT NULL," +
                "preco DOUBLE NOT NULL" +
                ")";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela 'produtos' criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela 'produtos'.");
            e.printStackTrace();
        }
    }

    public void atualizarTabelaBancoDados(List<Produto> produtos) {
        try {
            // Limpar a tabela existente
            limparTabela();

            // Inserir os novos registros
            for (Produto produto : produtos) {
                adicionarProduto(produto);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar tabela no banco de dados.");
            e.printStackTrace();
        }
    }

    private void limparTabela() throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(LIMPAR_TABELA)) {
            preparedStatement.executeUpdate();
        }
    }

    public void fecharConexao() {
        ConnectionFactory.closeConnection(this.connection);
    }
}
