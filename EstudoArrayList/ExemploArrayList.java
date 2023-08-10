import java.util.ArrayList;
import java.util.Random;

/**
 * exemploArryList
 */
public class ExemploArrayList {
//atributo
//Declarando a ArrayList do Tipo String
 ArrayList<String> carros = new ArrayList<>();
 //métodos
 public void teste(){
    //Adicionar o valor ao ArrayList
    carros.add("Uno");
    carros.add("Chevette");
    carros.add("Fusca");
    carros.add("Celta");
    carros.add("Brasilia");
   //imprimir toda a lista
    System.out.println(carros);
    //pegando o valor correspondente a 5 posição(index 4) 
    System.out.println(carros.get(4));
   //percorrendo a lista com FOR
    for (int i = 0; i < carros.size(); i++) {
        System.out.println(carros.get(i));


    
   }
   //percorrendo a lista com FOR-EACH
   for (String i : carros) {
    System.out.println(i);
    
   }
    //apagar a lista
    carros.clear();
    System.out.println(carros);


 }
 Random rd = new Random(10);
 public void exercicio() {
    //criar um arraylist (Interger) + 5 valores
    ArrayList<Integer> valor = new ArrayList<>();
    valor.add();

    

    
}
 
}
