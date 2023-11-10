package ejercicioU1_3.probaCentroEstudos;
import ejercicioU1_3.centroEstudos.*;
public class ProbaCCentroEstudos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] notas= {0,1,2,3,4,5,6,7,8,9,10};
		int[] notas2= {3,6,4,7,5,3,6,4,7,3};
		CCentroEstudos centro=new CCentroEstudos();
		
		
		System.out.println("Aprobados : "+centro.numeroDeAprobados(notas));
		System.out.println("Suspensos : "+centro.numeroDeSuspensos(notas));
		System.out.println("Media : "+centro.notaMedia(notas2));
		System.out.println("Numero de pisos : "+centro.numeroDePisos+"\n"+
		"Numero de aulas : "+centro.numeroDeAulas+"\n"+
				"Numero de Despachos : "+centro.numeroDeDespachos+"\n");
	}

}
