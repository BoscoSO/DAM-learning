package boletin1_3.dto4;

import java.util.Random;

public class Fillo {

	public int getRandomNum() {
		Random r=new Random();	
		int aux=r.nextInt(10);
		return aux;
	}
}
