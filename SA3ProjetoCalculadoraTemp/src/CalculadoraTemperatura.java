import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraTemperatura extends JPanel {
    private JTextField text;
    private JLabel resultadoLabel;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;

    private JPanel calculadoraPanel;
    private JPanel resultadoPanel;

    public CalculadoraTemperatura() {
        // Cria um painel para a calculadora
        calculadoraPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento entre os componentes

        // Adicionar um JLabel para o título com fonte Arial
        JLabel titleLabel = new JLabel("Conversor de Temperaturas");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Configura a fonte
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3; // Estende por 3 colunas
        calculadoraPanel.add(titleLabel, gbc);

        text = new JTextField(10);
        resultadoLabel = new JLabel("Resultado: ");
        comboBox1 = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});
        comboBox2 = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});

        JButton converterButton = new JButton("Converter");
        converterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                converterTemperatura();
                // Alternar para o painel de resultado após a conversão
                swapPanels(calculadoraPanel, resultadoPanel);
            }
        });

        // Configuração dos componentes usando GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        calculadoraPanel.add(new JLabel("Valor:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        calculadoraPanel.add(text, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        calculadoraPanel.add(comboBox1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        calculadoraPanel.add(comboBox2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        calculadoraPanel.add(converterButton, gbc);

        // Cria um painel para exibir o resultado
        resultadoPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();

        // Configuração do painel de resultado
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento
        resultadoPanel.add(resultadoLabel, gbc);

        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Alternar para o painel da calculadora ao clicar em "Voltar"
                swapPanels(resultadoPanel, calculadoraPanel);
            }
        });
        gbc.gridy = 1;
        resultadoPanel.add(voltarButton, gbc);

        // Adicione o painel da calculadora ao this inicialmente
        this.add(calculadoraPanel);
    }

    // Método para converter a temperatura
    private void converterTemperatura() {
        try {
            double valorInserido = Double.parseDouble(text.getText());
            double resultado = 0.0;
            String escalaSelecionada1 = (String) comboBox1.getSelectedItem();
            String escalaSelecionada2 = (String) comboBox2.getSelectedItem();

            if (escalaSelecionada1.equals(escalaSelecionada2)) {
                resultadoLabel.setText("Resultado: " + valorInserido);
                return;
            }

            // Converte a temperatura da escala de origem para a escala de destino
            if (escalaSelecionada1.equals("Celsius")) {
                resultado = converterCelsius(valorInserido, escalaSelecionada2);
            } else if (escalaSelecionada1.equals("Fahrenheit")) {
                resultado = converterFahrenheit(valorInserido, escalaSelecionada2);
            } else if (escalaSelecionada1.equals("Kelvin")) {
                resultado = converterKelvin(valorInserido, escalaSelecionada2);
            }

            resultadoLabel.setText("Resultado: " + resultado);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(resultadoLabel, "Insira um valor válido.");
        }
    }

    // Funções de conversão de temperatura
    private double converterCelsius(double valor, String escalaDestino) {
        if (escalaDestino.equals("Fahrenheit")) {
            return (valor * 9 / 5) + 32;
        } else if (escalaDestino.equals("Kelvin")) {
            return valor + 273.15;
        }
        return valor;
    }

    private double converterFahrenheit(double valor, String escalaDestino) {
        if (escalaDestino.equals("Celsius")) {
            return (valor - 32) * 5 / 9;
        } else if (escalaDestino.equals("Kelvin")) {
            return (valor - 32) * 5 / 9 + 273.15;
        }
        return valor;
    }

    private double converterKelvin(double valor, String escalaDestino) {
        if (escalaDestino.equals("Celsius")) {
            return valor - 273.15;
        } else if (escalaDestino.equals("Fahrenheit")) {
            return (valor - 273.15) * 9 / 5 + 32;
        }
        return valor;
    }

    // Método para alternar entre dois painéis
    private void swapPanels(JPanel fromPanel, JPanel toPanel) {
        removeAll();
        add(toPanel);
        revalidate();
        repaint();
    }

    // Método principal
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraTemperatura();
            }
        });
    }
}
