package articulo;

class Libro extends Articulo{
	
	
    public float getPrecio() {
        return 0.0f;
    }

	@Override
	public boolean esAlquilable() {
		// TODO Auto-generated method stub
		return true;
	}
}