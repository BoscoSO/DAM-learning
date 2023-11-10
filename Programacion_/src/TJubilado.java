
public class TJubilado extends Tarjeta {
	private int descuento=100; 
	public TJubilado(String nombre, int edad) {
		super(nombre, edad);
	}
	
	public String precioViaje(Viaje viaje) {	
		
		return "0 €";
		
	}

}
