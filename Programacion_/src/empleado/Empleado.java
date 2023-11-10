package empleado;

import dni.DNI;
import dni.DNIException;

public class Empleado {
	DNI dni;
	String nombre;
	double sueldo;
	
	public Empleado(String dni, String nombre, double sueldo) throws DNIException {
		this.dni=new DNI(dni);
		this.nombre = nombre;
		this.sueldo = sueldo;
	}
	
}
