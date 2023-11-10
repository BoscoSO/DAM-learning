package practicaSockets.ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class ServidorEj1 {
	private Socket socket;
	private ServerSocket serverSocket;
	private DataInputStream bufferEntrada = null;
	private DataOutputStream bufferSalida = null;

	Scanner sc = new Scanner(System.in);

	final String COMANDO_END = "salir()";
	int num = 0;

	public void levantarConexion(int puerto) {
		try {
			serverSocket = new ServerSocket(puerto);
			socket = serverSocket.accept();

			mostrarTexto(("Conexion establecida con : " + socket.getInetAddress() + "\n\n\n"));
		} catch (IOException e) {
			mostrarTexto("Error en levantarConexion: " + e.getMessage());
			System.exit(0);
		}
	}

	public void flujos() {
		try {
			bufferEntrada = new DataInputStream(socket.getInputStream());
			bufferSalida = new DataOutputStream(socket.getOutputStream());

			bufferSalida.flush();

		} catch (IOException e) {
			mostrarTexto("Error en flujos: " + e.getMessage());
		}

	}

	public void recibirDatos() {
		String str = "";

		try {
			do {
				str = (String) bufferEntrada.readUTF();
				mostrarTexto("\n[Cliente] ->" + str);
				procesa(str);

				System.out.print("\n[Usted] => ");
			} while (!str.equals(COMANDO_END));

		} catch (IOException e) {
			mostrarTexto("Error en recibirDatos: " + e.getMessage());
			cerrarConexion();
		}
	}

	public void enviarDatos(String s) {

		try {
			bufferSalida.writeUTF(s);
			bufferSalida.flush();
		} catch (IOException e) {
			mostrarTexto("Error en enviarDatos: " + e.getMessage());
			cerrarConexion();
		}
	}

	public void mostrarTexto(String s) {
		System.out.println(s);
	}

	public void escribirDatos() {

		while (true) {
			System.out.print("[Usted] => ");
			enviarDatos(sc.nextLine());
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

	public void ejecutarConexion(int puerto) {
		Thread hilo = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					try {
						levantarConexion(puerto);
						flujos();
						recibirDatos();
					} finally {
						cerrarConexion();
					}
				}
			}
		});

		hilo.start();

	}

	private void procesa(String str) {
		// TODO Auto-generated method stub
		try {
			int auX = Integer.parseInt(str);

			if (auX < num) {
				flujos();
				enviarDatos("Te quedaste corto");
			} else if (auX > num) {
				flujos();
				enviarDatos("Te pasaste, prueba otra vez");
			} else {
				flujos();
				enviarDatos("Enhorabuena, acertaste");

			}
		} catch (Exception e) {

		}
	}

	public static void main(String[] args) throws IOException {
		ServidorEj1 s = new ServidorEj1();

		Scanner s2c = new Scanner(System.in);

		s.mostrarTexto("Introduce el puerto (5050 por defecto)");
		String puerto = s2c.nextLine();
		if (puerto.isEmpty()) {
			puerto = "5050";
		}
		s.ejecutarConexion(Integer.parseInt(puerto));

		Random r = new Random();
		s.num = r.nextInt(100);
		s.mostrarTexto("El n�mero secreto es " + s.num);
		s.escribirDatos();

	}
}
