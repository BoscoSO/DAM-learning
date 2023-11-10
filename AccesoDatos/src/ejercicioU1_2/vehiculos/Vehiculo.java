package ejercicioU1_2.vehiculos;

public abstract class Vehiculo{
	static int SERIALM=0;
	static int SERIALC=0;
	private String color;
	private int numRuedas;
	private int cilindrada;
	private int potencia;
	
	Vehiculo(int potencia, int cilindrada, int numRuedas, String color){
		this.color=color;
		this.numRuedas=numRuedas;
		this.cilindrada=cilindrada;
		this.potencia=potencia;
	}

	public abstract double imposto();

	public double calculoImposto(int op){
		if(op==1){
			return this.cilindrada/30 +this.potencia+30;
		}else
			return this.cilindrada/30 + this.potencia*20+this.numRuedas*20;
	}
	public void setPotencia(int potencia){
		this.potencia=potencia;
	}
	public int getCilindrada(){
		return this.cilindrada;
	}
	
	
 	public String toString(){
 		return this.numRuedas+" ruedas \n"+
 				"\t Potencia: "+this.potencia+"\n"+
 				"\t Cilindrada: "+this.cilindrada+"\n"+
 				"\t Color: "+this.color;
 	}
	
}//VEHICULO



