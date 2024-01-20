package org.mql.java.application.persistancexml;

import java.util.List;
import java.util.Vector;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.mql.java.application.models.ContainerAnnotation;
import org.mql.java.application.models.ContainerClass;
import org.mql.java.application.models.ContainerEnum;
import org.mql.java.application.models.ContainerInterface;
import org.mql.java.application.models.ContainerPackage;
import org.mql.java.application.models.ContainerProject;

public class ProjectSAXParser extends DefaultHandler{
		
	
	private ContainerProject ctnpro ;
	private List<ContainerPackage> packlist ;
	private ContainerPackage ctnpck ;
	private ContainerClass ctnclz ;
	private ContainerInterface ctninterf ;
	private ContainerAnnotation ctnannot ;
	private ContainerEnum ctnenum ;
	private List<ContainerClass> classlist ;
	private List<ContainerInterface> interflist ;
	private List<ContainerAnnotation> annotalist ;
	private List<ContainerEnum> enumlist ;

	public ProjectSAXParser() {
		
	}
	
	public ContainerProject parse(String source) {
		SAXParserFactory factory = SAXParserFactory.newDefaultInstance();
		//	factory.setNamespaceAware(true); si on a une namespace a prendre en compte
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(source, this);
		}
		catch (Exception e) {
			System.out.println("Erreur : "+ e.getMessage());
		}
		return ctnpro;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if("project".equals(qName)) {
			String name = attributes.getValue("name");
			ctnpro = new ContainerProject(name);
			
		}
		
		else if ("package".equals(qName)) {
			String packagename = attributes.getValue("name");
			ctnpck = new ContainerPackage(packagename);
			
		}
		else if ("classes".equals(qName)) {
			classlist = new Vector<ContainerClass>();
			
		}
		else if ("interfaces".equals(qName)) {
			interflist = new Vector<ContainerInterface>();
		}
		else if ("annotations".equals(qName)) {
			annotalist = new Vector<ContainerAnnotation>();
		}
		else if ("enumerations".equals(qName)) {
			enumlist = new Vector<ContainerEnum>();
		}
		else if ("class".equals(qName)) {
			ctnclz = new ContainerClass();
			String name = attributes.getValue("name");
			String visibility = attributes.getValue("visibility");
			
			
		}
		else if ("interface".equals(qName)) {
			
		}
		else if ("annotation".equals(qName)) {
			
		}
		else if ("enumeration".equals(qName)) {
			
		}
		
		
			
			
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
	}
	

}
