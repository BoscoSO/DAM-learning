package boletin2_3.ej1;

public class Ejecutable implements Runnable{
	private String msg;
	
	public Ejecutable(String msg) {
		this.msg=msg;
	}
	
	@Override
	public void run() {
		for(int i=0;i<30;i++) {
			System.out.println(this.msg);
		}
		
	}

}
