package paresInpares;

import java.util.concurrent.Semaphore;

public class  GeneradorParImpar{
	Semaphore semImpar = new Semaphore(1); 
	Semaphore semPar = new Semaphore(0);
	
	public void imprimeImpar(int num) {
		try {
			semImpar.acquire();
			System.out.println("- "+Thread.currentThread().getName()+num+" per : "+semImpar.availablePermits());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semPar.release();
		}
	}
	public void imprimePar(int num) {
		try {
			semPar.acquire();
			System.out.println("- "+Thread.currentThread().getName()+num+" per : "+semPar.availablePermits());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semImpar.release();
		}
	}
	
	
	
	
	
	
}