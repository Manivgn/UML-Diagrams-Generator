package org.mql.java.application.models;

import java.util.List;

public class ContainerInterface {
	public List<String> getConstfields() {
		return constfields;
	}


	public void setConstfields(List<String> constfields) {
		this.constfields = constfields;
	}


	public List<String> getMethods() {
		return methods;
	}


	public void setMethods(List<String> methods) {
		this.methods = methods;
	}


	private List<String> constfields ;
	private List<String> methods ;
	

	public ContainerInterface() {
		
	}

}
