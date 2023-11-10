package principal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import dto.Cliente2;
import dto.LineaPedido2;
import dto.Pedido2;
import operations.Operations;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		Operations ope=new 	Operations();

		try {
			ope.openSession();
			ope.ordersList().forEach(System.out::println);
			ope.closeSession();
		
			System.out.println("\n\n Añadiendo nuevo pedido del cliente 3 ");
			
			System.out.println("\tNuestra lista de productos:");

			ope.openSession();
			ope.productsList().forEach(System.out::println);
			ope.closeSession();
			
			//Selecciona el producto y cuantos necesitas
			
			System.out.println("Que producto desea añadir a su pedido (indique el id, 0 si ya no desea añadir mas)");
			int pd=sc.nextInt();

			List<Integer> productosDeseados= new ArrayList<Integer>();
			List<Integer> cantidad= new ArrayList<Integer>();
			
			while(pd!=0) {
				if(!productosDeseados.contains(pd)) {
					productosDeseados.add(pd);
					System.out.println("Que cantidad necesitas");
					pd=sc.nextInt();
					if(pd<=0)throw new Exception("No es una cantidad aceptable");
					cantidad.add(pd);
				}else System.out.println("ya seleccionaste ese producto antes");
				System.out.println("Algun producto mas? (indique el id, 0 si ya no desea añadir mas)");
				pd=sc.nextInt();
			}
			
			// seleccionamos el cliente que realiza el pedido 
			
			ope.openSession();
			Cliente2 cli = ope.getCliente(3);
			ope.closeSession();
			
			// creamos un pedido inicial con ningun producto todavia
			Pedido2 pedido=new Pedido2(cli, 0.0, new HashSet(0));
			
			Set<LineaPedido2> lineas=new HashSet<LineaPedido2>(0);
			LineaPedido2 linea;
			
			ope.openSession();
			ope.addOrder(pedido);
			ope.closeSession();
			
			//Recuento de productos pedidos para integrarlos al pedido
			int cont=0;
			for(int i: productosDeseados) {
				ope.openSession();
				linea=new LineaPedido2(pedido, ope.getProducto(i), new Double(cantidad.get(cont++)));	
				lineas.add(linea); ope.addLinea(linea);
				ope.closeSession();
			}

			pedido.setLineaPedido2s(lineas);
			Double prezoTotal=0.0;
			
			for(LineaPedido2 l: lineas) {
				Double cant = l.getCantidade();
				Double prezo = l.getProduto2().getPrezo();
				
				prezoTotal+= cant * prezo ;
			}
			pedido.setImporte(prezoTotal);
			
			ope.openSession();
			ope.modifyOrder(pedido);
			ope.closeSession();
			
			//pedido finalmente añadido
			System.out.println("\nPedido añadido\n");
			
			ope.openSession();
			ope.ordersList().forEach(System.out::println);
			ope.closeSession();
			
			//modificamos el pedido
			System.out.println("\nVamos a añadirle un 20% de descuento al precio total\n ");
			pedido.setImporte(prezoTotal-(prezoTotal*0.20));
			
			ope.openSession();
			ope.modifyOrder(pedido);
			ope.closeSession();
			
			ope.openSession();
			ope.ordersList().forEach(System.out::println);
			ope.closeSession();
			
			System.out.println("\nPara finalizar vamos a borrar el pedido\n");
			//borramos el pedido
			ope.openSession();
			ope.deleteOrder(pedido);
			ope.closeSession();
			
			ope.openSession();
			ope.ordersList().forEach(System.out::println);
			ope.closeSession();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
