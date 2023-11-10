package accesoLibrary.dataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import accesoLibrary.dataBase.dto.Book;
import accesoLibrary.dataBase.dto.Client;
import accesoLibrary.dataBase.dto.Loan;


public class Conection {
	
	private Connection conexion;
	
	private String erros;
	
	public String getErros() {
		return erros;
	}
	
	public void openConection(String url) throws Exception{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Crea unha conexion a base de datos
		    conexion = DriverManager.getConnection(url,"manager","abc123.");
		    
		} catch (ClassNotFoundException e) {
			erros+="\nClass not found"+e.getMessage();
			throw(e);
		} catch (SQLException e) {
			erros+="\nSQL open operation :"+e.getMessage();
			throw(e);
		}
      
	}
	public void closeConection() throws Exception{
	
	      try {
			conexion.close();
		} catch (SQLException e) {
			erros+="\nSQL close operation :"+e.getMessage();
			throw(e);
		}
	}
	
	
	public int addLoan(int idBook,int idClient,Date date,int borrowed) throws Exception{
		
		int datos=0;
		String linea="insert into loan (idBook, idClient, date, borrowed) values ('"+idBook+
									"','"+idClient+"','"+date+"',"+borrowed+");";
	      try {
		      Statement consult=conexion.createStatement();
		      datos=consult.executeUpdate(linea);

		      consult.close();
		} catch (SQLException e) {
			erros+="\nSQL addLoan :"+e.getMessage();
			throw(e);
			}
	      
		return datos;
	}
	public int addClient(String dni,String nome,String email) throws Exception{
		
		int datos=0;
		String linea="insert into client (DNI, name, email) values ('"+dni+
									"','"+nome+"','"+email+"');";
	      try {
		      Statement consult=conexion.createStatement();
		      datos=consult.executeUpdate(linea);

		      consult.close();
		} catch (SQLException e) {
			erros+="\nSQL addClient :"+e.getMessage();
			throw(e);
			}
	      
		return datos;
	}
	public int addBook(String code,String title,String authors,String year) throws Exception{
		
		int datos=0;
		String linea="insert into book (code, title, authors, year) values ('"+code+"','"
											+title+"','"+authors+"','"+year+"');";
	      try {
		      Statement consult=conexion.createStatement();
		      datos=consult.executeUpdate(linea);

		      consult.close();
		} catch (SQLException e) {
			erros+="\nSQL addBook :"+e.getMessage();
			throw(e);
			}
	      
		return datos;
	}
	public int deleteLoan(int idLoan) throws Exception{
		int datos=0;
		
	      try {
	    	  String parametros="delete from loan WHERE  idLoan=?;";
		      PreparedStatement consultParams=conexion.prepareStatement(parametros);
		      
		      consultParams.setInt(1,idLoan);

    		  datos=consultParams.executeUpdate();
    		  consultParams.close();
		} catch (SQLException e) {
			erros+="\nSQL deleteStudent :"+e.getMessage();
			throw(e);
			}
	      
		return datos;
	}
	public int addReturn(int idBook) throws Exception{


		int datos=0;
		try {


		      PreparedStatement updateSales = conexion.prepareStatement(
		    		  "UPDATE loan SET borrowed=? WHERE idBook=?");
    		  updateSales.setInt(1, 0);
    		  updateSales.setInt(2, idBook);
    		  
    		  datos=updateSales.executeUpdate();
    		  updateSales.close();
		      
		} catch (SQLException e) {
			erros+="\nSQL addStudent :"+e.getMessage();
			throw(e);
			}
	      
		return datos;
		
	}
	
	public Client getClient(int id) throws Exception{
		Client st=null;
		 try {
			 //Consulta con parametros
		      String parametros="select * from client where idClient=?";
		      PreparedStatement consultParams=conexion.prepareStatement(parametros);
		      
		      consultParams.setInt(1,id);
		      
		      ResultSet datos=consultParams.executeQuery();
		      String dni,name,email;
		      int idClient;
		      if(datos.next()) {  
		    	  idClient=datos.getInt("idClient");
		    	  dni=datos.getString("DNI");
		    	  name=datos.getString("name");
		    	  email=datos.getString("email");
		    	  st=new Client(idClient,dni, name,email);
		      }
		      
		      consultParams.close();
		      datos.close();
		      
		      
		} catch (SQLException e) {
			erros+="\nSQL getClient :"+e.getMessage();
			throw(e);
		}
		return st;
	    
	}
	public Book getBook(int id) throws Exception{
		Book st=null;
		 try {
			 //Consulta con parametros
		      String parametros="select * from book where idBook=?";
		      PreparedStatement consultParams=conexion.prepareStatement(parametros);
		      
		      consultParams.setInt(1,id);
		      
		      ResultSet datos=consultParams.executeQuery();

		      String code,title,authors,year;
		      int idBook;
		      if(datos.next()) {  
		    	  idBook=datos.getInt("idBook");
		    	  code=datos.getString("code");
		    	  title=datos.getString("title");
		    	  authors=datos.getString("authors");
		    	  year=datos.getString("year");
		    	  
		    	  st=new Book(idBook, code, title, authors, year);
		      }
		      
		      consultParams.close();
		      datos.close();
		      
		      
		} catch (SQLException e) {
			erros+="\nSQL getProdcut :"+e.getMessage();
			throw(e);
		}
		return st;
	    
	}
	public Loan getLoan(int id) throws Exception{
		Loan st=null;
		 try {
			 //Consulta con parametros
		      String parametros="select * from loan where idLoan=?";
		      PreparedStatement consultParams=conexion.prepareStatement(parametros);
		      
		      consultParams.setInt(1,id);
		      
		      ResultSet datos=consultParams.executeQuery();


		      
		      int idLoan,idBook,idClient,borrowed;
		      Date date;
		      if(datos.next()) {  
		    	  idLoan=datos.getInt("idLoan");
		    	  idBook=datos.getInt("idBook");
		    	  idClient=datos.getInt("idClient");
		    	  date=datos.getDate("date");
		    	  borrowed=datos.getInt("borrowed");
		    	  
		    	  
		    	  st=new Loan(idLoan, getBook(idBook), getClient(idClient), date, borrowed);
		      }
		      
		      consultParams.close();
		      datos.close();
		      
		      
		} catch (SQLException e) {
			erros+="\nSQL getOrder :"+e.getMessage();
			throw(e);
		}
		return st;
	    
	}
	
	public ArrayList<Loan> getLoanList()throws Exception{
		
		ArrayList<Loan> ordersList=new ArrayList<Loan>();
		try { 
			
			Statement consult=conexion.createStatement();
		    ResultSet datos;
		
		    datos = consult.executeQuery("select * from loan");
		    int idLoan;
		    while(datos.next()) {
		    	idLoan=datos.getInt("idLoan");
		    	ordersList.add(getLoan(idLoan));
		    }
		    consult.close();
		    datos.close();
		} catch (SQLException e) {
			erros+="\nSQL getLoanList() :"+e.getMessage();
//			e.printStackTrace();
			throw(e);
		}
		
	    return ordersList; 
}
	
	public ArrayList<Integer> librosBloqueados() {
		ArrayList<Integer> bloqueados=new ArrayList<Integer>();
		try { 
			String parametros="select idBook from loan where borrowed=?";
			PreparedStatement consultParams=conexion.prepareStatement(parametros);
			
			consultParams.setInt(1,1);
	    
			ResultSet datos=consultParams.executeQuery();

			
		    int idBook;
		    
		    while(datos.next()) {
		    	idBook=datos.getInt("idBook");
		    	if(!bloqueados.contains(idBook)) {
		    		bloqueados.add(idBook);
		    	}
		    }
		    consultParams.close();
		    datos.close();
		} catch (SQLException e) {
			erros+="\nSQL bloqueados() :"+e.getMessage();
//			e.printStackTrace();
		}
		return bloqueados;
	}
	public ArrayList<Integer> getBookList()throws Exception{
		
		ArrayList<Integer> ordersList=new ArrayList<Integer>();
		try { //si nunca se pidio, añadirlo tmb(otro sel ect)
			String parametros="select idBook from book";
			
			Statement consult=conexion.createStatement();

	    
			ResultSet datos=consult.executeQuery(parametros);

			
		    int idBook;
		    while(datos.next()) {
		    	idBook=datos.getInt("idBook");
		    	ordersList.add(idBook);
		    	
		    }
		    
		    consult.close();
		    datos.close();
		} catch (SQLException e) {
			erros+="\nSQL getBookList() :"+e.getMessage();
//			e.printStackTrace();
			throw(e);
		}
		
	    return ordersList; 
	}
	
	public Connection getConection() {
		return this.conexion;
	}
}
