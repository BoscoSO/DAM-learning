package ejercicioU1_2.probaVehiculos;

import ejercicioU1_2.vehiculos.*;

public class ProbaVehiculos {
	public static void main(String[] args){
	    Motocicleta moto1=new Motocicleta(25,125,"rojo");
    	Motocicleta moto2=new Motocicleta(25,125,"verde",2);
    	Camion camion1= new Camion(300,4000,4,"azul",2);
    	Camion camion2= new Camion(1500,24,6);
		Vehiculo[] lista={moto1,moto2,camion1,camion2};

		moto1.setPlazas(1);
		System.out.println("cilindrada moto2 ="+moto2.getCilindrada()+"\n\n");
		camion2.setPotencia(800);

		for(Vehiculo c:lista){
			System.out.println(c.toString()+"\n Imposto: "+c.imposto()+" euros\n");	
		}
  }
}
