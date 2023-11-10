package acepta315;

import java.util.Scanner;

public class BuscaMinas {
	private char[][] map,cover;
	private int col;
	private int fil;
	
	
	public BuscaMinas(int filas, int columnas) {
		if(filas>50 || columnas>50 || filas<0 || columnas<0) {
			filas=0;
			columnas=0;
		}
		this.col = columnas;
		this.fil = filas;
		map= new char[columnas][filas];
		cover=new char[columnas][filas];
		for(int i=0;i<filas;i++){
			for(int j=0;j<columnas;j++){
				cover[j][i]='X';
			}
		}
	}
	public int getFilas() {
		return fil;
	}
	private void insertarFila(int f,String c) {
		for(int i=0;i<col;i++) {
			map[i][f]=c.charAt(i);
		}
	}
	private boolean destapar(int x, int y) {
		if(map[x][y]=='*') {
			cover[x][y]=map[x][y];
			return true;
		}else {
			cover[x][y]=cuentaMinas(x,y);
			if(cover[x][y]=='-') {
				despeja(x,y);
			}	
			return false;
		}
	}
	private void despeja(int x, int y) {
		for(int xx=x-1; xx<=x+1;xx++) {
			for(int yy=y-1; yy<=y+1;yy++) {
				if(xx>=0 && yy>=0 && xx<col && yy<fil)  { 
					
					if(!estaDescubierta(xx,yy)) {
						cover[xx][yy]=cuentaMinas(xx,yy);
						if(cover[xx][yy]=='-') {
							despeja(xx,yy);
						}
					}
					
				}
			}
		}
	}		
	private boolean estaDescubierta(int xx, int yy) {
		if(cover[xx][yy]=='X') return false;
		
		return true;
	}
	private char cuentaMinas(int x, int y) {
		int cont=0;
		for(int xx=x-1; xx<=x+1;xx++) {
			for(int yy=y-1; yy<=y+1;yy++) {
				if(xx>=0 && yy>=0 && xx<col && yy<fil) 
					if(map[xx][yy]=='*') cont++;
			}
		}
		if (cont==0)return '-';
		return Character.forDigit(cont, 10);
	}

 	private void showMap() {
		for(int i=0;i<fil;i++){
			for(int j=0;j<col;j++){
				System.out.print(cover[j][i]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int ladoA,ladoB;
		String fila;
		
		BuscaMinas campo;
		Scanner sc=new Scanner(System.in);
	
		while(sc.hasNext()){	
			ladoA=sc.nextInt();
			ladoB=sc.nextInt();	
				
			
			campo= new BuscaMinas(ladoA,ladoB);
			
			for(int i=0;i<campo.getFilas();i++) {
				fila=sc.next();
				campo.insertarFila(i,fila);
			}
			
			int op=sc.nextInt();
			boolean peto=false;
			for(int z=0;z<op;z++) {
				int y=sc.nextInt()-1;
				int x=sc.nextInt()-1;

				if(campo.destapar(x,y) && peto==false) {
					peto=true;
				}
			}	
			if(!peto) {
				campo.showMap();
			}else System.out.println("GAME OVER");
			
		}
	
	
	}
}
