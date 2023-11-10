package httpEjemplo;


import java.io.IOException;
//
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorHTTPMultihilo {

  /**
   * **************************************************************************
   * inicia un servidor HTTP escuchando por el puerto 8066, capaz de gestionar
   * la concurrencia mediante hilos
   * 
   * @param args the command line arguments
   */
  public static void main(String[] args) {		//FUNCIONA EN FIREFOX

    //variables locales
    ServerSocket socServidor;
    Socket socketCliente;
    HiloDespachador hilo;
    //    
    try {
      //
      socServidor = new ServerSocket(8066);
      //servidor disponible
      imprimeDisponible();
      //indefinidamente
      while (true) {
        //ante una petición entrante, asigna un socket cliente 
        //para enviar la respuesta a la petición
        socketCliente = socServidor.accept();
        //crea un nuevo hilo para atenderla por el socket cliente...
        hilo = new HiloDespachador(socketCliente);
        hilo.start();
      }
    } catch (IOException ex) {
    }
  }

  /**
   * **************************************************************************
   * muestra un mensaje en la Salida que confirma el arranque, y da algunas
   * indicaciones posteriores
   */
  private static void imprimeDisponible() {

    System.out.println("El Servidor WEB se está ejecutando y permanece a la "
            + "escucha por el puerto 8066.\nEscribe en la barra de direcciones "
            + "de tu explorador preferido:\n\nhttp://localhost:8066\npara "
            + "solicitar la página de bienvenida\n\nhttp://localhost:8066/"
            + "quijote\npara solicitar una página del Quijote, y \n\nhttp://"
            + "localhost:8066/q\npara simular una petición de página "
            + "inexistente.\n\nLa gestión de la concurrencia mediante hilos, le "
            + "permite ahora atender varias peticiones a la vez");
  }
}
