package boletin2_Sem;

import java.util.concurrent.Semaphore;

public class MesaRedonda {

	private Semaphore s=new Semaphore(1);
	
	private int[] palillos;

	public MesaRedonda() {
		this.palillos = new int[] {1,1,1,1,1}; 
	}

	public boolean getPalDer(int pos) {
		try {s.acquire();} catch (InterruptedException e) {e.printStackTrace();}
		if(palillos[(pos+1)%5]>0) {
			palillos[(pos+1)%5]-=1;
			palillos[pos]+=1;
			s.release();
			return true;
		}else {
			s.release();
			return false;
		}
	}
	public boolean getPalIzq(int pos) {
		try {s.acquire();} catch (InterruptedException e) {e.printStackTrace();}
		int p=pos-1;
		if(pos==0)
			p=4;
		if(palillos[p]>0) {
			palillos[p]-=1;
			palillos[pos]+=1;
			s.release();
			return true;
		}else {
			s.release();
			return false;
		}
	}
	public boolean tengoDos(int pos) {
		if(palillos[pos]==2) 
			return true;
		return false;
	}
	public boolean tengoUno(int pos) {
		if(palillos[pos]==1) 
			return true;
		return false;
	}
}
