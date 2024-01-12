package org.mql.java.application.models;


import java.io.File;
import java.util.List;
import java.util.Vector;

import org.mql.java.application.reflection.MaClassLoader;

public class ContainerPackage {
	private String packageName ;
	private List<ContainerClass> classlist ;
	private List<ContainerAnnotation> annotationlist ;
	private List<ContainerEnum> enumlist ;
	private List<ContainerInterface> interfacelist ;
	
	
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
				MaClassLoader m = new MaClassLoader(classpath, classqualifiedName);
				cls = m.getMaClass();
				
				if (cls.isAnnotation()) 
					annotationlist.add(new ContainerAnnotation(cls));
				
				else if (cls.isEnum()) 
					enumlist.add(new ContainerEnum(cls));

				else if (cls.isInterface()) 
					interfacelist.add(new ContainerInterface(cls));
				
				else if (!cls.isAnnotation() && !cls.isEnum() && !cls.isInterface() && !cls.isRecord()) 
					classlist.add(new ContainerClass(cls));
				
				m.closeClassLoader();
				
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
	
	@Override
	public String toString() {
		return getPackageName() + getInterfacelist()  ;
	}
	

}
