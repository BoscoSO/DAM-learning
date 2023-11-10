package acepta345;

import java.util.Scanner;
public class Sudokus {
	final int lado;
	private int[][] cara; 
	
	Sudokus(){
			this.lado = 9;
			cara=new int[9][9];
	}
	public void insertarFila(int f,String c) {
		int cont=0;
		for(int i=0;i<c.length();i+=2) {
			cara[cont][f]=Character.getNumericValue(c.charAt(i));
			cont++;
		}
	}
	public boolean estaEnCruz(int a,int b){
		for(int y=0;y<lado;y++){
			if(y!=a)
				if(cara[a][b]==cara[y][b]){
					return false;
				}
		}
		for(int x=0;x<lado;x++){
			if(x!=b)
				if(cara[a][b]==cara[a][x]){
					return false;
				}
		}
		return true;

	}
	public boolean estaCasilla(int a,int b){
		int posX=0;
		if(a>=3){
			posX=3;
			if(a>=6)
				posX=6;
		}
		int posY=0;
		if(b>=3){
			posY=3;
			if(b>=6)
				posY=6;
		}

		for(int y=posY;y<3;y++){
			for(int x=posX;x<3;x++){
				if(a!=x || b!=y)
					if(cara[a][b]==cara[x][y]) return false;
			}
		}

		return true;

	}
	public boolean procesarSudoku(){
		for(int y=0;y<lado;y++){
			for(int x=0;x<lado;x++){
				if(!estaEnCruz(x,y)) return false;
				if(!estaCasilla(x,y)) return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		int veces;
		Sudokus nuevo;
		Scanner sc=new Scanner(System.in);
		String fila;
		veces=sc.nextInt();
		sc.nextLine();
		for(int c=0;c<veces;c++){
			nuevo=new Sudokus();
			for(int i=0;i<9;i++) {
				fila=sc.nextLine();
				nuevo.insertarFila(i,fila);
			}
			if(nuevo.procesarSudoku()){ 
				System.out.println("SI");
			}else System.out.println("NO");
		}

		//sc.close();

	}

}
