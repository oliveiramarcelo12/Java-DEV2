package EstruturaSwitchCase;

import java.util.Scanner;

public class SwitchCase {
    Scanner sc= new Scanner(System.in);
    public void letras() {
        System.out.println("Digite Uma Letra");
        String letra= sc.nextLine();
        switch (letra) {
            case "a": System.out.println(letra+ "é vogal");
                
                break;
            case "e": System.out.println(letra+ "é vogal");
                
                break;
            case "i": System.out.println(letra+ "é vogal");
                
                break; 
            case "o": System.out.println(letra+ "é vogal");
                
                break;
            case "u": System.out.println(letra+ "é vogal");
                
                break;
                   
          
        
            default: System.out.println (letra+ "é consoante");
                break;
        }

        
    }
    public void mes() {
        System.out.println("Informe um nº de 1 a 12 ref. aos Meses dos Anos");
        int mes= sc.nextInt();
        String Mes1= sc.nextLine();
        switch (mes) {
            case 1: Mes1= "Janeiro";
                
                break;
            case 2: Mes1= "Fevereiro";
                
                break;
            case 3: Mes1= "Março";
                
                break;
            case 4: Mes1= "Abril";
                
                break;
            case 5: Mes1= "Maio";
                
                break;
            case 6: Mes1= "Junho";
                
                break;
            case 7: Mes1= "Julho";
                
                break;
            case 8: Mes1= "Agosto";
                
                break;
            case 9: Mes1= "Setembro";
                
                break;
            case 10: Mes1= "Outubro";
                
                break;
            case 11: Mes1= "Novembro";

                
                break;
            case 12: Mes1= "Dezembro";
                
                break;
                
                
               
        
        
        
        
        
        
        
        
        
            default: System.out.println("Número Incorreto");
                break;
                
        }
        System.out.println("O Mês de Refêrencia é"+Mes1);
        
        
    }
}

