package Figura;

public class Circulo extends Figura{
	private double radio;
	
	Circulo(double radio,String color) {
		super(color);
		this.radio=radio;
	}
	@Override
	double area() {
		return 3.14*radio;
	}

}
