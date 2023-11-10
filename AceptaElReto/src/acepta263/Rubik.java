package acepta263;

import java.util.Scanner;

public class Rubik {
	private final int lado;
	private char[][] cara; 
	
	Rubik(int lado){
		if(lado>=1 && lado <=50) {
			this.lado = lado;
			cara=new char[lado][lado];
		}else this.lado=0;
	}
	public void insertarFila(int f,String c) {
		for(int i=0;i<lado;i++) {
			cara[i][f]=c.charAt(i);
		}
	}
	public void moverFila(int fil) {
		char aux;
		if(fil>0) {
			fil--;
			aux=cara[lado-1][fil];
			for(int i=(lado-1);i>0;i--) {
				cara[i][fil]=cara[i-1][fil];		
			}
			cara[0][fil]=aux;
			
		}else {
			fil=Math.abs(fil);
			fil--;
			aux=cara[0][fil];
			for(int i=0;i<lado-1;i++) {
				cara[i][fil]=cara[i+1][fil];		
			}
			cara[lado-1][fil]=aux;
		}		
	}
	public void moverColumna(int col) {
		char aux;
		if(col>0) {
			col--;
			aux=cara[col][lado-1];
			for(int i=(lado-1);i>0;i--) {
				cara[col][i]=cara[col][i-1];		
			}
			cara[col][0]=aux;
			
		}else {
			col=Math.abs(col);
			col--;
			aux=cara[col][0];
			for(int i=0;i<lado-1;i++) {
				cara[col][i]=cara[col][i+1];		
			}
			cara[col][lado-1]=aux;
			
		}
	}
	public void procesarInstrucciones(String linea) {
		char c;
		int i=0,num;
		c=linea.charAt(i);
		while(c!='x') {
			if(c=='f') {
				i+=2;
				c=linea.charAt(i);
				if(c=='-') {
					i++;
					c=linea.charAt(i);	
					num=0-Character.getNumericValue(c);
				}else num=Character.getNumericValue(c);
				moverFila(num);
			}else if(c=='c')  {
				i+=2;
				c=linea.charAt(i);
				if(c=='-') {
					i++;
					c=linea.charAt(i);	
					num=0-Character.getNumericValue(c);
				}else num=Character.getNumericValue(c);
				moverColumna(num);
				
			}
			
			i+=2;
			c=linea.charAt(i);
		}
	}
	public void imprimirCara() {
		for(int y=0;y<lado;y++) {
			for(int x=0;x<lado;x++) {
				System.out.print(cara[x][y]);
			}
			System.out.println();
		}
		System.out.println("---");
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Rubik cubo;
		
		int lado=1;
		String fila="";

		do {
			lado=sc.nextInt();
			sc.nextLine();
			if(lado==0) break;
			cubo=new Rubik(lado);
			for(int i=0;i<=lado;i++) {
				fila=sc.nextLine();
				if(i!=lado)
					cubo.insertarFila(i,fila);
			}
			
			cubo.procesarInstrucciones(fila);
			cubo.imprimirCara();

		}while(lado!=0);
//		sc.close();
	}

}
