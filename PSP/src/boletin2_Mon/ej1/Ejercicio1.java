package boletin2_Mon.ej1;

public class Ejercicio1 {

	
	
	public static void main(String[] args) {
		Thread participacion; 

		CajaPremios cp = new CajaPremios();
		
		for (int i = 0; i < 15; i++) {
			participacion= new Sorteo(cp);
			participacion.start();
		}
		
	}
}
