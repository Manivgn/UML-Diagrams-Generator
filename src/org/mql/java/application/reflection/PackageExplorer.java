package org.mql.java.application.reflection;

import java.io.File;

import org.mql.java.application.models.ContainerPackage;

public class PackageExplorer {
	private  ContainerPackage ctnpck ;
	
	public PackageExplorer(String classpath, String packagename) {
		String packagefolder = packagename.replace(".", "\\");
		File dir = new File(classpath + "\\" + packagefolder);
		//System.out.println(classpath);
		File [] files = dir.listFiles();
		ctnpck = new ContainerPackage(classpath, packagename, files);
		
	}

	public ContainerPackage getCtnpck() {
		return ctnpck;
	}


}
