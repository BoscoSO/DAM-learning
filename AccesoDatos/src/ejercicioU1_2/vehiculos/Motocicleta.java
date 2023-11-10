package ejercicioU1_2.vehiculos;


public class Motocicleta extends Vehiculo{
	private int ocupantes;
	private int numSerie;
	
	public Motocicleta(int potencia, int cilindrada, String color){
		super(potencia,cilindrada,2,color);
		this.ocupantes=2;
		this.numSerie=++SERIALM;
	}
	public Motocicleta(int potencia, int cilindrada, String color, int ocupantes){
		super(potencia,cilindrada,2,color);
		this.ocupantes=ocupantes;

		this.numSerie=++SERIALM;
	}
	
	public double imposto(){
		return super.calculoImposto(1);
	}

	public void setPlazas(int plazas){
		this.ocupantes=plazas;
	}

	public int getCilindrada(){
		return super.getCilindrada();
	}
 	public String toString(){
 		return "Motocicleta "+this.numSerie+": "+super.toString()+"\n"+
 				"\t Plazas: "+this.ocupantes;
 	}
}//MOTOCICLETA