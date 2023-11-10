package comunicacionEnRed.descargaArchivo;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DescargaArchivo {

	
	public static void main(String[] args) {
		try {
			URL url=new URL("http://www.maestrosdelweb.com/images/2009/08/crayones_gif.gif");
			
			URLConnection urlCon= url.openConnection();
			
			System.out.println(urlCon.getContentType());
			
			
			InputStream is =urlCon.getInputStream();
			FileOutputStream fos=new FileOutputStream("foto.jpg");
			
			
			
			byte[] array=new byte[1000];
			int leido=is.read(array);
			while (leido>0) {
				fos.write(array,0,leido);
				leido=is.read(array);
				
			}
			
			
			is.close();
			
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
