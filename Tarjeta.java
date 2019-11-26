/*
 * Programación Interactiva
 * Equipo de trabajo:
 * -Andres Pineda Cortez 1843660-3743
 * -Mateo Obando Gutierrez 1844983-3743
 * Taller # 1 -Juego Memory Cards
 */
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

// TODO: Auto-generated Javadoc
/**
 * The Class Tarjetas.
 */
@SuppressWarnings("serial")
public class Tarjeta extends JButton{
	
	/** The Caratula. 
	 * guarda la imagen trasera de la carta*/
	
	private ImageIcon Caratula;
	
	/** The tema. 
	 * guarda el string del tema de las cartas a usar, esta variable se llamará posteriormente en la direccion de las imagenes
	 * */
	private String tema;
	
	/** The cara. 
	 * la imagen de la carta que se comparará con las otras
	 * */
	private ImageIcon cara;
	
	/**  The identificador. 
	 * identificador interno del sistema para procesar las cartas
	 * */
	private int identificador;
	
	/** The tipo. 
	 * tipo es el numero de la imagen de cada carta
	 * */
	private int tipo;
	
	
	/** The revelado. 
	 * valor al cual se le pregunta la posicion actual de la carta
	 * */
	private boolean revelado;
	
	/**
	 * Instantiates a new tarjeta.
	 * la creacion de una tarjeta inicializa su caratula
	 */
	Tarjeta(){
		Caratula = new ImageIcon("src/imagenes/Caratula-tarjetas.jpg");
	}
	
	/**
	 * Gets the identificador.
	 *
	 * @return the identificador
	 */
	public int getIdentificador() {
		return identificador;
	}
	
	/**
	 * Sets the identificador.
	 *
	 * @param numero the new identificador
	 */
	public void setIdentificador(int numero) {
		identificador = numero;
	}
	
	
	
	/**
	 * Gets the caratula.
	 *
	 * @return the caratula
	 */
	public ImageIcon getCaratula() {
		return Caratula;
	}
	/**
	 * Gets the cara.
	 *
	 * @return the cara
	 */
	public ImageIcon getCara() {
		return cara;
	}
	
	/**
	 * Sets the cara.
	 *
	 * @param cara the new cara
	 */
	public void setCara(ImageIcon cara) {
		this.cara = cara;
	}
	
	/**
	 * Sets the numero.
	 *
	 * @param num the new numero
	 */
	public void setNumero(int num) {
		tipo=num;
		setBackground(new Color(num*12,200,70));
	}
	
	/**
	 * Gets the tipo.
	 *
	 * @return the tipo
	 */
	public int getTipo(){ // Retorna el tipo
		return tipo;
	}
	
	/**
	 * Sets the tema.
	 *
	 * @param tem the new tema
	 */
	// Con el tema elegido, asigna de esta gama de temas una imagen segun el tipo.
		public void setTema(String tem){
			tema=tem;
			ImageIcon img = new ImageIcon(getClass().getResource("/Imagenes/"+tema+tipo+".png"));
			setIcon(img);
		}
	
	/**
	 * Checks if is revelado.
	 *
	 * @return true, if is revelado
	 */
	public boolean isRevelado() {
		return revelado;
	}
	
	/**
	 * Sets the revelado.
	 */
	public void setRevelado() {
		this.revelado = !revelado;
	}
	
	/**
	 * Mostrar ocultar img.
	 *
	 * @param tipoOperacion the tipo operacion
	 */
	// Se encarga de mostrar la imagen del boton (1) o ocultarla (0)
		public void mostrarOcultarImg(int tipoOperacion){
			// Con uso de un hilo, se crea un efecto para mostrar o cultar la imagen
			Thread hilo = new Thread(){
	            public synchronized void run(){
	                try {
	                	int aux = 0;
	                	switch (tipoOperacion) {
	                	// Si las imagenes no son iguales, espera un momento para que el usuario las veas
	                	// luego las oculta
	                    case 0: sleep(500); aux = 92; break;
	                    case 1: aux = 0; break;
	                    default: break;             
	                	}
	                	for(int i=1;i<92;i+=5){
	                		ImageIcon img = new ImageIcon(getClass().getResource("/Imagenes/"+tema+tipo+".png"));
	                		img = new ImageIcon((img.getImage()).getScaledInstance(Math.abs(aux-i), 240,Image.SCALE_SMOOTH));
	                		setIcon(img);
	                		sleep(5);
	                	}
	                	if(tipoOperacion==0){
	                		setIcon(null);}
	                	}catch (InterruptedException ex){
	                		ex.printStackTrace();
	                	}
	            }	
			};hilo.start();
		}
}
