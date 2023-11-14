import java.sql.SQLException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Clientes;
import app.Connection.ClientesDAO;

public class ClientesControl {
    private List<Clientes> clientes;
    private DefaultTableModel tableModel;
    private JTable table;

    public ClientesControl(List<Clientes> clientes, DefaultTableModel tableModel, JTable table) {
        this.clientes = clientes;
        this.tableModel = tableModel;
        this.table = table;
    }

    public void cadastrar(String nome, String endereco, String telefone, String cpf)
            throws NumberFormatException, IllegalArgumentException, SQLException {
        // Verificar se o CPF é numérico
        try {
            Long.parseLong(cpf);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("O CPF deve ser numérico.");
        }

        // Restante do código para verificar outros requisitos, se necessário

        Clientes novoCliente = new Clientes(nome, endereco, telefone, cpf);
        new ClientesDAO().cadastrar(novoCliente);
        atualizarTabela();
    }

    public void atualizar(String nome, String endereco, String telefone, String cpf)
            throws SQLException, IllegalArgumentException {
        // Restante do código para verificar outros requisitos, se necessário

        Clientes clienteAtualizado = new Clientes(nome, endereco, telefone, cpf);
        new ClientesDAO().atualizar(clienteAtualizado);
        atualizarTabela();
    }

    public void apagar(String cpf) {
        new ClientesDAO().apagar(cpf);
        atualizarTabela();
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
