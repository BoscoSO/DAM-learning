package accesoLibrary.dataBase.dto;

import java.sql.Date;

public class Loan {
	private final int idLoan;
	private Book book;
	private Client client;
	private Date date;
	private int borrowed;
	

	
	public Loan(int idLoan, Book book, Client client, Date date, int borrowed) {
		this.idLoan = idLoan;
		this.book = book;
		this.client = client;
		this.date = date;
		this.borrowed = borrowed;
	}


	public int getIdLoan() {
		return idLoan;
	}
	public Book getBook() {
		return book;
	}
	public Client getClient() {
		return client;
	}
	public Date getDate() {
		return date;
	}
	public int getBorrowed() {
		return borrowed;
	}



	public String toString() {
		return"\t"+idLoan+"\t|\t"+book.getIdBook()+"\t|\t"+client.getIdClient()+"\t|\t"+date.toString()+"\t|\t"+borrowed+" ";
	}
	
	
}
