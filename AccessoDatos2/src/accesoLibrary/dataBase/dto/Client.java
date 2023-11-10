package accesoLibrary.dataBase.dto;

public class Client {
	private int idClient;
	private String dni;
	private String name;
	private String email;
	
	public Client(int idClient, String dni, String name, String email) {
		this.idClient = idClient;
		this.dni = dni;
		this.name = name;
		this.email = email;
	}


	public int getIdClient() {
		return idClient;
	}
	public String getDni() {
		return dni;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String toString() {
		return "ID cliente: "+idClient+"\n"+
				"DNI: "+dni+"\n"+
				"Name: "+name+"\n"+
				"Email: "+email+"\n";
	}
	
}
