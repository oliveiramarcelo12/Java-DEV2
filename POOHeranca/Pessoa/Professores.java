package POOHeranca.Pessoa;

public class Professores extends Funcionarios {
    private int nAulas;
    private String disciplina;
    public int getnAulas() {
        return nAulas;
    }
    public void setnAulas(int nAulas) {
        this.nAulas = nAulas;
    }
    public String getCurso() {
        return disciplina;
    }
    public void setCurso(String disciplina) {
        this.disciplina = disciplina;
    }
    

    
}
