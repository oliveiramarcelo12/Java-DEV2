package View;

import Controller.TarefasControl;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TarefasPainel extends JPanel {
    private JButton adicionarButton;
    private JButton concluirButton;
    private JButton excluirButton;
    private JComboBox<String> statusComboBox;
    private TarefasControl control;

    public TarefasPainel(TarefasControl control) {
        super();
        this.control = control;

        adicionarButton = new JButton("Adicionar");
        concluirButton = new JButton("Concluir");
        excluirButton = new JButton("Excluir");

        statusComboBox = new JComboBox<>(new String[]{"Ativas", "Concluídas", "Excluídas"});

        add(adicionarButton);
        add(concluirButton);
        add(excluirButton);
        add(statusComboBox);

        adicionarButton.addActionListener(e -> {
            String descricao = obterDescricaoTarefa();
            if (descricao != null && !descricao.isEmpty()) {
                control.adicionarTarefa(descricao);
                atualizarListaTarefas();
            }
        });

        concluirButton.addActionListener(e -> {
            int index = obterIndiceTarefaSelecionada();
            if (index != -1) {
                control.concluirTarefa(index);
                atualizarListaTarefas();
            }
        });

        excluirButton.addActionListener(e -> {
            int index = obterIndiceTarefaSelecionada();
            if (index != -1) {
                control.excluirTarefa(index);
                atualizarListaTarefas();
            }
        });

        statusComboBox.addActionListener(e -> atualizarListaTarefas());
    }

    public void atualizarListaTarefas() {
        List<String> tarefas = control.getTarefas();
        statusComboBox.removeAllItems();
        for (String tarefa : tarefas) {
            statusComboBox.addItem(tarefa);
        }
    }

    public String obterDescricaoTarefa() {
        return JOptionPane.showInputDialog(this, "Digite a descrição da nova tarefa:");
    }

    public int obterIndiceTarefaSelecionada() {
        return statusComboBox.getSelectedIndex();
    }
}
