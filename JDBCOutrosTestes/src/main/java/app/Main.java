package app;

public class Main {
    public static void main(String[] args) {
        ConnectionDAO obj = new ConnectionDAO();
        obj.cleanup();
        obj.doexample();
    }
}