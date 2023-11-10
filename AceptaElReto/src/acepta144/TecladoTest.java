package acepta144;

import java.util.LinkedList;
import java.util.Scanner;

public class TecladoTest {
	
	public void ejec(String input) {
		LinkedList<Character> output=new LinkedList<>();
		int pos=0;
		
		for(int i=0;i<input.length();i++) {
			char c=input.charAt(i);
			switch(c) {
				case '-':	pos=0;
					break;
				case '+':	pos=output.size();
					break;
				case '3':	if(pos<output.size()) {
								output.remove(pos);
							}
					break;
				case '*':	if(pos!=output.size()) {
								pos++;
							}
					break;
				default:	
					output.add(pos, c);
					pos++;
			}
			
		}
		

		String out="";
		while(!output.isEmpty()){
			out+=output.pollFirst();
		}
	
		System.out.println(out);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in); 
		TecladoTest teclado=new TecladoTest();
		
		while(sc.hasNext()){	
			String input=sc.nextLine();
			teclado.ejec(input);
			
		}
	}

}

