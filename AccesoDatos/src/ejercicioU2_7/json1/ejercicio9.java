package ejercicioU2_7.json1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.thoughtworks.xstream.XStream;

import ejercicioU2_7.clientes.Address;
import ejercicioU2_7.clientes.Client;

public class ejercicio9 {
	private ArrayList<Client> clientes= new ArrayList<Client>();
	
	private JSONArray getArrayAdress() {
		
		
		JSONObject product1= new JSONObject();
		
		product1.put("street", "Nova");
		product1.put("number", (int)2);
		product1.put("postalCode", (int)15755);
		
		JSONObject clientRow1= new JSONObject();
		clientRow1.put("address", product1);
		
		/**************************/
		JSONObject product2= new JSONObject();

		product2.put("street", "Pelamios");
		product2.put("number", (int)15);
		product2.put("postalCode", (int)15756);
		
		JSONObject clientRow2= new JSONObject();
		clientRow2.put("address", product2);
		/**************************/
		JSONObject product3= new JSONObject();
			

		product3.put("street", "Avda. Ferrol");
		product3.put("number", (int)24);
		product3.put("postalCode", (int)15754);
		
		JSONObject clientRow3= new JSONObject();
		clientRow3.put("address", product3);
		
		
		
		JSONArray arrai=new JSONArray();
		arrai.add(clientRow1);
		arrai.add(clientRow2);
		arrai.add(clientRow3);
		return arrai;
		
	}
	public void generarJSONOrders() {
		String[] dni= {"11111","22222","33333","44444"};
		String[] name= {"Pedro","Juan","Cristina","Luis"};

		String[] surname= {"apelido1","apelido2","apelido3","apelido4"};
		try {
			JSONObject cliente= null;
			JSONObject value;
			JSONArray padre=new JSONArray();

			for(int i=0;i<dni.length;i++) {
				cliente= new JSONObject();
				value= new JSONObject();
				
				value.put("DNI", dni[i]);
				value.put("name", name[i]);
				value.put("surname", surname[i]);
				value.put("Adresses", getArrayAdress());
				
	
				cliente.put("Client",value);
				
				padre.add(cliente);
				
			}
			
			FileWriter fw=new FileWriter("Clients.json");
			fw.write(padre.toJSONString());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void readJsonClients(){

		try (FileReader fr = new FileReader("Clients.json")){

			JSONParser parser = new JSONParser();

	        JSONArray princ=(JSONArray)  parser.parse(fr);
	        
	        String principal="Clients :\n";
	        
	        for(int i=0;i<princ.size();i++) {
	        	
	        
		        JSONObject clientPre =  (JSONObject) princ.get(i);

		        JSONObject client =  (JSONObject) clientPre.get("Client");
		        
		        String name="\tname : "+(String)client.get("name")+"\n";
	
		        String surname="\tsurname : "+(String) client.get("surname")+"\n";
	
		        String dni="\tdni : "+(String) client.get("DNI")+"\n";
	
			     
		        
	
			    JSONArray arr=(JSONArray) client.get("Adresses");
			    JSONObject clientRow;
			    String rows = "\tAdresses : \n";
			    for(int c=0;c<arr.size();c++) {
			    	clientRow=(JSONObject) arr.get(c);
			    	JSONObject aux=(JSONObject)clientRow.get("address"); 
			    	rows+="\t\tAdress "+(c+1)+"\n";
			    	rows+="\t\t   number : "+String.valueOf((Long)aux.get("number"))+"\n";
			    	rows+="\t\t   street : "+(String)aux.get("street")+"\n";
			    	rows+="\t\t   postalCode : "+String.valueOf((Long)aux.get("postalCode"))+"\n";
			    }
			    String clientString="   Client :\n"+name+surname+dni+rows;
			    
			    principal+=clientString;
	        }
	        
	        
		 
	        
		 
	        
	        
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

	public void storeJsonContent(){

		ArrayList<Client> clientesAux = new ArrayList<Client>();
		
		try (FileReader fr = new FileReader("Clients.json")){
			JSONParser parser = new JSONParser();

	        JSONArray princ=(JSONArray)  parser.parse(fr);
	        
	        String principal="Clients :\n";
	        
	        for(int i=0;i<princ.size();i++) {
	        	
	        
		        JSONObject clientPre =  (JSONObject) princ.get(i);

		        JSONObject client =  (JSONObject) clientPre.get("Client");

		        String name=(String)client.get("name");
	
		        String surname=(String) client.get("surname");
	
		        String dni=(String) client.get("DNI");
	
			    JSONArray arr=(JSONArray) client.get("Adresses");
			    JSONObject clientRow;
			    ArrayList<Address> addresses=new ArrayList<Address>();
			    Address add;
			    
			    for(int c=0;c<arr.size();c++) {
			    	clientRow=(JSONObject) arr.get(c);
			    	JSONObject aux=(JSONObject)clientRow.get("address"); 
			    	
			    	String number =String.valueOf((Long)aux.get("number"));
			    	String street =(String)aux.get("street");
			    	String  postalCode =String.valueOf((Long)aux.get("postalCode"));
			    	
			    	add=new Address(Integer.valueOf(postalCode),street,Integer.valueOf(number));
			    	addresses.add(add);
			    }
		    	clientesAux.add(new Client(Integer.valueOf(dni), name, surname, addresses));
	        }
		    clientes=clientesAux;
	        
	       
		
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public void generarClienteDAT() {
		FileOutputStream datos = null;
	    	
	    	try{   		
	    		datos=new FileOutputStream("clientes.dat");
	    		ObjectOutputStream tuberiaDatos = new ObjectOutputStream(datos);

	        	tuberiaDatos.writeObject(clientes);
	    		
	    		
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
				
				xs.alias("Adresses",List.class);
				xs.alias("Address",Address.class);
				xs.alias("Client",Client.class);
	    		
				xs.toXML(clientes,new FileOutputStream("clientsXStream.xml"));
				

				
			
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
	public void generateOrdersXMLDom() {


       
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation= builder.getDOMImplementation();
			
			
			Document doc=implementation.createDocument(null, "Clients", null);
			
			doc.setXmlVersion("1.0");
			
			for(Client c:clientes) {
				Element client= doc.createElement("Client");
				doc.getDocumentElement().appendChild(client);
				
					
					client.setAttribute("dni", String.valueOf(c.getDni()));
					client.setAttribute("name", c.getName());;
					client.setAttribute("surname", c.getSurname());;
				
				for(Address a: c.getAdresses()) {
					
					
					Element adress= doc.createElement("address");
					client.appendChild(adress);
					
					
					adress.setAttribute("postalCode", String.valueOf(a.getPostalCode()));
					
					Element street= doc.createElement("street");
					adress.appendChild(street);
					street.appendChild(doc.createTextNode(a.getStreet()));
					
					Element number= doc.createElement("number");
					adress.appendChild(number);
					number.appendChild(doc.createTextNode(String.valueOf(a.getNumber())));
				
						
				}
				
				
			}
	
			Source fonte = new DOMSource(doc); 
			
			Result resultado= new StreamResult(new File("Clients.xml"));
			
		    Transformer transformador = TransformerFactory.newInstance().newTransformer();
		    transformador.transform(fonte,resultado);

		    
		    // Eliminamos address e creamos otro

			deleteElementsbyTag("address",doc);
			Source fonte2 = new DOMSource(doc); 
			
			Result resultado2= new StreamResult(new File("ClientsNoAddress.xml"));
			
		    Transformer transformador2 = TransformerFactory.newInstance().newTransformer();
		    transformador2.transform(fonte2,resultado2);
			
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void deleteElementsbyTag(String tagName,Document doc) {
		
		NodeList lis=doc.getElementsByTagName(tagName);
		while(lis.getLength()>0) {
			Element e=(Element)lis.item(0);
			Element pa=(Element)e.getParentNode();
			pa.removeChild(e);
		}
		
	}
	
	public static void main(String[] args) {
		ejercicio9 a=new ejercicio9();
		
		a.generarJSONOrders();
		a.readJsonClients();
		a.storeJsonContent();
		a.generarClienteDAT();
		a.generarOrdersXML();
		
//		genera ambos xml con y sin address
		a.generateOrdersXMLDom();
	}


}
