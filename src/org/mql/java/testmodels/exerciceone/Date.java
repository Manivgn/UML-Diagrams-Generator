package org.mql.java.testmodels.exerciceone;


/*
 * Pour tester ClassParser
 */
public final class Date implements Calendar{
	//private static String season ;
	public int day;
	public int month;
	private final int year ;
	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	
	public class Day{
		
	}
	public class Month{	
		
	}
	public class Year{
		
	}
	@Override
	public void leapYear() {
		
	}
	
	

}
