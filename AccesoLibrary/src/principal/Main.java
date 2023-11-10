package principal;

import java.util.HashSet;
import java.util.Scanner;

import basedatos.Client;
import operations.ClientOperations;
import operations.LoanOperations;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Introduce un idClient a buscar");
		int idClient=Integer.valueOf(sc.nextLine());
		
		ClientOperations clOpe = new ClientOperations();
		
		try {
			System.out.println("\nBuscado:\n");
			clOpe.openSession();
			System.out.println(clOpe.getClient(idClient));
			clOpe.closeSession();
			
			Client cl1=new Client("45907503D", "Robarto","Sar", new HashSet(0));
			System.out.println("\nAñadido:\n");
			
			clOpe.openSession();
			clOpe.addClient(cl1);
			clOpe.clientsList().forEach(System.out::println);
			clOpe.closeSession();
			
			System.out.println("\nModificado:\n");
			
			cl1.setName("Pepe");
			
			clOpe.openSession();
			clOpe.modifyClient(cl1);
			clOpe.clientsList().forEach(System.out::println);
			clOpe.closeSession();
			System.out.println("\nEliminado\n");
			clOpe.openSession();
			clOpe.deleteClient(cl1);
			clOpe.clientsList().forEach(System.out::println);
			clOpe.closeSession();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//PARTE 2
		
		LoanOperations loanOpe = new LoanOperations();
		try {
			

			System.out.println("\nLibros no disponibles\n");
			
			loanOpe.openSession();
			loanOpe.borrowedBooksList().forEach(System.out::println);
			loanOpe.closeSession();
			

			System.out.println("\nCliente 1 solicita libro 1");
			
			loanOpe.openSession();
			loanOpe.addLoan(1,1);
			loanOpe.closeSession();
			
			
			System.out.println("\nLibros no disponibles\n");
			
			loanOpe.openSession();
			loanOpe.borrowedBooksList().forEach(System.out::println);
			loanOpe.closeSession();
			
			System.out.println("\nCliente 1 devuelve el libro");
			
			loanOpe.openSession();
			loanOpe.addReturn(1);
			loanOpe.closeSession();
			
			System.out.println("\nLibros no disponibles\n");
			
			loanOpe.openSession();
			loanOpe.borrowedBooksList().forEach(System.out::println);
			loanOpe.closeSession();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
	}

}
