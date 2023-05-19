package POOHeranca;

import POOHeranca.Pessoa.Alunos;
import POOHeranca.Pessoa.Funcionarios;
import POOHeranca.Pessoa.Professores;

public class App {
    public static void main(String[] args) {
        Alunos aluno01= new Alunos();
        Funcionarios func01= new Funcionarios();
        Professores prof01= new Professores();
        Pessoas pessoa01= new Pessoas();
        aluno01.setNome("João Figueira de Macedo");
        aluno01.setCurso("TI");
        aluno01.setEndereco("Av.dos Ratos");
        aluno01.setIdade(99);
        aluno01.setTurma("09");
        aluno01.setnCpf("000.000.000-00");
        aluno01.setnMatricula(1);
        func01.setNome("Maicão da Silva");
        prof01.setNome("Marcos Barbosa");
        prof01.setCurso("Eve");

        
        
    }
    
}
