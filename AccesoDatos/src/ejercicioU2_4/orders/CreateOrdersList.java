package ejercicioU2_4.orders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;


public class CreateOrdersList {
	
	public ArrayList<Product> createProductList() {
		
		int[] id = {123, 456, 789, 235, 567};
        String[] dc = {"coffee","milk","rice","salt","cocoa"};
        double[] pr = {1.22, 1.05, 1, 1.25, 3.2};
        
		ArrayList<Product> lista= new ArrayList<Product>();
        Random r=new Random();
    	for(int i=0;i<id.length;i++) {
    			
    		lista.add(new Product(id[i],dc[r.nextInt(5)],(float)pr[r.nextInt(5)]));
    	}
    	return lista;
	}
	public void storeProducts(ArrayList<Product> listaOrdes) {
		FileOutputStream datos = null;
    	
    	try{   		
    		datos=new FileOutputStream("products.dat");
    		ObjectOutputStream tuberiaDatos = new ObjectOutputStream(datos);

    		for(int i=0;i<listaOrdes.size();i++) {
        		tuberiaDatos.writeObject(listaOrdes.get(i));
    		}
    		
    		tuberiaDatos.close();
    		datos.close();
    		
    	
    	}catch(FileNotFoundException e) {
    		System.out.println("Fichero no encontrado /"+e.getMessage());
    	}catch(IOException e) {
    		e.printStackTrace();
    		System.out.println("guardarDatos :"+e.getMessage());
    	}
    			
    	
               
	}

	
	public ArrayList<Order> createOrderList() {
		ArrayList<Order> lista=new ArrayList<Order>();
		lista.add(new Order(555,"Juan"));
		lista.add(new Order(999,"Pepe"));
		lista.add(new Order(666,"Luis"));
		return lista;
	}
	public void storeOrders(ArrayList<Order> listaOrdes) {
		FileOutputStream datos = null;
    	
    	try{   		
    		datos=new FileOutputStream("orders.dat");
    		ObjectOutputStream tuberiaDatos = new ObjectOutputStream(datos);

    		for(int i=0;i<listaOrdes.size();i++) {
        		tuberiaDatos.writeObject(listaOrdes.get(i));
    		}
    		
    		tuberiaDatos.close();
    		datos.close();
    		
    	
    	}catch(FileNotFoundException e) {
    		System.out.println("Fichero no encontrado /"+e.getMessage());
    	}catch(IOException e) {
    		e.printStackTrace();
    		System.out.println("guardarDatos :"+e.getMessage());
    	}
    			
    	
               
	}
	public void readOrdersXML_V2() throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder db = dbf.newDocumentBuilder();
	
		Document doc=db.parse(new File("orders.xml"));
		
		NodeList orders=doc.getElementsByTagName("Order");
		
		for(int i=0;i<orders.getLength();i++) {
			System.out.println("Order");
			Node n=orders.item(i);
			NodeList nds =n.getChildNodes();
			
			for(int c=0;c<nds.getLength();c++) {
				Node aux=nds.item(c);
				Element eee=(Element) aux;
				
				if(eee.getTagName()=="Products") {
					System.out.println("\t"+eee.getTagName()+":");
					NodeList nds2 =aux.getChildNodes();
					
					for(int z=0;z<nds2.getLength();z++) {
						
						Node aux2=nds2.item(z);
						Element eee2=(Element) aux2;
						System.out.println("\t\t"+eee2.getTagName()+": ");
						NodeList nds3 =aux2.getChildNodes();
						for(int y=0;y<nds3.getLength();y++) {
							Node aux3=nds3.item(y);
							Element eee3=(Element) aux3;
							System.out.println("\t\t\t"+eee3.getTagName()+": "+eee3.getTextContent());
						}
					}
					
				}else				
					System.out.println("\t"+eee.getTagName()+": "+eee.getTextContent());
			}
			
			
			
			
		}
		
	}
	public void readOrdersXML() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder db = dbf.newDocumentBuilder();
	
		Document doc=db.parse(new File("orders.xml"));
		elementsRecursivo(doc.getDocumentElement(),"");
		
		
	}
	public void elementsRecursivo(Element elemento, String tabs) {//añadir variable String tab y ir sumando \t`s
		
		NodeList list= elemento.getChildNodes();
		
		for(int i=0;i<list.getLength();i++) {
			Node n=list.item(i);
			
			String aux="";
			
			switch (n.getNodeType()){
			 			 	
			 	case Node.ELEMENT_NODE:{ 
						Element e=(Element)n;
						if(e.getTagName().equals("Products")) {
							System.out.println(tabs+ e.getTagName()+": ");
						}else
							if(e.getTagName().equals("Product")) {
								System.out.println(tabs+ e.getTagName()+": ");
							}else
								System.out.print(tabs+ e.getTagName()+": ");
							
						elementsRecursivo(e,tabs+"\t");
				 		}
				 break;
			 	case Node.TEXT_NODE:{ 
			 			Text t=(Text)n;
			 			aux= t.getWholeText();
			 			System.out.println(aux);
			 		}
			 	break; 
				 
			 } 
			 
		}
		
	}
	
	public void readOrdersFile() {
		FileInputStream datos = null;
    	ObjectInputStream tuberiaDatos= null;
    	Order bd=null;
        try{
        	datos=new FileInputStream("orders.dat");
        	tuberiaDatos= new ObjectInputStream(datos);
        	
        	
        	while(tuberiaDatos.available()>=0) {
        		bd=(Order)tuberiaDatos.readObject();
        		System.out.println(bd);
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
	public void createOrderXML(ArrayList<Order> listaOrdes) {
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation= builder.getDOMImplementation();
			
			
			Document doc=implementation.createDocument(null, "Orders", null);
			
			doc.setXmlVersion("1.0");
			
			for(Order o:listaOrdes) {
				Element orden= doc.createElement("Order");
				doc.getDocumentElement().appendChild(orden);
				
				Element id= doc.createElement("id");
				orden.appendChild(id);
				id.appendChild(doc.createTextNode(o.getIdOrder()));
				
				Element client= doc.createElement("clientName");
				orden.appendChild(client);
				client.appendChild(doc.createTextNode(o.getClientName()));
				
				Element products= doc.createElement("Products");
				orden.appendChild(products);
				
				for(Product p: o.getLista()) {
					Element product= doc.createElement("Product");
					products.appendChild(product);

					Element idProduct= doc.createElement("idProduct");
					product.appendChild(idProduct);
					idProduct.appendChild(doc.createTextNode(p.getIdProduct()));
					Element descripcion= doc.createElement("Description");
					product.appendChild(descripcion);
					descripcion.appendChild(doc.createTextNode(p.getDescription()));
					Element price= doc.createElement("Price");
					product.appendChild(price);
					price.appendChild(doc.createTextNode(p.getPrice()));
				}
			}
	
	
			Source fonte = new DOMSource(doc); 
			
			Result resultado= new StreamResult(new File("orders.xml"));
			
		    Transformer transformador = TransformerFactory.newInstance().newTransformer();
		    transformador.transform(fonte,resultado);
			
			} catch (Exception ex) {
			System.out.println("Error! The XML document could not be loaded.");
		      ex.printStackTrace();
			} 
	}
	

}
