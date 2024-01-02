package org.mql.java.testmodels.exerciceone;


/*
 * Pour tester ClassParser
 */
public class Document extends AboveDocument{
	
		protected int ISBN;
		
		public Document(int ISBN) {
			this.ISBN = ISBN;
		}
		public int getISBN() {
			return ISBN;
		}
		public void setISBN(int iSBN) {
			ISBN = iSBN;
		}
		
}
