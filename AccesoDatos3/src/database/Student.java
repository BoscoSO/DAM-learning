package database;
// Generated 30 nov. 2020 13:13:59 by Hibernate Tools 5.2.12.Final

/**
 * Student generated by hbm2java
 */
public class Student implements java.io.Serializable {

	private String dni;
	private String name;
	private String surname;
	private Integer age;

	public Student() {
	}

	public Student(String dni) {
		this.dni = dni;
	}

	public Student(String dni, String name, String surname, Integer age) {
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [dni=" + dni + ", name=" + name + ", surname=" + surname + ", age=" + age + "]";
	}
	

}
