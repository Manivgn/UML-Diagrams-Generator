package org.mql.java.application.models;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;


public class ContainerClass {
	
	private List<String> visibility ;
	private String name ;
	private List<ContainerMethod> currclassConstructors ;
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
		if (!cl.isAnnotation() && !cl.isEnum() && !cl.isInterface() && !cl.isRecord() ) {
		this.visibility = Arrays.asList(Modifier.toString(cl.getModifiers()));
		this.name = cl.toString();
		uses = new Vector<String>();
		agregations = new Vector<String>();
		compositions = new Vector<String>();
		
		//constructors
		Constructor<?>[] constructors = cl.getDeclaredConstructors();
		currclassConstructors = new Vector<ContainerMethod>();
		for (Constructor<?> constructor : constructors) {
			currclassConstructors.add(new ContainerMethod(constructor));
			Type[] clzs = constructor.getParameterTypes();
			//Composition est plus complexe a determiner
			//Se baser uniquement sur les parametres du constructeur ne fournit pas réélement d'informations
			// sur une éventuelle composition
			for (Type clz : clzs) {
				if (isNotsPrimitive(clz) && !clz.getTypeName().equals(cl.getTypeName())) {
					compositions.add(clz.getTypeName());
				}
			}
		}
		//System.out.println("Composition");
		//System.out.println(getCompositions());
		
		//methods
		Method [] methods = cl.getDeclaredMethods();
		currclassmethods = new Vector<ContainerMethod>();
		for (Method method : methods) {
			currclassmethods.add(new ContainerMethod(method));
			Type[] clzs = method.getGenericParameterTypes();
			for (Type clz : clzs) {
				//System.out.println(clz.getTypeName());
				if (isNotsPrimitive(clz) && !clz.getTypeName().equals(cl.getTypeName())) {
					uses.add(clz.getTypeName());
					}
				}
			}
		//System.out.println("Utilisation");
		//System.out.println(getUses());
		
		//fields
		Field [] fields = cl.getDeclaredFields();
		currclassFields = new Vector<ContainerField>();
		for (Field field : fields) {
			currclassFields.add(new ContainerField(field));
			Type clz = field.getGenericType();
				if (isNotsPrimitive(clz) && !clz.getTypeName().equals(cl.getTypeName())) {
					agregations.add(clz.getTypeName());
			}
		}
		//System.out.println("Agrégation");
		//System.out.println(getAgregations());
		
		//Chaine d'héritage
		Class<?> superCl = cl.getSuperclass();
		currclassInheritance = new Vector<String>();
		//currclassInheritance.add(superCl.toString());
				while (superCl != null) {
					String src = System.getProperty("java.class.path");
					currclassInheritance.add(src.concat(" ").concat(superCl.toString()));
					superCl = superCl.getSuperclass();
		}
				
				
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
	
	@Override
	public String toString() {
		return (visibility + name + currclassFields + currclassmethods + currclassInheritance
						   + currclassImplementedInterf + currclassannotations + innerClasses);
	}

	public List<ContainerMethod> getCurrclassConstructors() {
		return currclassConstructors;
	}

	public void setCurrclassConstructors(List<ContainerMethod> currclassConstructors) {
		this.currclassConstructors = currclassConstructors;
	}
	
	public boolean isNotsPrimitive(Type tpz) {
		
		if (!tpz.getTypeName().equals(boolean.class.getTypeName())
			 && !tpz.getTypeName().equals(String.class.getTypeName())
			 && !tpz.getTypeName().equals(byte.class.getTypeName())
			 && !tpz.getTypeName().equals(short.class.getTypeName())
			 && !tpz.getTypeName().equals(int.class.getTypeName())
			 && !tpz.getTypeName().equals(long.class.getTypeName())
			 && !tpz.getTypeName().equals(float.class.getTypeName())
			 && !tpz.getTypeName().equals(double.class.getTypeName())
			 && !tpz.getTypeName().equals(Boolean.class.getTypeName())
			 && !tpz.getTypeName().equals(Byte.class.getTypeName())
			 && !tpz.getTypeName().equals(Short.class.getTypeName())
			 && !tpz.getTypeName().equals(Integer.class.getTypeName())
			 && !tpz.getTypeName().equals(Long.class.getTypeName())
			 && !tpz.getTypeName().equals(Float.class.getTypeName())
			 && !tpz.getTypeName().equals(Double.class.getTypeName())
			 && !tpz.getTypeName().equals(Character.class.getTypeName())	 
			)
			{
			return true ;
			}
		return false;
		
	}



}
