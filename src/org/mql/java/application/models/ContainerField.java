package org.mql.java.application.models;

import java.lang.reflect.Field;

public class ContainerField {
	private String visibility ;
	private String type ;
	private String name ;

	public ContainerField(Field field) {
		this.type = field.getGenericType().getTypeName();
		this.name = field.getName() ;
		
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
