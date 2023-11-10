
public abstract class Tarjeta {
	private int idTarjeta;
	private String nombre;
	private int edad;
	private boolean esFN;
	private String caducidad;

	private static int contadorID=1;
	
	public Tarjeta(String nombre,int edad) {
		idTarjeta=contadorID++;
		this.nombre=nombre;
		this.edad=edad;
		this.esFN=false;
		setCaducidad(3,6,2022);
		
	}
	public Tarjeta(String nombre, int edad, boolean esFN) {
		idTarjeta=contadorID++;
		this.nombre=nombre;
		this.edad=edad;
		this.esFN=esFN;
		setCaducidad(3,6,2022);
	}
	
	
	public static Tarjeta getInstance(String nombre,int edad) {
		if(edad>=65) return new TJubilado(nombre,edad);
		if(edad<18) return new TMenor(nombre,edad);
		
		return null;
	}
	public static Tarjeta getInstance(String nombre,int edad,boolean esFN) {
		if(edad>=18 && edad<65) {
			return new TAdulto(nombre,edad,esFN);
		}else return null;	
	}

	
	public void setCaducidad(int dia,int mes,int año) {
		caducidad=""+dia+"/"+mes+"/"+año;
	}
	
	public abstract String precioViaje(Viaje viaje);
}
