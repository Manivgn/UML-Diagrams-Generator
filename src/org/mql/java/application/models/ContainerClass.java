package org.mql.java.application.models;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;


public class ContainerClass {
	
	private List<String> visibility ;
	private String name ;
	private List<ContainerMethod> currclassmethods; //
	private List<ContainerField> currclassFields  ; //
	private List<String> currclassInheritance  ; //
	private List <String> uses ;
	private List<String> compositions ;
	private List<String> agregations ;
	private List<String> currclassImplementedInterf  ;//
	private List<String> currclassannotations; //
	private List<ContainerClass> innerClasses ; //
	
	
	public ContainerClass(Class<?> cl) {
		
		this.visibility = Arrays.asList(Modifier.toString(cl.getModifiers()));
		this.name = cl.toString();
		
		//methods
		Method [] methods = cl.getDeclaredMethods();
		currclassmethods = new Vector<ContainerMethod>();
		for (Method method : methods) {
			currclassmethods.add(new ContainerMethod(method));
		}
		//fields
		Field [] fields = cl.getDeclaredFields();
		currclassFields = new Vector<ContainerField>();
		for (Field field : fields) {
			currclassFields.add(new ContainerField(field));
		}
		
		//Chaine d'héritage
		Class<?> superCl = cl.getSuperclass();
		currclassInheritance = new Vector<String>();
		currclassInheritance.add(superCl.toString());
				while (superCl != null) {
					currclassInheritance.add(superCl.toString());
					superCl = superCl.getSuperclass();
		}
		//uses
				
		//agregation
				
		//composition
		
		//implemented interfaces
		currclassImplementedInterf = new Vector<String>();
		Class<?> []ans = cl.getInterfaces();
		for (Class<?> an : ans) {
			currclassImplementedInterf.add(an.toString());
		}
		
		//annotations
		currclassannotations = new Vector<String>();
		Annotation[]annots = cl.getDeclaredAnnotations();
		for (Annotation  annot: annots) {
			currclassannotations.add(annot.toString());
		}
		
		//innerclasses
		innerClasses = new Vector<ContainerClass>();
		Class<?> [] innercl = cl.getDeclaredClasses();
		for (Class<?> class1 : innercl) {
			innerClasses.add(new ContainerClass(class1));
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

	public List<String> getCurrclassImplementedInterf() {
		return currclassImplementedInterf;
	}

	public void setCurrclassImplementedInterf(List<String> currclassImplementedInterf) {
		this.currclassImplementedInterf = currclassImplementedInterf;
	}

	public List<String> getCurrclassannotations() {
		return currclassannotations;
	}

	public void setCurrclassannotations(List<String> currclassannotations) {
		this.currclassannotations = currclassannotations;
	}

	public List<ContainerClass> getInnerClasses() {
		return innerClasses;
	}


	public void setInnerClasses(List<ContainerClass> innerClasses) {
		this.innerClasses = innerClasses;
	}

	public List<String> getVisibility() {
		return visibility;
	}

	public void setVisibility(List <String> visibility) {
		this.visibility = visibility;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getCompositions() {
		return compositions;
	}

	public void setCompositions(List<String> compositions) {
		this.compositions = compositions;
	}

	public List<String> getAgregations() {
		return agregations;
	}

	public void setAgregations(List<String> agregations) {
		this.agregations = agregations;
	}

	public List <String> getUses() {
		return uses;
	}

	public void setUses(List <String> uses) {
		this.uses = uses;
	}





}
