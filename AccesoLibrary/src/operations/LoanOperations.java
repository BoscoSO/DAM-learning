package operations;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import basedatos.Book;
import basedatos.Client;
import basedatos.HibernateUtil;
import basedatos.Loan;

public class LoanOperations {
private Session session;
	
	public void openSession() throws Exception {
		try {
			SessionFactory sesion = HibernateUtil.getSessionFactory();
			session= sesion.openSession();
		}catch(Exception erro) {
			throw new Exception("open session. //"+erro.getMessage());
			
		}
	}
	public boolean isBorrowed(int idBook) throws Exception {
		try{
			
			if(borrowedBooksList().contains(getBook(idBook))) {
				return true;
			}
			
		}catch(Exception erro) {
			throw new Exception("Book no encontrado. //"+erro.getMessage());
			
		}
		return false;
	}
	public Book getBook(int idBook) throws Exception {
		try{/*
			TypedQuery<Book> query1 = session.createQuery("select b from Book b where b.idBook=?1", Book.class);
														  
			query1.setParameter(1,idBook);
			
			Book book = query1.getSingleResult();*/
			Book book=session.get(Book.class,idBook);
			return book;
		}catch(Exception erro) {
			throw new Exception("Book no encontrado. //"+erro.getMessage());
			
		}
	}	
	public Loan getLoanBorrowed(int idBook) throws Exception {
		try{
			TypedQuery<Loan> query = session.createQuery("select l from Loan l where l.borrowed=true", Loan.class);
					
			List<Loan> listadoLoans = query.getResultList();
			for(Loan l:listadoLoans) {
				if(l.getBook().getIdBook()==idBook) {
					return l;
				}
			}
			
		}catch(Exception erro) {
			throw new Exception("Loan no encontrado. //"+erro.getMessage());
			
		}
		return null;
	}
	public void addLoan(int idClient,int idBook) throws Exception {
		try {
			if(!isBorrowed(idBook)){
				Book book = getBook( idBook);
				ClientOperations oper = new ClientOperations();
				oper.openSession();
				Client cliente = oper.getClient(idClient);
				oper.closeSession();
				if(cliente!=null) {

					Transaction tx = session.beginTransaction();
					
					LocalDate fecha = LocalDate.now( ZoneId.of( "Europe/Paris" ) );
					Date sqlDate = java.sql.Date.valueOf( fecha );
					Loan loan= new Loan(book, cliente, sqlDate, true);
					session.save(loan);
					tx.commit();	
				}
				
			}else throw new Exception("Loan no añadido. //\n\t Libro ya prestado");
		}catch(Exception erro) {
			throw new Exception("Loan no añadido. //\n\t"+erro.getMessage());
			
		}
	}
	public void addReturn(int idBook) throws Exception {
		try{
			if(isBorrowed(idBook)){
				Transaction tx = session.beginTransaction();
				Loan mod=getLoanBorrowed(idBook);
				mod.setBorrowed(false);
				session.update(mod);
				tx.commit();
			
			}else throw new Exception("Loan no modificado. //\n\t Libro no esta prestado");
			
		}catch(Exception erro) {
			throw new Exception("Loan no modificado. //"+erro.getMessage());
			
		}
		
	}

	public List<Book> borrowedBooksList() throws Exception {
		try {
			TypedQuery<Loan> query = session.createQuery("select l from Loan l where borrowed=true", Loan.class);
			
			List<Loan> listadoLoans = query.getResultList();
			List<Book> listado = new ArrayList<Book>(); 
			for(Loan l:listadoLoans) {
				if(l.getBorrowed()) {
					Book b=l.getBook();
					if(!listado.contains(b)) {
						listado.add(b);
					}
				}
			}
			return listado;
			// from loan where borrowed=true
		}catch(Exception erro) {
			throw new Exception("borrowed list :/"+erro.getMessage());
			
		}
	}

	
	public void closeSession() throws Exception {
		try{
			session.close();
		}catch(Exception erro) {
			throw new Exception("Close operation. //"+erro.getMessage());
			
		}
	}
}

