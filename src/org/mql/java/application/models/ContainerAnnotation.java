package org.mql.java.application.models;

import java.lang.annotation.Retention;
import java.lang.reflect.Field;
import java.util.HashMap;


public class ContainerAnnotation {
	
	private String name ;
	private HashMap<String,Object> fields ;
	//private String target ;
	private String retpolicy ;
	
	public ContainerAnnotation(Class<?> cl) {
		if (cl.isAnnotation()) {
			this.name = cl.toString();
			Retention retention = cl.getAnnotation(Retention.class);
			this.retpolicy = retention.value().toString();
			fields = new HashMap<String, Object>();
			Field[] f = cl.getDeclaredFields();
			for (Field field : f) {
				try {
				fields.put(field.toString(), field.get(cl));
				}
				catch (Exception e) {
				 System.out.println(e.getMessage());
				}
			}
		}
	}

	public HashMap<String,Object> getFields() {
		return fields;
	}

	public void setFields(HashMap<String, Object> fields) {
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
