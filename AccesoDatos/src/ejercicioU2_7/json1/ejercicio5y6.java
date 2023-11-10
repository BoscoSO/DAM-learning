package ejercicioU2_7.json1;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Element;

import com.thoughtworks.xstream.io.json.JsonWriter;
public class ejercicio5y6 {
	public void generarJsonMenuVersion1() {
		Writer a;
		try {
			a = new FileWriter("menuV1.json");
			JsonWriter w=new JsonWriter(a);
			
			w.startNode("menu");
				w.addAttribute("id", "file");
				w.addAttribute("value", "File");
				w.startNode("popup");
					w.startNode("menuItem");	
						w.addAttribute("value","New");
						w.addAttribute("onclick","CreateNewDoc");
					w.endNode();
					
					w.startNode("menuItem");	
						w.addAttribute("value","Open");
						w.addAttribute("onclick","OpenDoc()");
					w.endNode();
					
					w.startNode("menuItem");	
						w.addAttribute("value","Close");
						w.addAttribute("onclick","CloseDoc()");
					w.endNode();
				w.endNode();
			
			w.endNode();
			
			w.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public void generarJsonMenu()  {
			
		try {
			JSONObject padre= new JSONObject();
			JSONObject menu= new JSONObject();
			JSONObject item1= new JSONObject();
			JSONObject aux= new JSONObject();
			
			JSONArray arr=new JSONArray();
			
			item1.put("Value", "New");
			item1.put("onclick", "CreateNewDoc()");
			aux.put("menu-item",item1);
			arr.add(aux);
					
			item1= new JSONObject();
			aux= new JSONObject();
			item1.put("Value", "Open");
			item1.put("onclick", "OpenDoc()");
			aux.put("menu-item",item1);
			arr.add(aux);
			
			item1= new JSONObject();			
			item1.put("Value", "Close");
			item1.put("onclick", "CloseDoc()");
			aux.put("menu-item",item1);
			arr.add(aux);
			
			
			menu.put("id", "file");
			menu.put("value", "File");
			menu.put("popup",arr);
			
			
			padre.put("menu", menu);
			
			
			FileWriter fw=new FileWriter("menu.json");
			fw.write(padre.toJSONString());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void readJsonMenu(){
//		try {
			JSONParser parser = new JSONParser();
	        FileReader fr;
			try {
				fr = new FileReader("menu.json");

		        JSONObject datos =  (JSONObject) parser.parse(fr);
		        System.out.println(datos.size());
		        System.out.println(datos.toJSONString());
		        
		        Collection a =datos.values();
		        Object[] array=a.toArray();
		        
		        for(Object o:array) {
		        	System.out.println("-  "+o.toString());
		        }
			
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

			catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
	}


	public static void main(String[] args) {
		new ejercicio5y6().generarJsonMenu();

		new ejercicio5y6().readJsonMenu();
	}
}
