package test;

import java.util.ArrayList;

import org.bson.Document;

import dto.Cliente;
import dto.Enderezo;
import dto.Libro;
import ope.Operacions;

public class TestCliente {
	
	
	
	public static void main(String[] args) {
	
		Operacions ope=new Operacions();
		
		try {
			ope.abrirConexion("biblioteca");
			
			
			/***************************AHORA CLIENTES******************************/
			
			//Creamos coleccion cliente
//			ope.createCollection("cliente");
			//indicamos a coleccion que usamos (createCollection ya lo inicializa)
			ope.setNomeCollection("cliente");
			
			//Añadimos o contido de cliente
//			ArrayList<Cliente> list = getClientes(1);
//			for(Cliente c:list) {
//				ope.addDoc(c.toDocument());
//			}
			
			//Buscamos o documento con nome Luis			
			Document d=ope.getDoc("nome", "Luis");
		
			System.out.println("Documento buscado :\n - "+d.toString()+"\n");
			
			//modificamos o cliente Luis
			ope.modifyDoc("nome", "Luis", "dni", "2345254A");
		
			//Lo volvemos a mostrar			
			d=ope.getDoc("nome", "Luis");
		
			System.out.println("Documento buscado :\n - "+d.toString());
		
			//Probamos a borrar o documento adquirido
//			long res=ope.delDoc(d);
//			
//			if(res==1) 
//				System.out.println("Documento borrado");
//			else 
//				System.out.println("Documento no borrado");
			
				
			//mostramos o contido de cliente ordenado por nome de manera adcendente
			System.out.println("\n Listado ordenado \n");
			ope.list("nome", 1).forEach(System.out::println);			
			
			/****************************AHORA LIBROS*******************************/
			
			//Creamos coleccion cliente
//			ope.createCollection("libro");

			//indicamos a coleccion a usar 
			ope.setNomeCollection("libro");

			//Añadimos o contido á coleccion libro
			ArrayList<Libro> lista = getLibros(1);
			for(Libro l:lista) {
				ope.addDoc(l.toDocument());
			}
			
			
			//Buscamos un libro
			Document doc2=ope.getDoc("titulo", "El Quijote");
			System.out.println("\nDocumento buscado :\n - "+doc2.toString());

			//modificamos un libro
			ope.modifyDoc("titulo", "El Quijote", "isbn","7777-777-77");
			
			//Lo volvemos a mostrar			
			doc2=ope.getDoc("titulo", "El Quijote");
			System.out.println("Documento buscado :\n - "+doc2.toString());
			
			//Probamos a borrar o documento adquirido
//			long res=ope.delDoc(doc2);
//			
//			if(res==1) 
//				System.out.println("Documento borrado");
//			else 
//				System.out.println("Documento no borrado");
			
			//listamos o contenido de manera ordenada (por isbn en orden descendente)
			System.out.println("\n Listado \n");
			ope.list("isbn", 0).forEach(System.out::println);		
			
			ope.cerrarConexion();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private static ArrayList<Libro> getLibros(int i) {
		
		ArrayList<Libro> lista=new ArrayList<Libro>();
		if(i==1) {
			lista.add(new Libro("1111-222-12", "Los tres cerditos",getAutores(1)));
			lista.add(new Libro("3333-444-34", "Caperucita roja",getAutores(2)));
			lista.add(new Libro("5555-666-56", "El Quijote",getAutores(0)));
		}else {
			lista.add(new Libro("7777-888-78", "Lazarillo de Tormes",getAutores(2)));
			lista.add(new Libro("9999-000-90", "Firgoas",getAutores(1)));
		}
		return lista;
	}
	
	private static  ArrayList<String> getAutores(int i) {

		ArrayList<String> lista=new ArrayList<String>();
		if(i==1) {
			lista.add("Jhon Writter");
			lista.add("Edan Reader");
			lista.add("Sue Pages");
		}else if(i==0) {
			lista.add("Cervantes");
			
		}else {
			lista.add("Mary Books");
			lista.add("Tuli Pan");
			
		}
		return lista;
	}

	private static ArrayList<Cliente> getClientes(int i) {
		
		ArrayList<Cliente> lista=new ArrayList<Cliente>();
		if(i==1) {
			lista.add(new Cliente("4592462D", "Antonio", "Martinez",getEnderezos(1)));
			lista.add(new Cliente("4592462D", "Luis", "Suarez", getEnderezos(2)));
			lista.add(new Cliente("4592462D", "Ana", "Garcia", getEnderezos(0)));
		}else {
			lista.add(new Cliente("4592462D", "Pedro", "Perez", getEnderezos(0)));
			lista.add(new Cliente("5135134S", "Juan", "Pazos", getEnderezos(1)));
			lista.add(new Cliente("5624587A", "Maria", "Zapatero", getEnderezos(2)));
			lista.add(new Cliente("8654216K", "Teresa", "Lagos", getEnderezos(1)));
		}
		return lista;
	}
	
	private static ArrayList<Enderezo> getEnderezos(int i) {
		
		ArrayList<Enderezo> lista=new ArrayList<Enderezo>();
		if(i==1) {
			lista.add(new Enderezo("Horreo",32, "Santiago", "A Coru�a"));
			lista.add(new Enderezo("Carabel",11, "A Coru�a", "A Coru�a"));
		}else if(i==2) {
			lista.add(new Enderezo("Felipe",23, "Orense", "Orense"));
			lista.add(new Enderezo("Zapatero",23, "Madrid", "Madrid"));
			lista.add(new Enderezo("Horreo",62, "Baiona", "Pontevedra"));
		}else {

			lista.add(new Enderezo("laranxas",88, "O Eixo", "Coru�a"));
		}
		return lista;
	}
}
