package org.mql.java.application.models;

import java.util.LinkedHashSet;

public class ContainerProject {
	private LinkedHashSet<ContainerPackage> packlist ;
 
	public ContainerProject() {
		packlist = new LinkedHashSet<ContainerPackage>();
	}
	
	public LinkedHashSet<ContainerPackage> getPacklist() {
		return packlist;
	}
	
	public void addtoContainerProject(ContainerPackage pack ) {
		packlist.add(pack);
	}

}
