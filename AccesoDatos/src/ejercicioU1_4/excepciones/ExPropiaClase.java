package ejercicioU1_4.excepciones;

import java.util.Scanner;

public class ExPropiaClase  {

	Scanner sc = new Scanner(System.in);
	public void metodo() throws ExPropia{
		
		if(sc.nextInt()==0) throw new ExPropia("Es cero");
		
	}
}
