package persona;

import java.util.List;

public class Profesor extends Persona{
	List<Character> prestamos;
	
	public Profesor(String numeroDeTelefono) {
		super(numeroDeTelefono);
	
	}
	
	public void printInformacionPersonal() {
		System.out.println("Nombre: "+nombre);
		System.out.println("Edad: "+edad);
		System.out.println("Teléfono: "+numeroDeTelefono);
	}
	
	public void printTodaLaInformacion() {
		
		printInformacionPersonal();
		
		for(Character p: prestamos) {
			System.out.println(p);
			
		}
	}
}
