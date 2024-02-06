package Controller;

import Model.Tarefas;
import View.TarefaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TarefasControl {
    private List<Tarefas> tarefas;
    private TarefaView tarefaView;

    public TarefasControl(TarefaView tarefaView) {
        this.tarefas = new ArrayList<>();
        this.tarefaView = tarefaView;

        this.tarefaView.setAdicionarTarefaListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarTarefa();
            }
        });

        this.tarefaView.setExcluirTarefaListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirTarefa();
            }
        });

        this.tarefaView.setConcluirTarefaListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                concluirTarefa();
            }
        });

        this.tarefaView.setLimparConcluidasListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparTarefasConcluidas();
            }
        });
    }

    private void adicionarTarefa() {
        String descricao = tarefaView.getInputDescricao();
        if (descricao.isEmpty()) {
            tarefaView.mostrarMensagem("A descrição da tarefa não pode estar vazia.");
            return;
        }

        Tarefa novaTarefa = new Tarefa(descricao);
        tarefas.add(novaTarefa);
        tarefaView.atualizarListaTarefas(tarefas);
        tarefaView.limparInputDescricao();
    }

    private void excluirTarefa() {
        int indiceSelecionado = tarefaView.getIndiceTarefaSelecionada();
        if (indiceSelecionado != -1) {
            int opcao = JOptionPane.showConfirmDialog(null,
                    "Você tem certeza que deseja excluir esta tarefa?",
                    "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                tarefas.remove(indiceSelecionado);
                tarefaView.atualizarListaTarefas(tarefas);
            }
        } else {
            tarefaView.mostrarMensagem("Selecione uma tarefa para excluir.");
        }
    }

    private void concluirTarefa() {
        int indiceSelecionado = tarefaView.getIndiceTarefaSelecionada();
        if (indiceSelecionado != -1) {
            Tarefa tarefa = tarefas.get(indiceSelecionado);
            tarefa.setConcluida(true);
            tarefaView.atualizarListaTarefas(tarefas);
        } else {
            tarefaView.mostrarMensagem("Selecione uma tarefa para concluir.");
        }
    }

    private void limparTarefasConcluidas() {
        List<Tarefa> tarefasConcluidas = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            if (tarefa.isConcluida()) {
                tarefasConcluidas.add(tarefa);
            }
        }
        tarefas.removeAll(tarefasConcluidas);
        tarefaView.atualizarListaTarefas(tarefas);
    }

    public void run() {
        tarefaView.run();
    }
}
