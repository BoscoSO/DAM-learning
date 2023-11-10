package boletin2_Mon.ej1Version2;

import java.util.ArrayList;

public class CajaPremios {
	private ArrayList<Premio> premios;
	
	public CajaPremios(ArrayList<Premio> premios) {
		this.premios = premios;
	}

	public void imprimePremios() {
		for(int i=0; i<premios.size(); i++) {
			System.out.println("Premio con la rifa " + premios.get(i).getNumRifa() + " es " + premios.get(i).getPremio());
		}
	}
	
	public ArrayList<Premio> getPremios() {
		return premios;
	}

	public void setPremios(ArrayList<Premio> premios) {
		this.premios = premios;
	}
	
	public synchronized boolean tryPremios(int numSocio,int rifa) {

		boolean flag = false;
		
		System.out.println("El socio " + numSocio + " ha entrado a comprobar");
		for(int i = 0; i<premios.size(); i++) {
			if(rifa == premios.get(i).getNumRifa() && premios.get(i).isDisponible() == true) {
				flag = true;
				premios.get(i).setDisponible(false);
				System.out.println("El socio " + numSocio + " con rifa " + rifa +" ha ganado el premio "+ premios.get(i).getPremio());
				
				break;
			}else if(rifa == premios.get(i).getNumRifa() && premios.get(i).isDisponible() == false) {
				flag = true;
				System.out.println("El socio " + numSocio + " con rifa " + rifa + " premiada, llegó tarde.");
				break;
			}
		}
		return flag;
	
	}
}