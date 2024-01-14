package org.mql.java.application.reflection;


import org.mql.java.application.mapping.SerializeToXML;
import org.mql.java.application.models.ContainerProject;


public class Examples {

	public Examples() {
		exp11();
	}
	void ex() {
		StringBuffer b = new StringBuffer();
		b.append("eabcde");
		System.out.println(b.lastIndexOf("e"));
	}
	
	/*
	public void exp01() {
		ContainerClass example = new ContainerClass(Author.class);
		System.out.println("1 " + example.getVisibility());
		System.out.println("2 " + example.getName());
		for (ContainerMethod el : example.getCurrclassmethods()) {
			System.out.println(el.getVisibility());
			System.out.println(el.getType());
			System.out.println(el.getName());
			System.out.println(el.getParameterstype());
			System.out.println(el.getAnnotations());
			
		}
		//System.out.println("5" + example.getCurrclassInheritance());
		//System.out.println("6" + example.getCurrclassannotations());
		//System.out.println("7" + example.getInnerClasses());
		//System.out.println(example.getVisibility());
	}
	void exp02() {
		ContainerClass example = new ContainerClass(Author.class);
		System.out.println("1 " + example.getVisibility());
		System.out.println("2 " + example.getName());
		for (ContainerField fl : example.getCurrclassFields()) {
			System.out.println(fl.getVisibility());
			System.out.println(fl.getType());
			System.out.println(fl.getName());
			System.out.println(fl.getAnnotations());
		}
		
	}
	
	void exp03() {
		ContainerClass example = new ContainerClass(Author.class);
		System.out.println("1 " + example.getVisibility());
		System.out.println("2 " + example.getName());
		System.out.println(example.getCurrclassInheritance());
	}
	
	void exp04() {
		ContainerClass example = new ContainerClass(Author.class);
		System.out.println("1 " + example.getVisibility());
		System.out.println("2 " + example.getName());
		System.out.println(example.getCurrclassImplementedInterf());
	}
	
	void exp05() {
		ContainerClass example = new ContainerClass(Author.class);
		System.out.println("1 " + example.getVisibility());
		System.out.println("2 " + example.getName());
		System.out.println(example.getCurrclassannotations());
	}
	
	void exp06() {
		ContainerClass example = new ContainerClass(Book.class);
		System.out.println("1 " + example.getVisibility());
		System.out.println("2 " + example.getName());
		System.out.println(example.getInnerClasses());
	}
	
	void exp07() {
		ContainerInterface example = new ContainerInterface(TestforInterface.class);
		System.out.println("1 " + example.getName());
		for (ConstField el : example.getConstfields()) {
			System.out.println(el.getVisibility());
			System.out.println(el.getType());
			System.out.println(el.getName());
			System.out.println(el.getValue());
		}
	}
	
	void exp08() {
		ContainerAnnotation example = new ContainerAnnotation(Action.class);
		System.out.println("1 " + example.getName());
		System.out.println(example.getRetpolicy());
		System.out.println(example.getFields());
		
	}
	
	void exp09() {
		ContainerClass example = new ContainerClass(Book.class);
		System.out.println("1 " + example.getVisibility());
		System.out.println("2 " + example.getName());
		for (ContainerMethod el : example.getCurrclassConstructors()) {
			System.out.println(el.getVisibility());
			System.out.println(el.getName());
			System.out.println(el.getParameterstype());
			System.out.println(el.getAnnotations());
			
		}
	}
	*/
	
	void exp11() {
		ProjectExplorer p = new ProjectExplorer("C:\\Users\\hp\\eclipse-workspace\\ProjectForTesting UML Diagrams Generator");
		ContainerProject cp = p.getCtnpro();
		cp.generateContainerPackage(p.getClasspath());
		String source = "resources/XML/" + cp.getProjectName() +".xml" ;
		SerializeToXML.PersistToXML(source, cp.toXML());
			//PackageExplorer pexp = new PackageExplorer(p.getClasspath(), s);
			
			//ctnpck.setLogger(new ConsoleLogger());
			//ctnpck.display();
			
			
			 // System.out.println("Conteneur package");
			 // System.out.println("Nom du package");
			 //System.out.println(ctnpck.getPackageName());
			 /*
			 * System.out.println("Conteneur de Class");
			 * System.out.println(ctnpck.getClasslist());
			 * 
			 */ 
			 //System.out.println("Conteneur d'Interface");
			 //System.out.println(ctnpck.getInterfacelist());
			 /*
			 * System.out.println("Conteneur d'Annotation");
			 * System.out.println(ctnpck.getAnnotationlist());
			 * System.out.println("Conteneur d'Enumeration");
			 * System.out.println(ctnpck.getEnumlist());
			 */
			 
			
			
		
	}

	public static void main(String[] args) {
		new Examples();

	}
	

}
