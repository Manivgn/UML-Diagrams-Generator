package org.mql.java.application.models;


import java.util.List;
import java.util.Vector;

public class ContainerEnum {
	private String name ;
	private List<Object> enumconst ;
	
	public ContainerEnum(Class<?> enums) {
		if (enums.isEnum()) {
			this.name = enums.toString();
			Object [] cls = enums.getEnumConstants();
			this.enumconst = new Vector<Object>();
			for (Object cl : cls) {
				enumconst.add(cl);
			}
		}
		
	}

	public List<Object> getEnumconst() {
		return enumconst;
	}

	public void setEnumconst(List<Object> enumconst) {
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
		return name + enumconst ;
	}

}
