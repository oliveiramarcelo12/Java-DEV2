package IteracaoWhile;

public class ExerciciosWhile {
    public void exercicio1() {
        int vetorA[] = new int[] { 3, 5, 7, 11, 13 };
        int vetorB[] = new int[5];
        int i = 0;
        while (i < vetorA.length) {
            vetorB[i] = vetorA[i];
            System.out.println("VetorB [" + i + "]=" + vetorB[i]);
            i++;

        }

    }

    public void exercicio2() {
        int vetorA[] = new int[] { 3, 5, 7, 11, 13, 56, 63, 9 };
        int vetorB[] = new int[8];
        int i = 0;
        while (i < vetorA.length) {
            vetorB[i] = vetorA[i] * 2;
            System.out.println("VetorB [" + i + "]=" + vetorB[i]);
            i++;

        }

    }

    public void exercicio3() {
        int vetorA[] = new int[] { 3, 5, 7, 11, 13, 56, 63, 9, 45, 23, 2, 1, 15, 67, 30 };
        int vetorB[] = new int[15];
        int i = 0;
        while (i < vetorA.length) {
            vetorB[i] = vetorA[i] * vetorA[i];
            System.out.println("VetorB [" + i + "]=" + vetorB[i]);
            i++;

        }

    }

    public void exercicio4() {
        int vetorA[] = new int[] { 25, 5, 7, 11, 13, 56, 63, 9, 45, 23, 2, 1, 15, 67, 30 };
        double vetorB[] = new double[15];
        int i = 0;
        while (i < vetorA.length) {
            vetorB[i] = Math.sqrt(vetorA[i]);
            System.out.println("VetorB [" + i + "]=" + vetorB[i]);
            i++;

        }

    }

    public void exercicio5() {
        int vetorA[] = new int[] { 3, 5, 7, 11, 13, 56, 63, 9, 45, 23 };
        double vetorB[] = new double[10];
        int i = 0;
        while (i < vetorA.length) {
            vetorB[i] = vetorA[i] * i;
            System.out.println("VetorB [" + i + "]=" + vetorB[i]);
            i++;

        }

    }

    public void exercicio6() {
        int vetorA[] = new int[] { 3, 5, 7, 11, 13, 56, 63, 9, 45, 23 };
        int vetorB[] = new int[] { 6, 9, 34, 56, 23, 2, 11, 89, 34, 22 };
        int vetorC[] = new int[10];
        int i = 0;
        while (i < vetorA.length) {
            vetorC[i] = vetorA[i] + vetorB[i];
            System.out.println("VetorC [" + i + "]=" + vetorC[i]);
            i++;

        }

    }

}
