package org.mql.java.application.mapping;

import java.io.PrintWriter;


public class SerializeToXML {
	

	public static void PersistToXML(String source, StringBuffer content) {
		
		try {
			PrintWriter out = new PrintWriter(source);
				out.println(content);
			
			out.close();
		}
		catch (Exception e) {
			System.out.println("Erreur :"+ e.getMessage());
		}
	}
	

}
