package org.mql.java.application.models;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;


public class ContainerMethod {
	private String visibility ="";
	private String returntype ;
	private String name ;
	private List<String> parameterstype ;
	private List<String> parameters ;
	private List<String> annotations ;
	
	
	public ContainerMethod(Method method) { 
		this.visibility = Modifier.toString(method.getModifiers());
		this.returntype = method.getReturnType().getSimpleName();
		this.name = method.getName().toString() ;
		
		Type[] cls = method.getGenericParameterTypes();
		if (cls.length != 0) {
		this.parameterstype = new Vector<String>();
		for (Type cl : cls) {
			parameterstype.add(cl.getTypeName());
		}
		}
		Annotation[] annots = method.getDeclaredAnnotations();
		if (annots.length != 0) {
		this.annotations = new Vector<String>();
		for (Annotation annot : annots) {
			annotations.add(annot.toString());
		}
		}
		
		
	}
	public ContainerMethod(Constructor<?> construct) { 
		this.visibility = Modifier.toString(construct.getModifiers());
		this.name = construct.getName();
		Type[] cls = construct.getGenericParameterTypes();
		if (cls.length != 0) {
		this.parameterstype = new LinkedList<String>();
		for (Type cl : cls) {
			parameterstype.add(cl.getTypeName().toString());
		}
		}
		Annotation[] annots = construct.getDeclaredAnnotations();
		if (annots.length != 0) {
		this.annotations = new LinkedList<String>();
		for (Annotation annot : annots) {
			annotations.add(annot.toString());
		}
		}
		
		
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

	public List<String> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(List<String> annotations) {
		this.annotations = annotations;
	}
	
	@Override
	public String toString() {
		return getVisibility() + getType() + getName(); 
		
	}
	




}
