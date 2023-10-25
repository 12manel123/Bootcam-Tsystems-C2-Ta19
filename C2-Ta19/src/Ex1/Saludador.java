package Ex1;

import javax.swing.*;

import ejemplo.AplicacionGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Saludador extends JFrame {
    public static void main(String[] args) {
    	new Saludador();
    }
    
	private JTextField textField;
    private JButton saludarButton;
    
    public Saludador() {
        setTitle("Saludador Personalizable");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textField = new JTextField(20);
        saludarButton = new JButton("Saludar");
        saludarButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            String nombre = textField.getText();
	            if (!nombre.isEmpty()) {
	                JOptionPane.showMessageDialog(Saludador.this, "¡Hola " + nombre + "!");
	            }
	        }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Nombre: "));
        panel.add(textField);
        panel.add(saludarButton);
        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    } 
}
