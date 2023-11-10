package principal;

import dto.Facturas;
import operations.OperationsFacturacion;

public class Main {

	public static void main(String[] args) {
		OperationsFacturacion ope= new OperationsFacturacion();
		
		try {
			//mostramos la lista
			System.out.println("\nListado facturas\n");
			ope.openSession();
			ope.facturasList().forEach(System.out::println);
			ope.closeSession();

			//Creamos factura con cliente ya existente (2)
			ope.openSession();
			Facturas factura=new Facturas(ope.getCliente(2), "Recien añadido", 100.00);
			ope.closeSession();

			//Añadimos factura
			ope.openSession();
			ope.addFactura(factura);
			ope.closeSession();
			
			//mostramos la lista
			System.out.println("\nListado nuevo\n");
			ope.openSession();
			ope.facturasList().forEach(System.out::println);
			ope.closeSession();
			
			//modificamos la factura
			factura.setDetalle("Modificado");
			factura.setImporte(200.00);
			
			//aplicamos la modificacion
			ope.openSession();
			ope.modifyFactura(factura);
			ope.closeSession();
			
			//mostramos la lista
			System.out.println("\nListado actualizado\n");
			ope.openSession();
			ope.facturasList().forEach(System.out::println);
			ope.closeSession();
			
			//Eliminamos la factura creada
			ope.openSession();
			ope.deleteFactura(factura.getIdFactura());
			ope.closeSession();
			
			//mostramos la lista
			System.out.println("\nListado Facturas\n");
			ope.openSession();
			ope.facturasList().forEach(System.out::println);
			ope.closeSession();
			
		} catch (Exception e) {
			System.out.println("Algo sucedio. \n"+e.getMessage());
		}
	}

}
