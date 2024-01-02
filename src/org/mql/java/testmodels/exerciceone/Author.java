package org.mql.java.testmodels.exerciceone;

/*
 * Pour tester StringMapper et ClassParser
 */
public  class Author {
		private String name ;
		private String country ;
		private Date birthday ;
		
		public Date getBirthday() {
			return birthday;
		}

		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}

		public Author(String name, String country, Date birthday) {
			super();
			this.name = name;
			this.country = country;
			this.birthday = birthday;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}
		
}
