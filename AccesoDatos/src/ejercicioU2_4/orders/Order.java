package ejercicioU2_4.orders;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;


public class Order implements Serializable {
	private int idOrder;
	private String clientName;
	private ArrayList<Product> productos;
	
	public Order(int idd,String nome){
		this.idOrder=idd;
		this.clientName=nome;
		int[] id = {123, 456, 789, 235, 567};
        String[] dc = {"coffee","milk","rice","salt","cocoa"};
        double[] pr = {1.22, 1.05, 1, 1.25, 3.2};
        
        productos= new ArrayList<Product>();
        Random r=new Random();
    	for(int i=0;i<id.length;i++) {
    			
    		productos.add(new Product(id[i],dc[r.nextInt(5)],(float)pr[r.nextInt(5)]));
    	}
	}
	public ArrayList<Product> getLista() {
		return productos;
	}
	public String getIdOrder() {
		return String.valueOf(idOrder);
	}

	public String getClientName() {
		return clientName;
	}
	public String toString() {
		String cadea="Client Name: "+this.clientName+"\n"+
					 "Order:"+this.idOrder+"\nProducts:\n";
						
		for(int i=0;i<productos.size();i++) {
			cadea+=productos.get(i).toString();
		}
		return cadea+"\n";
	}
}
