package ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class OrdenarNumeros {
	ArrayList<Integer> numeros;
	/************************************************EJERCICIO 1*******************************/
	public OrdenarNumeros() {
		numeros=new ArrayList<Integer>();
	}
	
	public void leerNums() {
		Scanner sc=new Scanner(System.in);
		int i;
		while((i=sc.nextInt())!=-1) {
			numeros.add(i);
		}
		sc.close();
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
		OrdenarNumeros orden=new OrdenarNumeros();

		orden.leerNums();
		orden.ordena();
	}
}
