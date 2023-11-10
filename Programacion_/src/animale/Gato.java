package animale;

public class Gato extends Animal {
    private boolean razaEuropea;

    public Gato(int edad,boolean razaEuropea) {
        super(edad);
    	this.razaEuropea=razaEuropea;
    }
    public boolean esRazaEuropea(){
        return razaEuropea;
    }

    
}