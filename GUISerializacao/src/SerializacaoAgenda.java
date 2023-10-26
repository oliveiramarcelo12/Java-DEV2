import java.io.*;
import java.util.List;

public class SerializacaoAgenda {
    public static void serializar(String arquivo, List<Agenda> agendas) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            outputStream.writeObject(agendas);
            System.out.println("Dados de agenda serializados com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao serializar os dados de agenda: " + e.getMessage());
        }
    }

    public static List<Agenda> deserializar(String arquivo) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<Agenda>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao deserializar os dados de agenda: " + e.getMessage());
            return null;
        }
    }
}
