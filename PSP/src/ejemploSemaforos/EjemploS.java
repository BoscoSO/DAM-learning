package ejemploSemaforos;

import java.util.concurrent.Semaphore;

public class EjemploS implements Runnable{
	Semaphore sem= new Semaphore(1);

	@Override
	public void run() {
		try {
			sem.acquire();
			
			System.out.println("Siendo ejecutado por: "+ Thread.currentThread());
			
			for (int i = 0; i < 5; i++) {
				System.out.println("Hilo que se está ejecutando: "+Thread.currentThread());
				Thread.sleep(1000);
			}
			
			sem.release();
		} catch (Exception e) {
			
		}
		
	}
	
	
}
