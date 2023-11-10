package ejercicioU2_4.orders;

import java.io.Serializable;

public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idProduct;	
	private String description;
	private float price;
	
	public Product (int ide,String descrip, float precio){
		this.idProduct=ide;
		this.description=descrip;
		this.price=precio;
	}
	public String toString() {
		return "   ID: "+this.idProduct+"  -  "+this.description+"\tprecio: "+this.price+"€\n";
	}
	
	

	public String getIdProduct() {
		return String.valueOf(idProduct);
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getPrice() {
		return String.valueOf(price);
	}
		
}