package ejemploSemaforos;

public class Semaforos1 {

	
	public static void main(String[] args) {
	
		EjemploS ej=new EjemploS();
		
		Thread t1= new Thread(ej);
		Thread t2= new Thread(ej);
		t1.setName("Hilo 1");
		t2.setName("Hilo 2");
		t1.start();
		t2.start();
	}
}
