package ejemplo2UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DatagramaServidor {

	public static void main(String[] args) throws IOException {
		byte[] buffer =new byte[1024];
		

		DatagramSocket socket = null;
		DatagramPacket recibo = null;
		
		socket=new DatagramSocket(33333);
	
	
		System.out.println("Esperando datagrama...");
		recibo=new DatagramPacket(buffer,buffer.length);

		socket.receive(recibo);
	
		
		int bytesRec=recibo.getLength();
		String paquete= new String (recibo.getData());

		System.out.println("Número de bytes recibido: "+bytesRec);
		System.out.println("Contenido del paquete: "+paquete.trim());
		System.out.println("Puerto de origen del mensage: "+recibo.getPort());
		System.out.println("Ip de origen: "+recibo.getAddress().getHostAddress());
		System.out.println("Puerto de destino del mensaje: "+socket.getLocalPort());
		
		socket.close();
	}
}
