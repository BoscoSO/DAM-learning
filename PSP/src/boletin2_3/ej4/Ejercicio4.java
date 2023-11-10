package boletin2_3.ej4;

public class Ejercicio4 {

	
	public static void main(String[] args) {
		ProductorConsumidorComplementaria pc= new ProductorConsumidorComplementaria();
		
		Thread t1=new Productor(pc,20);
		Thread t2=new Consumidor(pc,20);
		
		t1.start();
		t2.start();
	}
}
