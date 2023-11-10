package ordenador;

class Figura{
    private String color; 
    
    void setColor(String color){
        this.color=color;
    }
    String getColor(){
        return color;
    }
}

class Cuadrado extends Figura{
    private double lado;

    Cuadrado(double lado, String color){
        super.setColor(color);
        this.lado = lado;
    }

    double getLado() {
        return lado;
    }
}


class Circulo extends Figura{
    private double radio;

    Circulo(double radio, String color){
    	super.setColor(color);
        this.radio = radio;
    }
    
}
