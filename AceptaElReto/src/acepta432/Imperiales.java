package acepta432;

import java.util.Scanner;

public class Imperiales {
	private final int fila;
	private final int colum;
	private char[][] mapa; 
	
	Imperiales(int columnas,int filas){
		if(filas>=1 && columnas<=20) {
			this.fila = filas;
			this.colum = columnas;
			mapa=new char[columnas][filas];
		}else {
			this.fila = 0;
			this.colum =0;
		}
	}
	public int getFilas(){
		return this.fila;
	}
	public void insertarFila(int f,String c) {
		for(int i=0;i<colum;i++) {
			mapa[i][f]=c.charAt(i);
		}
	}
	public boolean trazarSalida(int x,int y){
		if(x<0 || y<0 || x>=colum || y>=fila) return false;
		if(mapa[x][y]=='F') return true;
		if(mapa[x][y]=='*') return false;
		if(mapa[x][y]=='-') return false;

		 mapa[x][y]='-'; 
//if(mapa[x][y]=='.')
		if(trazarSalida(x+1,y)) return true;		//derecha
		if(trazarSalida(x-1,y)) return true; 		//izquierda
		if(trazarSalida(x,y+1)) return true;		//abajo
		if(trazarSalida(x,y-1)) return true;		//arriba
		
		return false;
	}
	public boolean buscarSalida(){
		for(int y=0;y<fila;y++) {
			for(int x=0;x<colum;x++) {
				if(mapa[x][y]=='S'){
					return trazarSalida(x,y);
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int ladoA,ladoB;
		String fila;
		
		Imperiales campo;
		Scanner sc=new Scanner(System.in);
	
		while(sc.hasNext()){	
			ladoA=sc.nextInt();
			ladoB=sc.nextInt();	
			sc.nextLine();	
			campo=new Imperiales(ladoB,ladoA);
			
			for(int i=0;i<campo.getFilas();i++) {
				fila=sc.nextLine();
				campo.insertarFila(i,fila);
			}
			if(campo.buscarSalida()){ 
				System.out.println("SI");
			}else System.out.println("NO");	

	
			
		}
	}

}









