import java.awt.event.*;
import java.awt.*;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import Controller.ClientesControl; // Certifique-se de ter um controlador para clientes
import Model.Clientes; // Certifique-se de ter a classe Cliente

import app.Connection.ClientesDAO; // Certifique-se de ter a classe ClientesDAO

import javax.swing.*;

public class ClientesPainel extends JPanel {
    // Atributos(componentes)
    private JButton cadastrar, apagar, editar;
    private JTextField nomeField, enderecoField, telefoneField, cpfField;
    private List<Clientes> clientes;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    // Construtor(GUI-JPanel)
    public ClientesPainel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro Clientes"));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Nome"));
        nomeField = new JTextField(20);
        inputPanel.add(nomeField);
        inputPanel.add(new JLabel("Endereço"));
        enderecoField = new JTextField(20);
        inputPanel.add(enderecoField);
        inputPanel.add(new JLabel("Telefone"));
        telefoneField = new JTextField(20);
        inputPanel.add(telefoneField);
        inputPanel.add(new JLabel("CPF"));
        cpfField = new JTextField(20);
        inputPanel.add(cpfField);

        add(inputPanel);

        JPanel botoes = new JPanel();
        cadastrar = new JButton("Cadastrar");
        editar = new JButton("Editar");
        apagar = new JButton("Apagar");
        botoes.add(cadastrar);
        botoes.add(editar);
        botoes.add(apagar);
        add(botoes);

        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Endereço", "Telefone", "CPF" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        new ClientesDAO().criaTabela();
        atualizarTabela();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    nomeField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    enderecoField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    telefoneField.setText((String) table.getValueAt(linhaSelecionada, 2));
                    cpfField.setText((String) table.getValueAt(linhaSelecionada, 3));
                }
            }
        });

        ClientesControl operacoes = new ClientesControl(clientes, tableModel, table);

        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    operacoes.cadastrar(nomeField.getText(), enderecoField.getText(), telefoneField.getText(),
                            cpfField.getText());
                    nomeField.setText("");
                    enderecoField.setText("");
                    telefoneField.setText("");
                    cpfField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ClientesPainel.this, "Erro ao cadastrar: CPF deve ser numérico.",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(ClientesPainel.this, "Erro ao cadastrar: " + ex.getMessage(), "Erro",
                            JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ClientesPainel.this, "Erro ao cadastrar: " + ex.getMessage(), "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    operacoes.atualizar(nomeField.getText(), enderecoField.getText(), telefoneField.getText(),
                            cpfField.getText());
                    nomeField.setText("");
                    enderecoField.setText("");
                    telefoneField.setText("");
                    cpfField.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ClientesPainel.this,
                            "Erro ao atualizar dados no banco de dados: " + ex.getMessage(), "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        apagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagar(cpfField.getText());
                nomeField.setText("");
                enderecoField.setText("");
                telefoneField.setText("");
                cpfField.setText("");
            }
        });
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        clientes = new ClientesDAO().listarTodos();
        for (Clientes cliente : clientes) {
            tableModel.addRow(new Object[] { cliente.getNome(), cliente.getEndereco(), cliente.getTelefone(),
                    cliente.getCpf() });
        }
    }
}
