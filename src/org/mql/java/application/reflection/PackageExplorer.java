package org.mql.java.application.reflection;

import java.io.File;
import org.mql.java.application.models.ContainerPackage;

public class PackageExplorer {
	private  static ContainerPackage ctnpck ;
	
	public static ContainerPackage explorePackage(String classpath, String packagename) {
		String packagefolder = packagename.replace(".", "\\");
		File dir = new File(classpath + "\\" + packagefolder);
		//System.out.println(classpath);
		File [] files = dir.listFiles();
		ctnpck = new ContainerPackage(classpath, packagename, files);
		return ctnpck ;
		
	}

	public static ContainerPackage getCtnpck() {
		return ctnpck;
	}


}
