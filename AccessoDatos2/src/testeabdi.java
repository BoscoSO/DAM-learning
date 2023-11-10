import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class testeabdi {

	public static void main(String[] args) {
		 ArrayList<String> arrlist = new ArrayList<String>(); 
		  
         // Adding elemnet to srclst 

         arrlist.add("solicitar");
         arrlist.add("devolver");
		 
         arrlist.add("idBook");  

         // Print the list 
         System.out.println("List: " + arrlist); 

         // creating object of type Enumeration<String> 
         Enumeration<String> params = Collections.enumeration(arrlist); 

	      int idCli=0,idBook=0;
	      boolean devolverB=false;
	      boolean solicitarB=false;
	      
	      
	      while(params.hasMoreElements()){
	        String aux=(String)params.nextElement();
//	        if(aux.equals("idCli")){
//	        	 idCli=Integer.valueOf(request.getParameter("idCli"));
//	        }else
//	        if(aux.equals("idBook")){
//	        	idBook=Integer.valueOf(request.getParameter("idBook"));
//	        }else
	        if(aux.equals("devolver")){
	        	devolverB=true;
	        }else
	        if(aux.equals("solicitar")){
	        	solicitarB=true;
	        }
	         
	        
	      }
	      
	      System.out.println("id: "+idCli+" | idBook: "+idBook+" | devolver: "+devolverB+" | solicitar: "+solicitarB);
	}

}
