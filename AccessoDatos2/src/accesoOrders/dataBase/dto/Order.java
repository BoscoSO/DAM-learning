package accesoOrders.dataBase.dto;

public class Order {
	private static int idContador=1;
	private final int idPedido;
	private Product product;
	private Client client;
	private int amount;
	
	public Order(int idPedido,Product product, Client client, int amount) {
		this.idPedido = idPedido;
		this.product = product;
		this.client = client;
		this.amount = amount;
		idContador++;
	}
	public Order(Product product, Client client, int amount) {
		this.idPedido = idContador++;
		this.product = product;
		this.client = client;
		this.amount = amount;
	}
	
	public int getIdPedido() {
		return idPedido;
	}
	public Product getProduct() {
		return product;
	}
	public Client getClient() {
		return client;
	}
	public int getAmount() {
		return amount;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String toString() {
		return"      "+idPedido+"     |      "+product.getIdProduct()+"      |      "+client.getIdClient()+"     |    "+amount+" ";
	}
	
	
}
