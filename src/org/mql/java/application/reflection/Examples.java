package org.mql.java.application.reflection;


import org.mql.java.application.loggers.ConsoleLogger;
import org.mql.java.application.models.ContainerPackage;
import org.mql.java.application.models.ContainerProject;
import org.mql.java.application.persistancexml.ProjectSAXParser;
import org.mql.java.application.persistancexml.SerializeToXML;


public class Examples {

	public Examples() {
		exp10();
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
	void exp10() {
		ProjectExplorer p = new ProjectExplorer("C:\\Users\\hp\\eclipse-workspace\\p05-MultiThreading");
		ContainerProject cp = p.getCtnpro();
		cp.generateContainerPackage();
		for(ContainerPackage ctnpck: ContainerProject.getCtnpcklist()) {
			ctnpck.setLogger(new ConsoleLogger());
			ctnpck.display();
		}
		
	}
	
	void exp11() {
		ProjectExplorer p = new ProjectExplorer("C:\\Users\\hp\\eclipse-workspace\\p05-MultiThreading");
		ContainerProject cp = p.getCtnpro();
		cp.generateContainerPackage();
		SerializeToXML.PersistToXML(cp.getProjectName(), cp.toXML());
				
	
	}
	void exp12() {
		ProjectSAXParser parser = new ProjectSAXParser();
		ContainerProject cp = parser.parse("resources/XML/p05-MultiThreading.xml");
		for(ContainerPackage ctnpck: ContainerProject.getCtnpcklist()) {
			ctnpck.setLogger(new ConsoleLogger());
			ctnpck.display();
		}
	}

	public static void main(String[] args) {
		new Examples();

	}
	

}
