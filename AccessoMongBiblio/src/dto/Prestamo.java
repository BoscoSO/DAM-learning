package dto;

import org.bson.Document;

public class Prestamo {

	private String data;
	private Cliente cliente;
	private Libro libro;

	public Prestamo(String data, Cliente cliente, Libro libro) {
		this.data = data;
		this.cliente = cliente;
		this.libro = libro;
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	@Override
	public String toString() {
		return "Prestamo [data=" + data + ", cliente=" + cliente + ", libro=" + libro + "]";
	}
	
	public Document toDocument() {
	
		Document prest= new Document()
         		.append("data", data)
         		.append("cliente",cliente.toDocument())
         		.append("libro", libro.toDocument());
        
		return prest;
	}
	 
}
