package org.mql.java.application.persistancexml;

import java.io.File;
import java.io.PrintWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class SerializeToXML {
	

	public static void PersistToXML(String destination, StringBuffer content) {
		 
		try {
			 PrintWriter out = new PrintWriter("resources/XML/" + destination +  ".xml");
			 out.println(content.toString());
			 out.close();
			 
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			e.printStackTrace();
		}
		SerializeToXML.format(destination);
		
	}
	public static void format(String destination) {
		try {
			XMLNode node = new XMLNode("resources/XML/" + destination +  ".xml");
			DOMSource source = new DOMSource(node.getNode());
			
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			File file = new File("resources/XML/" + destination + ".xml");
			StreamResult result = new StreamResult(file);
			
			transformer.transform(source, result);
			
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		
	}

	
	

}
