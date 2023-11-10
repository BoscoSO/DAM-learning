package accesoStudents;

import java.util.ArrayList;
import java.util.Scanner;

import accesoStudents.operations.OperationsDB;
import accesoStudents.operations.Student;

public class Program {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		OperationsDB odb=new OperationsDB();
		try {
			//abrir conexion
			odb.openConection();
		
			//Arraylist
			ArrayList<Student> lista=odb.studentsList();
				
			for(Student s:lista)System.out.println(s.toString());
	
			//A�adir	
			System.out.println("Introduce un dni : ");
			String dni=sc.nextLine();
			System.out.println("Introduce un nome : ");
			String name=sc.nextLine();
			System.out.println("Introduce un apelido : ");
			String surname=sc.nextLine();
			System.out.println("Introduce la edad : ");
			int age=sc.nextInt();
			sc.nextLine();
			int result=odb.addStudent(new Student(dni,name,surname,age));
	
			if(result==1) {
				System.out.println("A�adir completo");
			}else System.out.println("A�adir no completado");
			
			//Buscar
			System.out.println("Introduce un dni para buscar : ");
			dni=sc.nextLine();
	
			Student buscado=odb.getStudent(dni);
			if(buscado!= null) {
				System.out.println("Existe\n"+buscado.toString());
			}else System.out.println("No existe el estudiante con dni ["+dni+"]");
			
			//ELiminar
			System.out.println("Introduce un dni para eliminar : ");
			dni=sc.nextLine();
			
			result=odb.deleteStudent(dni);
			if(result==1) {
				System.out.println("Borrado completo");
			}else System.out.println("Borrado no completado");
			
			//Modificar
			System.out.println("Introduce un dni para buscar : ");
			dni=sc.nextLine();
			System.out.println("Introduce un nome para editar : ");
			name=sc.nextLine();
			System.out.println("Introduce un apelido para editar : ");
			surname=sc.nextLine();
			System.out.println("Introduce la edad para editar : ");
			age=sc.nextInt();
			sc.nextLine();
			
	
			result=odb.modifyStudent(new Student(dni, name, surname, age));
			if(result==1) {
				System.out.println("Modificado completo");
			}else System.out.println("Modificado no completado");
			
			
			
	
			//Arraylist para visualizar el contenido final
			ArrayList<Student> listaa=odb.studentsList();
					
			for(Student s:listaa)System.out.println(s.toString());
			
			sc.close();
			odb.closeConection();
		}catch(Exception e) {
			System.out.println(odb.getErros());
		}
		
	}
}
