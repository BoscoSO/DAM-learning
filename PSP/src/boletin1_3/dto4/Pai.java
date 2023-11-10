package boletin1_3.dto4;

import java.util.Scanner;

public class Pai {
	Scanner sc;
	
	public Pai() {
		sc=new Scanner(System.in);
		leeLinea();
		close();
		System.out.println("Hola");
	}
	public String leeLinea() {
		String rt=sc.nextLine();
		int aux;
		if(!rt.equals("fin")) {
			
			aux=new Fillo().getRandomNum();
			System.out.println(aux);
		}
		return rt;
	}
	public void close() {
		sc.close();
	}
}
