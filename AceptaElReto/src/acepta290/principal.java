package acepta290;

import java.util.Scanner;

public class principal {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String linea;
        int opc=Integer.parseInt(sc.next());
        
        for(int i=0;i<opc;i++) {
        
	        
	        linea = sc.next();
	        ArbolBin arbol = new ArbolBin(linea);
	        arbol.crearArbol();
	       
	       int alt =  arbol.alturaHijo(arbol.raiz);
	       System.out.println(alt);
    
        }
        sc.close();
    }


}
