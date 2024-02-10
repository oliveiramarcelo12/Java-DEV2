package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionFactory;
import Model.Usuario;

public class UsuarioDAO {
    // Variáveis de conexão e lista de usuários
    private Connection connection;
    private List<Usuario> usuarios;

    // Construtor para inicializar a conexão
    public UsuarioDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // Método para criar a tabela de usuários
    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios (NOME VARCHAR(255), EMAIL VARCHAR(255), SENHA VARCHAR(255), PRIMARY KEY (EMAIL))";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela de usuários criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela de usuários: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Método para recuperar uma lista de todos os usuários do banco de dados
    public List<Usuario> listarTodos() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        usuarios = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM usuarios");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }
        return usuarios;
    }

    // Método para inserir um novo usuário no banco de dados
    public void cadastrar(String nome, String email, String senha) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, senha);
            stmt.executeUpdate();
            System.out.println("Usuário cadastrado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir usuário no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Método para atualizar informações de um usuário no banco de dados
    public void atualizar(String nome, String email, String senha) {
        PreparedStatement stmt = null;
        String sql = "UPDATE usuarios SET nome = ?, senha = ? WHERE email = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            stmt.setString(3, email);
            stmt.executeUpdate();
            System.out.println("Usuário atualizado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar usuário no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Método para excluir um usuário do banco de dados
    public void apagar(String email) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM usuarios WHERE email = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.executeUpdate();
            System.out.println("Usuário excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir usuário do banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Método para obter um usuário por seu email
    public Usuario obterUsuarioPorEmail(String email) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            stmt = connection.prepareStatement("SELECT * FROM usuarios WHERE email = ?");
            stmt.setString(1, email);
            rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(null, stmt, rs);
        }

        return usuario;
    }
}
