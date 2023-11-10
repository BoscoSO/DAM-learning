package test0;


import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.*;
import static com.mongodb.client.model.Updates.*;
import java.util.ArrayList;

import javax.print.Doc;


public class Test0 {

	public static void main(String[] args) {
		 try {
	        	//Crear conexion
	            MongoClient mongoClient = new MongoClient("192.168.56.102");
	            MongoDatabase db = mongoClient.getDatabase("miDB");
	    	    
	    	    //Engadir unha colecci�n
	    	    //db.createCollection("coleccionExemplo");
	    	    
	    	    //engadir un documento
//	            Document unDoc= new Document()
//	            		.append("titulo", "Exemplo1")
//	            		.append("valor", 30);
//	            db.getCollection("coleccionExemplo").insertOne(unDoc);
	            	
	    	    //engadir un doc pero con un array
	          /*  ArrayList<Document> alumnos =new ArrayList<Document>();
	            Document alumno1= new Document()
	            		.append("dni", "23452111A")
	            		.append("nome", "Pedro")
	            		.append("apelidos", "Suarez")
	            		.append("idade", 33);
	            alumnos.add(alumno1);
	            Document alumno2= new Document()
	            		.append("dni", "2352235S")
	            		.append("nome", "Carlos")
	            		.append("apelidos", "Barro")
	            		.append("idade", 23);
	            alumnos.add(alumno2);
	            
	            //GrupoAlumnos
	            Document grupo= new Document()
	            		.append("id", 13)
	            		.append("Grupo", "2DAM")
	            		.append("mesas", "4")
	            		.append("alumnos", alumnos);
	            db.getCollection("coleccionExemplo").insertOne(grupo);
	            */
	            //get listados  ###############OK
	            ArrayList<Document> listado= db.getCollection("coleccionExemplo").find().into(new ArrayList<Document>());
	            System.out.println("LISTA");
	            listado.forEach(System.out::println);
	            
	          //get first###############OK
	            Document doc3 = db.getCollection("coleccionExemplo").find(eq("id",13)).first();
	            System.out.println("Documento buscado\n"+doc3);
	            
	            //Listado ordenado###############OK
	            listado= db.getCollection("coleccionExemplo")
	            		.find()
	            		.sort(Sorts.descending("id"))
	            		.into(new ArrayList<Document>());
	            
	            System.out.println("LISTADO:");
	    			for (Document documento:listado)
	    				System.out.println(documento);
	    			
	    			//Modificar documento
	    			UpdateResult resultado = db.getCollection("coleccionExemplo").updateOne(eq("id",20),combine(set("Grupo","2 ASIR")));
	    			System.out.println("N�mero de documentos modificados: "+resultado.getModifiedCount());
	    			
	    			//Busca con condicion
	    			Document documento4 = db.getCollection("coleccionExemplo").find(eq("id",20)).first();
	    			System.out.println("Documento buscado: "+documento4);
	    			
	     
	            
	            //Cerrar conexion
	            mongoClient.close();
	        } catch (Exception erro) {
	            System.out.println("Erro no main: "+erro.getMessage());
	        }// TODO Auto-generated method stub

	}

}
