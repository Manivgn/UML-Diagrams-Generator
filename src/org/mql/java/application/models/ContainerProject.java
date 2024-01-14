package org.mql.java.application.models;


import java.util.LinkedHashSet;
import java.util.List;
import java.util.Vector;

import org.mql.java.application.mapping.XMLMapping;
import org.mql.java.application.reflection.PackageExplorer;


public class ContainerProject implements XMLMapping{
	private String projectName ="";
	private LinkedHashSet<String> packagelist ; //un tableau de packages (uniques/Set);
	private static List<ContainerPackage> ctnpcklist ;
	
	/*
	public ContainerProject(String projectpath, String packagename) {
		setPackagelist(new LinkedHashSet<ContainerPackage>());
		classpath = projectpath.concat("\\bin");
		System.out.println(classpath);
		scanProject(new File(classpath),classpath, packagename);
		//System.out.println(ctnpro.getPacklist());
	}
	*/
	public ContainerProject(String projectname) {
		this.projectName += projectname;
		packagelist = new LinkedHashSet<String>();	
		ctnpcklist = new Vector<ContainerPackage>();
	}
	public  void generateContainerPackage(String classpath) {
		for (String item : getPackagelist()) {
			ctnpcklist.add(PackageExplorer.explorePackage(classpath, item));
		}
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
	
	public static List<ContainerPackage> getCtnpcklist() {
		return ctnpcklist;
	}
	public String getProjectName() {
		return projectName;
	}
		
	@Override
	public StringBuffer toXML() {
		StringBuffer  r = new StringBuffer();
		r.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append("\n");
		r.append("<project").append("\n");
						r.append(" name =\"").append(getProjectName()).append("\"");
		r.append(" >");
			for (ContainerPackage item : ctnpcklist) {
				r.append(item.toXML()).append("\n");
			}
		r.append("</project>");
		
		return r ;
	}
	

	


}
