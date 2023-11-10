package boletin2_Mon.ej1;

public class CajaPremios {

	Premio[] premios=new Premio[] {new Premio(7,"Play 3"),new Premio(14,"Iphone 2"),new Premio(3,"Iphone XXX"),new Premio(12,"Televisor de 60'"),new Premio(5,"Radio")};
	boolean libre=true;
	
	
	public synchronized boolean check(Socio s) {
		for (int i = 0; i < premios.length; i++) {
			if(premios[i].getNumero()==s.getRifa()) {
				System.out.println("Socio["+s.getIdSocio()+"] Esperando Comprobar...");
				
				return true;
			}
		}
		return false;
	}
	public synchronized boolean checkGift(Socio s)  {

		for (int i = 0; i < premios.length; i++) {
			if(premios[i].getNumero()==s.getRifa()) {
				return true;
			}
		}
		return false;
	}
	public synchronized String getGift(Socio s) throws InterruptedException {
		String cad="nada por llegar tarde";
		System.out.println("Socio["+s.getIdSocio()+"] Comprobando");
		for (int i = 0; i < premios.length; i++) {
			if(premios[i].getNumero()==s.getRifa()) {
				
				if(premios[i].isDisponible()) {

					cad=premios[i].getPremio();	
					premios[i].setDisponible(false);
				}
					
			}
		}
		return cad;
	}
	
}
