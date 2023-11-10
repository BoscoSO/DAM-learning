package ejercicioU1_2.vehiculos;


public class Camion extends Vehiculo{
	private int numEjes;
	private int numSerie;

	public Camion(int potencia, int cilindrada, int numRuedas, String color, int numEjes){
		super(potencia,cilindrada,numRuedas,color);
		this.numEjes=numEjes;
		this.numSerie=++SERIALC;
	}
	public Camion(int cilindrada, int numRuedas, int numEjes){
		super(0,cilindrada,numRuedas,"no especificado");
		this.numEjes=numEjes;

		this.numSerie=++SERIALC;
	}

	public double imposto(){
		return super.calculoImposto(0)+numEjes*50;
	}

	public void setPotencia(int potencia){
		super.setPotencia(potencia);
	}
	public String toString(){
 		return "Camion "+this.numSerie+": "+super.toString()+"\n"+
 				"\t Ejes: "+this.numEjes;
 	}
}//CAMION