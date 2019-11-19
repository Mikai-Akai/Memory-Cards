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
	
	private Vector<String> number;
	
	/**Numero de filas*/
	private int FILAS;
	
	/**Numero de columnas*/
	private int COLUMNAS;
	
	/**Las tarjetas de juego*/
	private Tarjeta[] Tarjetas;
	
	/** The contador. */
	private int contador = 0;
	
	private int tipo1, tipo2, identi1, identi2,cambio;
	
	/** The posiciones. */
	private int fichas;
	
	private Random azar;
	
	private int ramdon;
	
	
	
	/**
	 * Se inicializan los botones y algunas variables
	 */
	
	void iniciarJuego() {
		fichas=FILAS*COLUMNAS;
		Tarjetas= new Tarjeta[FILAS*COLUMNAS];
		azar = new Random();
		prepararRandom();
		
	}
	// LLena el vector "number" con parejas del 1 a 15
	void prepararRandom() {
		for(int i=0;i<(FILAS*COLUMNAS/2);i++){
			number.addElement (String.valueOf(i+1));
			number.addElement (String.valueOf(i+1));
		}	
	}
	 
	// Retorna un numero del 1 al 15 contenidos en "number" y elimina este elemento del vetor.
		public int ramdonNumero(){
			int retorno;
			ramdon = azar.nextInt(fichas);
			retorno = Integer.parseInt(number.elementAt(ramdon));
			number.removeElementAt(ramdon);
			fichas-=1;
			return retorno;
		}
		
		// Crea los botones, les asigna el numero random y un identificador y los manda a la interfaz
		public Tarjeta[] crearTarjetas(){
			for(int i=0;i<FILAS*COLUMNAS;i++){
				Tarjetas[i] = new Tarjeta();
				Tarjetas[i].setNumero(ramdonNumero());
				Tarjetas[i].setIdentificador(i);
			}	
			return Tarjetas;
			
		}
		
		// Dependiendo del tema y el numero random asigna la imagen correspondiente al boton
		public void asignarImagenes(Tarjeta[] arreglo, String tema){
			for(int i=0;i<FILAS*COLUMNAS;i++){
				arreglo[i].setTema(tema);
			}	
		}
		
		// Muestra la ficha, juzga si las fichas son iguales mas no la misma y
		// la oculta si no son iguales, si los son las bloquea
		public void cambiar(Tarjeta boton, Tarjeta[] arreglo){
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
					arreglo[identi1].setEnabled(false);
					contador+=1;
				}else{
					// si es el mismo boton o diferentes fichas las tapa
					boton.mostrarOcultarImg(0);
					arreglo[identi1].mostrarOcultarImg(0);
				}
			}
		}
		
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
		
		// Mira si todas las fichas estan destapadas
		public boolean ganador(){
			boolean gano=false;
			if(contador == (FILAS*COLUMNAS/2)){ gano = true; }
			return gano;
		}
		
		// Efecto para desbloquear los botones una vez terminado el juego.
		public void desbloquearBotones(Tarjeta[] boton){
			// Se utiliza un Hilo para el efecto
			Thread hilo = new Thread(){
	            public synchronized void run(){
	                try {
	                	sleep(900);
	                	for(int i=(FILAS*COLUMNAS)-1;i>-1;i--){
	                		boton[i].setEnabled(true);
	                		sleep(30);
	                	}
	                } catch (InterruptedException ex) {
	                    ex.printStackTrace();
	                }
	            }
			};hilo.start();
		}
		
		// Si continua jugando, se resetea las botones, se prepara otro ramdon y setean variables
		public void seguirJugando(Tarjeta[] botones){		
			prepararRandom();
			fichas = FILAS*COLUMNAS;
			contador = 0;
			cambio = 0;
			for(int i=0;i<FILAS*COLUMNAS;i++){
				//botones[i].setEnabled(true);
				botones[i].setNumero(ramdonNumero());
			}			
		}
		
	}
