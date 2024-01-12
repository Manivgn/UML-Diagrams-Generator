package org.mql.java.testmodels.exerciceone;


import java.util.Vector;
import org.mql.java.testmodels.annotations.ForConstructor;
import org.mql.java.testmodels.annotations.Form;
import org.mql.java.testmodels.annotations.TextField;

/*
 * Pour tester StringMapper et ClassParser
 */
public class Book extends Document implements PageParser, TestforInterface{
	
	private int identificateur ;
	private Author author ;
	private Vector<String> pages ;
		
		@ForConstructor(key=18)
		public Book(int ISBN, int identificateur,Date date) {
			super(ISBN);
			this.identificateur = identificateur;
			
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
		
		@Form(title="Gestion Section de Livre" , labelSize = 70)
		public class InsideBook{
			@TextField(label="Nom", size=30)
			private String first ;
			
			
			public String toGo() {
				return first;
				
			}
			public void setFirst() {
				this.first = toGo();
			}
		}
		
		@Form(title="Gestion Section de Livre" , labelSize = 70)
		public class AnotherPart{
			@TextField(label="Nom", size=30)
			private String second ;
			
			private String toCome() {
				return second;
			}
			
			public void setSecond() {
				this.second = toCome();
			}
		}

		@Override
		public boolean isWorking() {
			// TODO Auto-generated method stub
			return true;
		}
		
		
}
