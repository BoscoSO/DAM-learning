package boletin2_Sem;

public class ProgramaFilosofos { 

	
	public static void main(String[] args) {
		
		MesaRedonda mesa=new MesaRedonda();
		
		for (int i = 0; i < 5; i++) {
			Filosofo f= new Filosofo(i, mesa);
			f.start();	
		}
	}
	
	
}
