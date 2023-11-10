package coche;

public class Coche {

    private String marca;
    private Motor motor;
    
    public Coche(String marca, int potencia, int cilindros) {
    	this.marca=marca;
    	this.motor=new Motor(potencia,cilindros);	
    }
    
    public Motor getMotor() {
        return motor;
    }

    public String getMarca() {
        return marca;
    }

  
    
    public int getPotencia() {
        return motor.getPotencia();
    }
    
}

