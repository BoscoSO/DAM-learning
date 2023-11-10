package boletin2_4.ej2;

public class ejercicio2 {

	public static void main(String[] args) {
	       Buffer buffer = new Buffer(0);
	        
	        //crea los hilos productor y consumidor
	        Productor productor = new Productor(buffer,15);
	        Consumidor consumidor = new Consumidor(buffer,13);

	        //inicia los hilos
	        productor.start();
	        consumidor.start();
	}

}
