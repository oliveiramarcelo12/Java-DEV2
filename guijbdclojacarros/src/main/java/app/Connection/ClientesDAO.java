package app.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Clientes;

public class ClientesDAO {
    private Connection connection;

    public ClientesDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS clientes (NOME VARCHAR(255), ENDERECO VARCHAR(255), TELEFONE VARCHAR(15), CPF VARCHAR(11) PRIMARY KEY)";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela de clientes criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela de clientes: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    public void cadastrar(Clientes cliente) throws SQLException {
        String sql = "INSERT INTO clientes (NOME, ENDERECO, TELEFONE, CPF) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getCpf());
            stmt.executeUpdate();
            System.out.println("Cliente cadastrado com sucesso.");
        } finally {
            ConnectionFactory.closeConnection(connection);
        }
    }

    public void atualizar(Clientes cliente) throws SQLException {
        String sql = "UPDATE clientes SET NOME = ?, ENDERECO = ?, TELEFONE = ? WHERE CPF = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getCpf());
            stmt.executeUpdate();
            System.out.println("Cliente atualizado com sucesso.");
        } finally {
            ConnectionFactory.closeConnection(connection);
        }
    }

    public void apagar(String cpf) {
        String sql = "DELETE FROM clientes WHERE CPF = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.executeUpdate();
            System.out.println("Cliente removido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar cliente: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection);
        }
    }

    public List<Clientes> listarTodos() {
        List<Clientes> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Clientes cliente = new Clientes(
                    rs.getString("NOME"),
                    rs.getString("ENDERECO"),
                    rs.getString("TELEFONE"),
                    rs.getString("CPF")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar clientes: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection);
        }
        return clientes;
    }
}
