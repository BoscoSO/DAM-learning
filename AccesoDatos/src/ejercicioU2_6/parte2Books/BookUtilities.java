package ejercicioU2_6.parte2Books;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.thoughtworks.xstream.XStream;


public class BookUtilities {
	
	
	public void generateBookDat() {
		
        String[] isbn = {"11111","22222","33333","44444","55555","66666"};
        String[] title = {"El picaro","Luna nueva","arroz","El quijote","Mates divertidas","Roma"};
        String[] author = {"Pedro Gomez","Abascal","Zapatero","Cervantes","Lozano","Cesar"};
		int[] year = {2010, 2018, 2006, 1605,2020, 600};
		boolean[] brrw= {true,true,false,true,false,false};
		Person[] readers= {new Person("Maria","010101A"),new Person("Juan","121212B"),new Person("Bosco","232323C"),
				new Person("Luis","343434D"),new Person("Elisa","454545E"),new Person("Antonio","565656F")};
        
		
		ArrayList<Book> lista= new ArrayList<Book>();

		ArrayList<String> n;

		Random r=new Random();
   	 
    	for(int i=0;i<isbn.length;i++) {
    		n= new ArrayList<String>();
    		int aux=0;
    		boolean salir=false, min=false;
    		
    		while(aux<4 || !salir) {
    			if(r.nextInt(2)==1) {
    				n.add(author[r.nextInt(6)]);
    				min=true;
    			}
    			if(aux>=4 && min) salir=true;
    			aux++;
    			
    		}
    		lista.add(new Book(isbn[i],title[i],n,year[i],brrw[i],readers[i]));
    	}
     
     		

		FileOutputStream datos = null;
    	
    	try{   		
    		datos=new FileOutputStream("books.dat");
    		ObjectOutputStream tuberiaDatos = new ObjectOutputStream(datos);

    		for(int i=0;i<lista.size();i++) {
        		tuberiaDatos.writeObject(lista.get(i));
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
	
	public void showBooks() {
		FileInputStream datos = null;
    	ObjectInputStream tuberiaDatos= null;
    	Book libro=null;
        try{
        	datos=new FileInputStream("books.dat");
        	tuberiaDatos= new ObjectInputStream(datos);
        	
        	
        	while(tuberiaDatos.available()>=0) {
        		libro=(Book)tuberiaDatos.readObject();
        		System.out.println(libro.toString());
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
	private ArrayList<Book> readBooksDat(){
		FileInputStream datos = null;
    	ObjectInputStream tuberiaDatos= null;
    	Book libro=null;
    	ArrayList<Book> lista=null;
        try{
        	datos=new FileInputStream("books.dat");
        	tuberiaDatos= new ObjectInputStream(datos);
        	lista= new ArrayList<Book>();
        	
        	while(tuberiaDatos.available()>=0) {
        		libro=(Book)tuberiaDatos.readObject();
        		lista.add(libro);
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

	public void generateXMLBookDom() {
	
		ArrayList<Book> lista=readBooksDat();
       
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation= builder.getDOMImplementation();
			
			
			Document doc=implementation.createDocument(null, "Books", null);
			
			doc.setXmlVersion("1.0");
			
			for(Book o:lista) {
				Element book= doc.createElement("Book");
				doc.getDocumentElement().appendChild(book);
				
					Element isbn= doc.createElement("isbn");
					book.appendChild(isbn);
					isbn.appendChild(doc.createTextNode(o.getIsbn()));
					
					Element title= doc.createElement("title");
					book.appendChild(title);
					title.appendChild(doc.createTextNode(o.getTitle()));
				
					Element year= doc.createElement("year");
					book.appendChild(year);
					year.appendChild(doc.createTextNode(o.getYear()));
					
				ArrayList<String> aux= o.getAuthors();
				
				if(aux.size()>1) {
					Element authors= doc.createElement("authors");
					book.appendChild(authors);
					
					for(String p: aux) {
						Element author= doc.createElement("author");
						authors.appendChild(author);
						author.appendChild(doc.createTextNode(p));
							
					}
				}else {
					Element author= doc.createElement("author");
					book.appendChild(author);
					author.appendChild(doc.createTextNode(aux.get(0)));
					
				}
				

					Element borrowd= doc.createElement("borrowed");
					book.appendChild(borrowd);
					borrowd.appendChild(doc.createTextNode(String.valueOf(o.isBorrowed())));
					
					Element reader= doc.createElement("reader");
					book.appendChild(reader);
					
					Person pers=o.getReader();
					
					Element nome= doc.createElement("name");
					reader.appendChild(nome);
					nome.appendChild(doc.createTextNode(pers.getName()));
					Element dni= doc.createElement("dni");
					reader.appendChild(dni);
					dni.appendChild(doc.createTextNode(pers.getDni()));
					
				
				
			}
	
	
			Source fonte = new DOMSource(doc); 
			
			Result resultado= new StreamResult(new File("bookDoom.xml"));
			
		    Transformer transformador = TransformerFactory.newInstance().newTransformer();
		    transformador.transform(fonte,resultado);

			
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	
	public void generateXMLBookXstream() {
		ArrayList<Book> lista=readBooksDat();
		try {

			XStream xs= new XStream();			
			

			
			xs.setMode(xs.NO_REFERENCES);
			xs.alias("Books",List.class);
			xs.alias("Book",Book.class); 
			xs.alias("author", String.class);
    		xs.toXML(lista,new FileOutputStream("bookXstream.xml"));
			

			
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	//******************************************************************//

//	public void generarJSON() {
//		ArrayList<Book> lista=readBooksDat();
//		
//		FileOutputStream datos = null;
//    	
//    	try{   		
//    		datos=new FileOutputStream("books.json");
//    		ObjectOutputStream tuberiaDatos = new ObjectOutputStream(datos);
//    		String str="";
//    		for(int i=0;i<lista.size();i++) {
//    			str=lista.toJsonString();
//        		tuberiaDatos.writeChars(str);
//    		}
//    		
//    		tuberiaDatos.close();
//    		datos.close();
//			
//		
//		
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}			
//	}

	
}
