package dto;

import java.util.List;

import org.bson.Document;

public class Libro {

	private String isbn;
	private String titulo;
	private List<String> autores;

	public Libro(String isbn, String titulo, List<String> autores) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autores = autores;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<String> getAutores() {
		return autores;
	}
	public void setAutores(List<String> autores) {
		this.autores = autores;
	}

	
	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autores=" + autores + "]";
	}
	
	public Document toDocument() {
		Document enderezo= new Document()
         		.append("isbn", isbn)
         		.append("titulo", titulo)
         		.append("autores", autores);
        
		return enderezo;
	}
	
}
