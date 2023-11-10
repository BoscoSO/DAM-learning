package ejercicioU1_3.interfaces;

public interface CalculosCentroEstudos {
	public default int numeroDeAprobados(int[] notas) {
		int cont=0;
		for(int i=0;i<notas.length;i++)
			if(notas[i]>5)
				cont++;

		return 	cont;
	}
	public default int numeroDeSuspensos(int[] notas) {
		int cont=0;
		for(int i=0;i<notas.length;i++)
			if(notas[i]<5)
				cont++;

		return 	cont;
	}
	public default int notaMedia(int[] notas) {
		int cont=0;
		for(int i=0;i<notas.length;i++)
				cont+=notas[i];

		return 	cont/(notas.length+1);
	}
}
