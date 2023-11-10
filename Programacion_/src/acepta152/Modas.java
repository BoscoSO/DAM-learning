package acepta152;

import java.util.HashMap;
import java.util.Scanner;

public class Modas {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        HashMap<String,Integer> hm= new HashMap<>();
		int caso;
		int veces;
		String num;
		caso=sc.nextInt();
		
		while(caso!=0) {

			veces=0;
			for(int i=0;i<caso;i++) {
	            num=sc.next();
				if(hm.get(num)==null){//el num no estaba en el mapa
		               veces=1;
		        }else{
		                veces=hm.get(num)+1;
		            };
		         hm.put(num, veces);
			}
			int aux=0;
			String numero="";
			for(String s:hm.keySet()){
				if(hm.get(s)>aux) {
					aux=hm.get(s);
					numero=s;
				}	
	        }
			
			System.out.println(numero);
			hm.clear();
			caso=sc.nextInt();
			
		}//end while
		
	}

}
