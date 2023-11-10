package persona;

public class Persona {
	String nombre;
	int edad;
	String numeroDeTelefono;
	
	public Persona(String numeroDeTelefono) {
		super();
		this.numeroDeTelefono=numeroDeTelefono;
	}
	
	public String getTelefono() {
		return numeroDeTelefono;
	}

	public void setTelefono(String numeroDeTelefono) {
		this.numeroDeTelefono = numeroDeTelefono;
	}
}
