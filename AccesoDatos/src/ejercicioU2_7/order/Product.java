package ejercicioU2_7.order;

import java.io.Serializable;

public class Product implements Serializable {
	private int id;
	private String productName;
	private String description;
	private String picture;
	private double price;
	public Product(int id, String productName, String description, String picture, double price) {
		this.id = id;
		this.productName = productName;
		this.description = description;
		this.picture = picture;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public String getProductName() {
		return productName;
	}
	public String getDescription() {
		return description;
	}
	public String getPicture() {
		return picture;
	}
	public double getPrice() {
		return price;
	}
	
	public String toString() {
		String cadea="\t\tId : "+this.id+"\n"+
					"\t\tProductName : "+this.productName+"\n"+
					"\t\tDescription : "+this.description+"\n"+
					"\t\tPicture : "+this.picture+"\n"+
					"\t\tPrice : "+this.price+"\n";
						
		
		
		return cadea;
	}
	
	
	
}
