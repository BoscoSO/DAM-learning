package ejercicioU2_5;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class XMLUtilities {
	public Document creatEmptyDOM(String rootName) throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		DOMImplementation implementation= builder.getDOMImplementation();
		
		
		Document doc=implementation.createDocument(null, rootName, null);
		
		doc.setXmlVersion("1.0");
		return doc;
	}
	public Element creatTextElement(String tagName,String text,Document doc) {
		Element elemento= doc.createElement(tagName);
		doc.getDocumentElement().appendChild(elemento);
		if(!text.isEmpty()) 
			elemento.appendChild(doc.createTextNode(text));
		
		return elemento;
	}
	public Element creatTextElement(String tagName,String text,Document doc,Element ele) {
		Element elemento= doc.createElement(tagName);
		ele.appendChild(elemento);
		if(!text.isEmpty()) 
			elemento.appendChild(doc.createTextNode(text));
		
		return elemento;
	}
	public Element creatTextElement(String tagName,String text,Document doc,int id) {
		NodeList lista=doc.getElementsByTagName("contact");
		Element aux=null;
		for(int i=0;i<lista.getLength();i++) {
			Node node=lista.item(i);
			Element e=(Element)node;
			if(e.getAttribute("id").equals(String.valueOf(id))) {
				aux=e;
				break;
			}
		}
		if(aux!=null) {
			Element elemento= doc.createElement(tagName);
			aux.appendChild(elemento);
			if(!text.isEmpty()) 
				elemento.appendChild(doc.createTextNode(text));
			
			return elemento;
		}else return null;
	}
	public Document XMLtoDOM(String xmlDoc) throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document doc=db.parse(new File(xmlDoc));
		return doc;
	}
	public void showRootElement(Document doc) {
		System.out.println("Root - "+doc.getDocumentElement().getTagName());
	}
	public void showElementContents2(Element elemento, String tabs) {//a�adir variable String tab y ir sumando \t`s
		if(elemento.getAttributes()!=null) {
			NamedNodeMap mapa=elemento.getAttributes();
			for(int i=0;i<mapa.getLength();i++) {
				System.out.println(tabs+""+mapa.item(i).getNodeName()+"e:o"+mapa.item(i).getNodeValue());
			}
		}
		NodeList list= elemento.getChildNodes();
		
		for(int i=0;i<list.getLength();i++) {
			Node n=list.item(i);
			
			String aux="";
			
			switch (n.getNodeType()){
			 			 	
			 	case Node.ELEMENT_NODE:{ 
						Element e=(Element)n;
						if(e.getTagName().equals("address")) {
							System.out.println(tabs+ e.getTagName()+": ");
						}else
							if(e.hasAttributes()) {
								System.out.println(tabs+ e.getTagName()+" id-"+e.getAttribute("id")+": ");
							}else
								System.out.print(tabs+ e.getTagName()+": ");
							
				 		showElementContents(e,tabs+"\t");
				 		}
				 break;
			 	case Node.TEXT_NODE:{ 
			 			Text t=(Text)n;
			 			aux= t.getWholeText();
			 			System.out.println(aux);
			 		}
			 	break; 
				 
				 
			 }
			
			 
			 
		}
		
	}
	public void showElementContents(Element elemento, String tabs) {//a�adir variable String tab y ir sumando \t`s
		
		NodeList list= elemento.getChildNodes();
		
		for(int i=0;i<list.getLength();i++) {
			Node n=list.item(i);
			
			String aux="";
			
			switch (n.getNodeType()){
			 			 	
			 	case Node.ELEMENT_NODE:{ 
						Element e=(Element)n;
						if(e.getTagName().equals("address")) {
							System.out.println(tabs+ e.getTagName()+": ");
						}else
							if(e.hasAttributes()) {
								System.out.println(tabs+ e.getTagName()+" id-"+e.getAttribute("id")+": ");
							}else
								System.out.print(tabs+ e.getTagName()+": ");
							
				 		showElementContents(e,tabs+"\t");
				 		}
				 break;
			 	case Node.TEXT_NODE:{ 
			 			Text t=(Text)n;
			 			aux= t.getWholeText();
			 			System.out.println(aux);
			 		}
			 	break; 
				 
				 
			 }
			
			 
			 
		}
		
	}
	public void deleteElementsbyTag(String tagName,Document doc) {
		
		NodeList lis=doc.getElementsByTagName(tagName);
		while(lis.getLength()>0) {
			Element e=(Element)lis.item(0);
			Element pa=(Element)e.getParentNode();
			pa.removeChild(e);
		}
		
	}
	public void DOMtoXML(Document doc,String xmlDoc) throws TransformerFactoryConfigurationError, TransformerException {
		Source fonte = new DOMSource(doc); 
		
		Result resultado= new StreamResult(new File(xmlDoc));
		
	    Transformer transformador = TransformerFactory.newInstance().newTransformer();
	    transformador.transform(fonte,resultado);
	}
	
	

}
