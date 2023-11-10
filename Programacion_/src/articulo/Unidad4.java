package articulo;

class Unidad4 {

	public static void main(String[] args) {
		Pelicula pelicula = new Pelicula();
        Libro libro = new Libro();
        System.out.println(pelicula.esAlquilable());
        System.out.println(libro.getPrecio());
    }
}