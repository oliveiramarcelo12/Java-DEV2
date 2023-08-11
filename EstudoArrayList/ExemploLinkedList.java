import java.util.LinkedList;

/**
 * ExemploLinkedList
 */
public class ExemploLinkedList {
    //atributos
    LinkedList <String> pessoas = new LinkedList<>();
    //métodos
    public void teste() {
        pessoas.add("Maria");
        pessoas.add("Joana");
        pessoas.add("Pedro");
        //adicionando na 1 posição
        pessoas.addFirst("Ana");
        //buscando a 1 posição
        System.out.println(pessoas.getFirst());
        
    }

}