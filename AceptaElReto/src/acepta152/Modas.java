package acepta152;

/////////////////////////////
import java.util.ArrayList;
import java.util.Scanner;


class Elemento<K,V>{
    private K clave;
    private V veces;        

    public Elemento(K clave, V veces) {
        this.clave = clave;
        this.veces = veces;
    }

    public K getClave() {
        return clave;
    }
    public void setValor(V valor) {
    	veces=valor;
    }
    public V getValor() {
        return veces;
    }
    
    
    
}
class MiMapa<K,V>{
       
    ArrayList<Elemento<K,V>> almacen = new ArrayList<>();
    public void añadir(K clave, V valor) {
        almacen.add(new Elemento(clave, valor));
    }
   
    public void masVeces(K num,V valor) {
    	
    	 for (Elemento<K, V> c : almacen) {

             if (c.getClave().equals(num)) {
            	
            	 c.setValor(valor);
             }
    	 }
    }
    
    
    public V buscar(K clave) {
        V valor = null;

        for (Elemento<K, V> elemento : almacen) {

            if (elemento.getClave().equals(clave)) {
                valor = elemento.getValor();
            }
        }

        return valor;

    }
    
    
   
}

public class Modas {
	 public static int buscarModa(MiMapa<Integer,Integer> mm) {
	        int aux = 0;
	        int cl=0;
	        for (Elemento<Integer, Integer> e : mm.almacen) {
	        	if(e.getValor()>aux) {
	        		aux=e.getValor();
	        		cl=e.getClave();
	        	}
	        }
	        return cl;

	    }
    public static void main(String[] args) {
        MiMapa<Integer,Integer> mm;

        Scanner sc=new Scanner(System.in);
        
        
		int x;
		
		x=sc.nextInt();
		while(x!=0) {
			mm= new MiMapa<>();
			int aux;
			for(int i=0;i<x;i++) {
				aux=sc.nextInt();
				
				if(mm.buscar(aux)==null) {
					mm.añadir(aux,1);
				}else {
					int tmp=mm.buscar(aux)+1;
					mm.masVeces(aux, tmp);
				}
				
			}
			System.out.println(buscarModa(mm));
			
			x=sc.nextInt();
		}
		sc.close();

      
                
    }
}
