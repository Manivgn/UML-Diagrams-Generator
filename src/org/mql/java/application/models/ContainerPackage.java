package org.mql.java.application.models;

import java.util.List;

public class ContainerPackage {
	private List<ContainerClass> classlist ;
	private List<ContainerAnnotation> annotationlist ;
	private List<ContainerEnum> enumlist ;
	private List<ContainerInterface> interfacelist ;
	
	
	public ContainerPackage() {
		
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
	
	
	

}
