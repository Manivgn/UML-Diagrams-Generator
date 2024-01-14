package org.mql.java.application.models;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.mql.java.application.mapping.XMLMapping;

public class ContainerInterface implements XMLMapping{
	
	private String name ;
	private List<ConstField> constfields ;
	private List<ContainerMethod> innermethods ;
	
	
	public ContainerInterface(Class<?> cl) {
		if (cl.isInterface()) {
			
			this.name = cl.toString();
			constfields = new Vector<ConstField>();
			Field [] fields = cl.getDeclaredFields();
			for (Field field : fields) {
				constfields.add(new ConstField(cl, field));
			}
			innermethods = new Vector<ContainerMethod>();
			Method [] methods = cl.getDeclaredMethods();
			for (Method method : methods) {
				innermethods.add(new ContainerMethod(method));
			}
			
		}
		
	}

	public List<ConstField> getConstfields() {
		return constfields;
	}


	public void setConstfields(List<ConstField> constfields) {
		this.constfields = constfields;
	}


	public List<ContainerMethod> getInnerMethods() {
		return innermethods;
	}


	public void setMethods(List<ContainerMethod> methods) {
		this.innermethods = methods;
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
				Arrays.toString(getConstfields().toArray()) +"\n"+
				Arrays.toString(getInnerMethods().toArray())+" } \n";
	}
	
	@Override
	public StringBuffer toXML() {
		StringBuffer r = new StringBuffer();
		r.append("<interface ").append("\n");
							r.append(" name =\"").append(getName()).append("\"");
							r.append(">");
						if(getConstfields() != null && !getConstfields().isEmpty()) {
						r.append("<fields>").append("\n");
						for (ConstField cf : getConstfields()) {
							r.append(cf.toXML()).append("\n");
						}
						r.append("</fields>").append("\n");
						}
						if (getInnerMethods() != null && !getInnerMethods().isEmpty()) {
						r.append("<methods>").append("\n");
						for (ContainerMethod im : getInnerMethods()) {
							r.append(im.toXML()).append("\n");
						}
						r.append("</methods>").append("\n");
						}
		r.append("</interface>").append("\n");
		return r ;
	}
	


	
}
