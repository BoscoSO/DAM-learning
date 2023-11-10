package ejercicio1;

class Vehiculo{
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
	public void setPlazas(int i) {
		// TODO Auto-generated method stub
		
	}

}

class Camion extends Vehiculo{
	private int numEjes;

	Camion(int potencia, int cilindrada, int numRuedas, String color, int nunEjes){
		super(potencia,cilindrada,numRuedas,color);
		this.numEjes=numEjes;
		System.out.println(numEjes+" insertados");
	}
	Camion(int cilindrada, int numRuedas, int nunEjes){
		super(0,cilindrada,numRuedas,"no especificado");
		this.numEjes=numEjes;
			System.out.println(numEjes+" insertados");
	}
	public void setPotencia(int potencia){
		super.setPotencia(potencia);
	}
	public String toString(){
 		return "Camion: "+super.toString()+"\n"+
 				"\t Ejes: "+this.numEjes;
 	}
}

class Motocicleta extends Vehiculo{
	private int ocupantes;
	Motocicleta(int potencia, int cilindrada, String color){
		super(potencia,cilindrada,2,color);
		this.ocupantes=1;
	}
	Motocicleta(int potencia, int cilindrada, String color, int ocupantes){
		super(potencia,cilindrada,2,color);
		this.ocupantes=ocupantes;
	}
	public void setPlazas(int plazas){
		this.ocupantes=plazas;
	}

	public int getCilindrada(){
		return super.getCilindrada();
	}
 	public String toString(){
 		return "Motocicleta: "+super.toString()+"\n"+
 				"\t Plazas: "+this.ocupantes;
 	}
}


public class Ejercicio1{
  public static void main(String[] args){
    	Vehiculo moto1=new Motocicleta(25,125,"rojo");
		Vehiculo moto2=new Motocicleta(25,125,"verde",2);
		Vehiculo camion1= new Camion(300,4000,4,"azul",2);
		Vehiculo camion2= new Camion(1500,24,6);
		Vehiculo[] lista={moto1,moto2,camion1,camion2};

	//moto1.this.setPlazas(1);
		moto1.setPlazas(1);
		System.out.println("cilindrada moto2 ="+moto2.getCilindrada()+"\n\n");
		camion2.setPotencia(800);

		for(Vehiculo c:lista){
		System.out.println(c.toString()+"\n");	
		}
  }
}





