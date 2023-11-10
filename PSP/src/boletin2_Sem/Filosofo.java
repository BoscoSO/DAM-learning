package boletin2_Sem;

public class Filosofo extends Thread{
	private int posiMesa;
	private MesaRedonda mesa;
	
	private boolean bucle=true;
	
	public Filosofo(int posiMesa,MesaRedonda mesa) {
		this.posiMesa = posiMesa;
		this.mesa=mesa;
	}

	@Override
	public void run() {
		while(bucle) {   //no terminan de comer nunca por lo que while(true)
			pensar();
			comer();
		}
		System.out.println("Filosofo "+posiMesa+" se levanta de la mesa");
	}

	private void comer()  {
		System.out.println("Filosofo "+posiMesa+" tiene hambre");
		
		if(mesa.tengoDos(posiMesa)) {
			System.out.println("Filosofo "+posiMesa+" está comiendo");
			try {sleep(1000);} catch (InterruptedException e) {}
			System.out.println("Filosofo "+posiMesa+" libera tenedores");
			bucle=false;
		}else if(mesa.tengoUno(posiMesa)){
			mesa.getPalDer(posiMesa);
		}else {
			System.out.println("Filosofo "+posiMesa+" recupera su tenedor");
			mesa.getPalIzq(posiMesa);
		}
		
	}

	private void pensar() {
		System.out.println("Filosofo "+posiMesa+" está pensando");
		
		try {sleep(2000);} catch (InterruptedException e) {}
		
	}

}
