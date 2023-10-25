package Ex3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Encuesta extends JFrame {
	public static void main(String[] args) {
		new Encuesta();
	}
	
	private JRadioButton windowsRadioButton, linuxRadioButton, macRadioButton;
	private JCheckBox programacionCheckBox, disenoGraficoCheckBox, administracionCheckBox;
	private JSlider horasDedicadasSlider;
	private JButton mostrarButton;
	
	public Encuesta() {
		setTitle("Mini Encuesta");
		setSize(400, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		windowsRadioButton = new JRadioButton("Windows");
		linuxRadioButton = new JRadioButton("Linux");
		macRadioButton = new JRadioButton("Mac");
		
		programacionCheckBox = new JCheckBox("Programacion");
		disenoGraficoCheckBox = new JCheckBox("Diseño Grafico");
		administracionCheckBox = new JCheckBox("Administracion");
		
		ButtonGroup sistemaOperativoGroup = new ButtonGroup();
		sistemaOperativoGroup.add(windowsRadioButton);
		sistemaOperativoGroup.add(linuxRadioButton);
		sistemaOperativoGroup.add(macRadioButton);
		
		horasDedicadasSlider = new JSlider(0, 10);
		horasDedicadasSlider.setMajorTickSpacing(1);
		horasDedicadasSlider.setPaintTicks(true);
		
		mostrarButton = new JButton("Mostrar Resultados");
		mostrarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String sistemaOperativo = "";
        		if (windowsRadioButton.isSelected()) {sistemaOperativo = "Windows";} 
        		else if (linuxRadioButton.isSelected()) { sistemaOperativo = "Linux";} 
        		else if (macRadioButton.isSelected()) {sistemaOperativo = "Mac";}
        		
        		StringBuilder especialidades = new StringBuilder();
        		if (programacionCheckBox.isSelected()) {especialidades.append("Programacion, ");}
        		if (disenoGraficoCheckBox.isSelected()) {especialidades.append("Diseno Grafico, ");}
        		if (administracionCheckBox.isSelected()) {especialidades.append("Administración, ");}
        		
        		int horasDedicadas = horasDedicadasSlider.getValue();
        		
        		String mensaje = "SO: " + sistemaOperativo + "\n";
        		mensaje += "Especialidades: " + (especialidades.length() > 0 ? especialidades.substring(0, especialidades.length() - 2) : "Ninguna") + "\n";
        		mensaje += "Horas: " + horasDedicadas;
        		
        		JOptionPane.showMessageDialog(null, mensaje, "Resultados", JOptionPane.INFORMATION_MESSAGE);
        	}
		});
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(7, 1));
		panel.add(new JLabel("Elije un SO:"));
		panel.add(windowsRadioButton);
		panel.add(linuxRadioButton);
		panel.add(macRadioButton);
		panel.add(new JLabel("Elije especialidad:"));
		panel.add(programacionCheckBox);
		panel.add(disenoGraficoCheckBox);
		panel.add(administracionCheckBox);
		panel.add(new JLabel("Horas dedicadas en el PC:"));
		panel.add(horasDedicadasSlider);
		panel.add(mostrarButton);
		add(panel);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}