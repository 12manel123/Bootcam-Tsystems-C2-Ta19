package ejemplo;
import javax.swing.*;

public class AplicacionGrafica extends JFrame {
    

    public static void main(String[] args) {
    	AplicacionGrafica ventana = new AplicacionGrafica();
    }
    private JPanel contentPane;//crear atributo panel
	private JTextField textField;//crear relleno de texto
    private JButton Button;


    public AplicacionGrafica() {
        setTitle("Titulo de ventana");//Marcar el titulo
        setSize(500, 700);//Hay 2 paneras de marcar la longitud
        setBounds(200,200,400,200);//Esta es la otra manera de marcarla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Cuando se cierre la ventana, se apaga la aplicacion
        setLocationRelativeTo(null);//Posicion al crear la ventana, este caso es al medio
        setVisible(true);//Hace visible la ventana
        contentPane = new JPanel();//Crear nuevo panel
        contentPane.setLayout(null);//Indicar diseño default = null
        setContentPane(contentPane);//Asignar el pannel a la ventana principal
        JLabel etiqueta = new JLabel("Hola");//Nombre en el contenido
        etiqueta.setSize(100, 200);//establezer posicion del texto
        etiqueta.setBounds(60,20,100,20);//otra manera de establecer posicion
        contentPane.add(etiqueta);//añadir al panel, si no, no se vera
        
        textField = new JTextField();
        textField.setBounds(80,20,100,20);//establezer posicion 
        textField.setVisible(true);//Hace visible la ventana
        contentPane.add(textField);
        
        JButton Button=new JButton("Pulsame");
        Button.setBounds(120,20,100,20);//establezer posicion 
        Button.setVisible(true);//Hace visible la ventana
        contentPane.add(Button);
        
       
    }
}
