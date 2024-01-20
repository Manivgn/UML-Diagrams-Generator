package org.mql.java.application.reflection;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class MaClassLoader  {
	private static URLClassLoader myClassLoader;
	
	
	public static Class<?> loadClass(String projectClassPath, String classqualifiedname) {
		 try {
	        	URL[] classPath = {new File(projectClassPath).toURI().toURL()};
	        	myClassLoader = new URLClassLoader(classPath, ClassLoader.getSystemClassLoader());
	            Class<?> maClasse = myClassLoader.loadClass(classqualifiedname); 
	            return maClasse;
	        }
	        catch (Exception e) {
				e.printStackTrace();
			}
		return null ;
	}
	
	public static void closeClassLoader() {
		try {
		myClassLoader.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
