package ExemploThrow;

import javax.swing.JOptionPane;

public class ExemploThrow {
    public static void main(String[] args) {
        boolean teste = true;
    
        while (teste) {
            String nomeUsuario  =JOptionPane.showInputDialog("Digíte o seu Nome de Usuário");
            String dataNascimento  =JOptionPane.showInputDialog("Informe o sua data de nascimento [dd/mm/aa]");
            dataNascimento= dataNascimento.replace("/","");
            String senha = JOptionPane.showInputDialog("Digite uma Senha de 6 digítos");
           
            

            try {
               
                if (senha.length() !=6) {
                    throw new Exception("Senha Inválida");
                    
                }//equals comparação
             if (senha.equals(nomeUsuario) ) {
                    throw new Exception("Sua senha não pode igual ao Nome de Usário");
                    
                }
                 if(senha.equals(dataNascimento)){
                    throw new Exception("Sua senha não pode igual a Sua Data de Nascimento");

                }
                 

               
                teste=false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(),null,JOptionPane.CLOSED_OPTION);
            }
            
        }
    }
}