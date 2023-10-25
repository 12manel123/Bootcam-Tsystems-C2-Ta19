package Ex4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame {
	public static void main(String[] args) {
		new Calculadora();
	}
	
	private JTextField labelResultado;
	private JPanel panelNumeros, panelOperaciones;
	private JButton botonLimpiar, botonCambiarSigno, botonComa, botonIgual;
	private JButton[] botonesNumeros;
	private JButton[] botonesOperaciones;
	private StringBuilder operacionActual = new StringBuilder();

	public Calculadora() {
		setTitle("Calculadora");
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		labelResultado = new JTextField(10);
		labelResultado.setEditable(false);
		labelResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		
		panelNumeros = new JPanel(new GridLayout(4, 3));
		panelOperaciones = new JPanel(new GridLayout(5, 1));
		
		//Creando botones
		botonLimpiar = new JButton("C");
		botonCambiarSigno = new JButton("+/-");
		botonComa = new JButton(".");
		botonIgual = new JButton("=");
		botonesNumeros = new JButton[10];
		botonesOperaciones = new JButton[] {
		    new JButton("+"),
		    new JButton("-"),
		    new JButton("*"),
		    new JButton("/")
		};
        //Crear botones numericos con un for asi ahorro codigo
		for (int i = 0; i < 10; i++) {
			botonesNumeros[i] = new JButton(Integer.toString(i));
		}
		
		ActionListener numerosListener = new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        JButton boton = (JButton) e.getSource();
		        operacionActual.append(boton.getText());
		        labelResultado.setText(operacionActual.toString());
		    }
		};
		
		for (JButton boton : botonesNumeros) {
			boton.addActionListener(numerosListener);
		}
		
		botonComa.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (!labelResultado.getText().contains(".")) {
		            operacionActual.append(".");
		            labelResultado.setText(operacionActual.toString());
		        }
		    }
		});
		
		//action listeners:
		botonCambiarSigno.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (labelResultado.getText().isEmpty() || labelResultado.getText().equals("0")) {
		        	return;
		        }
		        if (operacionActual.charAt(0) == '-') {
		        	operacionActual.deleteCharAt(0);
		        } else {
		        	operacionActual.insert(0, '-');
		        }
		        labelResultado.setText(operacionActual.toString());
		    }
		});
		ActionListener operacionesListener = new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        JButton boton = (JButton) e.getSource();
		        if (!labelResultado.getText().isEmpty()) {
		            operacionActual.append(" " + boton.getText() + " ");
		            labelResultado.setText(operacionActual.toString());
		        }
		    }
		};
		
		for (JButton boton : botonesOperaciones) {
		    boton.addActionListener(operacionesListener);
		}
		
		botonIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!labelResultado.getText().isEmpty()) {
		        	calcular();
		        }
			}
		});
		
		botonLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacionActual.setLength(0);
				labelResultado.setText("");
			}
		});
		
		setLayout(new BorderLayout());
		add(labelResultado, BorderLayout.NORTH);
		add(panelNumeros, BorderLayout.CENTER);
		add(panelOperaciones, BorderLayout.EAST);
		add(botonLimpiar, BorderLayout.SOUTH);
		for (JButton boton : botonesNumeros) {panelNumeros.add(boton);}
		panelNumeros.add(botonCambiarSigno);
		panelNumeros.add(botonesNumeros[0]);
		panelNumeros.add(botonComa);
		for (JButton boton : botonesOperaciones) {panelOperaciones.add(boton);}
		panelOperaciones.add(botonIgual);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void calcular() {
		try {
			String[] partes = operacionActual.toString().split(" ");
			double resultadoParcial = Double.parseDouble(partes[0]);
			char operador = ' ';
			for (int i = 1; i < partes.length; i++) {
				if (partes[i].equals("+") || partes[i].equals("-") || partes[i].equals("*") || partes[i].equals("/")) {
					operador = partes[i].charAt(0);
				} else {
					double numero = Double.parseDouble(partes[i]);
					switch (operador) {
						case '+':
							resultadoParcial += numero;
							break;
						case '-':
							resultadoParcial -= numero;
							break;
						case '*':
							resultadoParcial *= numero;
							break;
						case '/':
							if (numero != 0) {
                            	resultadoParcial /= numero;
							} else {
								JOptionPane.showMessageDialog(null, "No se puede dividir por cero.", "Error", JOptionPane.ERROR_MESSAGE);
								return;
							}
							break;
						default:
							resultadoParcial = numero;
							break;
					}
				}
			}
       	    operacionActual.setLength(0);
       	    operacionActual.append(resultadoParcial);
       	    labelResultado.setText(operacionActual.toString());
		} catch (NumberFormatException e) {
        	JOptionPane.showMessageDialog(null, "Operación inválida.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}