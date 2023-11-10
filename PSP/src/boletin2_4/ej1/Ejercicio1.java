package boletin2_4.ej1;

import java.util.concurrent.Phaser;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		Phaser phaser=new Phaser(3);
		
		RunProcess rp1 = new RunProcess(1,phaser);
		RunProcess rp2 = new RunProcess(2,phaser);
		RunProcess rp3 = new RunProcess(3,phaser);
		
		Thread t1 = new Thread(rp1);
		Thread t2 = new Thread(rp2);
		Thread t3 = new Thread(rp3);
		

		t1.start();
		t2.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t3.start();
	}

}
