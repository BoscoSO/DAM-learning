
import dni.DNIException;
import empleado.Empleado;

public class Unidad4 {
	public static void main(String[] args) {
	//metemos tb. un string vacio ""
    	
    try {
    	new Empleado("45907503D","Juan",20.02);
    	System.out.println("primer empleado OK");
	} catch (DNIException e) {
		// TODO Auto-generated catch block
		e.getMessage();
	}
    
    
    try {
    	new Empleado("45907503A","Jhonn",11.02);
    	System.out.println("segundo empleado OK");
    	
	} catch (DNIException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	}
}