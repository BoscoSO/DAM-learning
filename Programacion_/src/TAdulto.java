
public class TAdulto extends Tarjeta {

	private int descuento=10; 
	
	public TAdulto(String nombre, int edad,boolean esFN) {
		super(nombre, edad,esFN);	
		if(esFN)descuento+=15;
		// TODO Auto-generated constructor stub
	}
	
	public String precioViaje(Viaje viaje) {	
		int precio=viaje.getPrecio();
		
		return ""+precio*(descuento/100);
		
	}

}
