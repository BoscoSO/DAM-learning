package boletin2_4.ej2;

import java.util.concurrent.Semaphore;

public class Buffer {
	Semaphore s = new Semaphore(0);

	Semaphore c = new Semaphore(0);
	private int n;

	public Buffer(int n) {
		this.n = n;
	}

	public synchronized void add() {
		c.release();

		System.out.println("produce una, quedan " + ++n);
		if (n == 1) {
			if (s.availablePermits() != 1)
				s.release();
		}

	}

	public synchronized void get() {

		try {
			c.acquire();
			if(n==0)
				s.acquire();
		} catch (InterruptedException e) {
			System.out.println("ups");
		}

		System.out.println("consume una, quedan " + --n);
	}

}
