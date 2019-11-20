/*
 * Programación Interactiva
 * Equipo de trabajo:
 * -Andres Pineda Cortez 1843660-3743
 * -Mateo Obando Gutierrez 1844983-3743
 * Taller # 1 -Juego Memory Cards
 */
import java.awt.EventQueue;

import javax.swing.UIManager;

/*
 * Programación Interactiva
 * Equipo de trabajo:
 * -Andres Pineda Cortez 1843660-3743
 * -Mateo Obando Gutierrez 1844983-3743
 * Taller # 1 -Juego Memory Cards
 */
public class Principal {

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
				GUIMemoryCards vista = new GUIMemoryCards();
				}
			});	
	}
}