package Model;

public class Usuario {
    private String username;
    private char[] password; // Armazenar senha como array de caracteres para segurança

    public Usuario(String username, char[] password) {
        this.username = username;
        this.password = password.clone(); // Clonar para garantir que o array original não seja alterado externamente
    }

    public String getUsername() {
        return username;
    }

    public char[] getPassword() {
        return password.clone(); // Clonar para garantir que o array original não seja alterado externamente
    }
}
