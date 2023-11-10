package povOf2;

import java.util.ArrayList;
import java.util.List;

import dni.DNI;
import dni.DNIException;

public class Principal {

	public static String povOf2(int exp) {
		if(exp==0)
			return "0";
		List<Integer> digits=new ArrayList<Integer>();
		digits.add(1);
		int size=1;
		int tmp;
		int ac=0;
		//1st loop
		for(int i=0;i<exp;i++) {
			//2nd loop
			for(int c=0;c<size;c++) {
				tmp=digits.get(c);
				tmp*=2;
				tmp+=ac;
				ac=0;
				//1st if
				if(tmp>9) {
					tmp-=10;
					ac=1;
				}
				digits.set(c,tmp);
			}
			//2nd if
			if(ac==1) {
				digits.add(ac);
				size++;
				ac=0; // (1)
			}
				
		}
		String s="";
		//3er loop
		for(int i=digits.size()-1;i>=0;i--) {
			s+=digits.get(i);
		}
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		
		System.out.println(i+" -> "+povOf2(0));i++;
		System.out.println(i+" -> "+povOf2(1));i++;
		System.out.println(i+" -> "+povOf2(2));i++;
		System.out.println(i+" -> "+povOf2(3));i++;i++;
		System.out.println("-10 -> "+povOf2(-10));i++;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
	}

}
