package POOIntroducao;
/**
 * App
 */
public class App {

    public static void main(String[] args) {
        RegistraAluno aluno1 = new RegistraAluno();
        //modificar os atributos(set)
        aluno1.setNome("Ana Clara Pereira");
        aluno1.setEndereco("Rua Dos Passaros,187");
        aluno1.setIdade(10);
        aluno1.setNotaCiencias(8.0);
        aluno1.setNotaMatematica(7.5);
        aluno1.setNotaPortugues(8.9);

         //Acessar os atributos
         System.out.println("None:"+aluno1.getNome());
         System.out.println("Endereço:"+aluno1.getEndereco());
         System.out.println("Idade:"+aluno1.getIdadee());
         System.out.println("Média:"+aluno1.getMedia());
         
       

    }
}