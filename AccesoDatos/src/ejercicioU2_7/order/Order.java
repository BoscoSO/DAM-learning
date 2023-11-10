package ejercicioU2_7.order;

import java.io.Serializable;
import java.util.ArrayList;

import ejercicioU2_7.order.Product;

public class Order implements Serializable {

	private long id;

	private Client cliente;
	private ArrayList<OrderRow> orderRows;
	
	private boolean delivered;
	private double price;
	
	public Order(long id, Client cliente, ArrayList<OrderRow> orderRow, boolean delivered) {

		this.id = id;
		this.cliente = cliente;
		this.orderRows = orderRow;
		this.delivered = delivered;
		this.price =0;
		for(int i=0;i<orderRow.size();i++)
			this.price += orderRow.get(i).getPrice();
		
	}
	public long getId() {
		return id;
	}
	public Client getCliente() {
		return cliente;
	}
	public ArrayList<OrderRow> getOrderRow() {
		return orderRows;
	}
	public boolean isDelivered() {
		return delivered;
	}
	public double getPrice() {
		return price;
	}
	
	public String toString() {
		String cadea="Id : "+this.id+"\n"+
					 "Cliente : \n"+this.cliente.toString()+
					 "OrderRows:\n";
						
		for(int i=0;i<orderRows.size();i++) {
			cadea+=orderRows.get(i).toString();
		}
		cadea+="\nDelivered : "+delivered+"\n";
		cadea+="Price : "+price;
		
		return cadea+"\n";
	}
	
	
}
