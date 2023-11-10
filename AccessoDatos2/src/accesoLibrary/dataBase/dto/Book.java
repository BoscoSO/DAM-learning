package accesoLibrary.dataBase.dto;

public class Book {

	private static int idContador=1;
	private int idBook;
	private String code;
	private String title;
	private String authors;
	private String year;

	
	public Book(int idBook, String code, String title, String authors, String year) {
		super();
		this.idBook = idBook;
		this.code = code;
		this.title = title;
		this.authors = authors;
		this.year = year;
	}


	public static int getIdContador() {
		return idContador;
	}


	public int getIdBook() {
		return idBook;
	}


	public String getCode() {
		return code;
	}


	public String getTitle() {
		return title;
	}


	public String getAuthors() {
		return authors;
	}


	public String getYear() {
		return year;
	}


	public String toString() {
		return "ID Book: "+idBook+"\n"+
				"code: "+code+"\n"+
				"title: "+title+"\n"+
				"authors: "+authors+"\n"+
				"year"+year+"\n";
	}
	
}
