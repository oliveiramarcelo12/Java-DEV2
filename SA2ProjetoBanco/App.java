package SA2ProjetoBanco;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        // criar vetor de objetos
        ContaPJ clientePJ[] = new ContaPJ[10];
        ContaPF clientePF[] = new ContaPF[10];
        // começar meu banco
        boolean aberto = true;
        int contPJ = 0;
        int contPF = 0;

        while (aberto) {
            int acao = Integer.parseInt(JOptionPane.showInputDialog("Informe a ação Desejada:"
                    + "\n 1-Abrir Conta PJ"
                    + "\n 2-Abrir Cont PF"
                    + "\n 3-Acessar Conta PJ"
                    + "\n 4-Acessar Conta PF"
                    + "\n 5-Sair"));
            if (acao == 1) { // abrir conta
                // criar um objeto
                clientePJ[contPJ] = new ContaPJ();
                clientePJ[contPJ].setNome(JOptionPane.showInputDialog("Informe o Nome da Empresa"));
                clientePJ[contPJ].setnCnpj(JOptionPane.showInputDialog("Informe o CNPJ da Empresa"));
                clientePJ[contPJ].setDeposito(0);
                clientePJ[contPJ].setnConta(2000 + contPJ);
                clientePJ[contPJ].setSaldo(0);
                // acrescimo no contador
                JOptionPane.showMessageDialog(null, "Conta Criada com Sucesso");
                contPJ++;
            } else if (acao == 2) {
                // abrir conta
                // criar um objeto
                clientePF[contPF] = new ContaPF();
                clientePF[contPF].setNome(JOptionPane.showInputDialog("Informe o Nome do Indivíduo"));
                clientePF[contPF].setnCpf(JOptionPane.showInputDialog("Informe o CPF do Indivíduo"));
                clientePF[contPF].setnConta(1000 + contPF);
                clientePF[contPF].setSaldo(0);
                // acrescimo no contador
                JOptionPane.showMessageDialog(null, "Conta Criada com Sucesso");
                contPF++;
            }

            else if (acao == 3) { // acessar uma conta PJ já criada
                // localizar a conta no vetor
                int i; // contador
                int nContaBuscada = Integer.parseInt(JOptionPane.showInputDialog("Informe o Número da Conta Buscada"));
                for (i = 0; i < contPJ; i++) {
                    if (nContaBuscada == clientePJ[i].getnConta()) {
                        JOptionPane.showMessageDialog(null, "Conta Encontrada");

                        // menu de acesso da conta
                        boolean acesso = true;
                        while (acesso) {
                            int acao3 = Integer.parseInt(JOptionPane.showInputDialog("Informe a operação Desejada:"
                                    + "\n 1-Consultar o Saldo"
                                    + "\n 2-Realizar um Saque"
                                    + "\n 3-Realizar um Depósito"
                                    + "\n 4-Sair"));
                            if (acao3 == 1) { // saldo
                                JOptionPane.showMessageDialog(null,
                                        "Seu Saldo é de R$ " + clientePJ[i].getSaldo());
                            } 
                            
                            else if (acao3 == 2) { // saque
                                clientePJ[i].saque();
                            } 
                            
                            else if (acao3 == 3) { // depósito
                                clientePJ[i].deposito();
                            }
                            
                            else if (acao3 == 4) { 
                                clientePJ[i].emprestimo();
                            }
                            else if (acao== 5) {
                                // sair
                                acesso = false;

                                
                            }
                        }
                        break;
                    }
                }
                if (i == contPJ) {
                    JOptionPane.showMessageDialog(null, "Conta não encontrada.");
                }
            } else if (acao == 4) { // acessar uma conta PF já criada
                // localizar a conta no vetor
                int i; // contador
                int nContaBuscada = Integer.parseInt(JOptionPane.showInputDialog("Informe o Número da Conta Buscada"));
                for (i = 0; i < contPF; i++) {
                    if (nContaBuscada == clientePF[i].getnConta()) {
                        JOptionPane.showMessageDialog(null, "Conta Encontrada");

                        // menu de acesso da conta
                        boolean acesso = true;
                        while (acesso) {
                            int acao3 = Integer.parseInt(JOptionPane.showInputDialog("Informe a operação Desejada:"
                                    + "\n 1-Consultar o Saldo"
                                    + "\n 2-Realizar um Saque"
                                    + "\n 3-Realizar um Depósito"
                                    + "\n 4-Emprétimo"
                                    + "\n 5-Sair"));
                            if (acao3 == 1) { // saldo
                                JOptionPane.showMessageDialog(null,
                                        "Seu Saldo é de R$ " + clientePF[i].getSaldo());
                            } 
                            else if (acao3 == 2) { // saque
                                clientePF[i].saque();
                            } 
                            else if (acao3 == 3) { // depósito
                                clientePF[i].deposito();
                            } 
                            else if (acao3 == 4) { 
                                clientePF[i].emprestimo();
                            }
                            else if (acao== 5) {
                                // sair
                                acesso = false;

                                
                            }
                        }
                        break;
                    }
                }
                if (i == contPF) {
                    JOptionPane.showMessageDialog(null, "Conta não encontrada.");
                }
            } else if (acao == 5) { // sair
                aberto = false;
                JOptionPane.showMessageDialog(null, "Sistema Encerrado.");
            }
        }

    }
}
