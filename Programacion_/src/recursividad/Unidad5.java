package recursividad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Unidad5 {

	static List<String> combinaciones(int longitud, List<String> numeros) {
        ArrayList<String> res = new ArrayList<>();
       
        
        if (longitud == 1) {
            for (String s : numeros) {
                res.add(s);
            }
            
        } else if (numeros.size() == 1) {
            String s = "";
            for(int i=0;i<longitud;i++) 
                s += numeros.get(0);
            
            res.add(s);
            
        } else {
            List<String> aux = combinaciones(longitud - 1, numeros);
            for (String s : numeros) {
                for (String s2 : aux) {
                    res.add(s + s2);
                }
            }
        }
        return res;
    }
	

  
    
    
  public static void main(String[] args) {
        List<String> numeros=Arrays.asList("0","1","2");
        
        System.out.println("combinaciones de  0, 1 y 2 con longitud 2");
        int longitud=2;
        List<String> result=combinaciones(longitud,numeros);
        for(String s:result){
            System.out.println(s);
        }
        
        System.out.println("combinaciones de  0, 1 y 2 con longitud 3");
        longitud=3;
        result=combinaciones(longitud,numeros);
        for(String s:result){
            System.out.println(s);
        }
        
        System.out.println("combinaciones de  8 y 5 con longitud 4");
        numeros=Arrays.asList("8","5");
        longitud=4;
        result=combinaciones(longitud,numeros);
        for(String s:result){
            System.out.println(s);
        }
                
    }
    
}
