package Controller;

import Model.Tarefas; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionFactory;
import Model.Tarefas;

public class TarefasDAO {
    private Connection connection;

    public TarefasDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS tarefas ("
                   + "id SERIAL PRIMARY KEY,"
                   + "descricao TEXT,"
                   + "status VARCHAR(20),"
                   + "usuario_id INT REFERENCES usuarios(id)"
                   + ")";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela de tarefas criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela de tarefas: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    public List<Tarefas> listarTodas() {
        List<Tarefas> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM tarefas";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Tarefas tarefa = new Tarefa(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getString("status"),
                        rs.getInt("usuario_id")
                );
                tarefas.add(tarefa);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar as tarefas: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection);
        }
        return tarefas;
    }

    public void cadastrar(Tarefas tarefa) {
        String sql = "INSERT INTO tarefas (descricao, status, usuario_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tarefa.getDescricao());
            stmt.setString(2, tarefa.getStatus());
            stmt.setInt(3, tarefa.getUsuarioId());
            stmt.executeUpdate();
            System.out.println("Tarefa cadastrada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar a tarefa: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection);
        }
    }

    public void atualizar(Tarefas tarefa) {
        String sql = "UPDATE tarefas SET descricao = ?, status = ?, usuario_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tarefa.getDescricao());
            stmt.setString(2, tarefa.getStatus());
            stmt.setInt(3, tarefa.getUsuarioId());
            stmt.setInt(4, tarefa.getId());
            stmt.executeUpdate();
            System.out.println("Tarefa atualizada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar a tarefa: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection);
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM tarefas WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Tarefa excluída com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir a tarefa: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection);
        }
    }

    public Tarefas buscarPorId(int id) {
        String sql = "SELECT * FROM tarefas WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Tarefa(
                            rs.getInt("id"),
                            rs.getString("descricao"),
                            rs.getString("status"),
                            rs.getInt("usuario_id")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar a tarefa: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection);
        }
        return null;
    }
}
