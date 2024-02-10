package Controller;

import View.TarefasPainel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TarefasControl {
    private TarefasPainel view; // Referência à interface de usuário
    private List<String> tarefas; // Lista de tarefas
    

    public TarefasControl(TarefasPainel view) {
        this.view = view;
        this.tarefas = new ArrayList<>();

        // Adiciona os ouvintes aos botões na view
        this.view.addAdicionarListener(new AdicionarListener());
        this.view.addConcluirListener(new ConcluirListener());
        this.view.addExcluirListener(new ExcluirListener());
    }

    

    // Ouvinte para o botão "Adicionar"
    class AdicionarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String descricao = view.obterDescricaoTarefa();
            if (!descricao.isEmpty()) {
                adicionarTarefa(descricao);
                view.atualizarListaTarefas(tarefas);
            }
        }
    }

    // Ouvinte para o botão "Concluir"
    class ConcluirListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int index = view.obterIndiceTarefaSelecionada();
            if (index != -1) {
                concluirTarefa(index);
                view.atualizarListaTarefas(tarefas);
            }
        }
    }

    // Ouvinte para o botão "Excluir"
    class ExcluirListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int index = view.obterIndiceTarefaSelecionada();
            if (index != -1) {
                excluirTarefa(index);
                view.atualizarListaTarefas(tarefas);
            }
        }
    }

    // Método para adicionar uma nova tarefa à lista
    public void adicionarTarefa(String descricao) {
        tarefas.add(descricao);
    }

    // Método para concluir uma tarefa
    public void concluirTarefa(int index) {
        tarefas.remove(index);
    }

    // Método para excluir uma tarefa
    public void excluirTarefa(int index) {
        tarefas.remove(index);
    }

    // Método para retornar a lista de tarefas
    public List<String> getTarefas() {
        return tarefas;
    }
}
