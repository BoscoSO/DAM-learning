package acepta452;


import java.util.*;


public class Bingo {

	private int[] nums;
	private TreeSet<Integer> sol;
	
	private int pos;
	
	Bingo (int n){
		sol=new TreeSet<>();
		nums= new int[n];
		pos=0;
	}
	public void add(int x) {
		nums[pos]=x;
		pos++;
	}
	
	public void see() {
		int aux=0;
		
		for(int i=0;i<nums.length-1;i++) {
			for(int x=i+1;x<nums.length;x++) {
				aux=Math.abs(nums[i]-nums[x]);
				sol.add(aux);
			}
		}
			
		
	}
	public String toString() {
		String cad="";
		int c=sol.size();
		for(int i=0;i<c;i++) {
			cad+=sol.pollFirst();
			
			if(i!=c-1)
				cad+=" ";
		}
		
		return cad;
	}
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int x;
		Bingo bg;
		x=sc.nextInt();
		while(x!=0) {
			bg=new Bingo(x);
			
			for(int i=0;i<x;i++) {
				bg.add(sc.nextInt());
			}
			bg.see();
			System.out.println(bg.toString());
			
			x=sc.nextInt();
		}
		sc.close();

	}

}
