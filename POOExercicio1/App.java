package POOExercicio1;

import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * App
 */
public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //criar objeto
      Pessoa  pessoa1 = new Pessoa();
      pessoa1.setNome("Fabiana");
      pessoa1.setAltura(1.67);
      pessoa1.setDiaNascimento(11);
      pessoa1.setMesNascimento(11);
      pessoa1.setAnoNascimento(1989);
      pessoa1.imprimir();
      System.out.println("Idade: " +pessoa1.getIdade());
    }
}