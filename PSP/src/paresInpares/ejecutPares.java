package paresInpares;

public class ejecutPares implements Runnable {
	private GeneradorParImpar generadorParImpar;
	private int total;
	
	public ejecutPares(GeneradorParImpar generadorParImpar,int total) {
		super();
		this.generadorParImpar = generadorParImpar;
		this.total=total;
	}

	
	@Override
	public void run() {
		for (int i = 2; i < total; i+=2) {
			generadorParImpar.imprimePar(i);
		}
	}
}



