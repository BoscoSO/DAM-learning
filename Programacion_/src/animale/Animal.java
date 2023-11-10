package animale;

//Animal.java

public class Animal {
   private int edad;
   public Animal(int edad){
	    if(edad>15)
			this.edad = 15;
		else
			this.edad=edad;
   }
  public int getEdad() {
      return edad;
  }
}