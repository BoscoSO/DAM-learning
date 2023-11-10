package boletin2_Mon.ej1Version2;

public class  Premio {
	private int numRifa;
	private String premio;
	private boolean disponible; 
	
	public Premio(int numRifa, String premio) {
		this.numRifa = numRifa;
		this.premio = premio;
		this.disponible = true;
	}
	
	
	public int getNumRifa() {
		return numRifa;
	}
	public void setNumRifa(int numRifa) {
		this.numRifa = numRifa;
	}
	public String getPremio() {
		return premio;
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