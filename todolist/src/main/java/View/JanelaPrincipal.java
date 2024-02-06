package View;

import Controller.TarefasControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaPrincipal extends JFrame {
    private TarefasControl tarefaController;

    private JPanel mainPanel;
    private JTextField taskInputField;
    private JButton addButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private JButton deleteButton;
    private JButton markDoneButton;
    private JComboBox<String> filterComboBox;
    private JButton clearCompletedButton;
    private JLabel timerLabel;

    public JanelaPrincipal(TarefasControl tarefaController) {
        super("TodoListApp");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(480, 400);

        this.tarefaController = tarefaController;

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        taskInputField = new JTextField();
        addButton = new JButton("Adicionar");
        deleteButton = new JButton("Excluir");
        markDoneButton = new JButton("Concluir");
        filterComboBox = new JComboBox<>(new String[]{"Todas", "Ativas", "Concluídas"});
        clearCompletedButton = new JButton("Limpar Concluídas");

        timerLabel = new JLabel("Tempo decorrido: 0 segundos");
        mainPanel.add(timerLabel, BorderLayout.SOUTH);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(deleteButton);
        buttonPanel.add(markDoneButton);
        buttonPanel.add(filterComboBox);
        buttonPanel.add(clearCompletedButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(mainPanel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tarefaControl.adicionarTarefa(taskInputField.getText());
                atualizarListaTarefas();
                taskInputField.setText("");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tarefaController.excluirTarefa(taskList.getSelectedIndex());
                atualizarListaTarefas();
            }
        });

        markDoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tarefaController.marcarTarefaConcluida(taskList.getSelectedIndex());
                atualizarListaTarefas();
            }
        });

        clearCompletedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tarefaController.limparTarefasConcluidas();
                atualizarListaTarefas();
            }
        });

        filterComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tarefaController.filtrarTarefas(filterComboBox.getSelectedItem().toString());
                atualizarListaTarefas();
            }
        });
    }

    private void atualizarListaTarefas() {
        listModel.clear();
        for (String descricao : tarefaController.getListaTarefas()) {
            listModel.addElement(descricao);
        }
    }

    public void run() {
        this.setVisible(true);
    }
}
