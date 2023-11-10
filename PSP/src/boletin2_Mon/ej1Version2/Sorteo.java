package boletin2_Mon.ej1Version2;

import java.util.ArrayList;
import java.util.Random;


public class Sorteo {
	private CajaPremios cajaPremios;
	private ArrayList<Socio> socios;
	private ArrayList<Premio> premios;

	public Sorteo() {
		socios = new ArrayList<Socio>();
		premios = new ArrayList<Premio>();
		cajaPremios = new CajaPremios(premios);
	}

	public void metodoSorteo() {
		
		Random random = new Random();
		int r;
		
		Premio p1 = new Premio(13, "Luces de casa de Alex");
		Premio p2 = new Premio(4, "Desert Eagle");
		Premio p3 = new Premio(11, "Vacuna Covid");
		Premio p4 = new Premio(7, "Moto");
		Premio p5 = new Premio(1, "Cena con Messi");
		
		premios.add(p1);
		premios.add(p2);
		premios.add(p3);
		premios.add(p4);
		premios.add(p5);
		
		for (int i = 0; i<15; i++) {
			r = random.nextInt(15);
			Socio s = new Socio(i+1,r,cajaPremios);
			socios.add(s);
		}
		
	}
	
	public void comprobarBoletos() {
		for(int i = 0; i<socios.size(); i++) {
			socios.get(i).start();
		}
	}
	
	public CajaPremios getCajaPremios() {
		return cajaPremios;
	}

	public void setCajaPremios(CajaPremios cajaPremios) {
		this.cajaPremios = cajaPremios;
	}

	public ArrayList<Socio> getSocios() {
		return socios;
	}

	public void setSocios(ArrayList<Socio> socios) {
		this.socios = socios;
	}

	public ArrayList<Premio> getPremios() {
		return premios;
	}

	public void setPremios(ArrayList<Premio> premios) {
		this.premios = premios;
	}
	
}