package boletin2_4.ej2;

public class Productor extends Thread {

	private Buffer buffer;
	private int numP;
	
	public Productor(Buffer buffer,int numP) {
		this.buffer=buffer;
		this.numP=numP;
	}

	@Override
	public void run() {
		for (int i = 0; i < numP; i++) {
			buffer.add();
			
		}
	}

}
