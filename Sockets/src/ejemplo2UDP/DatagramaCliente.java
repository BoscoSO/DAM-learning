package ejemplo2UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class DatagramaCliente {

	
	
	public static void main(String[] args) throws IOException {
		InetAddress destino;
		
		destino= InetAddress.getLocalHost();
	
		
		int port=33333;
		byte[] mensaje=new byte[1024];
		String saludo="Hola servidor!";
		mensaje=saludo.getBytes();
		
		

		DatagramSocket socket;
		DatagramPacket envio = null;
			 socket=new DatagramSocket(34536);
		
			envio=new DatagramPacket(mensaje,mensaje.length,destino,port);


	
		System.out.println("Enviando datagrama de longitud:  "+mensaje.length);
		System.out.println("Host de destino: "+destino.getHostAddress());
		System.out.println("Puerto local del socket: "+socket.getLocalPort());
		System.out.println("Puerto al que enviamos: "+envio.getPort());
		

		socket.send(envio);
		
	}
}
