import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class Agendamento extends JPanel {
    private JTextField inputData;
    private JTextField inputHora;
    private JTextField inputDescricao;
    private JTextField inputUsuario; // Alterado para JTextField
    private DefaultTableModel tableModel;
    private JTable table;
    private List<Agenda> agendas = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private int linhaSelecionada = -1;

    public Agendamento() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Data");
        tableModel.addColumn("Hora");
        tableModel.addColumn("Usuário");
        tableModel.addColumn("Descrição");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        inputData = new JTextField(10);
        inputHora = new JTextField(5);
        inputDescricao = new JTextField(20);
        inputUsuario = new JTextField(15); // Alterado para JTextField

        JButton agendarButton = new JButton("Agendar");
        JButton atualizarButton = new JButton("Atualizar");
        JButton apagarButton = new JButton("Apagar");
        JButton apagarTodosButton = new JButton("Apagar Todos");
        JButton salvarButton = new JButton("Salvar");

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Data (dd/MM/yyyy):"));
        inputPanel.add(inputData);
        inputPanel.add(new JLabel("Hora (HH:mm):"));
        inputPanel.add(inputHora);
        inputPanel.add(new JLabel("Usuário:"));
        inputPanel.add(inputUsuario);
        inputPanel.add(new JLabel("Descrição:"));
        inputPanel.add(inputDescricao);
        inputPanel.add(agendarButton);
        inputPanel.add(atualizarButton);
        inputPanel.add(apagarButton);
        inputPanel.add(apagarTodosButton);
        inputPanel.add(salvarButton);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        File arquivo = new File("dados.txt");
        if (arquivo.exists()) {
            usuarios = CarregadorUsuarios.carregarUsuarios("dados.txt");
            atualizarTabela();
        }
        

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    Agenda agenda = agendas.get(linhaSelecionada);
                    inputData.setText(agenda.getDataAgendamento());
                    inputHora.setText(agenda.getHoraAgendamento());
                    inputUsuario.setText(agenda.getUsuario()); // Alterado para JTextField
                    inputDescricao.setText(agenda.getDescricao());
                }
            }
        });

        agendarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = inputData.getText();
                String hora = inputHora.getText();
                String nomeUsuario = inputUsuario.getText(); // Obter o nome do usuário
                String descricao = inputDescricao.getText();

                // Verificar se o usuário com o nome inserido existe no sistema
                Usuario usuario = encontrarUsuarioPorNome(nomeUsuario);
                if (usuario != null) {
                    Agenda agenda = new Agenda(data, hora, nomeUsuario, descricao); // Alterado para usar o nome do usuário
                    agendas.add(agenda);
                    atualizarTabela();
                    limparCampos();
                } else {
                    // Trate o caso em que o usuário não existe
                    JOptionPane.showMessageDialog(null, "Usuário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (linhaSelecionada != -1) {
                    String data = inputData.getText();
                    String hora = inputHora.getText();
                    String nomeUsuario = inputUsuario.getText(); // Obter o nome do usuário
                    String descricao = inputDescricao.getText();

                    // Verificar se o usuário com o nome inserido existe no sistema
                    Usuario usuario = encontrarUsuarioPorNome(nomeUsuario);
                    if (usuario != null) {
                        Agenda agenda = agendas.get(linhaSelecionada);
                        agenda.atualizarAgendamento(data, hora, nomeUsuario, descricao); // Alterado para usar o nome do usuário
                        atualizarTabela();
                        limparCampos();
                    } else {
                        // Trate o caso em que o usuário não existe
                        JOptionPane.showMessageDialog(null, "Usuário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (linhaSelecionada != -1) {
                    agendas.remove(linhaSelecionada);
                    atualizarTabela();
                    limparCampos();
                }
            }
        });

        apagarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agendas.clear();
                atualizarTabela();
                limparCampos();
            }
        });

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SerializacaoAgenda.serializar("dadosAgendamento.txt", agendas);
            }
        });
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (Agenda agenda : agendas) {
            tableModel.addRow(new Object[] {
                    agenda.getDataAgendamento(),
                    agenda.getHoraAgendamento(),
                    agenda.getUsuario(),
                    agenda.getDescricao()
            });
        }
    }

    private void limparCampos() {
        inputData.setText("");
        inputHora.setText("");
        inputUsuario.setText("");
        inputDescricao.setText("");
        linhaSelecionada = -1;
    }

    // Método para encontrar um usuário por nome
    private Usuario encontrarUsuarioPorNome(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                return usuario; // Retorna o usuário se o nome corresponder
            }
        }
        return null; // Retorna null se o usuário não for encontrado
    }
}
