package ejercicioU2_7.clientes;

import java.io.Serializable;
import java.util.ArrayList;

public class Client implements Serializable{
	private int dni;
	private String name;
	private String surname;
	private ArrayList<Address> adresses;
	
	public Client(int dni, String name, String surname,ArrayList<Address> adresss) {
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.adresses=adresss;
	}
	
	public int getDni() {
		return dni;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	
	public ArrayList<Address> getAdresses() {
		return adresses;
	}
}
