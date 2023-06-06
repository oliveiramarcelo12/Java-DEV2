package POOExercicio2;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import POOHeranca.Pessoas;

public class App {
  
 
        public static void main(String[] args) {
            Random rd = new Random();
            //criar um array de objetos
            Agenda contatos[] = new Agenda[10];
            //criar e preencher os objetos
            for (int i = 0; i < contatos.length; i++) {
                contatos[i] = new Agenda();
                //preencher os atributos do objjeto
                contatos[i].setNome(JOptionPane.showInputDialog("Nome:"));
                contatos[i].setIdade(i+18);
                contatos[i].setAltura(rd.nextDouble(1.5,2));
            }
            //busca de um objetos da Agenda(nome)
            String nomeBuscado = JOptionPane.showInputDialog(
                                "Informe o Nome Buscado");
            int cont=0;// contador
            boolean procure = true;
            while(procure){//enquanto procure for verdadeiro loop
                if(nomeBuscado.equals(contatos[cont].getNome())){
                    procure = false;//parar o laço
                    JOptionPane.showMessageDialog(null,
                        "Idade: "+contatos[cont].getIdade()
                        +"\nAltura: "+contatos[cont].getAltura());
                }
                cont++;
            }
    
        }
}
