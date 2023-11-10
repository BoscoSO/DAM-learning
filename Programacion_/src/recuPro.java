import java.util.Scanner;

public class recuPro {
	private static void procesarRecorrido(String linea) {
		String[] marchas=new String[13];
		int posicionMarcha=Integer.parseInt(linea.substring(0, 2));
		
		
		char aux=' ';
		int i=2;
		while(aux!='S') {
			aux=linea.charAt(i);
			if(aux=='S')
				break;
			if(aux=='U') {
				posicionMarcha++;
				i++;
			}else if(aux=='D') {
				posicionMarcha--;
				i++;
			}else {
				
				int tiempo=Integer.parseInt(linea.substring(i, i+3));
				String tiempoS=String.valueOf(tiempo);
				marchas[posicionMarcha]=tiempoS;
				i+=3;
			}
			
		}
		
		for(int x=0 ; x<13 ; x++) {
			if(marchas[x]!=null)
				System.out.println(x+" "+marchas[x]);	
		}
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 	
			
		int veces = sc.nextInt();
		
		sc.nextLine();
		
		
		for(int bucle=0 ; bucle<veces ; bucle++) {
			
			String linea=sc.nextLine();
			System.out.println("Caso "+(bucle+1)+":");
			procesarRecorrido(linea);
			
			
		}
		
	}

	

}
