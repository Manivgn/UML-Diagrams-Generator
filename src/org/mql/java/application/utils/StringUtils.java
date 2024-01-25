package org.mql.java.application.utils;

import java.lang.reflect.Modifier;

public class StringUtils{

	public StringUtils() {
		
	}
	
	public static String toProjectName(String projectpath) {
		int lasti = projectpath.lastIndexOf("\\");
		return projectpath.substring(lasti+1);
		
	}
	
	public static String toSimpleClassName(String name) {
			int lasti = name.lastIndexOf(".");
			name = name.substring(lasti+1);
			return name;
				
	}
	
	public static String toclassQName(String n) {
		return n.replace("class", "");
	}
	
	public static String toInterfQName(String n) {
		return n.replace("interface", "");
	}
	
	public static String toModifier(int n) {
		if (Modifier.isPrivate(n)) {
			return "-" ;
		}
		else if (Modifier.isPublic(n)) {
			return "+" ;
		}
		else if (Modifier.isProtected(n)) {
			return "#" ;
		}
		else {
			return "~" ;
		}
	}

}
