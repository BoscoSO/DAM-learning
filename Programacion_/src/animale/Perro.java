package animale;


public class Perro extends Animal {
    private boolean puraRaza;

    public Perro(int edad,boolean puraRaza) {
    	super(edad);
    	this.puraRaza = puraRaza;
    }
    public boolean esPuraRaza(){
        return puraRaza;
    }

    
}
