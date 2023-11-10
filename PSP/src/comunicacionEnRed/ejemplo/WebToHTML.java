package comunicacionEnRed.ejemplo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class WebToHTML {

	
	 public static void main(String[] args) {
		 
	 
	 String cadena;
	 String sFichero="pagina.html";
	 File fichero=new File(sFichero);
	 
		 if(fichero.exists()) {
			 System.out.println(sFichero+" ya existe");
		 }else {
			
			try {
				// url=new URL("https://mestre.iessanclemente.net");
				 URL url=new URL("https://es.wikipedia.org/wiki/Copa_del_Rey");
				
				
				
				BufferedReader in=new BufferedReader(new InputStreamReader(url.openStream()));

				BufferedWriter bw=new BufferedWriter(new FileWriter(sFichero));
				
				
				while((cadena=in.readLine())!=null) {
					bw.write(cadena+"\r\n");
				}
				
				in.close();
				bw.close();
				
			}catch (Exception e) {
				// TODO: handle exception
			}
	 	}
	 
	 
	 } 
	 
	 
}
