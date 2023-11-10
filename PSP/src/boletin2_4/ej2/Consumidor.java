package boletin2_4.ej2;

public class Consumidor extends Thread {

	private Buffer buffer;
	private int numP;
	
	public Consumidor(Buffer buffer,int numP) {
		this.buffer=buffer;
		this.numP=numP;
	}

	@Override
	public void run() {
		for (int i = 0; i < numP; i++) {
			buffer.get();
			
		}
	}
 
}
