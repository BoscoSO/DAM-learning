package accesoLibrary.dataBase;


import java.sql.Date;
import java.util.ArrayList;

import accesoLibrary.dataBase.dto.Book;
import accesoLibrary.dataBase.dto.Client;
import accesoLibrary.dataBase.dto.Loan;

public class Operations {
	Conection orderDB;
	
	public Operations(){
		this.orderDB = new Conection();
	}
	public void openCon(String url)throws Exception {

		orderDB.openConection(url);
		
	}
	public String getErros() {
		return orderDB.getErros();
	}
	public ArrayList<Loan> loanList()throws Exception{
		
		return orderDB.getLoanList(); 
	}
	public ArrayList<Loan> borrowedBookList()throws Exception{
		
		ArrayList<Loan> prestados=new ArrayList<Loan>();
		
		for(Loan l:loanList()) {
			if(l.getBorrowed()!=0) {
				prestados.add(l);
			}
		}
		return  prestados;
	}
	public ArrayList<Book> avaliableBooksLit()throws Exception{
		ArrayList<Book> bookList=new ArrayList<Book>();
		
		
	    int idBook;

	    ArrayList<Integer> b=orderDB.librosBloqueados();
	    ArrayList<Integer> librosTotaltes=orderDB.getBookList();
	    
	    int i=0;	    
	    while(i<librosTotaltes.size()) {
	    	idBook=librosTotaltes.get(i);
	    	if(!b.contains(idBook) ) {
	    		bookList.add(getBook(idBook));
	    	}
	    	i++;
	    }


		
		
	    return bookList; 
	}
	public ArrayList<Loan> avaliableLoanLit()throws Exception{
		ArrayList<Loan> disponibles=new ArrayList<Loan>();
		
		for(Loan l:loanList()) {
			if(l.getBorrowed()==0) {
				disponibles.add(l);
			}
		}
		return  disponibles;
	}

	
	public boolean existBook(int id) throws Exception{
		if(orderDB.getBook(id)!=null) {
			return true;
		}
		return false;
	}
	public boolean existClient(int id) throws Exception{
		if(orderDB.getClient(id)!=null) {
			return true;
		}
		return false;
	}
	
	public boolean isBorrowed(int id) throws Exception{
		
		for(Loan l: borrowedBookList()) {
			if(l.getBook().getIdBook()==id) {
				return true;
			}
		}
		
		return false;
	}
	
	public Book getBook(int id) throws Exception{
		return orderDB.getBook(id);
	}
	public Client getClient(int id) throws Exception{
		return orderDB.getClient(id);
	}
	public Loan getLoan(int id) throws Exception{
		return orderDB.getLoan(id);
	}
	public int addClient(String dni,String nome,String email) throws Exception{
		return orderDB.addClient(dni, nome, email);
	}
	public int addBook(String code,String title,String authors,String year) throws Exception{
		return orderDB.addBook(code, title, authors, year);
	}
	public int addLoan(int idCL,int idBook) throws Exception{
		if(existClient(idCL)) {
			if(existBook(idBook)) {
				if(!isBorrowed(idBook)) {
					Date sqlDate = new Date(System.currentTimeMillis());
					return orderDB.addLoan(idBook,idCL,sqlDate,1);
				} 
			}
		}
		return 0;
	
	
	}
	
	public int addReturn(int id) throws Exception{
		if(existBook(id))
			if(isBorrowed(id))
				return orderDB.addReturn(id);
		return 0;
	}
	
	public int deleteLoan(int idLoan) throws Exception{
		return orderDB.deleteLoan(idLoan);
		
		
	}
	
	public void quit() throws Exception{
		this.orderDB.closeConection();
	}
	
}
