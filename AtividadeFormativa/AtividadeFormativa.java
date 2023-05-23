package AtividadeFormativa;

import java.util.Random;
import java.util.Scanner;

public class AtividadeFormativa {
    Scanner sc= new Scanner(System.in);
    Random rd = new Random();
    public void exercicio1() {
        int linha=0;
        int coluna=0;
        System.out.println("Informe a quantidade de linhas da matriz");
        linha=sc.nextInt();
        System.out.println("Informa a quantidade de Colunas");
        coluna=sc.nextInt();
      
      
        int matriz [][] =new int[linha][coluna];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j]=rd.nextInt(10);
                
            }
        }
        for (int i = 0; i < matriz[0].length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("matriz["+i+"] ["+j+"]=" 
                +matriz[i][j]);
                

                
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i>j) {
                    matriz [i][j]=1;
                    
                }
                else if (i<j){
                    matriz [i][j]=2;
                }
                else {
                    matriz [i][j]=0;

                }
             
              
               
                
            }
        }
       for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz.length; j++) {
            System.out.println("matriz["+i+"] ["+j+"]=" 
                +matriz[i][j]);
        }
       }

        
    }
    public void exercicio2() {
      int nSorteado=rd.nextInt(1000);
      int nDigitado;
      System.out.println("Digite um Nº");
      nDigitado=sc.nextInt();
      int cont=1;
      System.out.println("=========");
      
      while (nSorteado!=nDigitado) {
        cont++;
         if( nSorteado>nDigitado){
           
            System.out.println("Tente Novamente");
            System.out.println("Número Sorteado é maior do que Numero Digitado");
            System.out.println("Aperte CTRL+C, a qualquer momento, para parar.");
           
           
        }
       else  if  ( nSorteado<nDigitado) {
        System.out.println("Tente Novamente");
        System.out.println(" Número Sorteado é menor do que Numero Digitado ");
       }
       
       

        else{
           
        }
        System.out.println("Digite outro Número");
        nDigitado=sc.nextInt();
        cont++;

        System.out.println("Você Acertou");
        System.out.println("Em"+cont+"tentativas");
  


        
      }
      
    }
    public void exercicio3() {
        int tamanhoVetor=rd.nextInt(900)+100;
        int vetor[] = new int [tamanhoVetor];
        int contImparNoPar=0;
        int contParNoImpar=0;
        for (int i = 0; i < vetor.length; i++) {
            vetor[i]=rd.nextInt(100)+1;
        }
        for (int i = 0; i < 0; i+=2) {
         
            if (vetor[i]%2==0) {
                System.out.println(vetor[i]);
                if (i%2==0) {
                    contImparNoPar++;
                    
                    
                }

                
                
            }
         

            
        }
        
        for (int i = 0; i < vetor.length; i+=2) {
            if (vetor[i]%2==1) {
                System.out.println(vetor[i]);
                if (i%2==1) {
                    contParNoImpar++;
                    
                    
                }

                
            }

            
        }
        



        
    }

    
}
