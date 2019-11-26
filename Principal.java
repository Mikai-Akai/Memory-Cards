/*
 * Programación Interactiva
 * Equipo de trabajo:
 * -Andres Pineda Cortez 1843660-3743
 * -Mateo Obando Gutierrez 1844983-3743
 * Taller # 1 -Juego Memory Cards
 */
import java.awt.EventQueue;

import javax.swing.UIManager;

// TODO: Auto-generated Javadoc
/**
 * The Class Principal.
 */
public class Principal {

	/**
	 * The main method.
	 *solicita la creacion y activacion de la interfaz grafica
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String className = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(className);
			}
		catch (Exception e) {
			
		}
			EventQueue.invokeLater(new Runnable() {
			public void run() {
				@SuppressWarnings("unused")
				GUIMemoryCards vista = new GUIMemoryCards();
				}
			});	
	}
}