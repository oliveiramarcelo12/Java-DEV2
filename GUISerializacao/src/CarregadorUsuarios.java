import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarregadorUsuarios {
    public static List<Usuario> carregarUsuarios(String arquivo) {
        List<Usuario> usuarios = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(":");
                if (partes.length == 2) {
                    String nome = partes[0];
                    int idade = Integer.parseInt(partes[1]);
                    Usuario usuario = new Usuario(nome, idade);
                    usuarios.add(usuario);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar os usuários: " + e.getMessage());
        }

        return usuarios;
    }
}
