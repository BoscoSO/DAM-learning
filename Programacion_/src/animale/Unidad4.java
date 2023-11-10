package animale;

import animale.*;
public class Unidad4{
    public static void main(String[] args) {
       Perro canKan=new Perro(16,true);
       Gato  cati=new Gato(13,false);
       
       System.out.println("Edad canKan: "+ canKan.getEdad() +"   Es pura raza canKan: "+ canKan.esPuraRaza());
       System.out.println("Edad cati: "+ cati.getEdad() +"   cati es raza europea: "+ cati.esRazaEuropea());
    }
}
