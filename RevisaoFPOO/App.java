package RevisaoFPOO;

import javax.swing.JOptionPane;

import RevisaoFPOO.Cadastro.Cachorro;
import RevisaoFPOO.Cadastro.Gato;
import RevisaoFPOO.Cadastro.OutrosAnimais;


/**
 * App
 */
public class App {
    Cachorro cadastroCh[] = new Cachorro [2];
    Gato cadastroG[]= new Gato[2];
    OutrosAnimais cadastroOA[] = new OutrosAnimais[2];
    boolean aberto = true;
    int contCh =0;
    int contG = 0;

    public static void main(String[] args) {
       while (aberto) {
            int acao = Integer.parseInt(JOptionPane.showInputDialog("Informe a ação Desejada:"
                    + "\n 1-Gato"
                    + "\n 2-Cachorro"
                    + "\n 3-Outro Animal"
                    + "\n 4-Sair"
                    ));
                    

    if (acao ==1) {
        cadastroCh[contCh] = new Cachorro();
        
        
    }                
                
   }
        
    }
}