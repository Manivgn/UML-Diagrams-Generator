package org.mql.java.application.models;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;


public class ContainerMethod {
	private List<String> visibility ;
	private String name ;
	private String returntype ;
	private List<String> parameterstype ;
	private List<String> parameters ;
	
	
	public ContainerMethod(Method method) {
		this.visibility = Arrays.asList(Modifier.toString(method.getModifiers()));
		this.returntype = method.getGenericReturnType().getTypeName();
		this.name = method.getName() ;
		parameterstype = Arrays.asList(method.getGenericParameterTypes().toString());
		parameters = Arrays.asList(method.getParameters().toString());
	}
	
	public List<String> getVisibility() {
		return visibility;
	}


	public void setVisibility(List<String> visibility) {
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
		return returntype;
	}

	public void setType(String type) {
		this.returntype = type;
	}

	public List<String> getParameterstype() {
		return parameterstype;
	}

	public void setParameterstype(List<String> parameterstype) {
		this.parameterstype = parameterstype;
	}



}
