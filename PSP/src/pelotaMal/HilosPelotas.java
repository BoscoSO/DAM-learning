package pelotaMal;

import java.awt.Component;

public class HilosPelotas implements Runnable{

	private Pelota pelota;
	private LaminaPelota componente;
	
	public HilosPelotas(Pelota pelota, LaminaPelota componente) {
		this.pelota = pelota;
		this.componente = componente;
	}

	@Override
	public void run() {
		for (int i=1; i<=3000; i++){
			
			pelota.mueve_pelota(componente.getBounds());
			
			componente.paint(componente.getGraphics());
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		componente.quita();
	}


}
