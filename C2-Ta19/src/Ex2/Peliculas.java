package Ex2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Peliculas extends JFrame {
	public static void main(String[] args) {
    	new Peliculas();
    }
	
	private JComboBox<String> peliculasComboBox;
    private JTextField peliculaTextField;
    private JButton agregarButton;
    
    public Peliculas() {
        setTitle("Lista de Películas");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        peliculasComboBox = new JComboBox<>();
        peliculaTextField = new JTextField(20);
        agregarButton = new JButton("Añadir");

        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nuevaPelicula = peliculaTextField.getText();
                if (!nuevaPelicula.isEmpty()) {
                    peliculasComboBox.addItem(nuevaPelicula);
                    peliculaTextField.setText("");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Pelicula: "));
        panel.add(peliculaTextField);
        panel.add(agregarButton);
        panel.add(new JLabel("Lista: "));
        panel.add(peliculasComboBox);
        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
