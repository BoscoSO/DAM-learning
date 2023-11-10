package coche;

public class Motor {

    private int potencia;
    private int cilindros;

   	public Motor(int potencia,int cilindros) {
   		this.potencia=potencia;
   		this.cilindros=cilindros;
   	}
   	
    public int getPotencia() {
        return potencia;
    }
    public int getCilindros() {
        return cilindros;
    }
 
}
