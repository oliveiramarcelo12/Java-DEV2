package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class TarefaView {
    private JFrame frame;
    private JList<String> listaTarefas;
    private JTextField inputDescricao;
    private JButton btnAdicionar;
    private JButton btnExcluir;
    private JButton btnConcluir;
    private JButton btnLimparConcluidas;

    public TarefaView() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Lista de Tarefas");
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane, BorderLayout.CENTER);

        listaTarefas = new JList<>();
        scrollPane.setViewportView(listaTarefas);

        JPanel panelBotoes = new JPanel();
        panel.add(panelBotoes, BorderLayout.SOUTH);

        inputDescricao = new JTextField();
        panelBotoes.add(inputDescricao);
        inputDescricao.setColumns(20);

        btnAdicionar = new JButton("Adicionar");
        panelBotoes.add(btnAdicionar);

        btnExcluir = new JButton("Excluir");
        panelBotoes.add(btnExcluir);

        btnConcluir = new JButton("Concluir");
        panelBotoes.add(btnConcluir);

        btnLimparConcluidas = new JButton("Limpar Concluídas");
        panelBotoes.add(btnLimparConcluidas);
    }

    public String getInputDescricao() {
        return inputDescricao.getText().trim();
    }

    public void limparInputDescricao() {
        inputDescricao.setText("");
    }

    public int getIndiceTarefaSelecionada() {
        return listaTarefas.getSelectedIndex();
    }

    public void atualizarListaTarefas(List<String> tarefas) {
        listaTarefas.setListData(tarefas.toArray(new String[0]));
    }

    public void setAdicionarTarefaListener(ActionListener listener) {
        btnAdicionar.addActionListener(listener);
    }

    public void setExcluirTarefaListener(ActionListener listener) {
        btnExcluir.addActionListener(listener);
    }

    public void setConcluirTarefaListener(ActionListener listener) {
        btnConcluir.addActionListener(listener);
    }

    public void setLimparConcluidasListener(ActionListener listener) {
        btnLimparConcluidas.addActionListener(listener);
    }

    public void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(frame, mensagem);
    }

    public void run() {
        frame.setVisible(true);
    }
}
