package articulo;

abstract class Articulo{
    protected String titulo;
    protected float precio = 5.0f;
    
    public abstract boolean esAlquilable();
    
    public float getPrecio() {
        return precio;
    }
}