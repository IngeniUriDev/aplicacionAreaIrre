/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadoraareaterreno;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraAreaTerreno {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        
        /*Creamos una nueva ventana crear un panel para colocar los componentes con GridLayout 
        hacemos etiquetas y campos de texto para los lados del terreno y
        creamos un botón para realizar el cálculo */
        
        JFrame frame = new JFrame(" Calculadora de Área ");

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        
        JLabel labelAB = new JLabel("    Lado AB:");
        JTextField inputAB = new JTextField(10);

        JLabel labelBC = new JLabel("    Lado BC:");
        JTextField inputBC = new JTextField(10);

        JLabel labelCD = new JLabel("   Lado CD:");
        JTextField inputCD = new JTextField(10);

        JLabel labelDA = new JLabel("    Lado DA:");
        JTextField inputDA = new JTextField(10);

        JButton calcularButton = new JButton("Calcular Área");

        /*Crear un botón para reiniciar valores
        y una etiqueta para mostrar el resultado*/
        
        JButton reiniciarButton = new JButton("Reiniciar Valores");
        JLabel resultadoLabel = new JLabel();

        //etiquetamos dmensaje superior
        JLabel mensajeSuperior = new JLabel("Hola, para obtener el resultado del área, el lado AB y CD deben ser del mismo tamaño.");

        /*agregamoos etiquetas del panel*/
        panel.add(labelAB);
        panel.add(inputAB);
        panel.add(labelBC);
        panel.add(inputBC);
        panel.add(labelCD);
        panel.add(inputCD);
        panel.add(labelDA);
        panel.add(inputDA);
        panel.add(calcularButton);
        panel.add(reiniciarButton);
        panel.add(resultadoLabel);

        // Configuramos el boton de "Calcular Area"
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*obtenemos los datos para el calculo
                por parte del usuario*/
                double ab = Double.parseDouble(inputAB.getText());
                double bc = Double.parseDouble(inputBC.getText());
                double cd = Double.parseDouble(inputCD.getText());
                double da = Double.parseDouble(inputDA.getText());

                /*configuramos la operacion */
                if (ab != cd) {
                    resultadoLabel.setText("Solo se calcula el area si  lado AB y CD son iguales.");
                } else {
                    double altura = Math.sqrt(ab * ab - ((bc - da) / 2) * ((bc - da) / 2));
                    double area = ((bc + da) / 2) * altura;
                    resultadoLabel.setText("El área es: " + area);
                }
            }
        });

        /* configuramos el boton para reiniciar
        los datos que le pedimos al usuario*/
        
        reiniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Reestablecemos valores*/
                inputAB.setText("");
                inputBC.setText("");
                inputCD.setText("");
                inputDA.setText("");
                resultadoLabel.setText("");
            }
        });

        /*configuracion de ventana*/
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mensajeSuperior, BorderLayout.NORTH);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

