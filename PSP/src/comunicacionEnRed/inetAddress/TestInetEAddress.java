package comunicacionEnRed.inetAddress;

import java.net.InetAddress;
import java.util.Scanner;

public class TestInetEAddress {
	// EJERCICIO 6 y 7

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		TestInetEAddress test=new TestInetEAddress();
		int op=0;
		while(op!=3) {

			System.out.println("1.- Obter direccion ip");
			System.out.println("2.- Obter la URL");
			System.out.println("3.- Salir");
			System.out.print("selecicione una opcion: ");

			op=sc.nextInt();
			switch (op) {
			case 1:
				System.out.print("Escribe la direccion: ");
				String url=sc.next();
				test.ejercicio67(url);
				
				break;
			case 2:
				System.out.print("Escribe la IP: ");
				String url2=sc.next();
				test.ejercicio9(url2);
				
				break;
			case 3:
				System.out.print("Adios :)");
				
				break;
			default:System.out.println("Introduce una opcion valida");
				break;
			}
		}
		
		
	}

	public void ejercicio67(String name) {
		InetAddress dir = null;
		InetAddress loc = null;
//		String name="www.google.com";
		System.out.println("===============================================");

		try {
			dir = InetAddress.getByName(name);
			loc =InetAddress.getLocalHost();
			System.out.println("Nombre nodo: "+dir.getHostName());
			System.out.println("ip nodo: "+dir.getHostAddress()+"\n");
			System.out.println("Nombre local: "+loc.getHostName());
			System.out.println("ip local: "+loc.getHostAddress()+"\n");
			
	

		} catch (Exception e) {
			System.out.println("Esa direccion no tiene buena pinta");
		}
	}
	private void ejercicio8(String url) {

		InetAddress dir = null;
	
		try {
			dir = InetAddress.getByName(url);
			System.out.println("Nombre nodo: "+dir.getHostName());
			System.out.println();
			
	

		} catch (Exception e) {
			System.out.println("Esa direccion no tiene buena pinta");
		}
	
		
	}
	private void ejercicio9(String str) {//10.180.188.155 por params y 2
		String[] arg=str.split("\\.");
		byte[] url=new byte[arg.length]; 		
		for(int o=0;o<arg.length;o++) {
			int i=Integer.valueOf(arg[o]);
			url[o]=(byte)i;
			System.out.println("i:"+i+"url["+o+"]:"+url[o]);
		}

		InetAddress dir = null;
		try {
			dir = InetAddress.getByAddress(url);

			System.out.println("Nombre nodo: "+dir.getHostName()+"\n");


		} catch (Exception e) {
			System.out.println("\nEsa direccion no tiene buena pinta");
			e.printStackTrace();

		}
			
		
	}
}
