package accesoStudents.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OperationsDB {
	
	private Connection conexion;
	private String erros="";
	
	
	public void openConection()throws Exception{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//Crea unha conexion a base de datos
			    String url="jdbc:mysql://192.168.56.101/exercises";
			    conexion = DriverManager.getConnection(url,"manager","abc123.");
			    
			} catch (ClassNotFoundException e) {
				erros+="Class not found"+e.getMessage();
				throw(e);
			} catch (SQLException e) {
				erros+="SQL open operation :"+e.getMessage();
				throw(e);
			}
	      
	}

	public void closeConection() throws Exception{

	      try {
			conexion.close();
		} catch (SQLException e) {
			erros+="SQL close operation :"+e.getMessage();
			throw(e);
		}
	}

	public int addStudent(Student student) throws Exception{
		int datos=0;
		String linea="insert into student (dni, name, surname, age) values ('"+student.getDni()+
									"','"+student.getName()+"','"+student.getSurname()+"',"+student.getAge()+");";
	      try {
		      Statement consult=conexion.createStatement();
		      datos=consult.executeUpdate(linea);

		      consult.close();
		} catch (SQLException e) {
			erros+="SQL addStudent :"+e.getMessage();
			throw(e);
		}
	      
		return datos;
	}
	
	public Student getStudent(String dni) throws Exception{
		Student st=null;
		 try {
			 //Consulta con parametros
		      String parametros="select * from student where DNI=?";
		      PreparedStatement consultParams=conexion.prepareStatement(parametros);
		      
		      consultParams.setString(1,dni);
		      
		      ResultSet datos=consultParams.executeQuery();

		      if(datos.next()) {  
		    	 st=new Student(datos.getString("dni"),datos.getString("name"),
	  						datos.getString("surname"),datos.getInt("age"));
		      }
		      
		      consultParams.close();
		      datos.close();
		      
		} catch (SQLException e) {
			erros+="SQL getStudent :"+e.getMessage();
			throw(e);
		}
		return st;
	    
	}

	public ArrayList<Student> studentsList()throws Exception{
		ArrayList<Student> listaStudents=new ArrayList<Student>();
		try { 
			  Statement consult=conexion.createStatement();
		      ResultSet datos;
		
		      datos = consult.executeQuery("select * from student");
			
		      while(datos.next()) {

		    	  listaStudents.add(new Student(datos.getString("dni"),datos.getString("name"),
		    			  						datos.getString("surname"),datos.getInt("age")));
		      }
		      consult.close();
		      datos.close();
		} catch (SQLException e) {
			erros+="SQL StudentsList :"+e.getMessage();
			throw(e);
		}
		
	    return listaStudents; 
	}
	
	public int deleteStudent(String dni)throws Exception {
		int datos=0;
		
	      try {
	    	  String parametros="delete from student WHERE  DNI=?;";
		      PreparedStatement consultParams=conexion.prepareStatement(parametros);
		      
		      consultParams.setString(1,dni);

    		  datos=consultParams.executeUpdate();
    		  consultParams.close();
		} catch (SQLException e) {
			erros+="SQL deleteStudent :"+e.getMessage();
			throw(e);
		}
	      
		return datos;
	}
	
	public int modifyStudent(Student student) throws Exception{
		int datos=0;
		String dni=student.getDni();
		String name=student.getName();
		String surname=student.getSurname();
		int age=student.getAge();
		
		try {


		      PreparedStatement updateSales = conexion.prepareStatement(
		    		  "UPDATE student SET name=?,surname=?,age=? WHERE DNI=?");
    		  updateSales.setString(1, name);
    		  updateSales.setString(2, surname);
    		  updateSales.setInt(3, age);
    		  updateSales.setString(4, dni);
    		  
    		  
    		  datos=updateSales.executeUpdate();
    		  updateSales.close();
		      
		} catch (SQLException e) {
			erros+="SQL addStudent :"+e.getMessage();
			throw(e);
		}
	      
		return datos;
		
	}

	public String getErros() {
		// TODO Auto-generated method stub
		return erros;
	}
}
