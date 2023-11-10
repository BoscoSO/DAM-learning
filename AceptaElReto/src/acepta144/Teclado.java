package acepta144;

import java.util.LinkedList;
import java.util.Scanner;

public class Teclado {
	private LinkedList<Character> output;
	private int pos;
	public Teclado(){
		output=new LinkedList<>();
		pos=0;
	}
	private void fin() {
		pos=output.size();
	}
	private void inicio() {
		pos=0;
	}
	private void derecha() {
		if(pos!=output.size())
			 pos++;
	}
	private void supr() {
		if(pos<output.size())
			output.remove(pos);
	}
	private void addLetra(char c) {
		output.add(pos, c);
		pos++;
	}
	
	private void proceso(char c) {
		switch(c) {
			case '-':	inicio();
				break;
			case '+':	fin();
				break;
			case '3':	supr();
				break;
			case '*':	derecha();
				break;
			default:	addLetra(c);
		}
	}
	
	public void ejec(String input) {
		for(int i=0;i<input.length();i++) {
			proceso(input.charAt(i));
		}
	}
	public String salida() {
	
		String out="";
		while(!output.isEmpty()){
			out+=output.pollFirst();
		}
	
		return out;
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in); 
		Teclado teclado;
		
		while(sc.hasNext()){	
			String input=sc.nextLine();
			teclado=new Teclado();
			teclado.ejec(input);
			
			System.out.println(teclado.salida());
			
		}
		sc.close();
	}

}

