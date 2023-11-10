package boletin2_3.ej3;

public class Ejercicio3 {

	
	public static void main(String[] args) {
		
	
	Thread t1=new Contador("YES");
	Thread t2=new Contador("NO");
	
	t1.start();
	t2.start();
	
	}
	
	
}
