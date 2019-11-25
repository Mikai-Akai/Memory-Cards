/*
 * Programación Interactiva
 * Equipo de trabajo:
 * -Andres Pineda Cortez 1843660-3743
 * -Mateo Obando Gutierrez 1844983-3743
 * Taller # 1 -Juego Memory Cards
 */
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

// TODO: Auto-generated Javadoc
/**
 * The Class Tarjetas.
 */
@SuppressWarnings("serial")
public class Tarjeta extends JButton{
	
	/** The Caratula. */
	private ImageIcon Caratula;
	
	private String tema;
	
	/** The cara. */
	private ImageIcon cara;
	
	/** The identificador*/
	private int identificador;
	
	private int tipo;
	
	
	/** The revelado. */
	private boolean revelado;
	
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
	
	public void setNumero(int num) {
		tipo=num;
		setBackground(new Color(num*12,200,70));
	}
	
	public int getTipo(){ // Retorna el tipo
		return tipo;
	}
	
	// Con el tema elegido, asigna de esta gama de temas una imagen segun el tipo.
		public void setTema(String tem){
			tema=tem;
			ImageIcon img = new ImageIcon(getClass().getResource("/Imagenes/"+tema+tipo+".png"));
			setIcon(img);
		}


	
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
	                		img = new ImageIcon((img.getImage()).getScaledInstance(Math.abs(aux-i), 91, java.awt.Image.SCALE_SMOOTH));
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
