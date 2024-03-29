package Controller;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Model.Usuarios;
public class UsuarioControl {
    // Atributos
private List<Usuarios> Usuarios;
private DefaultTableModel tableModel;
private JTable table;
// Construtor
public UsuarioControl(List<Usuarios> Usuarios, DefaultTableModel tableModel, JTable table)
{
this.usuarios = Usuarios;
this.tableModel = tableModel;
this.table = table;}
// Método para atualizar a tabela de exibição com dados do banco de dados
private void atualizarTabela() {
    tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
    Usuarios = new UsuariosDAO().listarTodos();
    // Obtém os carros atualizados do banco de dados
    for (Usuarios Usuarios : Usuarios) {
    // Adiciona os dados de cada carro como uma nova linha na tabela Swing
    tableModel.addRow(new Object[] { Usuarios.getNome(),  Usuarios.getCpf() });
    }
    }
    // Método para cadastrar um novo carro no banco de dados
    public boolean cadastrar(String nome, String endereco, String telefone, String email, String
    cpf) {
    new UsuariosDAO().cadastrar(nome, endereco, telefone, email, cpf);
    // Chama o método de cadastro no banco de dados
    atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
    return false;
}
// Método para atualizar os dados de um carro no banco de dados
public void atualizar(String nome, String endereco, String telefone, String email, String
cpf) {
new UsuariosDAO().atualizar(nome, endereco, telefone, email, cpf);
// Chama o método de atualização no banco de dados
atualizarTabela(); // Atualiza a tabela de exibição após a atualização
}
// Método para apagar um carro do banco de dados
public void apagar(String cpf) {
new UsuariosDAO().apagar(cpf);
// Chama o método de exclusão no banco de dados
atualizarTabela(); // Atualiza a tabela de exibição após a exclusão

//Cria o banco de dados caso não tenha sido criado
new UsuariosDAO().criaTabela();
// incluindo elementos do banco na criação do painel
atualizarTabela();
}
}