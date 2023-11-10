package boletin2_3.ej1;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r = new Ejecutable("NO");
		Thread thread = new Thread(r);
		thread.start();
		for(int i=0;i<30;i++) {
			System.out.println("YES");
		}
	}

}
