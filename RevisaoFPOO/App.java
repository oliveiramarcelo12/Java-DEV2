package RevisaoFPOO;

import java.util.Random;

import javax.swing.JOptionPane;


import RevisaoFPOO.Cadastro.Cachorro;
import RevisaoFPOO.Cadastro.Gato;
import RevisaoFPOO.Cadastro.OutrosAnimais;
import RevisaoFPOO.Cadastro.Agenda.Agenda;


/**
 * App
 */
public class App {
  
/**
 * @param args
 */
public static void main(String[] args) {
    Random rd=new Random();
     Cachorro cachorros[] =new Cachorro[2];
    Gato gatos[]= new Gato[2];
    OutrosAnimais outros[] = new OutrosAnimais[2];
    boolean aberto = true;
    int contCh =0;
    int contG = 0;
    int contO=0;
    
     while (aberto) {
        JOptionPane.showMessageDialog(null, "Bem-Vindo ao Consultório\n do Dr.Chapatin");
            int acao = Integer.parseInt(JOptionPane.showInputDialog("Informe a ação Desejada:"
                    + "\n 1-Cadastro"
                    + "\n 2-Consulta"
                    + "\n 3-Sair"
     
                    ));
      if (acao ==1) {
       int acao1 = Integer.parseInt(JOptionPane.showInputDialog("1-Gato\n 2-Cachorro\n 3-outro Animal"));
       if (acao1==1) {
        gatos[contG]= new Gato();
        gatos[contG].setNome(JOptionPane.showInputDialog("Informe o Nome do Animal"));
        gatos[contG].setRaca(JOptionPane.showInputDialog("Informe a Raça do Animal"));
        gatos[contG].setProprietario(JOptionPane.showInputDialog("Informe o Nome do Proprietário do Animal"));
        gatos[contG].setIdade(Double.parseDouble(JOptionPane.showInputDialog("Informe a Idade do Animal")));
        gatos[contG].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe a Peso do Animal")));
        contG++;
        



        
       }
       if (acao1==2) {
        cachorros[contCh]=new Cachorro();
        cachorros[contCh].setNome(JOptionPane.showInputDialog("Informe o Nome do Animal"));
        cachorros[contCh].setRaca(JOptionPane.showInputDialog("Informe a Raça do Animal"));
        cachorros[contCh].setProprietario(JOptionPane.showInputDialog("Informe o Nome do Proprietário do Animal")); 
        cachorros[contCh].setIdade(Double.parseDouble(JOptionPane.showInputDialog("Informe a Idade do Animal")));
        cachorros[contCh].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe a Peso do Animal"))); 
       }
       if (acao1==3) {
        outros[contO]=new OutrosAnimais();
        outros[contO].setNome(JOptionPane.showInputDialog("Informe o Nome do Animal"));
        outros[contO].setRaca(JOptionPane.showInputDialog("Informe a Raça do Animal"));
        outros[contO].setProprietario(JOptionPane.showInputDialog("Informe o Nome do Proprietário do Animal")); 
        outros[contO].setIdade(Double.parseDouble(JOptionPane.showInputDialog("Informe a Idade do Animal")));
        outros[contO].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe a Peso do Animal")));  

        
       }
        
      } 
      if (acao ==2) {
        Agenda contatos[] =  new Agenda [2];
        for (int i = 0; i < contatos.length; i++) {
            contatos[i] = new Agenda(null, null, acao, i, null);
            contatos[i].setNome(JOptionPane.showInputDialog("Nome"));
            contatos[i].setPeso(i);
            contatos[i].setProprietario(JOptionPane.showInputDialog("Proprietário"));
            contatos[i].setRaca(JOptionPane.showInputDialog("Raça"));
            contatos[i].setIdade(i);

            
        }
        String nomeBuscado=JOptionPane.showInputDialog(
                                      "Informe o Nome buscado "
        );
        int cont=0;
        boolean procure=true;
        while (procure) {
            if (nomeBuscado.equals(contatos[cont].getNome())) {
                procure=false;
          
                
            }
            cont++;
            
        }




        


        
      }             
     }
}
 }