package ejercicioU2_5;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ProcessDiary {

	public static void main(String[] args) {
		XMLUtilities gestor = new XMLUtilities();
		
		
		try {
			//Load the file xml
			Document doc=gestor.XMLtoDOM("diary.xml");
			//show root 
			gestor.showRootElement(doc);
			//content
			
			gestor.showElementContents(doc.getDocumentElement(),"");
			
			gestor.deleteElementsbyTag("telephone", doc);

			gestor.DOMtoXML(doc, "diary1.xml");
			
			gestor.deleteElementsbyTag("address", doc);
			
			gestor.DOMtoXML(doc, "diary2.xml");
			

			gestor.creatTextElement("email", "masDuro@niIdea.com",doc,1);
			gestor.creatTextElement("email", "espinosa@sancle.com",doc,2);
			gestor.creatTextElement("email", "general@gmail.com",doc,5);

			gestor.DOMtoXML(doc, "diary3.xml");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
