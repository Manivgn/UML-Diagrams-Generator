package org.mql.java.application.models;


import java.util.Arrays;

import org.mql.java.application.persistancexml.XMLMapping;

public class ContainerEnum implements XMLMapping {
	private String name ;
	private Object []enumconst ;
	
	
	
	
	public ContainerEnum() {
		
	}
	
	
	public ContainerEnum(Class<?> enums) {
		if (enums.isEnum()) {
			this.name = enums.toString();
			enumconst = enums.getEnumConstants();
		}
		
	}
	
	public Object[] getEnumconst() {
		return enumconst;
	}
	public void setEnumconst(Object[] enumconst) {
		this.enumconst = enumconst;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return getName() +"\n { "+
				Arrays.toString(getEnumconst())+" } \n";
	}

	@Override
	public StringBuffer toXML() {
		StringBuffer r = new StringBuffer() ;
		r.append("<enumeration ").append("name =\"").append(getName()).append("\"").append(" />");
				for (int i = 0 ; i < getEnumconst().length ; i++) {
					r.append("<state ");
							r.append("value =\"").append(getEnumconst()[i]).append("\"");
					r.append(" />");
				}
		r.append("</enumeration>");
		return r ;
	}
	

}
