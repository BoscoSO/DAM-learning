package accesoOrders;

import java.util.ArrayList;

import accesoOrders.dataBase.Operations;
import accesoOrders.dataBase.dto.Order;

public class Program {

	public static void main(String[] args) {

	    String url="jdbc:mysql://192.168.56.3/orders";
		Operations ope=new Operations();
		try{
					//MOSTRAMOS CONTENIDO INICIAL
			ope.openCon(url);
			ArrayList<Order> list= ope.ordersList();
			
			System.out.println("\nContenido inicial:\n\n  idPedido  |  idProduct  |  idClient  |  amount");
			for(Order o:list) {
				System.out.println(o.toString());
			}
			
			//Comprobamos si existe el producto 6 el 2 y el cliente 1
			
			int idPrd=6;
			int idCli=1;
			while(true) {
				if(ope.existProduct(idPrd)) {
					System.out.println("Producto id "+idPrd+" existe\n");
					if(ope.existClient(idCli))
						System.out.println("Cliente id "+idCli+" existe\n");
						
					break;
				}else {
					System.out.println("Producto idPrd "+idPrd+" no existe\n");
				}
				idPrd=2;
			}
			//a�adimos un pedido nuevo, el id se incrementa solo si se omite
			System.out.println("A�adiendo pedido con producto id:"+idPrd+", cliente id:"+idCli+" y cantidad: 420 \n");
			Order pedido=new Order(ope.getProduct(idPrd), ope.getClient(idCli), 420);
			ope.addOrder(pedido);
	
					//MOSTRAMOS CON CONTENIDO A�ADIDO
			list= ope.ordersList();
			
			System.out.println("\nContenido aumentado:\n\n  idPedido  |  idProduct  |  idClient  |  amount");
			for(Order o:list) {
				System.out.println(o.toString());
			}
			
			//modificamos el anteriormente a�adido
			idCli=3;
			idPrd=4;
			System.out.println("Modificamos el pedido anteriormente creado\n nueva Product id:"+idPrd+"\n nueva cliente id:"+idCli+"\n nueva cantidad: 340 \n");
			
			if(ope.existClient(idCli) && ope.existProduct(idPrd)){
				pedido.setProduct(ope.getProduct(idPrd));
				pedido.setClient(ope.getClient(idCli));
				System.out.println("modificado");
			}
			pedido.setAmount(340);
			
			ope.modifyOrder(pedido);
			
					//MOSTRAMOS CONTENIDO MODIFICADO
			list= ope.ordersList();
			
			
			System.out.println("\nContenido modificado:\n\n  idPedido  |  idProduct  |  idClient  |  amount");
			for(Order o:list) {
				System.out.println(o.toString());
			}
			
			// borramos el anteriormente modificado y a�adido
			System.out.println("\nBorramos el anteriormente modificado y a�adido");
			int result=ope.deleteOrder(pedido.getIdPedido());
			if(result==1) {
				System.out.println("Borrado completo");
			}else System.out.println("Borrado no completado");
			
				//MOSTRAMOS CONTENIDO FINAL
			list= ope.ordersList();
			
			System.out.println("\nContenido final:\n\n  idPedido  |  idProduct  |  idClient  |  amount");
			for(Order o:list) {
				System.out.println(o.toString());
			}
			ope.quit();
		}catch(Exception e) {
			System.out.println(ope.getErros());
			
		}
		
		
	}

}
