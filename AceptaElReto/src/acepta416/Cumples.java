package acepta416;

//import java.util.LinkedList;
import java.util.Scanner;

class Fecha{
	private int dia;
	private int mes;

	public Fecha(String fecha) {
		String[] f;
		f=fecha.split("/");
		dia=Integer.parseInt(f[0]);
		mes=Integer.parseInt(f[1]);
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	
}
public class Cumples {
	//private LinkedList<Fecha> fechasCumples;
	private Fecha[] conjuntoF; 
	private int posX;
	
	public Cumples(int num) {
		conjuntoF=new Fecha[num];
		posX=0;
	}
	public boolean add(String fec) {
		

		String[] f;
		f=fec.split(" ");
		
		for(String c:f) {
			conjuntoF[posX++]=new Fecha(c);
		}

		return coincideCumple();
	}
	private boolean compara(Fecha fecha1,Fecha fecha2) {
		if(fecha1.getDia()==fecha2.getDia()) {
			if(fecha1.getMes()==fecha2.getMes())
				return true;
		}
		
		return false;
	}
	public boolean coincideCumple() {
		
		for(int i=0;i<conjuntoF.length-1;i++) {
			for(int x=i+1;x<conjuntoF.length;x++) {
				if(compara(conjuntoF[i],conjuntoF[x]))
					return true;
				
			}
		}	
		return false;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Cumples cp;
		
		int x;		
		x=sc.nextInt();
		
		while(x!=0) {
			sc.nextLine();
			cp= new Cumples(x);
			boolean fin=cp.add(sc.nextLine());
			
			if(fin) {
				System.out.println("SI");
			}else 
				System.out.println("NO");

			x=sc.nextInt();
		}
		sc.close();
	
	}
}
