package org.mql.java.application.persistancexml;

import org.mql.java.application.models.ContainerProject;

public class DeserializeFromXML {
	ContainerProject result = new ContainerProject() ;
	
	public DeserializeFromXML(String source) {
		ProjectSAXParser sp = new ProjectSAXParser();
		result = sp.parse(source);
		
	}
	
	public ContainerProject getResult() {
		return result;
	}

}
