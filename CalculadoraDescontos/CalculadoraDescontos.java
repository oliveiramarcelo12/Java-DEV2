package Java CalculadoraDescontos;

import java.util.Scanner;
public class CalculadoraDescontos {public void calcular20(){
    Import java.util.Scanner
        Scanner sc = new Scanner (System.in);
        System.out.println("informe o Preço do Produto");
    
     double precoProduto = sc.nextDouble();
    final int desconto20 = 20;
    double precoComDesconto = precoProduto - (precoProduto*desconto20/100);
    System.out.println("O Preço com Desconto é"
    + precoComDesconto + "reais");
    
    }

    public void calcular30() {
        double precoProduto;
        precoProduto=200;
        final int desconto30 = 30;
        double precoComDesconto = precoProduto - (precoProduto*desconto20/100);
        System.out.println("O Preço com Desconto é"
        + precoComDesconto +"reais");
        
    

}


}
    
        
                
            



