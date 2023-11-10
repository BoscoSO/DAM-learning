package ejercicioU2_7.order;

import java.io.Serializable;

public class Client implements Serializable{
	private String name;
	private String surname;
	private String dni;
	
	public Client(String name, String surname, String dni) {
		this.name = name;
		this.surname = surname;
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getDni() {
		return dni;
	}

	public String toString() {
		String cadea="\tName : "+this.name+"\n"+
					 "\tSurname : "+this.surname+"\n"+
					 "\tDNI : "+this.dni+"\n";
						
		
		
		return cadea;
	}
	
}
