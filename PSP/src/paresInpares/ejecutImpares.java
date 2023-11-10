package paresInpares;

public class ejecutImpares implements Runnable {
	private GeneradorParImpar generadorParImpar;
	private int total;
	
	public ejecutImpares(GeneradorParImpar generadorParImpar,int total) {
		super();
		this.generadorParImpar = generadorParImpar;
		this.total=total;
	}

	
	@Override
	public void run() {
		for (int i = 1; i < total; i+=2) {
			generadorParImpar.imprimeImpar(i);
		}
	}
}
