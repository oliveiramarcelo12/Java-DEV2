import java.util.*;

import javax.swing.JOptionPane;

/**
 * App
 */
public class App {

    public static void main(String[] args) {
    
        //2. listar os Carros
       
        //4. apagar carro
        List <Carros> listaCarros = new ArrayList<>();
        boolean aberto = true;
        while (aberto) {
            int acao= Integer.parseInt(JOptionPane.showInputDialog("1-Cadastro\n2-Listar\n3-Consultar\n4-Excluir"));
            if(acao==1){ //1. cadastrar Carro
                String marcaCar = JOptionPane.showInputDialog("Marca do carro");
                String modeloCar = JOptionPane.showInputDialog("Modelo do carro");
                String anoCar = JOptionPane.showInputDialog("Ano do carro");
                String corCar = JOptionPane.showInputDialog("Cor do carro");
                Carros car= new Carros(marcaCar, modeloCar, anoCar, corCar);
                listaCarros.add(car);


            }
            else if(acao==2){//2-Listar carros cadastrados
                String listar="";
            for (Carros carros : listaCarros) {
                
                listar+=carros.imprimirLN();


                
            }
            JOptionPane.showMessageDialog(null, listar);

            
            
        }
        else if(acao==3){ //3. consultar Carro 
            String listar="";
            int i=0;
            for (Carros carros : listaCarros) {
                
                listar+=carros.imprimirLN();
                i++;


                
            }
            int acao2=Integer.parseInt((JOptionPane.showInputDialog("Escolha o Carro:\n"+listar)));
            listaCarros.get(acao2).imprimir();
            
         

        }
        else if(acao==4){ //3. consultar Carro 
            String listar="";
            int i=0;
            for (Carros carros : listaCarros) {
                
                listar+=carros.imprimirLN();
                i++;


                
            }
            int acao2=Integer.parseInt((JOptionPane.showInputDialog("Escolha o Carro para excluir:\n"+listar)));
            listaCarros.get(acao2).imprimir();
            listaCarros.remove(acao2);
            
         

        }
       
    }
}
}