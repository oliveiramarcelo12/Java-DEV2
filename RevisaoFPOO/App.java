package RevisaoFPOO;

import java.util.Random;

import javax.print.attribute.standard.JobHoldUntil;
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
    Agenda agendas[] =new Agenda[100];
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
      else if (acao1==2) {
        cachorros[contCh]=new Cachorro();
        cachorros[contCh].setNome(JOptionPane.showInputDialog("Informe o Nome do Animal"));
        cachorros[contCh].setRaca(JOptionPane.showInputDialog("Informe a Raça do Animal"));
        cachorros[contCh].setProprietario(JOptionPane.showInputDialog("Informe o Nome do Proprietário do Animal")); 
        cachorros[contCh].setIdade(Double.parseDouble(JOptionPane.showInputDialog("Informe a Idade do Animal")));
        cachorros[contCh].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe a Peso do Animal"))); 
        contCh++;
       }
     else  if (acao1==3) {
        outros[contO]=new OutrosAnimais();
        outros[contO].setNome(JOptionPane.showInputDialog("Informe o Nome do Animal"));
        outros[contO].setRaca(JOptionPane.showInputDialog("Informe a Raça do Animal"));
        outros[contO].setProprietario(JOptionPane.showInputDialog("Informe o Nome do Proprietário do Animal")); 
        outros[contO].setIdade(Double.parseDouble(JOptionPane.showInputDialog("Informe a Idade do Animal")));
        outros[contO].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe a Peso do Animal")));  
        contO++;

        
       }
        
      } 
      if (acao ==2) {
        boolean cadastroOk = false;
       String nomeAgenda=JOptionPane.showInputDialog("Informe o Nome do Pet");
       for (int i = 0; i < agendas.length; i++) {
        if (gatos[i].getNome().equals(nomeAgenda)) {
            //mensagem de confirmação
            JOptionPane.showMessageDialog(null,"Pet Encontrado");
            cadastroOk=true;
            break;

            
        }

        
       }
        for (int i = 0; i < agendas.length; i++) {
        if (cachorros[i].getNome().equals(nomeAgenda)) {
            //mensagem de confirmação
            JOptionPane.showMessageDialog(null,"Pet Encontrado");
             cadastroOk=true;
            break;

            
        }
        
        
       }
        for (int i = 0; i < agendas.length; i++) {
        if (outros[i].getNome().equals(nomeAgenda)) {
            //mensagem de confirmação
            JOptionPane.showMessageDialog(null,"Pet Encontrado");
             cadastroOk=true;
            break;

            
        }
        
        
       }
       //2º Terminar o Cadastro
       int contAgenda;
       if (cadastroOk) {
        boolean agendar=true;
        while (agendar) {
            String dataAgenda= JOptionPane.showInputDialog("informe a Data do Agendamento");
            String horaAgenda= JOptionPane.showInputDialog("informe a Hora do Agendamento");
            if (contAgenda==0) {
                agendas[contAgenda] = new Agenda();
                agendas[contAgenda].setData(dataAgenda);
                agendas[contAgenda].setHora(horaAgenda);

                
            }
            for (int i = 0; i < agendas.length; i++) {
                if (agendas[i].getDataHora().equals(dataAgenda+horaAgenda)) {
                    //não pode agendar
                    break;
                    
                }
                else{
                    agendas[contAgenda] = new Agenda();
                                agendas[contAgenda].setData(dataAgenda);
                                agendas[contAgenda].setHora(horaAgenda);
                    contAgenda++;
                                agendar = false;

                }
            }

            
        }
        
       }

        }
        




        


        
      }             
     }
}
 