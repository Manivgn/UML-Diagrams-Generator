package org.mql.java.application.models;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;


public class ContainerClass {
	private List<ContainerMethod> currclassmethods;
	private List<ContainerField> currclassFields  ;
	private List<String> currclassInheritance  ;
	private List<ContainerInterface> currclassImplementedInterf  ;
	private List<ContainerAnnotation> currclassannotations;
	private List<ContainerClass> innerClasses ;
	
	
	public ContainerClass(Class<?> cl) {
		Method [] methods = cl.getDeclaredMethods();
		for (Method method : methods) {
			currclassmethods.add(new ContainerMethod(method));
		}
		Field [] fields = cl.getDeclaredFields();
		for (Field field : fields) {
			currclassFields.add(new ContainerField(field));
		}
		
		
		
	}
	
	public List<ContainerField> getCurrclassFields() {
		return currclassFields;
	}

	public void setCurrclassFields(List<ContainerField> currclassFields) {
		this.currclassFields = currclassFields;
	}

	public List<ContainerMethod> getCurrclassmethods() {
		return currclassmethods;
	}

	public void setCurrclassmethods(List<ContainerMethod> currclassmethods) {
		this.currclassmethods = currclassmethods;
	}

	public List<String> getCurrclassInheritance() {
		return currclassInheritance;
	}

	public void setCurrclassInheritance(List<String> currclassInheritance) {
		this.currclassInheritance = currclassInheritance;
	}

	public List<ContainerInterface> getCurrclassImplementedInterf() {
		return currclassImplementedInterf;
	}

	public void setCurrclassImplementedInterf(List<ContainerInterface> currclassImplementedInterf) {
		this.currclassImplementedInterf = currclassImplementedInterf;
	}

	public List<ContainerAnnotation> getCurrclassannotations() {
		return currclassannotations;
	}

	public void setCurrclassannotations(List<ContainerAnnotation> currclassannotations) {
		this.currclassannotations = currclassannotations;
	}

	public List<ContainerClass> getInnerClasses() {
		return innerClasses;
	}


	public void setInnerClasses(List<ContainerClass> innerClasses) {
		this.innerClasses = innerClasses;
	}





}
