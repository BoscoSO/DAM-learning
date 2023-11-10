package ordenarListas;


import java.util.Collections;
import java.util.LinkedList;

class Articulo implements Comparable<Articulo> {
    public String codArticulo; // Código de artículo
    public String descripcion; // Descripción del artículo.
    public int cantidad; // Cantidad a proveer del artículo.
    //añado constructor por comodidad para Unidad5

    public Articulo(String codArticulo, String descripcion, int cantidad) {
        this.codArticulo = codArticulo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }
    @Override
   public int compareTo(Articulo o) {
    	if(this.cantidad<=o.cantidad) {
    		return -1;
    	}
    	return 1;// codArticulo.compareTo(o.codArticulo); }
    }
}
public class Unidad5 {

    public static void main(String[] args) {
        LinkedList<Articulo> articulos = new LinkedList<>();
        articulos.add(new Articulo("34","cuchillo",5));
        articulos.add(new Articulo("12","tenedor",7));
        articulos.add(new Articulo("41","cuchara",4));
        articulos.add(new Articulo("11","plato",6));
        
        Collections.sort(articulos);
        for(Articulo a:articulos)
            System.out.println(a.codArticulo+", "+a.descripcion+", "+a.cantidad);
    }
}

