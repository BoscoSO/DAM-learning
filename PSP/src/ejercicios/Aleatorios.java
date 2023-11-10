package ejercicios;

import java.util.ArrayList;
import java.util.Random;

public class Aleatorios {

	/************************************************EJERCICIO 2*******************************/
	ArrayList<Integer> numeros;
	
	public Aleatorios() {
		numeros=new ArrayList<Integer>();
	}
	
	public void generarAleatorios() {
		Random r=new Random();
		int cont=1;
		while(cont<=40) {
			int aux=r.nextInt(100);
			System.out.println("["+cont+"] :  "+aux);
			numeros.add(aux);
			cont++;
		}
	}
	public void ordena() {
		int[] numsAux=new int[numeros.size()];
		int numA;
		int numB;
		
		for(int i=0;i<numeros.size();i++) {
			numsAux[i]=numeros.get(i);
		}
		boolean salir=true;
		while(salir) {
			salir=false;
			for(int x=0;x<numsAux.length;x++) {
				if(x!=numsAux.length-1)
					if(numsAux[x]>numsAux[x+1]) {
						numA=numsAux[x];
						numsAux[x]=numsAux[x+1];
						numsAux[x+1]=numA;
						salir=true;						
					}
			}
		}
		for(int z=0;z<numsAux.length;z++) {
			System.out.println("->  "+numsAux[z]);
		}
	}
	
	
	public static void main(String[] args) {
		Aleatorios al=new Aleatorios();
		al.generarAleatorios();
		al.ordena();
	}
}
