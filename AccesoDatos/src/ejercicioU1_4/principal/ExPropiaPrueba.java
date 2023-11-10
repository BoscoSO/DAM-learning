package ejercicioU1_4.principal;
import ejercicioU1_4.excepciones.ExPropia;
import ejercicioU1_4.excepciones.ExPropiaClase;
public class ExPropiaPrueba {
	public static void main(String[] args){
		ExPropiaClase clase= new ExPropiaClase();
		
		System.out.println("ola");
		while(true) {
			try {
				clase.metodo();		
			}catch(ExPropia erro) {
				System.out.println(erro.getMessage());
			}
		}
		
	}
}
