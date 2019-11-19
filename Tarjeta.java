/*
 * Programación Interactiva
 * Equipo de trabajo:
 * -Andres Pineda Cortez 1843660-3743
 * -Mateo Obando Gutierrez 1844983-3743
 * Taller # 1 -Juego Memory Cards
 */
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class Tarjetas.
 */
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
	 *
	 * @param revelado the new revelado
	 */
	public void setRevelado(boolean revelado) {
		this.revelado = revelado;
	}
	
	
}
