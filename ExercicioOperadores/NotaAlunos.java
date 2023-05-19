package ExercicioOperadores;

import java.util.Scanner;

/**
 * NotaAlunos
 */
public class NotaAlunos {
 Scanner sc = new Scanner(System.in);
    /**
     * 
     */
    public void notaFrequencia() {
        System.out.println("Informe a Nota 1 do aluno: ");
        int nota1 = sc.nextInt();
        System.out.println("informe a Nota 2 do aluno:");
        int nota2 = sc.nextInt();
        final double mediaNotas = (nota1+nota2)/2;
        System.out.println("A Média do aluno é " +mediaNotas);
        boolean mediaAprovado = mediaNotas >= 50;
        System.out.println(" O Aluno esta Aprovado por Nota?"+mediaAprovado);
        System.out.println("Informe a Frequencia do Aluno:");
        int frequenciaAluno = sc.nextInt();
        boolean frequenciaAprovado = frequenciaAluno >=75;
        System.out.println(" O Aluno esta Aprovado por Frequencia?"+frequenciaAprovado);
        boolean aprovacaoFinal = (mediaAprovado==true)&&(frequenciaAprovado==true);
        System.out.println("O aluno esta aprovado no curso?" +aprovacaoFinal); 

    }

}