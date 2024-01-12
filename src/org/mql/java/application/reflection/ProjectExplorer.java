package org.mql.java.application.reflection;

import java.io.File;
import java.util.LinkedHashSet;

import org.mql.java.application.models.ContainerProject;



public class ProjectExplorer {
	private static ContainerProject ctnpro ;
	public String classpath ="" ;
	
	
	/*
	//Cas ou le nom du projet est fourni sans le path vers le projet
	// on peut récuperer le user dir lui soustraire le workspace et y concatener le nom du projet + bin
	public ProjectExplorer(String projectname) {
		int i = System.getProperty("user.dir").lastIndexOf("\\");
		//System.out.println("User dir " + System.getProperty("user.dir"));
		String workspacepath = System.getProperty("user.dir").substring(0,i);
		
		File workspacefile = new File(workspacepath);
		File []workspproject = workspacefile.listFiles();
		for (File file : workspproject) {
			//System.out.println(file.getAbsolutePath());
		
		}
	}
	*/
	
	//Boolean isProjectAvailable = false;
	// Cas ou le nom du projet est fourni incluant le path vers le projet
	//Sinon on peut récuperer le user dir lui soustraire le workspace et y concatener le nom du projet + bin
	public ProjectExplorer(String projectpath) {
		ctnpro = new ContainerProject();
		classpath = projectpath.concat("\\bin");
		System.out.println("Classpath : " + classpath);
		scanProject(new File(classpath), "");
	}
	
	public static void scanProject(File dir , String packagename) {
		
		File files[] = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				
				 scanProject(file, packagename + file.getName() + ".");
				
			} 
			else  {
				if(file.getName().endsWith(".class")) {
					//System.out.println(packagename.substring(0,packagename.length()-1));
					ctnpro.addPackage(packagename.substring(0,packagename.length()-1));
					
				}
				//String filename = file.getAbsolutePath();
				//System.out.println("Filename : " + filename);
				
				//filename = filename.replace(classpath+"\\", "");
				//System.out.println("Filename : " + filename);
				
				//filename = filename.replace("\\", ".");
				//filename = filename.substring(0,classpath.length()-1);
				//filename = filename.substring(0,filename.lastIndexOf("\\"));

			}
		
		}
	}
	
	public  LinkedHashSet<String> getCtnpro() {
		return ctnpro.getPackagelist();
	}
	
	public String getClasspath() {
		return classpath;
	}
	

	
}
