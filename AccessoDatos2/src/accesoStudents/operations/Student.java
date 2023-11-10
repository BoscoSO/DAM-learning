package accesoStudents.operations;

public class Student {
	private String dni;
	private String name;
	private String surname;
	private int age;

	public Student(String dni, String name, String surname, int age) {
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	public String getDni() {
		return dni;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public int getAge() {
		return age;
	}
	
	public String toString() {
		return	"Student{"+"\n"+
				 		"\tDNI : "+dni+"\n"+
						"\tName : "+name+"\n"+
						"\tSurname : "+surname+"\n"+
						"\tAge : "+age+"\n}\n";
	}
	
}
