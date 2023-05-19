package VetoresArray;

import java.util.Scanner;

public class vetores {
    Scanner sc= new Scanner(System.in);
    public void exemplo1() {
        //criando um vetor
        double[] valores= new double []{10.5,20.7,30.6,40.4};
        System.out.println("1º Posição- Índice[0]:"+valores[0]);
        System.out.println("2º Posição- Índice[1]:"+valores[1]);
        System.out.println("3º Posição- Índice[2]:"+valores[2]);
        System.out.println("4º Posição- Índice[3]:"+valores[3]);
        //mudando valores de uma posição definida
        valores[0]= 15.6; //mudando o valor do Índice[0]
        System.out.println("1º Posição- Índice[0]:"+valores[0]);

        
    }
    public void exemplo2() {
        //Criando um Vetor
        int valoresInt[]= new int[5];
        System.out.println("Digite 5 Nº inteiros");
        valoresInt[0]=sc.nextInt();
        valoresInt[1]=sc.nextInt();
        valoresInt[2]=sc.nextInt();
        valoresInt[3]=sc.nextInt();
        valoresInt[4]=sc.nextInt();
        System.out.println("1º Posição- Índice[0]:"+valoresInt[0]);
        System.out.println("2º Posição- Índice[1]:"+valoresInt[1]);
        System.out.println("3º Posição- Índice[2]:"+valoresInt[2]);
        System.out.println("4º Posição- Índice[3]:"+valoresInt[3]);
        System.out.println("5º Posição- Índice[4]:"+valoresInt[4]);

        
    }
    public void Exercicio2() {
        double[] valoresDouble= new double[10];
        System.out.println("Digite 10 Nº inteiros");
        valoresDouble[0]=sc.nextInt();
        valoresDouble[1]=sc.nextInt();
        valoresDouble[2]=sc.nextInt();
        valoresDouble[3]=sc.nextInt();
        valoresDouble[4]=sc.nextInt();
        valoresDouble[5]=sc.nextInt();
        valoresDouble[6]=sc.nextInt();
        valoresDouble[7]=sc.nextInt();
        valoresDouble[8]=sc.nextInt();
        valoresDouble[9]=sc.nextInt();
        System.out.println("1º Posição- Índice[9]:"+valoresDouble[9]);
        System.out.println("2º Posição- Índice[8]:"+valoresDouble[8]);
        System.out.println("3º Posição- Índice[7]:"+valoresDouble[7]);
        System.out.println("4º Posição- Índice[6]:"+valoresDouble[6]);
        System.out.println("5º Posição- Índice[5]:"+valoresDouble[5]);
        System.out.println("5º Posição- Índice[4]:"+valoresDouble[4]);
        System.out.println("5º Posição- Índice[3]:"+valoresDouble[3]);
        System.out.println("5º Posição- Índice[2]:"+valoresDouble[2]);
        System.out.println("5º Posição- Índice[1]:"+valoresDouble[1]);
        System.out.println("5º Posição- Índice[0]:"+valoresDouble[0]);







        
    }
    public void Exercicio3() {
        double[] Notas= new double [4];
        System.out.println("Digite 4 Notas");
        Notas[0]=sc.nextDouble();
        Notas[1]=sc.nextDouble();
        Notas[2]=sc.nextDouble();
        Notas[3]=sc.nextDouble();
        System.out.println("1º Nota- Índice[0]:"+Notas[0]);
        System.out.println("2º Nota- Índice[1]:"+Notas[1]);
        System.out.println("3º Nota- Índice[2]:"+Notas[0]);
        System.out.println("4º Nota- Índice[3]:"+Notas[0]);

        double Media=(Notas[0]+Notas[1]+Notas[2]+Notas[3])/4;
        System.out.println("Média é igual"+Media);

        


        
    }

    
}
