import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
public class GUIMemoryCards extends JFrame {
	Control activar;
	private static int columnas = 1;
	private static int filas = 2;
	private String tema;
	private JButton tema1, tema2;
	private JFrame frame = new JFrame();
	private ImageIcon imagen;
	private Escucha escucha;
	
	public GUIMemoryCards() {
		initGUI();
		this.setTitle("Memory Cards");
		this.setSize(300, 70);
		this.setUndecorated(false);
		this.setBackground(Color.BLACK);
		//this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	 	setVisible(true);
	}
	private void initGUI() {
		
		Container contenedor = this.getContentPane();
		contenedor.setLayout(new GridLayout(columnas, filas));
		frame.getContentPane().setLayout(null);
		tema1 = new JButton("Tema 1");
		tema1.addActionListener(escucha);
		tema1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tema1.setVisible(true);
		
		contenedor.add(tema1);
		tema1.addActionListener(escucha);
		
		tema2 = new JButton("Tema 2");
		tema2.addActionListener(escucha);
		tema2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tema2.setVisible(true);
		
		contenedor.add(tema2);
		tema2.addActionListener(escucha);
		
	}
	private class Escucha extends MouseAdapter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == tema1) {
				
			}else if(e.getSource() == tema2) {
				
			}
		}
		
	}	
}
