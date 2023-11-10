package boletin1_3;

import boletin1_3.dto5.Pai;

public class ejercicio5 {

	public static void main(String[] args) {
		Pai p=new Pai();
		
		String linea="";
		
		
		while(!linea.equals("fin")) {
			linea=p.leeLinea();			
		}
		
		p.close();
	
	}
}
