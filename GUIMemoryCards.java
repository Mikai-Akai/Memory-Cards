import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
@SuppressWarnings("serial")
public class GUIMemoryCards extends JFrame {
	
	private JButton tarjeta;
	private ImageIcon imagen;
	private String temaElegido,nivelElegido;
	private int filas = 0, columnas = 0;
	private String[] niveles = {"nivel 1", "nivel 2"},temas = {"Yugi","Magic"};
	Control juego;
	private Escucha escucha;
	
	public GUIMemoryCards() {
		escucha = new Escucha();
		juego = new Control();
		GUITema();
		this.setTitle("Reta a tu memoria");
		this.pack();
		this.setSize(210*filas, 320*columnas);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}	
	
	private void GUITema() {
		temaElegido = (String)JOptionPane.showInputDialog(null,"bienvenido, selecciona el tema que deseas jugar","Tema",JOptionPane.QUESTION_MESSAGE,null,temas,temas[0]);
		nivelElegido = (String)JOptionPane.showInputDialog(null, "has elegido jugar "+temaElegido, "Nivel", JOptionPane.UNDEFINED_CONDITION, null, niveles, niveles[0]);
		if(nivelElegido == "nivel 1") {
			filas = 3;
			columnas = 4;
			juego.setMatriz(3, 4);
			}else if(nivelElegido == "nivel 2") {
				filas = 4;
				columnas = 5;
				juego.setMatriz(4, 5);
			}
		Container contenedor = this.getContentPane();
		contenedor.setLayout(new GridLayout(filas,columnas));
		juego.iniciarJuego();
		juego.crearTarjetas();
	}
	public class Escucha implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			
		}}
}