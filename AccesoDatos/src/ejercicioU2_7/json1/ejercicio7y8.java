package ejercicioU2_7.json1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.thoughtworks.xstream.XStream;

import ejercicioU2_7.order.Client;
import ejercicioU2_7.order.Order;
import ejercicioU2_7.order.OrderRow;
import ejercicioU2_7.order.Product;

public class ejercicio7y8 {

	private JSONArray getArrayOrderRows() {
		JSONObject value= new JSONObject();
		
		
		JSONObject product1= new JSONObject();
			
			value.put("id", "2");
			value.put("productName", "Silla");
			value.put("description", "es una silla");
			value.put("picture", "/silla.png");
			value.put("price", "60");
			
		product1.put("product", value);
		product1.put("amount", 2);
		product1.put("price", 2*60);
		
		JSONObject orderRow1= new JSONObject();
		orderRow1.put("OrderRow", product1);
		
		/**************************/
		JSONObject product2= new JSONObject();
		value= new JSONObject();
			value.put("id", "2");
			value.put("productName", "Cama");
			value.put("description", "es una cama");
			value.put("picture", "/cama.png");
			value.put("price", "120");


		product2.put("product", value);
		product2.put("amount", 1);
		product2.put("price", 1*120);
		
		JSONObject orderRow2= new JSONObject();
		orderRow2.put("OrderRow", product2);
		/**************************/
		JSONObject product3= new JSONObject();
		value= new JSONObject();
			value.put("id", "2");
			value.put("productName", "Mesa");
			value.put("description", "es una mesa");
			value.put("picture", "/mesa.png");
			value.put("price", "40");
			
		product3.put("product", value);
		product3.put("amount", 3);
		product3.put("price", 3*40);
		
		JSONObject orderRow3= new JSONObject();
		orderRow3.put("OrderRow", product3);
		
		
		
		JSONArray arrai=new JSONArray();
		arrai.add(orderRow1);
		arrai.add(orderRow2);
		arrai.add(orderRow3);
		return arrai;
		
	}
	public void generarJSONOrders() {
		
		try {
			JSONObject cliente= new JSONObject();
			cliente.put("DNI", "123456");
			cliente.put("name", "PACO");
			cliente.put("surname", "Fernandez");
			
			
			JSONArray array=getArrayOrderRows();
			
			JSONObject padre= new JSONObject();
			JSONObject value= new JSONObject();
			
		
			value.put("id", 1);
			value.put("Client", cliente);
			value.put("orderRows", array);
			value.put("price", 360);
			value.put("delivered", false);
			
			padre.put("order",value);
			
			FileWriter fw=new FileWriter("orders.json");
			fw.write(padre.toJSONString());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void readJsonOrders(){

		try (FileReader fr = new FileReader("orders.json")){

			JSONParser parser = new JSONParser();

	        JSONObject orders =  (JSONObject) parser.parse(fr);
	        
	        JSONObject order =  (JSONObject) orders.get("order");
	        
	        String id="\tid : "+String.valueOf((Long) order.get("id"))+"\n";

	        JSONObject client=(JSONObject) order.get("Client");
	        
	        	String clientInfo="\tClient:\n"+
	        			"\t\tsurname : "+(String)client.get("surname")+"\n"+
	        	 		"\t\tname : "+(String)client.get("name")+"\n"+
	        			"\t\tdni : "+(String)client.get("DNI")+"\n";
	        

		    JSONArray arr=(JSONArray) order.get("orderRows");
		    JSONObject orderRow;
		    String rows = "\tOrderRows : \n";
		    for(int i=0;i<arr.size();i++) {
		    	orderRow=(JSONObject) arr.get(i);
		    	JSONObject aux=(JSONObject)orderRow.get("OrderRow"); 
		    	JSONObject product=(JSONObject)aux.get("product"); 
		    	rows+="\t   row : "+(i+1)+"\n\t\tProduct:\n"+
	        			"\t\t\tid : "+(String)product.get("id")+"\n"+
	        	 		"\t\t\tproductName : "+(String)product.get("productName")+"\n"+
	        	 		"\t\t\tdescription : "+(String)product.get("description")+"\n"+
	        	 		"\t\t\tpicture : "+(String)product.get("picture")+"\n"+
	        	 		"\t\t\tprice : "+(String)product.get("price")+"\n";
		    	rows+="\t\tamount : "+String.valueOf((Long)aux.get("amount"))+"\n";
		    	rows+="\t\tprice : "+String.valueOf((Long)aux.get("price"))+"$\n";
		    }

	        String price="\tprice : "+String.valueOf((Long) order.get("price"))+"$\n";
	        
	        String delivered="\tdelivered :"+(boolean) order.get("delivered")+"\n";
	        
	        
	        

	        String principal="Order :\n"+id+clientInfo+rows+price+delivered;
	        
	        
	        System.out.println(principal);
	       
		
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private Order readObjectJSONOrders() {
		try (FileReader fr = new FileReader("orders.json")){

			JSONParser parser = new JSONParser();

	        JSONObject orders =  (JSONObject) parser.parse(fr);
	        
	        JSONObject order =  (JSONObject) orders.get("order");
	        

	        JSONObject client=(JSONObject) order.get("Client");

		    JSONArray arr=(JSONArray) order.get("orderRows");
		    JSONObject orderRow;
		    
		    Product pr;
	    	OrderRow or;
	    	ArrayList<OrderRow> orderRows=new ArrayList<OrderRow>();
		    
		    for(int i=0;i<arr.size();i++) {
		    	orderRow=(JSONObject) arr.get(i);
		    	JSONObject aux=(JSONObject)orderRow.get("OrderRow"); 
		    	JSONObject product=(JSONObject)aux.get("product"); 
		    	
		    	pr=new Product(Integer.valueOf((String)product.get("id")),(String)product.get("productName"),(String)product.get("description"),(String)product.get("picture"),Double.valueOf((String)product.get("price")));
	        			
		    	or = new OrderRow(pr,(Long)aux.get("amount"));
		    	orderRows.add(or);
		    }

        	Client cl=new Client((String)client.get("name"),(String)client.get("surname"),(String)client.get("DNI"));

        	long id=(long) order.get("id");	        
	        boolean delivered=(boolean) order.get("delivered");

	        fr.close();
	        return new Order(id, cl, orderRows, delivered);
	        

	       
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public void generarOrdersDAT() {
	
    	
    	try(FileOutputStream datos =new FileOutputStream("orders.dat")){   		
    		ObjectOutputStream tuberiaDatos = new ObjectOutputStream(datos);

        	tuberiaDatos.writeObject(readObjectJSONOrders());
    		
    		
    		tuberiaDatos.close();
    		datos.close();
    		
    	
    	}catch(FileNotFoundException e) {
    		System.out.println("Fichero no encontrado /"+e.getMessage());
    	}catch(IOException e) {
    		e.printStackTrace();
    		System.out.println("guardarDatos :"+e.getMessage());
    	}
    			
    	
               
	}

	public void generarOrdersXML() {
		try {

			XStream xs= new XStream();			


			
			xs.setMode(xs.NO_REFERENCES);
			
			xs.alias("OrderRows",List.class);
			xs.alias("Product",Product.class);
			xs.alias("Client",Client.class);
			xs.alias("OrderRow",OrderRow.class);
			xs.alias("Order",Order.class);
    		
			xs.toXML(readObjectJSONOrders(),new FileOutputStream("orders.xml"));
			

			
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void readOrdersDat() {
		FileInputStream datos = null;
    	ObjectInputStream tuberiaDatos= null;
    	Order bd=null;
        try{
        	datos=new FileInputStream("orders.dat");
        	tuberiaDatos= new ObjectInputStream(datos);
        	
        	
        	while(tuberiaDatos.available()>=0) {
        		bd=(Order)tuberiaDatos.readObject();
        		System.out.println(bd.toString());
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
	}
	
	public static void main(String[] args) {
		ejercicio7y8 main=new ejercicio7y8();

        System.out.println("***************generarJSONOrders********************");
		main.generarJSONOrders();
		System.out.println("***************readJsonOrders********************");
		main.readJsonOrders();		
		System.out.println("***************generarOrdersXML********************");
		main.generarOrdersXML();
		System.out.println("***************generarOrdersDAT********************");
		main.generarOrdersDAT();
		System.out.println("***************readOrdersDat********************");
		main.readOrdersDat();
	}
}
