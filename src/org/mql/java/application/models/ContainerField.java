package org.mql.java.application.models;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Vector;

import org.mql.java.application.persistancexml.XMLMapping;

import java.lang.StringBuffer;



public class ContainerField implements XMLMapping{
	private String visibility ;
	private String type ;
	private String name ;
	private List<String> fieldannotations ;
	

	public ContainerField(Field field) {
		this.visibility = Modifier.toString(field.getModifiers());
		this.type = field.getGenericType().getTypeName().replace("<", "[").replace(">", "]");
		this.name = field.getName() ;
		Annotation[] annots = field.getDeclaredAnnotations();
		if (annots.length != 0) {
		this.fieldannotations = new Vector<String>();
		for (Annotation annot : annots) {
			fieldannotations.add(annot.toString());
		}
		}
		
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

	public List<String> getAnnotations() { 
		return fieldannotations;
	}

	public void setAnnotations(List<String> annotations) {
		this.fieldannotations = annotations;
	}
	
	@Override
	public String toString() {
		return visibility + type + name +"\n";
	}
	
	@Override
	public StringBuffer toXML() {
		StringBuffer r = new StringBuffer();
		r.append("<field ");
				r.append(" name =\"").append(getName()).append("\"");
				r.append(" type =\"").append(getType()).append("\"");
				r.append(" visibility =\"").append(getVisibility()).append("\"");
		r.append(" />").append("\n");
			
		
		return r;
	}
	
	

}
