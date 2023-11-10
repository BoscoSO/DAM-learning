package accesoOrders.dataBase.dto;

public class Client {
	
	private int idClient;
	private String dni;
	private String name;
	
	public Client( int idClient, String dni, String name) {
		this.idClient = idClient;
		this.dni = dni;
		this.name = name;
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

	public String toString() {
		return "ID cliente: "+idClient+"\n"+
				"DNI: "+dni+"\n"+
				"Name: "+name+"\n";
	}
	
}
