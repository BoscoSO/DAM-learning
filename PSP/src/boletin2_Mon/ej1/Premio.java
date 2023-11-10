package boletin2_Mon.ej1;

public class Premio {
	private int numero;
	private String premio;
	private boolean disponible;

	public Premio(int numero, String premio) {
		this.numero = numero;
		this.premio = premio;
		this.disponible=true;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPremio() {
		if(disponible)
			return premio;
		return "nada";
	}

	public void setPremio(String premio) {
		this.premio = premio;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	
}
