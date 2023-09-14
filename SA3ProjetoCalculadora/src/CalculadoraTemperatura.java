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
         // Criando JFrame
         this.setBounds(800, 450, 350, 150);

         // panel primeira linha
         JPanel a = new JPanel();
         this.add(a);
 
         // JPanel segunda linha
         JPanel b = new JPanel();
         this.add(b);
 
         // JPanel só pro botão
         JPanel but = new JPanel();
         this.add(but);
 
 
         // setando o Layout
         GridLayout grid = new GridLayout(3, 3);
         this.setLayout(grid);// atribui o layout
 
         // Criar a label temperatura
         JLabel texto = new JLabel("Temperatura: ");
         a.add(texto);
 
         // criar alguns componentes 1
         String[] temp1 = { "Celsius,Fahrenheit,Kelvin" };
         JComboBox<String> comboBox = new JComboBox<>(temp1);
         a.add(comboBox);
 
         // Criar a label ceonverter
         JLabel texto1 = new JLabel("Converter para : ");
         a.add(texto1);
 
         // criar componetntes para seleção de moeda
         String[] temp2 = { "Celsius,Fahrenheit,Kelvin" };
         JComboBox<String> comboBox1 = new JComboBox<>(temp2);
         a.add(comboBox1);
 
         // separador simples
         JLabel barra = new JLabel("  //  ");
 
         // Cria um botão JButton
         JButton button = new JButton("  Converter");
 
         // texto para digitar as temperaturasValor
         JTextField tempTexto1 = new JTextField(" Valor ", 10);
         JTextField tempTexto2 = new JTextField(" Valor ", 10);
 

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
