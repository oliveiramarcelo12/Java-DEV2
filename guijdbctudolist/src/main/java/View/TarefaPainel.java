package View;

import java.awt.event.*;
import java.awt.*;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import Controller.TarefaControl;

import javax.swing.*;

import Model.Tarefa;

public class TarefaPainel extends JPanel {
    private JButton adicionar, concluir, excluir;
    private JTextField descricaoField;
    private List<Tarefa> tarefas;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    public TarefaPainel(TarefaControl control) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Lista de Tarefas"));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1, 2));

        inputPanel.add(new JLabel("Descrição"));
        descricaoField = new JTextField(20);
        inputPanel.add(descricaoField);

        add(inputPanel);

        JPanel botoes = new JPanel();
        adicionar = new JButton("Adicionar");
        concluir = new JButton("Concluir");
        excluir = new JButton("Excluir");
        botoes.add(adicionar);
        botoes.add(concluir);
        botoes.add(excluir);
        add(botoes);

        JScrollPane jScrollPane = new JScrollPane();
        add(jScrollPane);
        tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Descrição", "Concluída" });
        table = new JTable(tableModel);
        jScrollPane.setViewportView(table);

        atualizarTabela();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    descricaoField.setText((String) table.getValueAt(linhaSelecionada, 0));
                }
            }
        });

        adicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descricao = descricaoField.getText();
                if (!descricao.isEmpty()) {
                    control.adicionarTarefa(descricao);
                    atualizarTabela();
                    descricaoField.setText("");
                }
            }
        });

        concluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (linhaSelecionada != -1) {
                    control.concluirTarefa(linhaSelecionada);
                    atualizarTabela();
                }
            }
        });

        excluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (linhaSelecionada != -1) {
                    control.excluirTarefa(linhaSelecionada);
                    atualizarTabela();
                }
            }
        });
    }

    private void atualizarTabela() {
        tarefas = control.getTarefas();
        tableModel.setRowCount(0);
        for (Tarefa tarefa : tarefas) {
            tableModel.addRow(new Object[] { tarefa.getDescricao(), tarefa.isConcluida() });
        }
    }
}
