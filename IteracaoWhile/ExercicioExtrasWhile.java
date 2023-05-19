package IteracaoWhile;

import java.util.Scanner;

public class ExercicioExtrasWhile {
    Scanner sc= new Scanner(System.in);
    public void Exercicio4() {
        String letras[] = new String[]{"a","b","c","d","e","f","g","h","i","j"};
        int i=0;
        int cont =0;
        while (i<letras.length) {
            if (letras[i]=="a"||letras[i]=="e"||letras[i]=="i"||letras[i]=="o"||letras[i]=="u") {

                
            }
            else{
                cont++;
                System.out.println(letras[i]+" é consoante");
            }
            i++; 
        }
        System.out.println("o nº de consoante é" +cont);
    }
    public void exercicio5() {
        System.out.println("Digite 20 números");
        int vetor[]= new int[]{sc.nextInt()};
        int contPar=0;
        int contImpar=0;
        int i=0;
       
        while (i<vetor.length) {
            if (vetor[i]% 2==0) {
                contPar++;
                
                
            }
            else{
                contImpar++;
            }
            i++;

            
        }
        int vetorPar[]=new int[contPar];
        int vetorImpar[]=new int[contImpar];
        i=0;
        contPar=0;
        contImpar=0;
        while (i>vetor.length) {
            if (vetor[i]% 2==0) {
               vetorPar[contPar]=vetor[i];
                contPar++;
                
                
            }
            else{
                vetorImpar[contImpar]=vetor[i];
                contImpar++;
            }
            i++;

            
        }



        
    }
    
}
