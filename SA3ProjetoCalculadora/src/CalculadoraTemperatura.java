import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraTemperatura {
    public CalculadoraTemperatura() {
        // Criação da janela principal
        JFrame frame = new JFrame("Conversor de Temperaturas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define a ação de fechamento da janela
        // Define as dimensões da janela (largura x altura)
        frame.setSize(400, 200); 
        frame.setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout

        // Criação de componentes gráficos
        JTextField text = new JTextField(10); // Campo de entrada de texto
        JLabel painel1 = new JLabel("Resultado: "); // Rótulo para exibir o resultado
        String escalaTemperaturas[] = { "Celsius", "Fahrenheit", "Kelvin" };
        JComboBox<String> comboBox = new JComboBox<>(escalaTemperaturas); // Caixa de seleção

        JButton botaoConversor = new JButton("Converter"); // Botão de conversão

        // Configuração do ouvinte de ação para o botão
        botaoConversor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Função executada quando o botão é clicado

                double valorInserido;
                try {
                    valorInserido = Double.parseDouble(text.getText()); // Obtém o valor inserido pelo usuário
                } catch (NumberFormatException ex) {
                    // Exibe uma mensagem de erro se o valor inserido não for válido
                    JOptionPane.showMessageDialog(frame, "Insira um valor válido.");
                    return;
                }

                String itemSelecionado = (String) comboBox.getSelectedItem(); // Obtém a unidade selecionada

                // Calcula e constrói a string de resultado com base na unidade selecionada
                StringBuilder resultado = new StringBuilder("Resultado: ");
                if (itemSelecionado.equals("Celsius")) {
                    double fahrenheit = (valorInserido * 9 / 5) + 32;
                    double kelvin = valorInserido + 273.15;
                    resultado.append("Celsius: ").append(valorInserido).append("°C, ");
                    resultado.append("Fahrenheit: ").append(fahrenheit).append("°F, ");
                    resultado.append("Kelvin: ").append(kelvin).append("K");
                } else if (itemSelecionado.equals("Fahrenheit")) {
                    double celsius = (valorInserido - 32) * 5 / 9;
                    double kelvin = celsius + 273.15;
                    resultado.append("Celsius: ").append(celsius).append("°C, ");
                    resultado.append("Fahrenheit: ").append(valorInserido).append("°F, ");
                    resultado.append("Kelvin: ").append(kelvin).append("K");
                } else if (itemSelecionado.equals("Kelvin")) {
                    double celsius = valorInserido - 273.15;
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    resultado.append("Celsius: ").append(celsius).append("°C, ");
                    resultado.append("Fahrenheit: ").append(fahrenheit).append("°F, ");
                    resultado.append("Kelvin: ").append(valorInserido).append("K");
                }

                // Define o resultado no rótulo
                painel1.setText(resultado.toString());
            }
        });

        // Adiciona componentes à janela
        frame.add(new JLabel("Valor: "));
        frame.add(text);
        frame.add(comboBox);
        frame.add(botaoConversor);
        frame.add(painel1);

        // Configurações finais da janela
        frame.pack(); // Ajusta o tamanho da janela automaticamente
        frame.setVisible(true); // Torna a janela visível
    }
  }