package practica2;

import java.util.concurrent.Semaphore;

public class MesaRedonda {

	
	private int[] palillos=new int[] {1,1,1,1,1};
	
	Semaphore s1=new Semaphore(1);
	Semaphore s2=new Semaphore(1);
	Semaphore s3=new Semaphore(1);
	Semaphore s4=new Semaphore(1);
	Semaphore s5=new Semaphore(1);
	
	
	
	private Semaphore[] pal=new Semaphore[] {s1,s2,s3,s4,s5};
	
	public synchronized void cogerPalillo(int miPos) {
		try {
			pal[miPos].acquire();
			pal[(miPos-1)%5].acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if(palillos[miPos]==0)
//			s.acquire();
//
//			if(palillos[miPos-1]==1) {
//				palillos[miPos-1]--;
//				palillos[miPos]++;
//			}		
//			
		//else recupera tu palillo primero
		
	}
	
	public synchronized void devolverPalillo(int miPos) {
		pal[miPos].release();
		pal[(miPos-1)%5].release();
		
//		if(palillos[miPos]==2) {
//				palillos[(miPos-1)%5]++;
//				palillos[miPos]--;
//				
//		}
		
	}
	
	
	
}
