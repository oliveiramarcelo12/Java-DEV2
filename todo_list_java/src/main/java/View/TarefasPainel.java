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

    public TarefasPainel(String tipoTarefa) {
        // Chama o construtor padrão da superclasse
        super();

        // Inicialização dos botões
        adicionarButton = new JButton("Adicionar");
        concluirButton = new JButton("Concluir");
        excluirButton = new JButton("Excluir");

        // Inicialização do JComboBox para selecionar o status das tarefas
        statusComboBox = new JComboBox<>(new String[]{"Ativas", "Concluídas", "Excluídas"});
        statusComboBox.setSelectedItem(tipoTarefa); // Define o item selecionado com base no tipo de tarefa inicial

        // Adiciona os botões e o JComboBox ao painel
        add(adicionarButton);
        add(concluirButton);
        add(excluirButton);
        add(statusComboBox);

        // ActionListener para o botão "Adicionar"
        adicionarButton.addActionListener(e -> {
            String descricao = JOptionPane.showInputDialog(TarefasPainel.this, "Digite a descrição da nova tarefa:");
            if (descricao != null && !descricao.isEmpty()) {
                control.adicionarTarefa(descricao);
                // Você pode chamar atualizarListaTarefas() aqui se necessário
            }
        });

        // ActionListener para o botão "Concluir"
        concluirButton.addActionListener(e -> {
            int index = obterIndiceTarefaSelecionada();
            if (index != -1) {
                control.concluirTarefa(index);
                // Você pode chamar atualizarListaTarefas() aqui se necessário
            }
        });

        // ActionListener para o botão "Excluir"
        excluirButton.addActionListener(e -> {
            int index = obterIndiceTarefaSelecionada();
            if (index != -1) {
                control.excluirTarefa(index);
                // Você pode chamar atualizarListaTarefas() aqui se necessário
            }
        });

        // ActionListener para o JComboBox de status das tarefas
        statusComboBox.addActionListener(e -> {
            String statusSelecionado = (String) statusComboBox.getSelectedItem();
            // Implemente a lógica para atualizar as tarefas com base no status selecionado
            // Exemplo: control.atualizarTarefas(statusSelecionado);
        });
    }

    // Método para atualizar a lista de tarefas no painel
    public void atualizarListaTarefas(List<String> tarefas) {
        // Implemente a lógica para atualizar o JList com as tarefas recebidas
    }

    // Método para obter a descrição da tarefa digitada pelo usuário
    public String obterDescricaoTarefa() {
        // Implemente a lógica para obter o texto do campo de entrada de tarefa
        return "";
    }

    // Método para obter o índice da tarefa selecionada na lista
    public int obterIndiceTarefaSelecionada() {
        // Implemente a lógica para obter o índice da tarefa selecionada na lista
        return -1;
    }

    // Métodos para adicionar ouvintes aos botões
    public void addAdicionarListener(ActionListener listener) {
        adicionarButton.addActionListener(listener);
    }

    public void addConcluirListener(ActionListener listener) {
        concluirButton.addActionListener(listener);
    }

    public void addExcluirListener(ActionListener listener) {
        excluirButton.addActionListener(listener);
    }
}
