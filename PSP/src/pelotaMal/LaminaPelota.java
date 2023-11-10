package pelotaMal;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

class LaminaPelota extends JPanel{
	
	//Añadimos pelota a la lamina
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
	
	public synchronized void add(Pelota b){
		
		pelotas.add(b);
	}
	
	public synchronized void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		
		for(Pelota b: pelotas){
			
			g2.fill(b.getShape());
		}
		
	}
	
	public synchronized void quita() {
		pelotas.remove(0);
	}
}