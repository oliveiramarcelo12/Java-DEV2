package Controller;

import java.util.List;
import Model.Tarefa;
import Controller.TarefaDAO;

public class TarefaControl {
    private TarefaDAO tarefaDAO;

    public TarefaControl() {
        this.tarefaDAO = new TarefaDAO();
    }

    /**
     * Adiciona uma nova tarefa e atualiza o banco de dados.
     *
     * @param descricao Descrição da tarefa.
     */
    public void adicionarTarefa(String descricao) {
        try {
            // Cria uma nova tarefa
            Tarefa novaTarefa = new Tarefa(descricao);

            // Adiciona a tarefa
            tarefaDAO.adicionarTarefa(novaTarefa);
            System.out.println("Tarefa adicionada com sucesso!");
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao adicionar tarefa: " + e.getMessage());
        }
    }

    /**
     * Remove uma tarefa e atualiza o banco de dados.
     *
     * @param tarefa Tarefa a ser removida.
     */
    public void removerTarefa(Tarefa tarefa) {
        try {
            // Remove a tarefa
            tarefaDAO.removerTarefa(tarefa);
            System.out.println("Tarefa removida com sucesso!");
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao remover tarefa: " + e.getMessage());
        }
    }

    /**
     * Conclui uma tarefa e atualiza o banco de dados.
     *
     * @param tarefa Tarefa a ser concluída.
     */
    public void concluirTarefa(Tarefa tarefa) {
        try {
            // Conclui a tarefa
            tarefa.concluir();
            
            // Atualiza a tarefa no banco de dados
            tarefaDAO.atualizarTarefa(tarefa);
            System.out.println("Tarefa concluída com sucesso!");
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao concluir tarefa: " + e.getMessage());
        }
    }

    /**
     * Exclui uma tarefa e atualiza o banco de dados.
     *
     * @param tarefa Tarefa a ser excluída.
     */
    public void excluirTarefa(Tarefa tarefa) {
        try {
            // Remove a tarefa
            tarefaDAO.removerTarefa(tarefa);
            System.out.println("Tarefa excluída com sucesso!");
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao excluir tarefa: " + e.getMessage());
        }
    }

    /**
     * Lista todas as tarefas do banco de dados.
     *
     * @return Lista de tarefas.
     */
    public List<Tarefa> listarTarefasDoBanco() {
        try {
            return tarefaDAO.listarTodas();
        } catch (Exception e) {
            System.err.println("Erro ao listar tarefas do banco de dados: " + e.getMessage());
            return null;
        }
    }
}
