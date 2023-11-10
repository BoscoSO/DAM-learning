package dto;
// Generated 11 ene. 2021 13:26:11 by Hibernate Tools 5.2.12.Final

/**
 * Telefonos generated by hbm2java
 */
public class Telefonos implements java.io.Serializable {

	private Integer idTelefono;
	private Clientes clientes;
	private String descricion;
	private String numero;

	public Telefonos() {
	}

	public Telefonos(Clientes clientes, String descricion, String numero) {
		this.clientes = clientes;
		this.descricion = descricion;
		this.numero = numero;
	}

	public Integer getIdTelefono() {
		return this.idTelefono;
	}

	public void setIdTelefono(Integer idTelefono) {
		this.idTelefono = idTelefono;
	}

	public Clientes getClientes() {
		return this.clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public String getDescricion() {
		return this.descricion;
	}

	public void setDescricion(String descricion) {
		this.descricion = descricion;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "(ID[" + idTelefono + "] " + descricion
				+ ":" + numero + ")";
	}

}