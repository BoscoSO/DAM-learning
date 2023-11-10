package boletin2_Mon.ej1Version2;

public class Socio extends Thread {
	private int numSocio;
	private int rifa;	
	private CajaPremios cajaPremios;
	
	public Socio(int numSocio, int rifa, CajaPremios cajaPremios) {
		super();
		this.numSocio = numSocio;
		this.rifa = rifa;
		this.cajaPremios = cajaPremios;
	}
	
	public void run() {
		boolean flag = false;
		System.out.println("El socio " + numSocio + " está esperando comprobar");
		flag= cajaPremios.tryPremios(numSocio,rifa);
		if(flag == false) {
			System.out.println("el socio " + numSocio + " con la rifa " + rifa + " no tiene premio.");
		}
	}
	
	
	
	
	public int getNumSocio() {
		return numSocio;
	}
	public void setNumSocio(int numSocio) {
		this.numSocio = numSocio;
	}
	public int getRifa() {
		return rifa;
	}
	public void setRifa(int rifa) {
		this.rifa = rifa;
	}
	public CajaPremios getCajaPremios() {
		return cajaPremios;
	}
	public void setCajaPremios(CajaPremios cajaPremios) {
		this.cajaPremios = cajaPremios;
	}
}