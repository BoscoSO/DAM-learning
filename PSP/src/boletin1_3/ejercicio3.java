package boletin1_3;

import java.io.IOException;
import java.io.InputStream;

public class ejercicio3 {
	public static void main(String[] args) {
		if(args[0]!=null && !args[0].isEmpty()) {
			Runtime r=Runtime.getRuntime();
			String com="ping "+args[0];
			
			Process p; 
			try {
				p=r.exec(com);
				InputStream is=p.getInputStream();
				
				int data =is.read();
				while (data != -1) {  
	                System.out.print((char) data);  
	                data = is.read();  
	            } 

			} catch (IOException e) {
				System.out.println("Error en: "+com);
			}
			
		}
	}
}
