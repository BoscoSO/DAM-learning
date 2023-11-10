package herenciaMult;

class Mamifero{
    int tiempoLactancia;

    public Mamifero(int tiempoLactancia) {
        this.tiempoLactancia = tiempoLactancia;
    }
    void mamar(){System.out.println("chup chup");}
    
}
class AnimalAcuatico{
    int temperaturaAgua;
    public AnimalAcuatico(int temperaturaAgua) {
        this.temperaturaAgua = temperaturaAgua;
    }
    void nadar(){System.out.println("glu glu");}   
}

class Ballena extends Mamifero{
	AnimalAcuatico estaBallena;
	public Ballena(int tiempoLactancia,int temp) {
		super(tiempoLactancia);
		estaBallena=new AnimalAcuatico(temp);
		
		// TODO Auto-generated constructor stub
	}
	void nadar() {estaBallena.nadar();}
	
}

public class Unidad4 {

	public static void main(String[] args) {
        Ballena b= new Ballena(2,15);
        b.nadar();
        b.mamar();
    }

}
