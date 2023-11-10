package ejercicioU2_6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import ejercicioU2_4.orders.Order;
import ejercicioU2_4.orders.Product;
//export CLASSPATH=.:/media/a19boscoso/a19boscoso_sarela/A19BoscoSO/AccesoADatos/libreriasEclipse/ksml2-2.3.0.jar:/media/a19boscoso/a19boscoso_sarela/A19BoscoSO/AccesoADatos/libreriasEclipse/xstream-1.4.3/lib/xstream-1.4.3.jar
public class XstreamClass {

	public ArrayList<Product> readProducts() {
		FileInputStream datos = null;
    	ObjectInputStream tuberiaDatos= null;
    	
    	ArrayList<Product> lista=new ArrayList<Product>();
        try{
        	datos=new FileInputStream("products.dat");
        	tuberiaDatos= new ObjectInputStream(datos);
        	
        	
        	while(tuberiaDatos.available()>=0) {
        		lista.add((Product)tuberiaDatos.readObject());
        	}
     
        }catch(FileNotFoundException e){
        	System.out.println("Fichero no encontrado /"+e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println("FIN DE FICHERO2");
        } catch (IOException e) {
		}finally { 
            try {
				datos.close();
				tuberiaDatos.close();
			} catch (IOException e) {
	            System.out.println("problema al cerrar Stream"); 
			}
        			
    	}
		return lista;
	}
	public ArrayList<Order> readOrders() {
		FileInputStream datos = null;
    	ObjectInputStream tuberiaDatos= null;
    	
    	ArrayList<Order> lista=new ArrayList<Order>();
        try{
        	datos=new FileInputStream("orders.dat");
        	tuberiaDatos= new ObjectInputStream(datos);
        	
        	
        	while(tuberiaDatos.available()>=0) {
        		lista.add((Order)tuberiaDatos.readObject());
        	}
     
        }catch(FileNotFoundException e){
        	System.out.println("Fichero no encontrado /"+e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println("FIN DE FICHERO2");
        } catch (IOException e) {
		}finally { 
            try {
				datos.close();
				tuberiaDatos.close();
			} catch (IOException e) {
	            System.out.println("problema al cerrar Stream"); 
			}
        			
    	}
		return lista;
	}
	
	public void generarXML() {

		try {

			XStream xs= new XStream();			
			ArrayList<Product> productos=readProducts();

			ArrayList<Order> ordes=readOrders();

			
			xs.setMode(xs.NO_REFERENCES);
			
			xs.alias("Productos",List.class);
			xs.alias("producto",Product.class);
    		
			xs.toXML(productos,new FileOutputStream("products.xml"));
			

			xs.alias("Ordes",List.class);
			xs.alias("orde",Order.class);
			
    		xs.toXML(ordes,new FileOutputStream("orders.xml"));
			
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	
	
	public static void main(String[] args) {
		XstreamClass r= new XstreamClass();
		//Genera dos archivos .xml de dos archivos .dat de productos y ordes
		r.generarXML();
	
	
	
	}
}
