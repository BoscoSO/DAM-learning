package ejercicioU2_5;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateDiary {

	
	public static void main(String[] args) {
		XMLUtilities gestor = new XMLUtilities();
		
		
		
		String[] nomes= {"Pedro","Juan","Maria","Bosco","Teresa","Luis","Joswe"};
		
		String[] tlfs= {"981 111 111","981 222 222","981 333 333","981 444 444","981 555 555","981 666 666","618 988 843"};
		
		String[] ruas= {"Rua da Rosa","Rua do Horreo","Santiago de Chile","Republica de Argentina","Alfonso Molina","General Pardiñas","calle nova"};
		
		String[] nums= {"16","32","23","11","9","45","16"};
		
		
		try {
			
			Document doc=gestor.creatEmptyDOM("diary");
			Element aux;
			for(int i=0;i<nomes.length;i++) {
				aux=gestor.creatTextElement("contact","", doc);
				aux.setAttribute("id", String.valueOf(i+1));
				gestor.creatTextElement("name",nomes[i] , doc, aux);
				gestor.creatTextElement("telephone",tlfs[i] , doc, aux);
				aux=gestor.creatTextElement("address","", doc, aux);
				gestor.creatTextElement("street",ruas[i] , doc, aux);
				gestor.creatTextElement("number",nums[i] , doc, aux);
			}
			gestor.DOMtoXML(doc, "diary.xml");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}


}
