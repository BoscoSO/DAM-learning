package series;

interface Parlanchin{
	void habla();
}
abstract class Animal implements Parlanchin{
	
}

class Gato extends Animal{
    public void habla() {
    	System.out.println("¡Miau!");
    }
}
class Perro extends Animal{
    public void habla() {
    	System.out.println("¡Guau!");
    }
}
class RelojCuco implements Parlanchin{
    public void habla() {
    	System.out.println("¡Cucu, cucu, ..!");
    }
}
public class Unidad4 {
    public static void main(String[] args) {
        Gato g = new Gato();
        Perro p = new Perro();
        RelojCuco rc = new RelojCuco();
        g.habla();
        p.habla();
        rc.habla();
    }
}