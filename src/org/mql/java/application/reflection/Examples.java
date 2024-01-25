package org.mql.java.application.reflection;





import org.mql.java.application.loggers.ConsoleLogger;
import org.mql.java.application.models.ContainerPackage;
import org.mql.java.application.models.ContainerProject;
import org.mql.java.application.persistancexml.ProjectSAXParser;
import org.mql.java.application.persistancexml.SerializeToXML;
import org.mql.java.application.ui.ProjectDiagram;




public class Examples {

	public Examples() {
		exp11();
	}
	
	
	
	@SuppressWarnings("unused")
	void exp02() {
		ProjectDiagram p = new ProjectDiagram("C:\\\\Users\\\\hp\\\\eclipse-workspace\\\\p05-MultiThreading");
		//C:\Users\hp\eclipse-workspace\ProjectForTesting UML Diagrams Generator
	}
	
	void exp10() {
		ProjectExplorer p = new ProjectExplorer("C:\\Users\\hp\\eclipse-workspace\\p05-MultiThreading");
		ContainerProject cp = p.getCtnpro();
		cp.generateContainerPackage();
		for(ContainerPackage ctnpck: cp.getCtnpcklist()) {
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
		for(ContainerPackage ctnpck: cp.getCtnpcklist()) {
			ctnpck.setLogger(new ConsoleLogger());
			ctnpck.display();
		}
	}

	public static void main(String[] args) {
		new Examples();

	}
	

}
