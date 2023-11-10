package articulo;

class Pelicula extends Articulo{
	

	@Override
    public boolean esAlquilable() {
        return true;
    }
}