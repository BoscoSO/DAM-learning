package ejercicioU2_7.clientes;

import java.io.Serializable;

public class Address implements Serializable{
	private int postalCode;
	private String street;
	private int number;
	
	public Address(int postalCode, String street, int number) {
		this.postalCode = postalCode;
		this.street = street;
		this.number = number;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public String getStreet() {
		return street;
	}
	public int getNumber() {
		return number;
	}
	
	
	
}
