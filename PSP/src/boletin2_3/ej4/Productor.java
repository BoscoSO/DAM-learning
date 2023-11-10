package boletin2_3.ej4;

public class Productor extends Thread {
	
	ProductorConsumidorComplementaria pc;
	int MAX;
	
	
	
	public Productor(ProductorConsumidorComplementaria pc, int mAX) {
		this.pc = pc;
		MAX = mAX;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < MAX; i++)
			try {
				pc.productor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
		
	}
}
