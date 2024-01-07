package org.mql.java.testmodels.exerciceone;

import org.mql.java.testmodels.annotations.*;
import org.mql.java.models.*;

/*
 * Pour tester StringMapper et ClassParser
 */
@Form(title="Gestion des auteurs" , labelSize = 120)
public final class Author extends Person implements TestforInterface{
		
		@Controller
		@TextField(label="Nom", size=30)
		private String name ;
		@Controller
		@TextField(label="Pays", size=20)
		private String country ;
		@Controller
		@TextField(label="Birthday", size=15)
		private Date birthday ;
		
		
		public Author(int id, String name, String country, Date birthday) {
			super(id);
			this.name = name;
			this.country = country;
			this.birthday = birthday;
		}
		
		@Action(name="NAME")
		public Date getBirthday() {
			return birthday;
		}
		@Action(name="NAME")
		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}
		
		@Action(name="NAME")
		public String getName() {
			return name;
		}
		
		@Action(name="NAME")
		public void setName(String name) {
			this.name = name;
		}
		
		@Action(name="NAME")
		public String getCountry() {
			return country;
		}
		
		@Action(name="NAME")
		public void setCountry(String country) {
			this.country = country;
		}

		@Override
		public boolean isWorking() {
			// TODO Auto-generated method stub
			return true;
		}
		
}
