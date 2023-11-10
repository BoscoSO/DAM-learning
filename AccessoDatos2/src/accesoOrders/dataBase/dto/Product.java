package accesoOrders.dataBase.dto;

public class Product {
	
	private int idProduct;
	private String name;
	private String description;
	private double price;
	private String picture;
	
	public Product(int idProduct,String name, String description, double price, String picture) {
		this.idProduct=idProduct;
		this.name = name;
		this.description = description;
		this.price = price;
		this.picture = picture;
	}
	
	public int getIdProduct() {
		return idProduct;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public double getPrice() {
		return price;
	}
	public String getPicture() {
		return picture;
	}
	
	
	public String toString() {
		return "ID product: "+idProduct+"\n"+
				"name: "+name+"\n"+
				"description: "+description+"\n"+
				"price: "+description+"\n"+
				"picture"+picture+"\n";
	}
	
}
