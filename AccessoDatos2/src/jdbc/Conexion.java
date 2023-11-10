package jdbc;

import java.sql.*;

public class Conexion {
	public static void main(String[] args) {
		  try{
		      //Carga do controlador JDBC de MySQL
		      Class.forName("com.mysql.jdbc.Driver");
		      //Crea unha conexion a base de datos
		      String url="jdbc:mysql://dbalumnos:3312/bosco_db";
		      Connection conexion = DriverManager.getConnection(url,"bosco","abc123.");

		      //Operamos coa conexions
		      //Mostrar a version do driver JDBC
		      DatabaseMetaData meta = conexion.getMetaData();
		      System.out.println("A version do driver JDBC e: "+meta.getDriverVersion());
		      
		      
		      //Cerrar conexion
		      conexion.close();
		    }
		    catch (SQLException erro){
		      System.out.println("Erro SQL: "+erro.getMessage());
		      erro.printStackTrace();
		    }
		    catch (Exception erro){
		      System.out.println("Erro: "+erro.getMessage());
		      erro.printStackTrace();
		    }
		
	}
}
