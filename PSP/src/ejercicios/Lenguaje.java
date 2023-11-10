package ejercicios;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

public class Lenguaje {
	
	private String[] abc=new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z"};
	
	private String contenido(int numP, int numL) {
		Random r=new Random();
		String cont="";
		
		for(int p=0;p<numP;p++) {
			for(int l=0;l<numL;l++) {
				cont+=abc[r.nextInt(abc.length)];
			}
			if(p!=(numP-1))
				cont+="\n";
		}
		
		return cont;
	}
	
	private void generarFichero(String nombreFich, int numPalabras, int numdLetras) {
		 try (Writer w = new FileWriter(nombreFich)){
			 	String content = contenido(numPalabras,numdLetras);  
	            w.write(content);  
	            w.close();  
		 } catch (IOException e) {
			 System.out.println("Error escribiendo fichero");
			 e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		if(args.length==3) {
			Lenguaje lg=new Lenguaje();
			
			try {
				int numPalabras=Integer.valueOf(args[0]);
				String nombreFich=args[1];
				int numdLetras=Integer.valueOf(args[2]);
				System.out.println("1-nombreFich: "+nombreFich);
				System.out.println("2-numdLetras: "+numdLetras);
				System.out.println("3-numPalabras: "+numPalabras);

				lg.generarFichero(nombreFich,numPalabras,numdLetras);
			}catch(NumberFormatException e) {
				System.out.println("parametros no validos");
			}
			
		}else System.out.println("faltan parametros");
	}


}
