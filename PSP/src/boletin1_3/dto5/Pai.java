package boletin1_3.dto5;

import java.util.Scanner;

public class Pai {
	Scanner sc;
	
	public Pai() {
		sc=new Scanner(System.in);
	}
	
	
	public String leeLinea() {
		String rt=sc.nextLine();
		String aux;
		if(!rt.equals("fin")) {
			
			aux=new Fillo().procesa(rt);
			System.out.println(aux);
		}
		return rt;
	}
	
	
	
	public void close() {
		sc.close();
	}
}
