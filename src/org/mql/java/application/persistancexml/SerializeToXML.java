package org.mql.java.application.persistancexml;

import java.io.FileWriter;


public class SerializeToXML {
	

	public static void PersistToXML(String source, StringBuffer content) {
		
		/*
		 * try { PrintWriter out = new PrintWriter(source); out.println(content);
		 * 
		 * out.close(); } catch (Exception e) { System.out.println("Erreur :"+
		 * e.getMessage()); }
		 */
		try {
			 FileWriter fw = new FileWriter(source);
			 fw.write(content.toString());
			 fw.close();
			 
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	

}
