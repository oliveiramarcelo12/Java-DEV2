package Controller;

import Model.Produto;
import Connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private Connection connection;

    private static final String LIMPAR_TABELA = "DELETE FROM produtos";
    private static final String VERIFICAR_REGISTRO = "SELECT COUNT(*) FROM produtos";

    public ProdutoDAO() {
        this.connection = ConnectionFactory.getConnection();
        criarTabelaProdutos(); // Chame o método para criar a tabela no construtor, se necessário
    }

    private void criarTabelaProdutos() {
        String sql = "CREATE TABLE IF NOT EXISTS produtos (codigo_barra VARCHAR(255), nome VARCHAR(255), quantidade INT, preco DOUBLE)";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela de produtos criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela de produtos: " + e.getMessage(), e);
        }
    }

    public void adicionarProduto(Produto produto) {
        String sql = "INSERT INTO produtos (codigo_barra, nome, quantidade, preco) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, produto.getCodigoBarra());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setInt(3, produto.getQuantidade());
            preparedStatement.setDouble(4, produto.getPreco());
            preparedStatement.executeUpdate();
            System.out.println("Produto adicionado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar produto: " + e.getMessage());
        }
    }

    public List<Produto> listarTodos() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = connection.prepareStatement("SELECT * FROM produtos");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getString("codigo_barra"),
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco")
                );
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }
        return produtos;
    }

    public void atualizarTabelaBancoDados(List<Produto> produtos) {
        try {
            // Atualiza apenas os registros existentes e adiciona os novos
            for (Produto produto : produtos) {
                if (registroExiste(produto.getCodigoBarra())) {
                    atualizarProduto(produto);
                } else {
                    adicionarProduto(produto);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar tabela no banco de dados.");
            e.printStackTrace();
        }
    }

    private void atualizarProduto(Produto produto) throws SQLException {
        // Atualiza os dados do produto no banco de dados
        String sql = "UPDATE produtos SET nome=?, quantidade=?, preco=? WHERE codigo_barra=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setInt(2, produto.getQuantidade());
            preparedStatement.setDouble(3, produto.getPreco());
            preparedStatement.setString(4, produto.getCodigoBarra());
            preparedStatement.executeUpdate();
            System.out.println("Produto atualizado com sucesso!");
        }
    }

    private boolean registroExiste(String codigoBarra) throws SQLException {
        // Verifica se um registro com o código de barras especificado existe
        try (PreparedStatement preparedStatement = connection.prepareStatement(VERIFICAR_REGISTRO)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next() && resultSet.getInt(1) > 0;
            }
        }
    }
    

    public void fecharConexao() {
        ConnectionFactory.closeConnection(this.connection);
    }
}
