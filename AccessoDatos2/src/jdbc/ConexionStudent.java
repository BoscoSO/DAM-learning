package jdbc;

import java.sql.*;

public class ConexionStudent {

	 public static void main(String[] args){
		    try{
			      //Carga do controlador JDBC de MySQL
			      Class.forName("com.mysql.jdbc.Driver");
			      //Crea unha conexion a base de datos
			      String url="jdbc:mysql://192.168.56.101/exercises";
			      Connection conexion = DriverManager.getConnection(url,"manager","abc123.");
			      
			      //Operamos coa conexion
			  
			      //Mostrar a version do driver JDBC
			      DatabaseMetaData meta = conexion.getMetaData();
			      System.out.println("A version do driver JDBC e: "+meta.getDriverVersion());
			 
			      //Consulta de datos
			      
			      Statement consult=conexion.createStatement();
			      ResultSet datos=consult.executeQuery("select * from student");
			      
			      while(datos.next()) {
			    	  System.out.println("dni - "+datos.getString("dni"));
			    	  System.out.println("\tname - "+datos.getString("name"));
			    	  System.out.println("\tsurname - "+datos.getString("surname"));
			    	  System.out.println("\tage - "+datos.getInt("age")+"\n\n");
			      }
			      datos.close();
			      
			      //Consulta con parametros
			      String parametros="select * from student where DNI=?";
			      PreparedStatement consultParams=conexion.prepareStatement(parametros);
			      
			      consultParams.setString(1,"22222222A");
			      
			      ResultSet datos2=consultParams.executeQuery();
			      System.out.println("buscando dni 2222222A:\n");
			      if(datos2.next()) {  
			    	  System.out.println("dni - "+datos2.getString("dni"));
			    	  System.out.println("\tname - "+datos2.getString("name"));
			    	  System.out.println("\tsurname - "+datos2.getString("surname"));
			    	  System.out.println("\tage - "+datos2.getInt("age")+"\n\n");
			      }else System.out.println("no existe");
			      
			      consultParams.close();
			      datos2.close();
			      
			      //Cerrar conexion
			      conexion.close();
		    }
		    catch (SQLException erro){
		      System.out.println("Erro SQL: "+erro.getMessage());
		      erro.printStackTrace();
		    } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}//main
}
