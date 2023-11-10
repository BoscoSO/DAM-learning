package acepta127;

import java.util.LinkedList;
import java.util.Scanner;

public class Hostal {
	private LinkedList<String> peregrinos;
	private int habitas, palabras;
	private int posArr;
	public Hostal(String datos) {
		peregrinos=new LinkedList<String>();
		gestionar(datos);
		posArr=-1;
	}
	
	private void gestionar(String datos) {
		Scanner sc=new Scanner(datos);
		boolean salir=false;
		sc.useDelimiter(" ");
		String token;
		while(!salir) {
			token=sc.next();
			if(token.compareTo("F")!=0) {
				peregrinos.add(token);	
			}else salir=true;
		}
		token=sc.next();
		habitas=Integer.parseInt(token);
		token=sc.next();
		palabras=Integer.parseInt(token);
		
		sc.close();
		
	}
	
	public String repartir() {
		int gente=peregrinos.size();
		int genteOut=gente-habitas;
		if(genteOut<=0)
			return "TODOS TIENEN CAMA";
		if(habitas==0)
			return "NADIE TIENE CAMA";

		for(int i=0;i<genteOut;i++) {
			for(int x=0;x<palabras;x++) {
				posArr++;
				if(posArr>=peregrinos.size()) {
					posArr=0;
				}
			}			
			peregrinos.remove(posArr);
			if(posArr==0) { posArr=peregrinos.size()-1;
			}else posArr--;
			
		}

		String conCama="";
		for(int y=0;y<peregrinos.size();y++) {
			if(y==peregrinos.size()-1) {
				conCama+=peregrinos.get(y);
			}else
				conCama+=peregrinos.get(y)+" ";			
		}
		return conCama;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Hostal camiño;
		int casos=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<casos;i++) {
			String datos=sc.nextLine();
			
			camiño=new Hostal(datos);
			
			System.out.println(camiño.repartir());
			
		}
		
	}

}
