package accesoLibrary;

import java.util.ArrayList;

import accesoLibrary.dataBase.dto.*;
import accesoLibrary.dataBase.Operations;

public class Program {

	public static void main(String[] args) {


	    //String url="jdbc:mysql://192.168.56.101/library"; CASA
	    //String url="jdbc:mysql://192.168.56.3/library"; Clase
	    String url="jdbc:mysql://192.168.56.101/library";
		Operations ope=new Operations();
		try {
			ope.openCon(url);
			//MOSTRAMOS CONTENIDO INICIAL
			ArrayList<Loan> list= ope.loanList();
			System.out.println("\nContenido inicial:\n\n      idLoan\t|     idBook\t|   idClient\t|\t   date\t\t|    borrowed");
			for(Loan l:list) {
				System.out.println(l.toString());
			}
			
		//Comprobamos si existe el libro 6 el 2 y el cliente 1
			
			int idBook=6;
			int idCli=1;
			while(true) {
				if(ope.existBook(idBook)) {
					System.out.println("Libro id "+idBook+" existe\n");
					if(ope.existClient(idCli))
						System.out.println("Cliente id "+idCli+" existe\n");
						
					break;
				}else {
					System.out.println("\nLibro idBook "+idBook+" no existe\n");
				}
				idBook=2;
			}
			//anhadimos un pedido nuevo, el id se incrementa solo si se omite
			System.out.println("Anhadiendo loan con libro id:"+idBook+", cliente id:"+idCli+"\n");
		//	ope.addLoan(idCli, idBook);
			idBook=1;
			System.out.println("\nAnhadiendo loan con libro id:"+idBook+", cliente id:"+idCli+"\n");
			//ope.addLoan(idCli, idBook);
			ope.addLoan(2,3);
					//MOSTRAMOS CON CONTENIDO ANHADIDO
			list= ope.loanList();
			
			System.out.println("\nContenido aumentado:\n\n      idLoan\t|     idBook\t|   idClient\t|\t   date\t\t|    borrowed");
			for(Loan l:list) {
				System.out.println(l.toString());
			}
			
			
			//DEVOLVEMOS EL LIBRO ANTERIORMENTE SOLICITADO
			System.out.println("\nDevolvemos el libro anteriormente solicitado\n");
		
			//int res=ope.addReturn(idBook);
			//System.out.println("resp "+res);
					//MOSTRAMOS CONTENIDO MODIFICADO
			 list= ope.loanList();
					
			 System.out.println("\nContenido modificado:\n\n      idLoan\t|     idBook\t|   idClient\t|\t   date\t\t|    borrowed");
			 for(Loan l:list) {
				System.out.println(l.toString());
			 }
			
			
			 list= ope.avaliableLoanLit();
				System.out.println("\nLoan disponibles:\n\n      idLoan\t|     idBook\t|   idClient\t|\t   date\t\t|    borrowed");
				for(Loan l:list) {
					System.out.println(l.toString());
				 }
			 list= ope.borrowedBookList();
				System.out.println("\nLoan no disponibles:\n\n      idLoan\t|     idBook\t|   idClient\t|\t   date\t\t|    borrowed");
				for(Loan l:list) {
					System.out.println(l.toString());
				 }
	
				
				for(Book l:ope.avaliableBooksLit()) {
					System.out.println(l.toString());
				 }
	
			ope.quit();
		}catch(Exception e) {
		System.out.println(ope.getErros());	
		}
		
	
	}

}
