package org.mql.java.application.models;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class ContainerField {
	private List <String> visibility ;
	private String type ;
	private String name ;

	public ContainerField(Field field) {
		this.visibility = Arrays.asList(Modifier.toString(field.getModifiers()));
		this.type = field.getGenericType().getTypeName();
		this.name = field.getName() ;
		
	}

	public List <String> getVisibility() {
		return visibility;
	}

	public void setVisibility(List <String> visibility) {
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
