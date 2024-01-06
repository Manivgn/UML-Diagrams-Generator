package org.mql.java.application.models;

import java.util.Arrays;
import java.util.List;

public class ContainerEnum {
	private List<?> enumconst ;
	
	public ContainerEnum(Class<?> enums) {
		if (enums.isEnum()) {
			this.enumconst = Arrays.asList(enums.getEnumConstants());
		}
		
	}

	public List<?> getEnumconst() {
		return enumconst;
	}

	public void setEnumconst(List<?> enumconst) {
		this.enumconst = enumconst;
	}

}
