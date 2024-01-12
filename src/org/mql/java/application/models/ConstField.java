package org.mql.java.application.models;

import java.lang.reflect.Field;

public class ConstField {
		
	private String visibility = "public" ;
	private String type ;
	private String name ;
	private Object value ;
	
	public ConstField(Object obj,Field field) {
		this.type = field.getGenericType().toString();
		this.name = field.getName().toString();
		try {
			field.setAccessible(true); //pas necessaire interface donc fields obligatoirement public
			this.value = field.get(obj);
			field.setAccessible(false);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
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

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	
	@Override
	public String toString() {
		return getVisibility() + getType() + getName() + getValue();
	}

}
