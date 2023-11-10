package boletin2_Mon.ej1;

public class Socio {
	static int contID=0;
	private int idSocio;
	private int rifa;

	public Socio(int rifa) {
		this.idSocio = ++contID;
		this.rifa = rifa;
	}

	public int getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}

	public int getRifa() {
		return rifa;
	}

	public void setRifa(int rifa) {
		this.rifa = rifa;
	}
	
	
}
