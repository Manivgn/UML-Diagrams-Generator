package org.mql.java.application.models;

import java.lang.annotation.Retention;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Vector;


public class ContainerAnnotation {
	
	private String name ;
	private String retpolicy ;
	private List<String> fields ;
	//private String target ;
	
	
	public ContainerAnnotation(Class<?> cl) {
		if (cl.isAnnotation()) {
			this.name = cl.toString();
			Retention retention = cl.getAnnotation(Retention.class);
			this.retpolicy = retention.value().toString();
			fields = new Vector<String>();
			Method[] f = cl.getDeclaredMethods();
			System.out.println(f.length);
			for (Method field : f) {
				fields.add(field.getName());
			}
		}
	}

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}


	public String getRetpolicy() {
		return retpolicy;
	}

	public void setRetpolicy(String retpolicy) {
		this.retpolicy = retpolicy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
