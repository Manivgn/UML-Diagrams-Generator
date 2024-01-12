package org.mql.java.application.models;


import java.util.LinkedHashSet;



public class ContainerProject {
	
	private LinkedHashSet<String> packagelist ; //un tableau de packages (uniques/Set);
	
	/*
	public ContainerProject(String projectpath, String packagename) {
		setPackagelist(new LinkedHashSet<ContainerPackage>());
		classpath = projectpath.concat("\\bin");
		System.out.println(classpath);
		scanProject(new File(classpath),classpath, packagename);
		//System.out.println(ctnpro.getPacklist());
	}
	*/
	public ContainerProject() {
		packagelist = new LinkedHashSet<String>();
		
	}
	
	public void addPackage(String e) {
		packagelist.add(e);
	}


	public LinkedHashSet<String> getPackagelist() {
		return packagelist;
	}


	public void setPackagelist(LinkedHashSet<String> packagelist) {
		this.packagelist = packagelist;
	}
		


}
