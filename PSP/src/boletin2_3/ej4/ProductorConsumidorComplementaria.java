package boletin2_3.ej4;

import java.util.concurrent.Semaphore;

public class ProductorConsumidorComplementaria {
	static int n=0;
	private final int MAX=20;
	Semaphore sp;
	Semaphore sc;
	Semaphore sem;
	
	public ProductorConsumidorComplementaria() {

		sc=new Semaphore(0);
		sp=new Semaphore(1);
		sem=new Semaphore(1);
	}
	
	public void productor() throws InterruptedException {
		if(n==MAX) {
			sp.acquire();
		}

		printBuffer('p');

		if(n==1) {
			sc.release();
		}
	}
	
	public void consumidor() throws InterruptedException {
		if(n<=1) {
			sc.acquire();
		}
		
		printBuffer('c');
		
		if(n==19) {
			sp.release();
		}
	}
	
	public void printBuffer(char c) throws InterruptedException {
		sem.acquire();
		if(c=='c') {
			n--;
		}else
			n++;
		
		System.out.println(c+"- "+n);
		
		sem.release();
	}
}
