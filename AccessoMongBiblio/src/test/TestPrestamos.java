package test;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import dto.Cliente;
import dto.Enderezo;
import dto.Libro;
import dto.Prestamo;
import ope.Operacions;

public class TestPrestamos {

	
	
	public static void main(String[] args) {
		
		Operacions ope=new Operacions();
		
		try {
			ope.abrirConexion("biblioteca");
			
			
			/***************************AHORA PRESTAMOS******************************/
		
			//primero cogemos el cliente que va a solicitar el libro
			ope.setNomeCollection("cliente");

			//Clientes disponibles
			System.out.println("\n Clientes disponibles \n");
			ope.list().forEach(System.out::println);	

			//recuperamos e formamos al cliente a partir de sus datos en la DB
			Cliente client=ope.getClienteFromDoc(ope.getDoc("nome", "Ana"));

			
			
			//Ahora necesitamos el libro a solicitar
			ope.setNomeCollection("libro");
			
			//Libros disponibles
			System.out.println("\n Libros disponibles \n");
			ope.list().forEach(System.out::println);	

			//Recuperamos el Libro a partir de sus datos en la DB
			Libro libro =ope.getLibroFromDoc(ope.getDoc("titulo", "El Quijote"));
			

			
			//Creamos la coleccion prestamo
//			ope.createCollection("prestamo");
			//indicamos la coleccion que usamos
			ope.setNomeCollection("prestamo");
			
			//Formamos o prestamo a partir de los datos recopilados hasta ahora e o añadimos 
			Prestamo p=new Prestamo("1/02/2021",client, libro);
			ope.addDoc(p.toDocument());
		
			//Mostrmos o documento
			Document d=ope.getDoc("data", "1/02/2021");
			System.out.println("\nDocumento buscado :\n - "+d.toString());
			
			//modificamos o documento
			ope.modifyDoc("data", "1/02/2021", "data","01/02/2021");			


			//Listamos o contido
			System.out.println("\n Listado \n");
			ope.list().forEach(System.out::println);	
			
			long res=ope.delDocs("data", "01/02/2021");
			System.out.println("\n"+res+ " -elementos borrados");
			
			
			//Listamos o contido
			System.out.println("\n Listado \n");
			ope.list().forEach(System.out::println);		
			
			
			ope.cerrarConexion();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
