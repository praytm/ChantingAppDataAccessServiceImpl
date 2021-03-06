package org.iskcon.nvcc.chantingApp.dao;

/**
 * Person generated by hbm2java
 */
public class Person implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7862850384306078424L;
	private Integer id;
	private String name;
	private String country;

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public Person(String name, String country) {
		this.name = name;
		this.country = country;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
