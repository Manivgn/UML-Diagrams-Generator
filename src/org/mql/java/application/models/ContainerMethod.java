package org.mql.java.application.models;

import java.lang.reflect.Method;

import java.util.Arrays;
import java.util.List;


public class ContainerMethod {
	private String visibility ;
	private String type ;
	private String name ;
	private List<String> parameterstype ;
	private List<String> parameters ;
	
	
	public ContainerMethod(Method method) {
		this.type = method.getGenericReturnType().getTypeName();
		this.name = method.getName() ;
		parameterstype = Arrays.asList(method.getGenericParameterTypes().toString());
		parameters = Arrays.asList(method.getParameters().toString());
	}
	
	public String getVisibility() {
		return visibility;
	}


	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<String> getParameters() {
		return parameters;
	}


	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getParameterstype() {
		return parameterstype;
	}

	public void setParameterstype(List<String> parameterstype) {
		this.parameterstype = parameterstype;
	}



}
