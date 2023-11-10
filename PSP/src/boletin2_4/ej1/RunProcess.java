package boletin2_4.ej1;

import java.util.concurrent.Phaser;

public class RunProcess implements Runnable {
	private Phaser phaser;
	private int id;
	
	public RunProcess(int id,Phaser phaser) {
		this.phaser=phaser;
		this.id=id;
	}
	@Override
	public void run() {
		
			System.out.println(id+"- esperando ..");
			phaser.arriveAndAwaitAdvance();

			System.out.println("Ejecucion -"+id);
			
		
	}

}
