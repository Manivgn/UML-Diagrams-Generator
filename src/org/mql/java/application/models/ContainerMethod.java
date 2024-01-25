package org.mql.java.application.models;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.mql.java.application.persistancexml.XMLMapping;
import org.mql.java.application.utils.StringUtils;


public class ContainerMethod implements XMLMapping{
	private String visibility ="";
	private String returntype ;
	private String name ;
	private List<String> parameterstype ;
	private List<String> annotations ;
	public boolean isConstructor = false ;
	
	
	public ContainerMethod() {
		parameterstype = new Vector<String>();
		annotations = new Vector<String>();
	}
	
	public ContainerMethod(Method method) { 
		this.isConstructor = false ;
		this.visibility = StringUtils.toModifier(method.getModifiers());
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
		this.visibility = StringUtils.toModifier(construct.getModifiers());
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

	public String getType() {
		if (isConstructor == false) { 
		return returntype;
		}
		return "";
	}

	public void setType(String type) {
		if (isConstructor == false) 
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
		if (getParameterstype() != null && !getParameterstype().isEmpty()) {
			if (isConstructor == false) {
				String a ="" ;
						a += " " ; 
						a += visibility ; 
						a += name ;
						a += "(" ;
							for (String st : getParameterstype()) {
								if (st.contains(".")) {
									a += StringUtils.toSimpleClassName(st) ;
								}
								else a += st ;
								a += ", " ;
							}
							int lasti = a.lastIndexOf(",");
						a = a.substring(0, lasti);
						a += ")" ; 
						a += " : " ;  
						a +=returntype ;
						return a ;
			}
			else { 
			String a ="" ;
			a += " " ; 
			a += visibility ; 
			a += name ;
			a += "(" ;
				for (String st : getParameterstype()) {
					if (st.contains(".")) {
						a += StringUtils.toSimpleClassName(st) ;
					}
					else a += st ;
					a += ", " ;
				}
				int lasti = a.lastIndexOf(",");
			a = a.substring(0, lasti);
			a += ")" ; 
			return a ;
			}
			
		}else {
			if (isConstructor == false) {
				return " " + visibility + 
						name + "(" + ")" + " : " + 
						returntype ;
			}
			else 
			return " " + visibility + 
								name + "(" + ")" ;
																	
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
				if (getAnnotations() != null && !getAnnotations().isEmpty()) {
					r.append(" annotations =\"").append(String.join(",", getAnnotations())).append("\"");
				}
			if(getParameterstype() != null && !getParameterstype().isEmpty()) {
				r.append(" >");
				r.append("<parameters>");
					for (String param : getParameterstype()) {
						r.append("<parameter ");
						r.append("type =\"").append(param.replace("<", "[").replace(">", "]")).append("\"");
						r.append(" />");
					}
					r.append("</parameters>");
					r.append("</method>");	
			}
			else {
				r.append("/>");
			}
		
	   }
		else {
			
			r.append("<constructor ").append("\n");
					r.append(" visibility =\"").append(getVisibility()).append("\"");
					r.append(" name =\"").append(getName()).append("\"");
					if (getAnnotations() != null && !getAnnotations().isEmpty()) {
						r.append(" annotations =\"").append(String.join(",", getAnnotations())).append("\"");
					}
			if(getParameterstype() != null && !getParameterstype().isEmpty()) {
				r.append(" >");
				r.append("<parameters>");
					for (String param : getParameterstype()) {
						r.append("<parameter ");
						r.append("type =\"").append(param.replace("<", "[").replace(">", "]")).append("\"");
						r.append(" />");
					}
					r.append("</parameters>");
					r.append("</constructor>");
				}
				else {
					r.append(" />");
				}
			}
		
			return r;
	}

}
