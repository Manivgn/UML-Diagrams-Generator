package org.mql.java.application.models;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.mql.java.application.persistancexml.XMLMapping;


public class ContainerMethod implements XMLMapping{
	private String visibility ="";
	private String returntype ;
	private String name ;
	private List<String> parameterstype ;
	private List<String> parameters ;
	private List<String> annotations ;
	public boolean isConstructor = false ;
	
	
	public ContainerMethod(Method method) { 
		this.isConstructor = false ;
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
		this.isConstructor = true ;
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
		if (getParameterstype() != null) {
			if (isConstructor == false) {
				return visibility +" "	+ 
						returntype +" " + 
								name + "( " + getParameterstype() + " )"
																	+"\n";
			}
			else 
			return visibility +" "	+ 
								name + "( " + getParameterstype() + " )"
																	+"\n";
			
		}else {
			if (isConstructor == false) {
				return visibility +" "	+ 
						returntype +" " + 
								name + "(" + " )" 
																	+"\n";
			}
			else 
			return visibility +" "	+ 
								name + "(" + " )"
																	+"\n";
			
		}
	
		
	}
	
	@Override
	public StringBuffer toXML() {
		StringBuffer r = new StringBuffer();
		
		if (isConstructor == false) {
		r.append("<method ");
				r.append("visibility =\"").append(getVisibility()).append("\"");
				r.append(" return-type =\"").append(getType().replace("<", "[").replace(">", "]")).append("\"");
				r.append(" name =\"").append(getName()).append("\"");
		r.append(" >").append("\n");
		if(getParameterstype() != null && !getParameterstype().isEmpty()) {
		r.append("<parameters>").append("\n");
				for (String param : getParameterstype()) {
					r.append("<parameter ");
					r.append("type =\"").append(param.replace("<", "[").replace(">", "]")).append("\"");
					r.append(" />").append("\n");
				}
		r.append("</parameters>").append("\n");
		}
		
		r.append("</method>").append("\n");	
		
	   }
		else {
			
			r.append("<constructor ").append("\n");
					r.append(" visibility =\"").append(getVisibility()).append("\"");
					r.append(" name =\"").append(getName()).append("\"");
			r.append(" >").append("\n");
			if(getParameterstype() != null && !getParameterstype().isEmpty()) {
			r.append("<parameters>").append("\n");
					for (String param : getParameterstype()) {
						r.append("<parameter ");
						r.append("type =\"").append(param).append("\"");
						r.append(" />").append("\n");
					}
			r.append("</parameters>").append("\n");
			}
			
			r.append("</constructor>").append("\n");	
	
		}
		return r;
	
	}

}
