package IteracaoWhile;

import java.util.Random;
import java.util.Scanner;

public class ExemploWhile {
    Scanner sc= new Scanner (System.in);
    public void exemplo1() {
        int iteracao =0;
        while (iteracao<1000000000) {
            iteracao +=1;
            System.out.println("essa é a iteracao de nº"+iteracao);

            
        }

        
    }
    public void exemplo2()   {
        Random rd = new Random();//função para escolher um nº aleatório
        int numeroAleatorio= rd.nextInt(10);
        System.out.println("============================");
boolean tentarNovamente = true;
System.out.println("Aperte CTRL+C, a qualquer momento, para parar.");
// Enquanto tentarNovamente igual a true, itera novamente.
while (tentarNovamente) {
System.out.print("Tente adivinhar o número: ");
int numero = sc.nextInt();
// Repare que a relação abaixo e a de diferença,
// enquanto diferente, retorna true e, por isso,
// tenta novamente.
tentarNovamente = numeroAleatorio != numero;

if (numero==numeroAleatorio) {
    System.out.println("Acertou Miseravi");
    tentarNovamente=false;
   
    
}
else {
    System.out.println("Erroou!!! Tente Novamente");
}
}



        
    }
    public void exemplo3() {
        // ler 5 números inteiros e printar na ordem
        // criar um vetor com while
        int vetor[] = new int[5];
        int i = 0;
        while (i<5) {
            System.out.println("Digite o valor para o vetor["+i+"]");
            vetor[i]=sc.nextInt();
            i++;
            
        }
        i=0;
        while (i<5) {
            System.out.println("O valor do vetor["+i+"] é "+vetor[i]);
            i++;
            
        }
        
    }
    
}
