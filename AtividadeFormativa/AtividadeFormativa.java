package AtividadeFormativa;

import java.util.Random;
import java.util.Scanner;

public class AtividadeFormativa {
    Scanner sc= new Scanner(System.in);
    Random rd = new Random();
    public void exercicio1() {
        int linha=0;
        int coluna=0;
        linha=sc.nextInt();
        System.out.println("Informe a quantidade de linhas da matriz");
        coluna=sc.nextInt();
        System.out.println("Informa a quantidade de Colunas");
        int matriz [][] =new int[linha][coluna];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j]=rd.nextInt(10);
                
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("matriz["+i+"]["+j+"]="
                        +matriz[i][j]);
            }
        }

        
    }
    
}
