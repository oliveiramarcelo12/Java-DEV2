package SA2ProjetoBanco;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        // criar vetor de objetos
        ContaPJ clientePJ[]= new ContaPJ[10];
        //começar meu banco
        boolean aberto=true;
        int contPJ=0;
        while (aberto) {
            int acao = Integer.parseInt(JOptionPane.showInputDialog("Informe a ação Desejada:"    
                        +"\n 1-Abrir Conta"
                        +"\n 2-Acessar Conta"
                        +"\n 3-Sair" ));
            if (acao==1) { //abrir conta
                //criar um objeto
                clientePJ[contPJ] = new ContaPJ();
                clientePJ[contPJ].setNome(JOptionPane.showInputDialog("Informe o Nome da Empresa"));
                clientePJ[contPJ].setnCnpj(JOptionPane.showInputDialog("Informe o CNPJ da Empresa"));
                clientePJ[contPJ].setnConta(2000+contPJ);
                clientePJ[contPJ].setSaldo(0);
                //acrescimo no contador
                 JOptionPane.showMessageDialog(null,"Conta Criada com Sucesso");
                contPJ++;
            } else if(acao==2){ //acessar uma conta já criada
                //localizar a conta no vetor
                int i;//contador
                int nContaBuscada= Integer.parseInt(JOptionPane.showInputDialog("informe o Número da Conta Buscada"));
                for ( i = 0; i < clientePJ.length; i++) {
                    if (nContaBuscada==clientePJ[i].getnConta()) {
                        JOptionPane.showMessageDialog(null,"Conta Encontrada");
                        break;
                        
                    }
                    //menu de acesso da conta
                    boolean acesso = true;
                    while (acesso) {//acessei a conta
                        int acao2 = Integer.parseInt(JOptionPane.showInputDialog("Informe a operação Desejada:"
                            +"\n 1-Consultar o Saldo"
                            +"\n 2-Realizar um Saque"
                            +"\n 3-..." ));
                            if(acao2==1){//saldo
                                JOptionPane.showMessageDialog(null, "Seu Saldo é de R$ "+clientePJ[i].getSaldo());
                            }
                    }
                    
                }

            }



                
            }            
            
        }
    }
   
}
