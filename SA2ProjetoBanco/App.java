package SA2ProjetoBanco;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        // criar vetor de objetos
        ContaPJ clientePJ[]= new ContaPJ[10];
        ContaPF clientePF[]= new ContaPF[10];
        //começar meu banco
        boolean aberto=true;
        int contPJ=0;
        int contPF=0;
        while (aberto) {
            int acao = Integer.parseInt(JOptionPane.showInputDialog("Informe a ação Desejada:"
                        +"\n 1-Abrir Conta PJ"
                        +"\n 2-Abrir Cont PF"
                        +"\n 3-Acessar Conta PJ"
                        +"\n 4-Acessar Conta PF"
                        +"\n 5-Sair"));
            if (acao==1) { //abrir conta
                //criar um objeto
                clientePJ[contPJ] = new ContaPJ();
                clientePJ[contPJ].setNome(JOptionPane.showInputDialog("Informe o Nome da Empresa"));
                clientePJ[contPJ].setnCnpj(JOptionPane.showInputDialog("Informe o CNPJ da Empresa"));
                clientePJ[contPJ].setDeposito(0);
                clientePJ[contPJ].setnConta(2000+contPJ);
                clientePJ[contPJ].setSaldo(0);
                //acrescimo no contador
                 JOptionPane.showMessageDialog(null,"Conta Criada com Sucesso");
                contPJ++;
            } 
            else if(acao==2)  {
                //abrir conta
                //criar um objeto
                clientePF[contPF] = new ContaPF();
                clientePF[contPF].setNome(JOptionPane.showInputDialog("Informe o Nome do Indivíduo"));
                clientePF[contPF].setnCpf(JOptionPane.showInputDialog("Informe o CPF do Indivíduo"));
                clientePF[contPF].setnConta(2000+contPF);
                clientePF[contPF].setSaldo(0);
                //acrescimo no contador
                 JOptionPane.showMessageDialog(null,"Conta Criada com Sucesso");
                contPF++;
            }

             else if(acao==3){ //acessar uma conta já criada
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
                        int acao3 = Integer.parseInt(JOptionPane.showInputDialog("Informe a operação Desejada:"
                            +"\n 1-Consultar o Saldo"
                            +"\n 2-Realizar um Saque"
                            +"\n 3-Realizar um Depósito" ));
                            if(acao3==1){//saldo
                                JOptionPane.showMessageDialog(null, "Seu Saldo é de R$ "+clientePJ[i].getSaldo());
                            }
                            else if(acao3==2){
                                JOptionPane.showMessageDialog(null, "Informe Valor do Saque"+clientePJ[i].getSaque());

                            }
                    }
                    
                }

            }



                
                        
            
        }
    }
    
   
}
