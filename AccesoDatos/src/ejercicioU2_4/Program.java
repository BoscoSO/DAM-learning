package ejercicioU2_4;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import ejercicioU2_4.orders.CreateOrdersList;

public class Program {

	public static void main(String[] args) {
		CreateOrdersList col= new CreateOrdersList();
		col.storeProducts(col.createProductList());
	
		col.storeOrders(col.createOrderList());//si ya esta creada se puede usar col.readOrders();
		
		System.out.println("ok");
//		col.readOrdersFile();
//		col.createOrderXML(col.readOrders());
//		try {
//			col.readOrdersXML_V2();
//		} catch (ParserConfigurationException | SAXException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
