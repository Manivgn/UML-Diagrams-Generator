package org.mql.java.testmodels.exerciceone;


import java.util.Vector;

/*
 * Pour tester StringMapper et ClassParser
 */
public class Book extends Document implements PageParser, Test{
	
	private int identificateur ;
	private Author author ;
	private Vector<String> pages ;
	
		public Book(int ISBN, int identificateur,Author author) {
			super(ISBN);
			this.identificateur = identificateur;
			this.author = author ;
		}
		public int getISBN() {
			return ISBN;
		}
		public void setISBN(int iSBN) {
			ISBN = iSBN;
		}
		public int getIdentificateur() {
			return identificateur;
		}
		public void setIdentificateur(int identificateur) {
			this.identificateur = identificateur;
		}
		public Author getAuthor() {
			return author;
		}
		public void setAuthor(Author author) {
			this.author = author;
		}
		public Vector<String> getPages() {
			return pages;
		}
		public void setPages(Vector<String> pages) {
			this.pages = pages;
		}
		@Override
		public void textParser() {
			
		}
		@Override
		public void imageParser() {
			
		}
		public class InsideBook{
			
		}
		public class AnotherPart{
			
		}
		
		
}
