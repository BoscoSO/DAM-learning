package boletin2_3.ej2;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r = new Ejecutable("NO");
		Runnable r2 = new Ejecutable("YES");
		Thread thread = new Thread(r);
		Thread thread2 = new Thread(r2);
		System.out.println("Ejecucion en HiloA");
		thread.start();
		System.out.println("Ejecucion en HiloB");
		thread2.start();
		System.out.println("Ejecucion en main");
	}

}
