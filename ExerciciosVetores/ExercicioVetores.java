package ExerciciosVetores;

import java.util.Scanner;

public class ExercicioVetores {
    Scanner sc = new Scanner(System.in);
    public void exercicio1() {
        int vetorA[]=new int[]{5,10,15,20,25};
        int vetorB[]=new int[5];
        vetorB[0]=vetorA[0];
        vetorB[1]=vetorA[1];
        vetorB[2]=vetorA[2];
        vetorB[3]=vetorA[3];
        vetorB[4]=vetorA[4];
        System.out.println("o vetorB é");
        System.out.println(vetorB[0]);
        System.out.println(vetorB[1]);
        System.out.println(vetorB[2]);
        System.out.println(vetorB[3]);
        System.out.println(vetorB[4]);


        
    }
    public void exercicio2() {
       System.out.println("Informe 8 Números Inteiros");
       int vetorA[]=new int []{7,46,23,9,8,3,65,6};
       int vetorB[]=new int[8];
       vetorB[0]=vetorA[0]*2;
       vetorB[1]=vetorA[1]*2;
       vetorB[2]=vetorA[2]*2;
       vetorB[3]=vetorA[3]*2;
       vetorB[4]=vetorA[4]*2;
       vetorB[5]=vetorA[5]*2;
       vetorB[6]=vetorA[6]*2;
       vetorB[7]=vetorA[7]*2;
       System.out.println("o vetorB é");
       System.out.println(vetorB[0]);
       System.out.println(vetorB[1]);
       System.out.println(vetorB[2]);
       System.out.println(vetorB[3]);
       System.out.println(vetorB[4]);
       System.out.println(vetorB[5]);
       System.out.println(vetorB[6]);
       System.out.println(vetorB[7]);



    


        
    }
    public void exercicio3() {
        System.out.println("Digite 15 Números Inteiros");
    int vetorA[]=new int [15];
    int vetorB[]=new int [15];
    vetorA[0]=sc.nextInt();
    vetorA[1]=sc.nextInt();
    vetorA[2]=sc.nextInt();
    vetorA[3]=sc.nextInt();
    vetorA[4]=sc.nextInt();
    vetorA[5]=sc.nextInt();
    vetorA[6]=sc.nextInt();
    vetorA[7]=sc.nextInt();
    vetorA[8]=sc.nextInt();
    vetorA[9]=sc.nextInt();
    vetorA[10]=sc.nextInt();
    vetorA[11]=sc.nextInt();
    vetorA[12]=sc.nextInt();
    vetorA[13]=sc.nextInt();
    vetorA[14]=sc.nextInt();
    vetorB[0]=vetorA[0]*vetorA[0];
    vetorB[1]=vetorA[1]*vetorA[1];
    vetorB[2]=vetorA[2]*vetorA[2];
    vetorB[3]=vetorA[3]*vetorA[3];
    vetorB[4]=vetorA[4]*vetorA[4];
    vetorB[5]=vetorA[5]*vetorA[5];
    vetorB[6]=vetorA[6]*vetorA[6];
    vetorB[7]=vetorA[7]*vetorA[7];
    vetorB[8]=vetorA[8]*vetorA[8];
    vetorB[9]=vetorA[9]*vetorA[9];
    vetorB[10]=vetorA[10]*vetorA[10];
    vetorB[11]=vetorA[11]*vetorA[11];
    vetorB[12]=vetorA[12]*vetorA[12];
    vetorB[13]=vetorA[13]*vetorA[13];
    vetorB[14]=vetorA[14]*vetorA[14];
    System.out.println("o vetorB é");
       System.out.println(vetorB[0]);
       System.out.println(vetorB[1]);
       System.out.println(vetorB[2]);
       System.out.println(vetorB[3]);
       System.out.println(vetorB[4]);
       System.out.println(vetorB[5]);
       System.out.println(vetorB[6]);
       System.out.println(vetorB[7]);
       System.out.println(vetorB[8]);
       System.out.println(vetorB[9]);
       System.out.println(vetorB[10]);
       System.out.println(vetorB[11]);
       System.out.println(vetorB[12]);
       System.out.println(vetorB[13]);
       System.out.println(vetorB[14]);
       
   

   














        
    }
    public void exercicio4() {
        System.out.println("Digite 15 Números Inteiros");
        double vetorA[]=new double [15];
        double vetorB[]=new double [15];
        vetorA[0]=sc.nextDouble();
        vetorA[1]=sc.nextDouble();
        vetorA[2]=sc.nextDouble();
        vetorA[3]=sc.nextDouble();
        vetorA[4]=sc.nextDouble();
        vetorA[5]=sc.nextDouble();
        vetorA[6]=sc.nextDouble();
        vetorA[7]=sc.nextDouble();
        vetorA[8]=sc.nextDouble();
        vetorA[9]=sc.nextDouble();
        vetorA[10]=sc.nextDouble();
        vetorA[11]=sc.nextDouble();
        vetorA[12]=sc.nextDouble();
        vetorA[13]=sc.nextDouble();
        vetorA[14]=sc.nextDouble();
        vetorB[0]=Math.sqrt(vetorA[0]);
        vetorB[1]=Math.sqrt(vetorA[1]);
        vetorB[2]=Math.sqrt(vetorA[2]);
        vetorB[3]=Math.sqrt(vetorA[3]);
        vetorB[4]=Math.sqrt(vetorA[4]);
        vetorB[5]=Math.sqrt(vetorA[5]);
        vetorB[6]=Math.sqrt(vetorA[6]);
        vetorB[7]=Math.sqrt(vetorA[7]);
        vetorB[8]=Math.sqrt(vetorA[8]);
        vetorB[9]=Math.sqrt(vetorA[9]);
        vetorB[10]=Math.sqrt(vetorA[10]);
        vetorB[11]=Math.sqrt(vetorA[11]);
        vetorB[12]=Math.sqrt(vetorA[13]);
        vetorB[14]=Math.sqrt(vetorA[14]);
        vetorB[14]=Math.sqrt(vetorA[14]);
        System.out.println("o vetorB é");
        System.out.println(vetorB[0]);
        System.out.println(vetorB[1]);
        System.out.println(vetorB[2]);
        System.out.println(vetorB[3]);
        System.out.println(vetorB[4]);
        System.out.println(vetorB[5]);
        System.out.println(vetorB[6]);
        System.out.println(vetorB[7]);
        System.out.println(vetorB[8]);
        System.out.println(vetorB[9]);
        System.out.println(vetorB[10]);
        System.out.println(vetorB[11]);
        System.out.println(vetorB[12]);
        System.out.println(vetorB[13]);
        System.out.println(vetorB[14]);
        
      
      

        
    }
    public void exercicio5() {
        System.out.println("Digite 10 Números Inteiros");
        double vetorA[]=new double [10];
        double vetorB[]=new double [10];
        vetorA[0]=sc.nextDouble();
        vetorA[1]=sc.nextDouble();
        vetorA[2]=sc.nextDouble();
        vetorA[3]=sc.nextDouble();
        vetorA[4]=sc.nextDouble();
        vetorA[5]=sc.nextDouble();
        vetorA[6]=sc.nextDouble();
        vetorA[7]=sc.nextDouble();
        vetorA[8]=sc.nextDouble();
        vetorA[9]=sc.nextDouble();
        vetorA[10]=sc.nextDouble();
        vetorB[0]=vetorA[0]*0;
        vetorB[1]=vetorA[1]*1;
        vetorB[2]=vetorA[2]*2;
        vetorB[3]=vetorA[3]*3;
        vetorB[4]=vetorA[4]*4;
        vetorB[5]=vetorA[5]*5;
        vetorB[6]=vetorA[6]*6;
        vetorB[7]=vetorA[7]*7;
        vetorB[8]=vetorA[8]*8;
        vetorB[9]=vetorA[9]*9;
        vetorB[10]=vetorA[10]*10;
        System.out.println("o vetorB é");
        System.out.println(vetorB[0]);
        System.out.println(vetorB[1]);
        System.out.println(vetorB[2]);
        System.out.println(vetorB[3]);
        System.out.println(vetorB[4]);
        System.out.println(vetorB[5]);
        System.out.println(vetorB[6]);
        System.out.println(vetorB[7]);
        System.out.println(vetorB[8]);
        System.out.println(vetorB[9]);
        System.out.println(vetorB[10]);


        
    }

    
}
