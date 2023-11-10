package boletin2_Mon.ej1;

import java.util.Random;

public class Sorteo extends Thread{

	
	private CajaPremios cp;
	private Socio s;
	
	public Sorteo(CajaPremios cp){
		this.cp=cp;
	}
	@Override
	public void run() {
		Random r= new Random();
		
		int rifa=r.nextInt(15);
		
		s=new Socio(rifa);
		
		
		boolean b=cp.check(s);
		
		
		if(b) {
	
			String premio="";
			try {
				premio = cp.getGift(s);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Socio["+s.getIdSocio()+"] con rifa ["+rifa+"] premiada con "+premio);
		
		}else 
			System.out.println("Socio["+s.getIdSocio()+"] con rifa ["+rifa+"] no premiada");
			
		
	}
}
