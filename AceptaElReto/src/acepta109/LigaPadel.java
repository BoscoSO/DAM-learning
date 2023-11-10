package acepta109;

import java.util.ArrayList;
import java.util.Scanner;

class Elemento{
    private String clave;
    private int veces;   
    public Elemento(String clave, int veces) {
        this.clave = clave;
        this.veces = veces;
    }
    public String getClave() {
        return clave;
    }
    public void aumentaV(int valor) {
    	veces+=valor;
    }
    public int getValor() {
        return veces;
    }
}
public class LigaPadel {

	ArrayList<Elemento> almacen=new ArrayList<>();
	private int partJug;
	public LigaPadel() {
		almacen.clear();
		this.partJug=0;
	}
	private Elemento contiene(String clave) {
		for(Elemento c: almacen) {
			if(clave.equals(c.getClave()))
				return c;
		}
		return null;
	}
	private void añadir(String clave, int valor) {
		Elemento c;
		c=contiene(clave);
		
		if(c==null) {
			almacen.add(new Elemento(clave, valor));
		}else {
			c.aumentaV(valor);
		}
    }
	public void procesa(String linea) {
	
		String[] sc=linea.split(" ");
		
		String teamA,teamB;
		int setsA,setsB;
		
		teamA=sc[0]; setsA=Integer.parseInt(sc[1]);
		teamB=sc[2]; setsB=Integer.parseInt(sc[3]);
	
		if(setsA>setsB) {
			añadir(teamA,2);
			añadir(teamB,1);
		}else {
			añadir(teamB,2);
			añadir(teamA,1);
			
		}
		partJug++;
	}
	private int fact(int n) {
	    if (n <= 2) {
	    	if(n==0)return 1;
	        return n;
	    }
	    return n * fact(n - 1);
	}
	public String temporada() {
		String cad="";
		
		int numPart=(fact(almacen.size())/(2*fact(almacen.size()-2)))*2;

		Elemento aux=new Elemento("",0);
		boolean emp=false;

		for(Elemento c: almacen) {
			
			if(c.getValor()==aux.getValor()) {
				emp=true;
			}
			if(c.getValor()>aux.getValor()) {
				aux=c;
				emp=false;
			}	
		}
		
		if(emp) {
			cad+="EMPATE ";
		}else {
			cad+=aux.getClave()+" ";
		}
		
		cad+=(numPart-partJug);
		
		
		
		return cad;
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);	
		String cat;	
		LigaPadel lig;
		cat=sc.nextLine();
		
		while(!cat.equals("FIN")) {
			lig= new LigaPadel();
			
			String part=sc.nextLine();
			while(!part.equals("FIN")) {
				lig.procesa(part);		
				part=sc.nextLine();	
			 }
			
			System.out.println(lig.temporada());
			
			cat=sc.nextLine();
		}
		
		sc.close();
		
		
	}

}