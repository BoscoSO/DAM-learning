package boletin2_3.ej4;

public class Consumidor extends Thread {
	
	ProductorConsumidorComplementaria pc;
	int MAX;
	
	
	
	public Consumidor(ProductorConsumidorComplementaria pc, int mAX) {
		this.pc = pc;
		MAX = mAX;
	}



	@Override
	public void run() {
	
			for (int c = 0; c < MAX; c++)
				try {
					pc.consumidor();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
}
