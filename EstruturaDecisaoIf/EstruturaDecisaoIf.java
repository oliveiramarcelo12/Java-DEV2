package EstruturaDecisaoIf;

import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class EstruturaDecisaoIf {
    Scanner sc = new Scanner(System.in);
    public void decisaoIf() {
        System.out.println("qual é o preço do Produto?");
        double precoProduto = sc.nextDouble();
        double percentualDesconto = 0.0;
        if (precoProduto>=200 && precoProduto<300) {
            // Estrutura de desisão if
            // Desconto para produtos de alto valor.
            percentualDesconto = 10.0;
            
        }
        if (precoProduto>=100 && precoProduto<200) { // Estrutura de desisão if
            // Desconto para produtos de alto valor.
            percentualDesconto = 5.0;
        }
        if (precoProduto>=300 && precoProduto<400) {
            percentualDesconto=15.0;
            
        }
        if (precoProduto>=400) {
            percentualDesconto=20.0;
            
        }
    
        // Regra de três
        double desconto = (precoProduto * percentualDesconto) / 100;
        double precoComDesconto = precoProduto - desconto;
        System.out.println("O produto sairá por R$" + precoComDesconto );

    }
    public static void decisaoIfElse() {
        System.out.println("digite o preco do produto");
        double precoProduto = sc.nextDouble();
        double percentualDesconto=0.0;
        if (precoProduto<100) {
            percentualDesconto =0.0;
            
        }else if(precoProduto>= 100 && precoProduto <200){
            percentualDesconto=10.0;

        }else if (precoProduto >=200 && precoProduto < 300){
            percentualDesconto= 15.0;
        }
        
        
        else{
            percentualDesconto=5.0;
            // Regra de três
        double desconto = (precoProduto * percentualDesconto) / 100;
        double precoComDesconto = precoProduto - desconto;
        System.out.println("O produto sairá por R$" + precoComDesconto );
        }
        
    }

}
