package POOHeranca.Pessoa;

import POOHeranca.Pessoas;

public class Funcionarios extends Pessoas   {
    //atríbutos especificos
     int nFi;
     String periodo;
     String funcao;
    int getnFi() {
        return nFi;
    }
    public void setnFi(int nFi) {
        this.nFi = nFi;
    }
    public String getPeriodo() {
        return periodo;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    public String getFuncao() {
        return funcao;
    }
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    

    
}
