package practicaSockets.ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class ClienteEj2 {

	private Socket socket;
	private ServerSocket serverSocket;
	private DataInputStream bufferEntrada = null;
	private DataOutputStream bufferSalida = null;

	Scanner sc = new Scanner(System.in);

	final String COMANDO_END = "salir()";

	public void levantarConexion(String ip, int puerto) {
		try {
			socket = new Socket(ip, puerto);

			mostrarTexto(("Conexion establecida con : " + socket.getInetAddress().getHostName() + "\n\n\n"));

		} catch (IOException e) {
			mostrarTexto("Error en levantarConexion: " + e.getMessage());
			System.exit(0);
		}
	}

	public void mostrarTexto(String s) {
		System.out.println(s);
	}

	public void abrirFlujos() {
		try {
			bufferEntrada = new DataInputStream(socket.getInputStream());
			bufferSalida = new DataOutputStream(socket.getOutputStream());

			bufferSalida.flush();

		} catch (IOException e) {
			mostrarTexto("Error en abrirFlujos: " + e.getMessage());
		}
	}

	public void enviar(String s) {
		try {
			bufferSalida.writeUTF(s);
			bufferSalida.flush();
		} catch (IOException e) {
			mostrarTexto("Error en enviar: " + e.getMessage());
			cerrarConexion();
		}
	}

	public void cerrarConexion() {
		try {
			bufferEntrada.close();
			bufferSalida.close();
			socket.close();
			// serverSocket.close();
		} catch (IOException e) {
			mostrarTexto("Error en cerrarConexion: " + e.getMessage());
		} finally {
			mostrarTexto("Conversacion finalizada");
			System.exit(0);
		}
	}

	public void ejectarConexion(String ip, int puerto) {
		Thread hilo = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					try {
						levantarConexion(ip, puerto);
						abrirFlujos();
						recibirDatos();
					} finally {
						cerrarConexion();
					}
				}
			}
		});

		hilo.start();
	}

	   public void recibirDatos() {
	        String st = "";
	        try {
	            do {
	                st = (String) bufferEntrada.readUTF();
	                mostrarTexto("\n[Servidor] => " + st);
	                System.out.print("\n[Usted] => ");
	            } while (!st.equals(COMANDO_END));
	        } catch (IOException e) {}
	    }

	    public void escribirDatos() {
	        String entrada = "";
	        while (true) {
	            System.out.print("[Usted] => ");
	            entrada = sc.nextLine();
	            if(entrada.length() > 0)
	                enviar(entrada);
	        }
	    }
	public static void main(String[] args) {
		ClienteEj2 c=new ClienteEj2();
		Scanner sc2=new Scanner(System.in);
		c.mostrarTexto("Introduce IP: [localhost por defecto]");
		String ip=sc2.nextLine();
		if(ip.isEmpty())
			ip="localhost";
		
		c.mostrarTexto("Introduce puerto: [localhost por 1500]");
		String puerto=sc2.nextLine();
		if(puerto.isEmpty())
			puerto="1500";
		
		c.ejectarConexion(ip, Integer.parseInt(puerto));
		c.mostrarTexto("Introduce el nombre de un fichero para ver su contenido o escribe salir() para cerrar");
		c.escribirDatos();

	}
}
