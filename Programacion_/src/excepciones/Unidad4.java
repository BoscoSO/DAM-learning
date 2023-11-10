package excepciones;

abstract class Figura {
    protected String color;
    public Figura(String color) throws Exception {
    	if(color=="blanco") {
    		throw new Exception("Error color: "+color);
    	}
        this.color = color;
    }
    abstract public double area();
}

class Triangulo extends Figura{
    private double base;
    private double altura;
    public Triangulo(double base, double altura, String color) throws Exception{
        super(color);
        this.base = base;
        this.altura = altura;
    }
    @Override
    public double area() {
        return base*altura/2;
    }
}

class Circulo extends Figura{
    private double radio;
    public Circulo(double radio, String color) throws Exception{
        super(color);
        this.radio = radio;
    }
    @Override
    public double area(){
        return Math.PI*radio*radio;
    }
}

public class Unidad4 {
    public static void main(String[] args){
        try{
        	Circulo c = new Circulo(2.0,"blanco");
            System.out.println("Area circulo "+c.area());
            Triangulo t = new Triangulo(2.0,3.0,"rojo");
            System.out.println("Area triangulo "+t.area());
        }catch(Exception m) {
        	System.out.println(m.getMessage());
        }
        
    }
}