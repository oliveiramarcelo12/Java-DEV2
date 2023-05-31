package POOExercicio2;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import POOHeranca.Pessoas;

public class App {
  
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random rd= new Random(0);
       // vetor de objetos
        Agenda pessoas[]= new Agenda[10];
        //prencheer o meu vetor/array
        for (int i = 0; i < pessoas.length; i++) {
            //construtor de objetos
            pessoas[i]= new Agenda();
            //preencher os atributos
            pessoas[i].setNome("Pessoa"+i);
            pessoas[i].setAltura(i);
            pessoas[i].setIdade(i+18);

            
        }
        //buscador
        System.out.println("Digite um Nome");
        String nomeDigitado = sc.nextLine();
        // enquanto nomeDigitado != nome do Objeto
        //cont e procure
        boolean teste=true;
  
        int cont=0;

        while (!nomeDigitado.equals(pessoas[cont].getNome())) {
           cont++;

          



            
        }
      System.out.println("Nome: "+pessoas[cont].getNome()
          +"Idade: "+pessoas[cont].getIdade()
             +"Altura: "+pessoas[cont].getAltura());

    }
    
}
