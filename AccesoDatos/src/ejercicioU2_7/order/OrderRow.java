package ejercicioU2_7.order;

import java.io.Serializable;

public class OrderRow implements Serializable{
	private Product product;
	private long amount;
	private double price;
	
	
	public OrderRow(Product product, long amount) {
		this.product = product;
		this.amount = amount;
		this.price =product.getPrice()*amount;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public long getAmount() {
		return amount;
	}
	
	public double getPrice() {
		return price;
	}
	public String toString() {
		String cadea="  OrderRow :\n "+
					"\tProduct : \n"+this.product.toString()+"\n"+
					"\tAmount : "+this.amount+"\n"+
					"\tPrice : "+this.price+"\n";
						
		
		
		return cadea;
	}

}
