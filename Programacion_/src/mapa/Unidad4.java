package mapa;

import java.util.HashMap;
import java.util.Scanner;
class Unidad4 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner sc= new Scanner(System.in);
        HashMap<String,Integer> hm= new HashMap<>();
        System.out.print("palabra: ");
        String  palabra=sc.next();
        while(!palabra.equals("fin")){
            
            int veces;
            if(hm.get(palabra)==null){//la palabra no estaba en el mapa
                veces=1;
            }else{
                veces=hm.get(palabra)+1;
            };
            hm.put(palabra, veces);
            System.out.print("palabra: ");
            palabra=sc.next();
        }
        System.out.println("Comprobamos ...");
        for(String s:hm.keySet()){
            System.out.println(s+" apararece "+hm.get(s)+" veces");
        }
        
   }
    
}