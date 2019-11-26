/*
 * Programación Interactiva
 * Equipo de trabajo:
 * -Andres Pineda Cortez 1843660-3743
 * -Mateo Obando
 * Taller # 1 -Juego Memory Cards
 */
import java.awt.Container;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
// TODO: Auto-generated Javadoc

/**
 * The Class GUIMemoryCards.
 */
@SuppressWarnings("serial")
public class GUIMemoryCards extends JFrame {
	
	/** The tarjeta. 
	 * la tarjeta que se selecciona al momento de procesar alguna funcion se guarda aqui
	 * */
	private JButton tarjeta;
	
	/** The imagen. 
	 * imagen inicial de todas las tarjetas cubiertas
	 * */
	private ImageIcon imagen;
	
	/** The nivel elegido. 
	 * variable que almacena el nivel elegido para jugar
	 * 
	 * the tema elegido.
	 * 
	 * variable que almacena el tema elegido para jugar
	 * */
	private String temaElegido,nivelElegido;
	
	/** The columnas. 
	 * cantidad de columnas del tablero
	 * 
	 * The filas.
	 * cantidad de filas en el tablero
	 * */
	private int filas = 0, columnas = 0;
	
	/** The temas.
	 * arreglo de strings que almacena las opciones de seleccion de tema
	 * 
	 *  The niveles.
	 *  arreglo de strings que almacena las opciones de seleccion de nivel
	 *  
	 *  */
	private String[] niveles = {"nivel 1", "nivel 2"},temas = {"Yugi","Magic"};
	
	/** The juego. 
	 * activacion de la clase control*/
	Control juego;
	
	/** The escucha. 
	 * activacion de un escucha*/
	private Escucha escucha;
	
	/**
	 * Instantiates a new GUI memory cards.
	 */
	public GUIMemoryCards() {
		escucha = new Escucha();
		juego = new Control();
		GUITema();
		this.setTitle("Reta a tu memoria");
		this.setSize(200*filas, 270*columnas);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}	
	
	/**
	 * GUI tema.
	 * aqui se lleva a cabo la solicitud de datos al usuario y se procesa el juego
	 */
	private void GUITema() {
		/* se genera una nueva ventana para solicitar el tema de juego, en caso de que el usuario salga el programa se cierra*/
		temaElegido = (String)JOptionPane.showInputDialog(null,"Bienvenido, selecciona el tema que deseas jugar","Tema",JOptionPane.QUESTION_MESSAGE,null,temas,temas[0]);
		if(temaElegido == "Yugi") {
			imagen = new ImageIcon("src/Imagenes/YugiCaratula.png");
		}else if(temaElegido == "Magic") {
			imagen = new ImageIcon("src/Imagenes/Caratula-tarjetas.jpeg");
		}else {
			System.exit(1);
		}
		/* se genera una nueva ventana para solicitar el nivel de juego, en caso de que el usuario salga el programa se cierra*/
		nivelElegido = (String)JOptionPane.showInputDialog(null, "has elegido jugar con cartas de "+temaElegido, "Nivel", JOptionPane.UNDEFINED_CONDITION, imagen, niveles, niveles[0]);
		
		if(nivelElegido == "nivel 1") {
			filas = 3;
			columnas = 4;
			juego.setMatriz(3, 4);
			}else if(nivelElegido == "nivel 2") {
				filas = 4;
				columnas = 5;
				juego.setMatriz(4, 5);
				
			}else {
				System.exit(1);
			}
		
		Container contenedor = this.getContentPane();
		contenedor.setLayout(new GridLayout(filas,columnas));
		juego.iniciarJuego();
		juego.crearTarjetas();
		juego.asignarImagenes(temaElegido);
		for(int i = 0;i<(filas*columnas);i++) {
			tarjeta = juego.getTarjetas(i);
			tarjeta.addActionListener(escucha);
			tarjeta.setIcon(imagen);
			tarjeta.setCursor(new Cursor(Cursor.HAND_CURSOR));
			contenedor.add(juego.getTarjetas(i));
		}
	}
	
	/**
	 * The Class Escucha.
	 */
	private class Escucha implements ActionListener {

		/**
		 * Action performed.
		 *
		 * @param event the event
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			juego.cambiar((Tarjeta)event.getSource());
			if(juego.ganador()) {
				juego.desbloquearBotones();
				int respuesta;
				respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas jugar de nuevo?", "Victoria", JOptionPane.YES_NO_OPTION);
				if(respuesta != JOptionPane.YES_OPTION) {
					System.exit(1);
				}
				juego.seguirJugando();
			}
			
		}
	}
}