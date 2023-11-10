package ejercicioU2_6.parte2Books;

import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String isbn;
	private String title;
	private int year;
	private ArrayList<String> authors;
	private boolean borrowed;
	private Person reader;
	
	
	public Book(String isbn, String title, ArrayList<String> authors, int year, boolean borrowed, Person reader) {
		this.isbn = isbn;
		this.title = title;
		this.authors = authors;
		this.year = year;
		this.borrowed = borrowed;
		this.reader = reader;
	}
	
	public String getIsbn() {
		return isbn;
	}


	public String getTitle() {
		return title;
	}


	public ArrayList<String> getAuthors() {
		return authors;
	}


	public String getYear() {
		return String.valueOf(year);
	}


	public boolean isBorrowed() {
		return borrowed;
	}


	public Person getReader() {
		return reader;
	}


	public String toString() {
		String cadena= "|Title: "+title+"\n|ISBN: "+isbn;
		String tab="";
		if(authors.size()>1) {
			cadena+="\n|Authors:\n";
			tab="|\t-";
		}else cadena+="\n|Author: ";
		

		for(String c:authors)
			cadena+=tab+c+"\n";
		cadena+="|Year : "+year+"\n";
		cadena+="|Borrowed : "+borrowed+"\n";
		cadena+="|Reader : "+reader.getName()+"\n"+"\n";
		return cadena;
	}
	
}
