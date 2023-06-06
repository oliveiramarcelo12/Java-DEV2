package POOExercicio2;

import javax.swing.JOptionPane;

public class Agenda {
   //atributos
   String nome;
   int idade;
   double altura;
   //métodos
   //construtor(atributos)//construtor método == classe
   public Agenda(String nome, int idade, double altura) {
       this.nome = nome;
       this.idade = idade;
       this.altura = altura;
   }
   //construtor default(vazio)
   public Agenda() {
   }
   //setters and getters
   public String getNome() {
       return nome;
   }
   public void setNome(String nome) {
       this.nome = nome;
   }
   public int getIdade() {
       return idade;
   }
   public void setIdade(int idade) {
       this.idade = idade;
   }
   public double getAltura() {
       return altura;
   }
   public void setAltura(double altura) {
       this.altura = altura;
   }
    
}
