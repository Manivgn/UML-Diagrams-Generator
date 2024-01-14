package org.mql.java.application.models;

import java.lang.annotation.Retention;
import java.lang.reflect.Method;

import java.util.HashMap;

import org.mql.java.application.mapping.XMLMapping;



public class ContainerAnnotation implements XMLMapping{
	
	private String name ;
	private String retpolicy ;
	private HashMap<String,String> fields ;
	//private String target ;
	
	
	
	public ContainerAnnotation(Class<?> cl) {
		if (cl.isAnnotation()) {
			this.name = cl.toString();
			Retention retention = cl.getAnnotation(Retention.class);
			this.retpolicy = retention.value().toString();
			fields = new HashMap<String,String>();
			Method[] f = cl.getDeclaredMethods();
			System.out.println(f.length);
			for (Method field : f) {
				fields.put(field.getName(), field.getGenericReturnType().toString());
			}
		}
	}

	public HashMap<String, String> getFields() {
		return fields;
	}

	public void setFields(HashMap<String, String> fields) {
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
	@Override
	public String toString() {
		return getRetpolicy() +"\n"+
				getName() +"\n { ";
				//Arrays.toString(fields.toArray()) +" } \n";
	}
	
	@Override
	public StringBuffer toXML() {
		StringBuffer r = new StringBuffer();
		r.append("<annotation ");
								r.append(" name=\"").append(getName()).append("\"");
								r.append(" Retention-Policy=\"").append(getRetpolicy()).append("\"");
		r.append(" >").append("\n");
		if (getFields() != null && !getFields().isEmpty()) {
			for (String k : fields.keySet() ) {
				r.append("<field ");
					r.append(" name =\"").append(k).append("\"");
					r.append(" type=\"").append(fields.get(k)).append("\"");
				r.append(" />").append("\n");
			}
		}
		r.append("</annotation").append("\n");
		return r;
	}
	
}
