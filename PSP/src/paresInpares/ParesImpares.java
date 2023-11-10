package paresInpares;

import java.util.concurrent.Semaphore;

public class ParesImpares {

	public static void main(String[] args) {
		
		int total=100;
		GeneradorParImpar generadorParImpar = new GeneradorParImpar();
		
		
		ejecutImpares ej1 = new ejecutImpares(generadorParImpar, total);
		ejecutPares ej2 = new ejecutPares(generadorParImpar, total);
		
		Thread t1=new Thread(ej1);
		
		Thread t2=new Thread(ej2);
		
		t1.setName("Hilo 1 ");
		t2.setName("Hilo 2 ");

		t1.start();
		t2.start();
	}
}
