package org.mql.java.testmodels.annotations;


/*
 *  A terminer
 */
public @interface Action {
	String name();
	String icon() default"";
	int key() default 0 ;
	
}
