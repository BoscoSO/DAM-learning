package ejercicioU2_6.main;

import ejercicioU2_6.parte2Books.BookUtilities;

public class BookManagement {
	public static void main(String[] args) {

		BookUtilities bu=new BookUtilities();
		
		bu.generateBookDat();
		
		bu.showBooks();
		
		bu.generateXMLBookDom();
		
		bu.generateXMLBookXstream();
	}
}
