package comunicacionEnRed.ejemplo;

import java.net.MalformedURLException;
import java.net.URL;

public class Ejemplo2 {

	public static void main(String[] args) {
		
		Ejemplo2 e=new Ejemplo2();
		
		
		try {
			
			System.out.println("Constructor simple para url principal");
			e.display(new URL("https://www.youtube.com/"));
			System.out.println();	
			
			System.out.println("Constructor de cadena para URL +directorio para url principal");
			e.display(new URL("https://www.youtube.com/feed/library"));
			System.out.println();
			
			System.out.println("Constructor con protocolo, host y directorio, para url principal");
			e.display(new URL("https","www.youtube.com","/feed/library"));
			System.out.println();
			
			System.out.println("Constructor con protocolo, host y directorio, para url principal");
			e.display(new URL("https","www.youtube.com",80,"/feed/library"));
			System.out.println();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void display(URL url) {
		System.out.println("Prot "+url.getProtocol());
		System.out.println("Host "+url.getHost());
		System.out.println("Port "+url.getPort());
		System.out.println("File "+url.getFile());
		System.out.println("Refe "+url.getRef());
		System.out.println("Ruta "+url.toString());
		
	}
}
