import java.util.HashMap;

import javax.swing.JOptionPane;

/**
 * ExemploHashMap
 */
public class ExemploHashMap {

    // atributos
    HashMap<String, String> capitalEstados = new HashMap<>();

    // método
    public void teste() {
        capitalEstados.put("SP", "São Paulo");
        capitalEstados.put("MG", "Belo Horizonte");
        capitalEstados.put("RJ", "Rio de Janeiro");
        capitalEstados.put("ES", "Vitória");
        boolean jogo = true;
        while (jogo) {
            String estado = JOptionPane.showInputDialog("Digite a Sigla do Estado");
            JOptionPane.showMessageDialog(null, capitalEstados.get(estado));

        }
        jogo = false;

    }

    HashMap<String, Integer> idadeNome = new HashMap<>();

   
    public void name() {
     idadeNome.put("Marcos", 23);
     idadeNome.put("Amélia", 100);
     idadeNome.put("Bruno", 67);
     idadeNome.put("Nora", 12);
     idadeNome.put("Clark", 1);
     boolean jogo = true;
     while (jogo) {
        String idade = JOptionPane.showInputDialog("Informe o Nome Buscado");
        JOptionPane.showMessageDialog(null, idadeNome.get(idade));

        
     }
     jogo = false;
        

    }
}