package Controller;

import Model.Tarefa;
import Connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {
    private Connection connection;

    // Consultas SQL
    private static final String LIMPAR_TABELA = "DELETE FROM tarefas";
    private static final String VERIFICAR_REGISTRO = "SELECT COUNT(*) FROM tarefas";

    // Inicia uma transação no banco de dados
    public void iniciarTransacao() throws SQLException {
        obterConexao(); // Garante que a conexão está aberta
        connection.setAutoCommit(false);
    }

    // Finaliza uma transação no banco de dados
    public void finalizarTransacao() {
        try {
            connection.commit();
        } catch (SQLException e) {
            System.err.println("Erro no commit: " + e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                System.err.println("Erro ao redefinir auto commit: " + e.getMessage());
            }
        }
    }

    // Executa rollback em caso de falha na transação
    public void rollbackTransacao() {
        try {
            if (connection != null) {
                connection.rollback();
            }
        } catch (SQLException e) {
            System.err.println("Erro no rollback: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.setAutoCommit(true);
                }
            } catch (SQLException e) {
                System.err.println("Erro ao redefinir auto commit: " + e.getMessage());
            }
        }
    }

    // Construtor que inicializa a conexão e cria a tabela de tarefas se não existir
    public TarefaDAO() {
        this.connection = ConnectionFactory.getConnection();
        criarTabelaTarefas(); // Chame o método para criar a tabela no construtor, se necessário
    }

    // Cria a tabela de tarefas no banco de dados
    private void criarTabelaTarefas() {
        String sql = "CREATE TABLE IF NOT EXISTS tarefas (id INT AUTO_INCREMENT PRIMARY KEY, descricao VARCHAR(255))";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela de tarefas criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela de tarefas: " + e.getMessage(), e);
        }
    }

    // Adiciona uma tarefa ao banco de dados
    public void adicionarTarefa(Tarefa tarefa) {
        String sql = "INSERT INTO tarefas (descricao) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, tarefa.getDescricao());
            preparedStatement.executeUpdate();
            System.out.println("Tarefa adicionada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar tarefa: " + e.getMessage());

            // Em caso de erro, faça o rollback da transação
            rollbackTransacao();
        }
    }

    // Lista todas as tarefas do banco de dados
    public List<Tarefa> listarTodas() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Tarefa> tarefas = new ArrayList<>();

        try {
            obterConexao(); // Garante que a conexão está aberta
            stmt = connection.prepareStatement("SELECT * FROM tarefas");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Tarefa tarefa = new Tarefa(rs.getString("descricao"));
                tarefas.add(tarefa);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }
        return tarefas;
    }

    // Verifica se um registro com a descrição especificada já existe no banco de dados
    private boolean registroExiste(String descricao) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT 1 FROM tarefas WHERE descricao = ?")) {
            preparedStatement.setString(1, descricao);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }

    // Atualiza a tabela do banco de dados com a lista de tarefas fornecida
    public void atualizarTabelaBancoDados(List<Tarefa> tarefas) {
        try {
            iniciarTransacao();

            // Atualiza apenas os registros existentes e adiciona os novos
            for (Tarefa tarefa : tarefas) {
                if (registroExiste(tarefa.getDescricao())) {
                    atualizarTarefa(tarefa);
                } else {
                    adicionarTarefa(tarefa);
                }
            }

            finalizarTransacao();
        } catch (SQLException e) {
            rollbackTransacao();
            System.err.println("Erro ao atualizar tabela no banco de dados.");
            e.printStackTrace();
        }
    }

    // Atualiza os dados de uma tarefa no banco de dados
    private void atualizarTarefa(Tarefa tarefa) throws SQLException {
        // Atualiza os dados da tarefa no banco de dados
        String sql = "UPDATE tarefas SET descricao=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, tarefa.getDescricao());
            // Define o ID da tarefa para atualização
            preparedStatement.setInt(2, obterIdTarefaPorDescricao(tarefa.getDescricao()));
            preparedStatement.executeUpdate();
            System.out.println("Tarefa atualizada com sucesso!");
        }
    }

    // Obtém o ID de uma tarefa com base na descrição
    private int obterIdTarefaPorDescricao(String descricao) throws SQLException {
        String sql = "SELECT id FROM tarefas WHERE descricao=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, descricao);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id");
                } else {
                    throw new IllegalArgumentException("Tarefa não encontrada com a descrição: " + descricao);
                }
            }
        }
    }

    // Obtém a conexão, abrindo-a se estiver fechada
    private void obterConexao() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = ConnectionFactory.getConnection();
        }
    }

    // Fecha a conexão com o banco de dados
    public void fecharConexao() {
        ConnectionFactory.closeConnection(this.connection);
    }
}
