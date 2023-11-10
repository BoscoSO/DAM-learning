package calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Unidad4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Calendar cal = Calendar.getInstance(); 
       cal.set(1986,9,16,11,45);
       
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
       System.out.println(sdf.format(cal.getTime()));
   }
}