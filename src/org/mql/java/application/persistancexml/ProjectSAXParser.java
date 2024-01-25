package org.mql.java.application.persistancexml;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.mql.java.application.models.ConstField;
import org.mql.java.application.models.ContainerAnnotation;
import org.mql.java.application.models.ContainerClass;
import org.mql.java.application.models.ContainerEnum;
import org.mql.java.application.models.ContainerField;
import org.mql.java.application.models.ContainerInterface;
import org.mql.java.application.models.ContainerMethod;
import org.mql.java.application.models.ContainerPackage;
import org.mql.java.application.models.ContainerProject;

public class ProjectSAXParser extends DefaultHandler{
		
	
	
	private List<ContainerPackage> packlist ;
	private List<ContainerClass> classlist ;
	private List<ContainerInterface> interflist ;
	private List<ContainerAnnotation> annotalist ;
	private List<ContainerEnum> enumlist ;
	private List<ContainerMethod> methlist ;
	private List<ContainerMethod> constructlist ;
	private List<ContainerField> fieldlist ;
	private List<ConstField> cnstlist ;
	private List<String> paramtypes ;
	private List<String> inheritance ;
	private List<String> uses ;
	private List<String> agregations ;
	private List<String> implementedinerf ;
	private List<String> innerclasses ;
	private ContainerProject ctnpro ;
	private ContainerPackage ctnpck ;
	private ContainerClass ctnclz ;
	private ContainerInterface ctninterf ;
	private ContainerAnnotation ctnannot ;
	private ContainerEnum ctnenum ;
	private ContainerMethod ctnmethod;
	private ContainerMethod construct ;
	private boolean isconstructor ;
	private boolean isinterface ;
	private boolean isannotation ;
	private ContainerField ctnfield ;
	private ConstField cnstfield ;
	private Object []enumconst ;
	private List<Object> econst ;
	private HashMap<String,String> annotafields ;

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
			String classpath = attributes.getValue("classpath");
			ctnpro = new ContainerProject(name,classpath);	
			packlist = new Vector<ContainerPackage>();
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
		else if ("methods".equals(qName)) {
			methlist = new Vector<ContainerMethod>();
		}
		else if ("constructors".equals(qName)) {
			constructlist = new Vector<ContainerMethod>();
		}
		
		else if ("fields".equals(qName)) {
			if (isannotation == true) {
				annotafields = new HashMap<String, String>();
			}
			else
			fieldlist = new Vector<ContainerField>();
		}
		else if ("class".equals(qName)) {
			ctnclz = new ContainerClass();
			String name = attributes.getValue("name");
			String visibility = attributes.getValue("visibility");
			String annotat = attributes.getValue("annotations");
			ctnclz.setName(name);
			ctnclz.setVisibility(visibility);
			ctnclz.setCurrclassannotations(Arrays.asList(annotat));
			
		}
		else if ("interface".equals(qName)) {
			ctninterf = new ContainerInterface();
			String name = attributes.getValue("name");
			ctninterf.setName(name);
			isinterface = true ;
			
		}
		else if ("annotation".equals(qName)) {
			isannotation = true ;
			ctnannot = new ContainerAnnotation();
			String name = attributes.getValue("name");
			String retpolicy = attributes.getValue("Retention-Policy");
			ctnannot.setName(name);
			ctnannot.setRetpolicy(retpolicy);
			
		}
		else if ("enumeration".equals(qName)) {
			ctnenum = new ContainerEnum();
			String name = attributes.getValue("name");
			ctnenum.setName(name);
			econst = new Vector<Object>();
		}
		else if ("state".equals(qName)) {
			Object state = attributes.getValue("value");
			econst.add(state);
			
		}
		else if ("field".equals(qName)) {
			if (isannotation == true) {
				annotafields.put(attributes.getValue("name"), attributes.getValue("type"));
			}
			else {
			ctnfield = new ContainerField();
			String visibilty = attributes.getValue("visibility");
			String name  = attributes.getValue("name");
		    String type = attributes.getValue("type");
		    List<String> fieldannota = Arrays.asList(attributes.getValue("annotations"));
		    ctnfield.setName(name);
		    ctnfield.setType(type);
		    ctnfield.setVisibility(visibilty);
		    ctnfield.setAnnotations(fieldannota);
			}
		    	
		}
		else if ("const-fields".equals(qName)) {
			cnstlist = new Vector<ConstField>();
			
		}
		else if ("const-field".equals(qName)) {
			cnstfield = new ConstField() ;
			String name = attributes.getValue("name");
			String type = attributes.getValue("type");
			String value = attributes.getValue("value");
			String visibility = attributes.getValue("visibility");
			cnstfield.setName(name);
			cnstfield.setType(type);
			cnstfield.setValue(value);
			cnstfield.setVisibility(visibility);
			
		}
	
		else if ("constructor".equals(qName)) {
			construct = new ContainerMethod();
			construct.isConstructor = true ;
			isconstructor = true ; 
			String visibilty = attributes.getValue("visibility");
			String name  = attributes.getValue("name");
		    List<String> construcannota = Arrays.asList(attributes.getValue("annotations"));
		    construct.setName(name);
		    construct.setVisibility(visibilty);
		    construct.setAnnotations(construcannota);
			
		}
	
		else if ("method".equals(qName)) {
			ctnmethod = new ContainerMethod();
			ctnmethod.isConstructor = false ;
			isconstructor = false ;
			String visibilty = attributes.getValue("visibility");
			String name  = attributes.getValue("name");
			String type = attributes.getValue("return-type");
		    List<String> methodannota = Arrays.asList(attributes.getValue("annotations"));
		    ctnmethod.setName(name);
		    ctnmethod.setVisibility(visibilty);
		    ctnmethod.setType(type);
		    ctnmethod.setAnnotations(methodannota);
		}
		else if ("parameters".equals(qName)) {
			paramtypes = new Vector<String>();
		}
		else if ("parameter".equals(qName)) {
			String paramtype = attributes.getValue("type");
			paramtypes.add(paramtype);
		}
		else if ("innerClasses".equals(qName)) {
			innerclasses = new Vector<String>() ;
		}
		
		else if ("innerclass".equals(qName)) {
			String name  = attributes.getValue("name");
			innerclasses.add(name);
		}
		
		else if ("relations".equals(qName)) {
			inheritance = new Vector<String>();
			uses = new Vector<String>();
			agregations = new Vector<String>();
			implementedinerf = new Vector<String>();
		}
		else if ("relation".equals(qName)) {
			String type = attributes.getValue("type");
			if (type.contains("inheritance")) {
				inheritance.add(attributes.getValue("superClass"));
			}
			else if (type.contains("use")) {
				uses.add(attributes.getValue("className"));
			}
			else if (type.contains("agregation")) {
				agregations.add(attributes.getValue("agregated"));
			}
			else if (type.contains("implementation")) {
				implementedinerf.add(attributes.getValue("implemented-interface"));
			}
		}	
			
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if ("field".equals(qName)) {
			if (isannotation == true) {
				
			}
			else 
			fieldlist.add(ctnfield);
		}
		else if ("fields".equals(qName)) {
			ctnclz.setCurrclassFields(fieldlist);
			
		}
		else if ("parameters".equals(qName)) {
			if (isconstructor == true) {
				construct.setParameterstype(paramtypes);
			}
			else {
				ctnmethod.setParameterstype(paramtypes);
			}
			
			
		}
		else if ("constructor".equals(qName)) {
			constructlist.add(construct);
			isconstructor = false ;
		}

		else if ("method".equals(qName)) {
			methlist.add(ctnmethod);
		}
		else if ("methods".equals(qName)) {
			if (isinterface == true) {
				ctninterf.setMethods(methlist);
			}
			else {
				ctnclz.setCurrclassmethods(methlist);
			}
			
		}
		else if ("constructors".equals(qName)) {
			ctnclz.setCurrclassConstructors(constructlist);
		}
		else if ("innerClasses".equals(qName)) {
			ctnclz.setInnerClasses(innerclasses);
		}
		else if ("relations".equals(qName)) {
			ctnclz.setCurrclassInheritance(inheritance);
			ctnclz.setAgregations(agregations);
			ctnclz.setUses(uses);
			ctnclz.setCurrclassImplementedInterf(implementedinerf);
		} 
		else if ("const-field".equals(qName)) {
			cnstlist.add(cnstfield);
		}
		else if ("annotation".equals(qName)) {
			ctnannot.setFields(annotafields);
			isannotation = false ;
			annotalist.add(ctnannot);
		}
		else if ("class".equals(qName)) {
			classlist.add(ctnclz);
		}
		else if ("interface".equals(qName)) {
			isinterface = false ;
			interflist.add(ctninterf);
		}
		else if ("enumeration".equals(qName)) {
			enumconst = new Object[econst.size()];
			econst.toArray(enumconst);
			ctnenum.setEnumconst(enumconst);
			enumlist.add(ctnenum);
		}
		else if ("interfaces".equals(qName)) {
			ctnpck.setInterfacelist(interflist);
		}
		else if ("classes".equals(qName)) {
			ctnpck.setClasslist(classlist);
		}
		else if ("annotations".equals(qName)) {
			ctnpck.setAnnotationlist(annotalist);
		}
		else if ("enumerations".equals(qName)) {
			ctnpck.setEnumlist(enumlist);
		}
		else if ("package".equals(qName)) {
			packlist.add(ctnpck);
		}
		else if ("project".equals(qName)) {
			ctnpro.setCtnpcklist(packlist);
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
	}
	

}
