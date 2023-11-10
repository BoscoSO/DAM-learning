package ejemploHilos;

public class HiloEsperaHilo {
public static void sleep(long millis) {
	try {
		Thread.sleep(millis);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		System.out.println("error");
		e.printStackTrace();
	}
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable runnable = () -> {
			for (int i = 0; i < 5; i++) {
				sleep(1000);
				System.out.println("Funcionando");
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.setDaemon(true); //hilo demonio, pa que no este funcionando constantemente y nos libere espacio
		thread.start();
		try {
			thread.join();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			e.printStackTrace();
		}
		
	}

}
