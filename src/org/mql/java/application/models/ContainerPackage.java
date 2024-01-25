package org.mql.java.application.models;


import java.io.File;
import java.util.List;
import java.util.Vector;

import org.mql.java.application.loggers.Logger;
import org.mql.java.application.persistancexml.XMLMapping;
import org.mql.java.application.reflection.MaClassLoader;

public class ContainerPackage implements XMLMapping{
	private Logger logger = null;
	private String packageName ;
	private List<ContainerClass> classlist ;
	private List<ContainerAnnotation> annotationlist ;
	private List<ContainerEnum> enumlist ;
	private List<ContainerInterface> interfacelist ;
	
	
	
	public ContainerPackage(String packagename) {
		this.packageName = packagename;
		classlist = new Vector<ContainerClass>();
		annotationlist = new Vector<ContainerAnnotation>();
		enumlist = new Vector<ContainerEnum>();
		interfacelist = new Vector<ContainerInterface>();
	}
	public ContainerPackage(String classpath, String packagename, File[] files)  {
		this.packageName = packagename;
		classlist = new Vector<ContainerClass>();
		annotationlist = new Vector<ContainerAnnotation>();
		enumlist = new Vector<ContainerEnum>();
		interfacelist = new Vector<ContainerInterface>();
		for (File f : files) {
			Class<?> cls = null;
			if(f.getName().endsWith(".class")) {
				String classqualifiedName = packagename + "." + f.getName().replace(".class", "");
				
				cls = MaClassLoader.loadClass(classpath, classqualifiedName);
				
				if (cls.isAnnotation()) 
					annotationlist.add(new ContainerAnnotation(cls));
				
				else if (cls.isEnum()) 
					enumlist.add(new ContainerEnum(cls));

				else if (cls.isInterface()) 
					interfacelist.add(new ContainerInterface(cls));
				
				else if (!cls.isAnnotation() && !cls.isEnum() && !cls.isInterface() && !cls.isRecord()) 
					classlist.add(new ContainerClass(cls));
				
				MaClassLoader.closeClassLoader();
				
			
			}
		}
	}
	
	public List<ContainerClass> getClasslist() {
		return classlist;
	}
	
	public List<ContainerAnnotation> getAnnotationlist() {
		return annotationlist;
	}
	
	public List<ContainerEnum> getEnumlist() {
		return enumlist;
	}
	
	public List<ContainerInterface> getInterfacelist() {
		return interfacelist;
	}
	
	public void addtoClassList(ContainerClass cla) {
		classlist.add(cla);
	}
	
	public void addtoEnumList(ContainerEnum cla) {
		enumlist.add(cla);
	}
	
	public void addtoAnnotatList(ContainerAnnotation cla) {
		annotationlist.add(cla);
	}
	
	public void addtoInterfaceList(ContainerInterface cla) {
		interfacelist.add(cla);
	}

	public void setClasslist(List<ContainerClass> classlist) {
		this.classlist = classlist;
	}

	public void setAnnotationlist(List<ContainerAnnotation> annotationlist) {
		this.annotationlist = annotationlist;
	}

	public void setEnumlist(List<ContainerEnum> enumlist) {
		this.enumlist = enumlist;
	}

	public void setInterfacelist(List<ContainerInterface> interfacelist) {
		this.interfacelist = interfacelist;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public void display() {
		log(this.toString());
	}
	@Override
	public String toString() {
		String a ="" ;
				a += getPackageName() +"\n" ;
				a += "Interface Section \n" ; 
				for(ContainerInterface i : getInterfacelist()) {
					a += i.toString();
				}
				a += "\n" ;
				a += "Class Section \n" ;
				for (ContainerClass clz : getClasslist()) {
					a += clz.toString();
				}
				a += "\n" ;
				a +="Annotation Section \n" ;
				for (ContainerAnnotation an : getAnnotationlist()) {
					a += an.toString();
				}
				a += "\n" ;
				 a += "Enum Section \n" ;
				for (ContainerEnum en : getEnumlist()) {
					a += en.toString();
				}
				a += "\n" +"\n" + "\n" + "\n" ;
				return a ;
				
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	public void log(String message) {
		if (logger != null) {
			logger.log(message);
		}
	}

	@Override
	public StringBuffer toXML() {
		StringBuffer r = new StringBuffer();
		r.append("<package ");
				r.append(" name =\"").append(getPackageName()).append("\"");
		r.append(" >");
		
		if (getClasslist() != null && !getClasslist().isEmpty()) {
			r.append("<classes>");
				for (ContainerClass ctnclz : getClasslist()) {
					r.append(ctnclz.toXML());
				}
			r.append("</classes>");
		}
		
		if (getInterfacelist() != null && !getInterfacelist().isEmpty()) {
			r.append("<interfaces>");
				for (ContainerInterface ctninterf : getInterfacelist()) {
					r.append(ctninterf.toXML());
				}
			r.append("</interfaces>");
			
		}
		
		if (getAnnotationlist() != null && !getEnumlist().isEmpty()) {
			r.append("<annotations>");
				for (ContainerAnnotation ctnann : getAnnotationlist()) {
					r.append(ctnann.toXML());
				}
			r.append("</annotations>");
	
		}
		
		if (getEnumlist() != null && !getEnumlist().isEmpty()) {
			r.append("<enumerations>");
				for (ContainerEnum ctnenum : getEnumlist()) {
					r.append(ctnenum.toXML());
				}
			r.append("</enumerations>");
	
		}
		r.append("</package>");
				
		return r ;
	}
	

}
