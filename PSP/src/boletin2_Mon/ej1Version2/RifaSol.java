package boletin2_Mon.ej1Version2;

public class RifaSol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sorteo sorteo = new Sorteo();
		sorteo.metodoSorteo();
		System.out.println("Los premios son: ");
		sorteo.getCajaPremios().imprimePremios();
		System.out.println("_____________________________________________");
		System.out.println("Inicio del sorteo: ");
		
		sorteo.comprobarBoletos();

	}
}
