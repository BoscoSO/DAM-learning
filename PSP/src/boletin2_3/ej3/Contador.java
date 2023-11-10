package boletin2_3.ej3;

public class Contador extends Thread {

	static int cont=0;
	private String objeto;
	
	
	public Contador(String objeto) {
		super();
		this.objeto = objeto;
	}


	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println((cont++)+""+objeto);
		}
		
	}

}
