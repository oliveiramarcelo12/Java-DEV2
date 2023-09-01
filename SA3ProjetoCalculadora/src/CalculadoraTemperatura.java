import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraTemperatura {
  public CalculadoraTemperatura() {
    JFrame frame = new JFrame("Conversor de Temperaturas");
    frame.setDefaultCloseOperation(2);
    frame.setLayout(new FlowLayout());
    JTextField text = new JTextField(10);
    JLabel painel1 = new JLabel("Resultado: ");
    JLabel painel2 = new JLabel();
    String escalaTemperaturas[] = { "Celsius", "Fahrenheit", "Kelvin" };
    JComboBox<String> comboBox = new JComboBox<>(escalaTemperaturas);
    GridLayout grid = new GridLayout(2, 2);
    painel2.setLayout(grid);
    String textoN[] = { "7", "8", "9", "4", "5", "6", "1", "2", "3", "0" };
    for (int i = 0; i < textoN.length; i++) {
      painel2.add(new JButton(textoN[i]));

    }
    JButton botaoConversor = new JButton("Converter");
    botaoConversor.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        double valorInserido;
        try {
          valorInserido = Double.parseDouble(text.getText());
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(frame, "Insira um valor válido.");
          return;
        }

        String itemSelecionado = (String) comboBox.getSelectedItem();
        StringBuilder resultado = new StringBuilder("Resultado: ");
        if (itemSelecionado.equals("Celsius")) {
          double fahrenheit = (* 9 / 5) + 32;
          double kelvin = valorInserido + 273.15;
          resultado.append("Celsius: ").append(valorInserido).append("°C, ");
          resultado.append("Fahrenheit: ").append(valorInserido).append("°F, ");
          resultado.append("Kelvin: ").append(valorInserido).append("°K");

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

        painel1.setText(resultado.toString());
      }
    });
    frame.add(new JLabel("Valor: "));
    frame.add(text);
    frame.add(comboBox);
    frame.add(botaoConversor);
    frame.add(painel1);
    frame.add(painel2);

    frame.pack();
    frame.setVisible(true);

  }
}