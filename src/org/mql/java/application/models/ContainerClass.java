package org.mql.java.application.models;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import java.lang.reflect.Type;

import java.util.List;
import java.util.Vector;

import org.mql.java.application.persistancexml.XMLMapping;
import org.mql.java.application.utils.StringUtils;


public class ContainerClass implements XMLMapping{
	
	private String visibility ;
	private String name ;
	private List<ContainerMethod> currclassConstructors ;
	private List<ContainerMethod> currclassmethods; //
	private List<ContainerField> currclassFields  ; //
	private List<String> currclassInheritance  ; //
	private List <String> uses ;
	private List<String> agregations ;
	private List<String> currclassImplementedInterf  ;//
	private List<String> currclassannotations; //
	private List<String> innerClasses ; //
	
	
	
	
	public ContainerClass() {
		uses = new Vector<String>();
		agregations = new Vector<String>();
		//compositions = new Vector<String>();
		currclassConstructors = new Vector<ContainerMethod>();
		currclassmethods = new Vector<ContainerMethod>();
		currclassFields = new Vector<ContainerField>();
		currclassInheritance = new Vector<String>();
		currclassImplementedInterf = new Vector<String>();
		currclassannotations = new Vector<String>();
		innerClasses = new Vector<String>();
	}
	
	public ContainerClass(Class<?> cl) {
		if (!cl.isAnnotation() && !cl.isEnum() && !cl.isInterface() && !cl.isRecord() ) {
		this.visibility = StringUtils.toModifier(cl.getModifiers());
		this.name = StringUtils.toclassQName(cl.toString());
		uses = new Vector<String>();
		agregations = new Vector<String>();
		//compositions = new Vector<String>();
		
		//constructors
		Constructor<?>[] constructors = cl.getDeclaredConstructors();
		currclassConstructors = new Vector<ContainerMethod>();
		for (Constructor<?> constructor : constructors) {
			currclassConstructors.add(new ContainerMethod(constructor));
			/*
			 * Type[] clzs = constructor.getParameterTypes(); //Composition est plus
			 * complexe a determiner //Se baser uniquement sur les parametres du
			 * constructeur ne fournit pas r��lement d'informations // sur une �ventuelle
			 * composition for (Type clz : clzs) { if (isNotsPrimitive(clz) &&
			 * !clz.getTypeName().equals(cl.getTypeName())) {
			 * compositions.add(clz.getTypeName()); } }
			 */
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
				if (isNotsPrimitive(clz) && !clz.getTypeName().equals(cl.getTypeName())
						&& !clz.getTypeName().contains("java.lang.String")
						) {
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
				if (isNotsPrimitive(clz) && !clz.getTypeName().equals(cl.getTypeName())
						&& !clz.getTypeName().contains("java.lang.String")
						) {
					agregations.add(clz.getTypeName());
			}
		}
		//System.out.println("Agr�gation");
		//System.out.println(getAgregations());
		
		//Chaine d'h�ritage
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
		innerClasses = new Vector<String>();
		Class<?> [] innercl = cl.getDeclaredClasses();
		for (Class<?> class1 : innercl) {
			innerClasses.add(class1.toString());
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

	public List<String> getInnerClasses() {
		return innerClasses;
	}


	public void setInnerClasses(List<String> innerClasses) {
		this.innerClasses = innerClasses;
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

	/*
	 * public List<String> getCompositions() { return compositions; }
	 * 
	 * public void setCompositions(List<String> compositions) { this.compositions =
	 * compositions; }
	 */
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

	@Override
	public String toString() {
		String a ="";
		
		a += getVisibility() ;
		a += getName() ; 
		a += " {  \n" ; 
			for(ContainerField f : getCurrclassFields()) {
				a += f ;
				a += "\n" ;
			}
			for (ContainerMethod m : getCurrclassConstructors()) {
				a += m ;
				a += "\n";
			}
			for (ContainerMethod mth : getCurrclassmethods()) {
				a += mth ;
				a += "\n";
			}	
				a += " } \n" ;		
		return a ;	
	}
	@Override
	public StringBuffer toXML() {
		StringBuffer r = new StringBuffer();
		r.append("<class ");
			r.append(" name =\"").append(getName()).append("\"");
			r.append(" visibility =\"").append(getVisibility()).append("\"");
			if (getCurrclassannotations() != null && !getCurrclassannotations().isEmpty()) {
				r.append(" annotations =\"");
				r.append(String.join(",", getCurrclassannotations())).append("\"");
			}else {
				
			}	
				//int lasti = r.lastIndexOf(",");
				//r.setCharAt(lasti-1, ' ');
				
		
		if (getCurrclassFields().isEmpty() && getCurrclassmethods().isEmpty()
			 && getCurrclassConstructors().isEmpty() && getCurrclassInheritance().isEmpty()
			 && getInnerClasses().isEmpty() && getUses().isEmpty()
			 && getAgregations().isEmpty() && getCurrclassImplementedInterf().isEmpty()) 
			{
			r.append("/>");
		}
		else {
			r.append(">");
			if (getCurrclassFields() != null && !getCurrclassFields().isEmpty()) {
				r.append("<fields>");
				for (ContainerField  cf: getCurrclassFields()) {
					r.append(cf.toXML());
				}
				r.append("</fields>");
			}else {
				
			}
			if(getCurrclassConstructors() != null && !getCurrclassConstructors().isEmpty()) {
				r.append("<constructors>");
				for (ContainerMethod  constr: getCurrclassConstructors()) {
					r.append(constr.toXML());
				}
				r.append("</constructors>");
			}else {
				
			}
			if (getCurrclassmethods() != null && !getCurrclassmethods().isEmpty()) {
				r.append("<methods>");
				for (ContainerMethod  cm: getCurrclassmethods()) {
					r.append(cm.toXML());
				}
				r.append("</methods>");
			}else {
				
			}
			if (getInnerClasses() != null && !getInnerClasses().isEmpty()) {
				r.append("<innerClasses>");
				for (String clz : getInnerClasses()) {
					r.append("<innerclass name =\"").append(clz).append("\"").append("/>");
				}
				r.append("</innerClasses>");
			}else {
				
			}
			
			if(		(getCurrclassInheritance() != null && !getCurrclassInheritance().isEmpty()) ||
					(getUses() != null && !getCurrclassInheritance().isEmpty()) ||
					(getAgregations() != null && !getCurrclassInheritance().isEmpty()) ||
					(getCurrclassImplementedInterf() != null && !getCurrclassInheritance().isEmpty()) 
					) {
				r.append("<relations>");
					for(String i : getCurrclassInheritance()) {
						r.append("<relation ");
						r.append("type =\"inheritance\"").append(" superClass =\"").append(i.replace("<", "[").replace(">", "]")).append("\"");
						r.append(" />");
					}
					for(String i : getUses()) {
						r.append("<relation ");
						r.append("type =\"use\"").append(" className =\"").append(i.replace("<", "[").replace(">", "]")).append("\"");
						r.append(" />");
					}
					for(String i : getAgregations()) {
						r.append("<relation ");
						r.append("type =\"agregation\"").append(" aggregated =\"").append(i.replace("<", "[").replace(">", "]")).append("\"");
						r.append(" />");
					}
					for(String i : getCurrclassImplementedInterf()) {
						r.append("<relation ");
						r.append("type =\"implementation\"").append(" implemented-interface =\"").append(i.replace("<", "[").replace(">", "]")).append("\"");
						r.append(" />");
					}
				r.append("</relations>");
				
			}else {
				
			}
		
			r.append("</class>");
			
		}
		
		return r ;
	}



}
