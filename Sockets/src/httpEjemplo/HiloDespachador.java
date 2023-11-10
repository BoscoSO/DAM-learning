package httpEjemplo;


import java.io.*;
import java.net.Socket;

/**
 ******************************************************************************
 * hilo para despachar la petición recibida por el Servidor HTTP mediante el
 * socket especificado en su constructor
 */
class HiloDespachador extends Thread {

  //socket cliente
  private Socket socketCliente = null;

  /**
   * **************************************************************************
   * constructor
   *
   * @param nombre
   */
  public HiloDespachador(Socket socketCliente) {
    this.socketCliente = socketCliente;
  }

  /**
   * **************************************************************************
   * método que atiende la petición
   */
  @Override
  public void run() {
    //
    InputStreamReader inSR = null;

    try {
      //variables locales
      String peticion;
      String html;
      inSR = new InputStreamReader(socketCliente.getInputStream());
      //espacio en memoria para la entrada de peticiones
      BufferedReader bufLeer = new BufferedReader(inSR);
      //objeto de java.io que entre otras características, permite escribir
      //'línea a línea' en un flujo de salida
      PrintWriter printWriter = new PrintWriter(
              socketCliente.getOutputStream(), true);
      //petición entrante
      peticion = bufLeer.readLine();
      //para compactar la petición y facilitar así su análisis, suprimimos todos
      //los espacios en blanco que contenga
      peticion = peticion.replaceAll(" ", "");
      //extrae la subcadena entre 'GET' y 'HTTP/1.1'
      peticion = peticion.substring(3, peticion.lastIndexOf("HTTP"));
      //si corresponde a la página de inicio
      if (peticion.length() == 0 || peticion.equals("/")) {
        //sirve la página
        html = Paginas.html_index;
        printWriter.println(Mensajes.lineaInicial_OK);
        printWriter.println(Paginas.primeraCabecera);
        printWriter.println("Content-Length:" + html.length() + 1);
        printWriter.println("\n");
        printWriter.println(html);
      } //si corresponde a la página del Quijote
      else if (peticion.equals("/quijote")) {
        //sirve la página
        html = Paginas.html_quijote;
        printWriter.println(Mensajes.lineaInicial_OK);
        printWriter.println(Paginas.primeraCabecera);
        printWriter.println("Content-Length: " + html.length() + 1);
        printWriter.println("\n");
        printWriter.println(html);
      } //en cualquier otro caso
      else {
        //sirve la página
        html = Paginas.html_noEncontrado;
        printWriter.println(Mensajes.lineaInicial_NotFound);
        printWriter.println(Paginas.primeraCabecera);
        printWriter.println("Content-Length: " + html.length() + 1);
        printWriter.println("\n");
        printWriter.println(html);
      }
      
      //cierra los flujos
      inSR.close();
      printWriter.close();
    } catch (IOException e) {
      //
      System.err.println("Error de lectura/escritura");
    }
  }
}
