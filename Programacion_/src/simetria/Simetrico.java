package simetria;
import java.util.Scanner;

public class Simetrico {
	private final int alto;
	private final int ancho;
	private char[][] mapa;
	private int numX;
	private int contX;
	public Simetrico(int x,int y) {
		if(x>99 || y>99){
			x=0;
			y=0;
		}
		mapa=new char[x][y];
		this.alto=y;
		this.ancho=x;
		numX=0;
	}
	
	public void insertarFila(final int f,final String c) {
		for(int i=0;i<ancho;i++) {
			if(c.charAt(i)=='X')numX++;
			mapa[i][f]=c.charAt(i);
		}
	}
	public String getFila(int y) {
		String c="";
		for(int x=0;x<ancho;x++) {
			c+=mapa[x][y];
		}		
		return c;
	}
	public int getAnchoAlto(boolean cual) {
		if(cual)return this.ancho;
		return this.alto;
	}
	public boolean estaConectado() {
		contX=0;
		if(numX==(this.ancho*this.alto))return false;
		for(int y=0;y<alto;y++) {
			for(int x=0;x<ancho;x++) {
				if(mapa[x][y]=='X') {
					return trazarSalida(x,y);
				}
			}
		}

		
		return false;
	}
	private boolean trazarSalida(final int x,final int y){
		
		if(x<0 || y<0 || x>=ancho || y>=alto) return false;
		
		if(contX==numX) return true;
		if(mapa[x][y]=='.') return false;
		if(mapa[x][y]=='p') return false;
		
		contX++;
		mapa[x][y]='p';
		
		if(trazarSalida(x,y-1)) return true;		//arriba
		if(trazarSalida(x+1,y)) return true;		//derecha
		if(trazarSalida(x-1,y)) return true; 		//izquierda
		if(trazarSalida(x,y+1)) return true;		//abajo

	//	if(trazarSalida(x+1,y-1)) return true;		//arriba-derecha+
	//	if(trazarSalida(x+1,y-1)) return true;		//arriba-derecha
	
	//	if(trazarSalida(x-1,y+1)) return true; 		//abajo-izquierda
	//	if(trazarSalida(x+1,y+1)) return true;		//abajo-derecha
		return false;
	}

	
	
    public static void main(String[] args) {
    	int x,y;
    	String fila;
    	
    	boolean esSimetrico;
    	
    	Simetrico foto;
    	Scanner sc=new Scanner(System.in);
    	
    	while(sc.hasNext()){

        	x=sc.nextInt();
        	y=sc.nextInt();
        	
			foto =new Simetrico(x,y);
			
			x=foto.getAnchoAlto(true);
			y=foto.getAnchoAlto(false);
			if((x*y)==0){ 
				esSimetrico=false;
			}else{
				esSimetrico=true;
				for(int i=0;i<y;i++) {
					fila=sc.next();
					foto.insertarFila(i,fila);
					for(int l=0;l<x/2;l++) {
						if(fila.charAt(l)!=fila.charAt(x-l-1)) {
							esSimetrico=false;
							break;
						}
					}
						
					
				}
				
				if(esSimetrico)
					for(int a=0;a<y/2;a++) 
						if(!foto.getFila(a).equals(foto.getFila(y-a-1))) {
							esSimetrico=false;
							break;
						}
					
						
				if(esSimetrico)
					if(!foto.estaConectado())	
						esSimetrico=false;
			}

			if(esSimetrico) {
				System.out.println("CORRECTO");
			}else System.out.println("TRAMPOSO");
			
    		

    	}

    	sc.close();
    }

}


