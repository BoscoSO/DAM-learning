package ejercicioU2_6.parte2Books;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String dni;
	
	

	public Person(String name, String dni) {
		this.name = name;
		this.dni = dni;
	}
	
	
	public String getName() {
		return name;
	}

	public String getDni() {
		return dni;
	}
}
