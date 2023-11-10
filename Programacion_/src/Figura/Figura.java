package Figura;

abstract class Figura {
	protected String color;
	
	Figura(String color){
		this.color=color;
	}
	
	abstract double area();
}
