package practica2;

import javax.naming.SizeLimitExceededException;

/**
 * Hilo filósofo. Su método run() realiza un bucle infinito que consite en
 * invocar a los métodos pensar y comer ... -> pensar -> comer...
 *
 * @author IMCG
 */
public class Filosofo implements IFilosofo {

	//////////////////////////// ATRIBUTOS /////////////////////////////////////

	// TODO:
	private Estado estado;
	private String nombre;
	private Long numBocados;
	private int pos;
	private Long millisPensando;
	private Long millisEntreBoc;

	private MesaRedonda mesa;

	//////////////////////////// SETTERS Y GETTERS /////////////////////////////
	public Long getNumeroBocados() {
		return numBocados;
	}

	public String getNombre() {
		return nombre;
	}

	public IFilosofo.Estado getEstado() {
		return estado;
	}

	public boolean isHablador() {
		return false;
	}

	public void setHablador(boolean hablador) {
	}

	public Long getMillisMaxPensando() {
		return millisPensando;
	}

	public void setMillisMaxPensando(long millisMaxPensando) {
		millisPensando = millisMaxPensando;
	}

	public Long getMillisMaxEntreBocadoAndBocado() {
		// TODO:
		return millisEntreBoc;
	}

	public void setMillisMaxEntreBocadoAndBocado(long millisMaxEntreBocadoAndBocado) {
		this.millisEntreBoc = millisMaxEntreBocadoAndBocado;
	}

	//////////////////////////// CONSTRUCCIÓN //////////////////////////////////

	/**
	 * constructor de tres parámetros, cada uno de los cuales se guardará en una
	 * variable local para usarla cuando sea neceario
	 * 
	 * @param pNombreFilosofo el nombre que le queremos dar al filósofo (puede ser
	 *                        cualquiera)
	 * @param params          [0] miIndice: índice que identifica al filósofo (un
	 *                        entero del 0 al 4)
	 * @param params          [1] semaforoPalillo: vector de semáforos (uno para
	 *                        cada palillo).
	 * @param params          [2] palillosFilosofo: matriz que para cada valor de su
	 *                        primer índice, la fila, almacena los palillos que
	 *                        necesita el filósofo de ese índice para comer. Por
	 *                        ejemplo: el filósofo de índice 0 necesita los
	 *                        palillos de índices {0,4}, el de índice 1 los de
	 *                        índices {1,0}, etc... Puedes prescindir de este
	 *                        vector si se te ocurre como calcular en tiempo real
	 *                        los índices de los palillos que necesita cada
	 *                        filósofo para comer
	 */
	public Filosofo(String pNombreFilosofo, Object... params) {
		// TODO:
		this.nombre=pNombreFilosofo;

		this.pos=(int) params[0];
		this.numBocados=(Long) params[1];
		this.millisPensando=(Long) params[2];
		this.millisEntreBoc=(Long) params[3];
		this.mesa=(MesaRedonda) params[4];
	}

	//////////////////////////// COMPORTAMIENTO ////////////////////////////////
	/**
	 * bucle infinito: llamada al método pensar(), llamada al método comer()
	 */
	@Override
	public void run() {

		while (true) {
			pensar();
			comer();
		}
	}

	/**
	 * método pensar(): mostrará un mensaje en la Salida de que el 'Filósofo ' N
	 * ' está pensado'. Para simular esta actividad, dormirá el hilo un tiempo
	 * aleatorio
	 * 
	 */
	public void pensar() {
		System.out.println("El filosodo " + nombre + " est� pensando");
		try {
			Thread.sleep(this.millisPensando);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * método comer(): mostrará un mensaje en la Salida de que el 'Filósofo ' N '
	 * está hambriento', mientras trata de conseguir los dos palillos que necesita
	 * para comer. Una vez conseguidos, mostrará un mensaje de que el 'Filósofo '
	 * N ' está comiendo'. Para simular esta actividad, dormirá el hilo un tiempo
	 * aleatorio. Cuando termine, mostrará un mensaje de que el 'Filósofo ' N ' ha
	 * terminado de comer', indicando los palillos que se quedan libres.
	 */
	public void comer() {
		System.out.println("El filosodo " + nombre + " est� hambriento");
		mesa.cogerPalillo(pos);

		System.out.println("El filosodo " + nombre + " est� comiendo");

		try {
			Thread.sleep(this.millisEntreBoc * this.numBocados);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("El filosodo " + nombre + " ha terminado de comer");
		mesa.devolverPalillo(pos);
	}

	public void hablar(String pMensaje) {
		// TODO:
	}

	@Override
	public void comienza() {
		// TODO Auto-generated method stub

	}

	@Override
	public void retirate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void interrumpete() {
		// TODO Auto-generated method stub

	}
}
