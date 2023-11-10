
	import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
	
public class Pruebaex {

		static final String HOST = "localhost";
		static final int Puerto=2000;

		public Pruebaex( ) {


			try {
				// Inicio el servidor en el puerto
				ServerSocket serverSocket = new ServerSocket(Puerto);
				System.out.println("Escucho el puerto " + Puerto );
				// Se conecta un cliente
				Socket socket = serverSocket.accept(); 
				System.out.println("Cliente conectado");
				// Creo los flujos de entrada y salida
				DataInputStream bufferEntrada = new DataInputStream(socket.getInputStream());
				DataOutputStream bufferSalida = new DataOutputStream(socket.getOutputStream());
				bufferSalida.flush();
				// cuerpo
				Random randomGenerator = new Random();
				int num_secreto = randomGenerator.nextInt(100);
				int encontrado=0;
				String num_cliente=new String();
				bufferSalida.writeUTF("Tienes que adivinar un número del 0 al 100");	
				while (encontrado==0){	
					num_cliente=bufferEntrada.readUTF();			
					System.out.println("\tEl cliente ha dicho:" + num_cliente);

					if(num_secreto==Integer.parseInt(num_cliente)){
						bufferSalida.writeUTF("CORRECTO");
						encontrado=1;
					}else{
						if(num_secreto>Integer.parseInt(num_cliente))
							bufferSalida.writeUTF("El número secreto es mayor");
						else
							bufferSalida.writeUTF("El número secreto es menor");	
					}
				}		
				bufferSalida.writeUTF("FIN");
				// Se cierra la conexión
				socket.close();
				serverSocket.close();
				System.out.println("Cliente desconectado");

			} catch( Exception e ) {
				System.out.println( e.getMessage() );
			}
		}

		public static void main( String[] arg ) {
			new Pruebaex();
		}
	}