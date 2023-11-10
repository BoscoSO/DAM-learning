
public class TMenor extends Tarjeta {

	private int descuento=50; 
	public TMenor(String nombre, int edad) {
		super(nombre, edad);
		// TODO Auto-generated constructor stub
	}

	
	public String precioViaje(Viaje viaje) {	
		return ""+viaje.getPrecio()*(descuento/100);
		
	}
}
