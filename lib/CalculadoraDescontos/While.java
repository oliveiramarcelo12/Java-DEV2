package lib.CalculadoraDescontos;

import java.util.Random;
import java.util.Scanner;

import javax.swing.BoundedRangeModel;

public class While {
    Scanner sc= new Scanner(System.in);
    public void Exemplo1() {
        int iteracao=0;
        while (iteracao<10) {
            System.out.println("O Nº da iteração"
            +iteracao);
            iteracao +=1;
            
        }
        
    }
    public void adivinhar() {
        Random rd= new Random();
        int nSorteado = rd.nextInt(bound:10);
        boolean tenteNovamente;
        while (tenteNovamente) {
          System.out.println("Digite um Nº");
          int nDigitado= sc.nextInt();
            if (nDigitado==nSorteado) {
                System.out.println("Acertou Miseravi");
                tenteNovamente= false;
                

                
            }
            else{
                System.out.println("Errrouuuu");
                tenteNovamente=true;
            }

            
        }
        
    }
    
}
