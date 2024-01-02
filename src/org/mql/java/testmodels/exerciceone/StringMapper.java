package org.mql.java.testmodels.exerciceone;

import java.lang.reflect.Field;
public class StringMapper {
	
	
		public static StringBuffer test = new StringBuffer();
		static StringBuffer re = new StringBuffer();
		
		public StringMapper() {
			
		}
		
		public static String toString(Object obj) {
			Field []fields  = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				String a1 = field.getType().getSimpleName();
				String a2 = field.getName().toString();
				test.append(a1+" : ");
				test.append(a2+" = ");
				String a3 ="";
					try {
						a3 = field.get(obj).toString();
						test.append(a3+", ");
						
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					field.setAccessible(false);
			}
				
			 String text = test.toString();
			 return text ;
			
		}
		
		public static String toDeepString(Object obj) {
			Field [] fields  = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				if(field.getType().isPrimitive() || field.getType().equals(String.class)) {
					String a1 = field.getType().getSimpleName();
					String a2 = field.getName().toString();
					re.append(a1+" : ");
					re.append(a2+" = ");
					String a3 ="";
						try {
							a3 = field.get(obj).toString();
							re.append(a3+", ");	
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
				}
				else if(!field.getType().isPrimitive() && !field.getType().equals(String.class)){
					try{
						
						Object a  = field.get(obj);
						test.append(toDeepString(a));
					}
					catch (Exception e) {System.out.println(e.getMessage());}	
					
				}
				field.setAccessible(false);
			}
			String text = re.toString();
			return text;
		}
}
		

