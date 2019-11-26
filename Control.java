/*
 * Programación Interactiva
 * Equipo de trabajo:
 * -Andres Pineda Cortez 1843660-3743
 * -Mateo Obando Gutierrez 1844983-3743
 * Taller # 1 -Juego Memory Cards
 */
import java.util.Random;
import java.util.Vector;

// TODO: Auto-generated Javadoc
/**
 * The Class Control.
 */
public class Control {
	
	/** The number. */
	private Vector<String> number;
	
	/** Numero de filas. 
	 * cantidad de filas que tendra el tablero
	 * */
	private int FILAS;
	
	/** Numero de columnas. 
	 * cantidad de columnas que tendra el tablero
	 * */
	private int COLUMNAS;
	
	/** Las tarjetas de juego. 
	 * arreglo que contiene las tarjetas
	 * */
	private Tarjeta[] Tarjetas;
	
	/** The contador. */
	private int contador = 0;
	
	/** The cambio. */
	private int tipo1, tipo2, identi1, identi2,cambio;
	
	/** The posiciones. */
	private int fichas;
	
	/** The azar. */
	private Random azar;
	
	/** The ramdon. */
	private int ramdon;
	
	
	
	/**
	 * Se inicializan los botones y algunas variables.
	 */
	
	void iniciarJuego() {
		fichas=FILAS*COLUMNAS;
		Tarjetas= new Tarjeta[FILAS*COLUMNAS];
		number = new Vector<String>();
		azar = new Random();
		prepararRandom();
		
	}
	
	/**
	 * Gets the tarjetas.
	 *
	 * @param a the a
	 * @return the tarjetas
	 */
	Tarjeta getTarjetas(int a) {
		return Tarjetas[a];
	}
	
	/**
	 * Sets the matriz.
	 *
	 * @param a the a
	 * @param b the b
	 */
	void setMatriz(int a, int b) {
		FILAS = a;
		COLUMNAS = b;
	}
	
	/**
	 * Preparar random.
	 * LLena el vector "number" con parejas iguales a la mitad del numero de tarjetas
	 */
	void prepararRandom() {
		for(int i=0;i<(FILAS*COLUMNAS/2);i++){
			number.addElement (String.valueOf(i+1));
			number.addElement (String.valueOf(i+1));
		}	
	}
	
	/**
	 * Ramdon numero.
	 * Retorna un numero del 1 a 6 o del 1 al 10 contenidos en "number" y elimina este elemento del vetor
	 * @return the int
	 */
	
		public int ramdonNumero(){
			int retorno;
			ramdon = azar.nextInt(fichas);
			retorno = Integer.parseInt(number.elementAt(ramdon));
			number.removeElementAt(ramdon);
			fichas-=1;
			return retorno;
		}
		
		/**
		 * Crear tarjetas.
		 * Crea los botones, les asigna el numero random y un identificador y los manda a la interfaz
		 * @return the tarjeta[]
		 */
		
		public Tarjeta[] crearTarjetas(){
			for(int i=0;i<FILAS*COLUMNAS;i++){
				Tarjetas[i] = new Tarjeta();
				Tarjetas[i].setNumero(ramdonNumero());
				Tarjetas[i].setIdentificador(i);
			}	
			return Tarjetas;
			
		}
		
		/**
		 * Asignar imagenes.
		 * Dependiendo del tema y el numero random asigna la imagen correspondiente al boton
		 * @param tema the tema
		 */
		
		public void asignarImagenes(String tema){
			for(int i=0;i<FILAS*COLUMNAS;i++){
				Tarjetas[i].setTema(tema);
			}	
		}
		
		
		/**
		 * Cambiar.
		 * Muestra la ficha, juzga si las fichas son iguales mas no la misma y
		 * la oculta si no son iguales, si los son las bloquea
		 * @param boton the boton
		 */
		
		public void cambiar(Tarjeta boton){
			cambio+=1; //cada numero par corresponde a una comparacion de 2 fichas
			boton.mostrarOcultarImg(1);
			if(cambio%2!=0){
				// Guarda los datos del primer boton pulsado 
				tipo1 = boton.getTipo();
				identi1 = boton.getIdentificador();
			}else{
				// Guarda los datos del segundo boton pulsado 
				tipo2 = boton.getTipo();
				identi2 = boton.getIdentificador();
				if(tipo1 == tipo2 && identi1 != identi2){ 
					// Si la imagen es la misma pero diferente boton los bloquea
					boton.setEnabled(false);
					Tarjetas[identi1].setEnabled(false);
					contador+=1;
				}else{
					// si es el mismo boton o diferentes fichas las tapa
					boton.mostrarOcultarImg(0);
					Tarjetas[identi1].mostrarOcultarImg(0);
				}
			}
		}
		
		/**
		 * Ocultar.
		 *
		 * @param boton the boton
		 */
		// Efecto que espera a que el usuario vea las fichas por un momento, luego las tapa.
		public void ocultar(Tarjeta[] boton){
			// Se utiliza un Hilo para el efecto
			Thread hilo = new Thread(){
	            public synchronized void run(){
	                try {
	                	sleep(1500);
	                	for(int i=0;i<FILAS*COLUMNAS;i++){
	                		boton[i].setIcon(null);
	                		sleep(30);
	                	}
	                } catch (InterruptedException ex) {
	                    ex.printStackTrace();
	                }
	            }
			};hilo.start();
		}
		
		/**
		 * Ganador.
		 * Mira si todas las fichas estan destapadas
		 * @return true, if successful
		 */
		public boolean ganador(){
			boolean gano=false;
			if(contador == (FILAS*COLUMNAS/2)){ gano = true; }
			return gano;
		}
		
		/**
		 * Desbloquear botones.
		 *
		 * @param boton the boton
		 */
		// Efecto para desbloquear los botones una vez terminado el juego.
		public void desbloquearBotones(){
			// Se utiliza un Hilo para el efecto
			Thread hilo = new Thread(){
	            public synchronized void run(){
	                try {
	                	sleep(900);
	                	for(int i=(FILAS*COLUMNAS)-1;i>-1;i--){
	                		Tarjetas[i].setEnabled(true);
	                		sleep(30);
	                	}
	                } catch (InterruptedException ex) {
	                    ex.printStackTrace();
	                }
	            }
			};hilo.start();
		}
		
		/**
		 * Seguir jugando.
		 * Si continua jugando, se resetea las botones, se prepara otro ramdon y resetean variables
		 * @param botones the botones
		 */
		
		public void seguirJugando(){		
			prepararRandom();
			fichas = FILAS*COLUMNAS;
			contador = 0;
			cambio = 0;
			for(int i=0;i<FILAS*COLUMNAS;i++){
				ocultar(Tarjetas);
				Tarjetas[i].setNumero(ramdonNumero());
			}			
		}
		
	}
