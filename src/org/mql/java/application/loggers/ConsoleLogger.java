package org.mql.java.application.loggers;

public class ConsoleLogger implements Logger{

	public ConsoleLogger() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void log(String message) {
		System.out.println("### "  + " : " + message );
		
	}
	

}
