
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import database.HibernateUtil;
import database.Student;

public class MainTest {

	public static void main(String[] args) {
		
		try {
			SessionFactory sesion=HibernateUtil.getSessionFactory();
			Session session =sesion.openSession();
			
			//add a student
			System.out.println("New student");
			Transaction trs= session.beginTransaction();
			Student st= new Student("45907503D", "Bosco", "Suárez-LLanos", 21);
			session.save(st);
			
			trs.commit();
			
			
			//listar contenido
			
			System.out.println("List of students");
			TypedQuery<Student> queryRes = session.createQuery("from Student",Student.class);
			List<Student> lista=queryRes.getResultList();
			lista.forEach(System.out::println);
			
			
			//sacar un alumno
			System.out.println("Buscando a Bosco...");
			TypedQuery<Student> query2 = session.createQuery("select s from Student s where s.dni=?1 and s.name=?2",Student.class);
			query2.setParameter(1,"45907503D");
			query2.setParameter(2,"Bosco");
			
			Student st1 = query2.getSingleResult();
			System.out.println(st1);
			
			//update un stuednt

			Transaction trs2= session.beginTransaction();
				//student a modificar
			st = query2.getSingleResult();
				//modificamos
			st.setSurname("Outeiriño");
			st.setAge(44);
				//actualizamos
		
			session.update(st);
			trs2.commit();
			//fin update
			
			
			
			
			st1 = query2.getSingleResult();
			System.out.println("Actualizado \n"+st1);
			
			//Borrar un student

			System.out.println("Borramos y comprobamos");
			Transaction trs3= session.beginTransaction();
			session.delete(st1);
			trs3.commit();
			
			 lista=queryRes.getResultList();
			lista.forEach(System.out::println);
			//close sesions
			
			session.close();
			sesion.close();
		} catch (Exception e) {
			System.out.println("erro : "+e.getMessage());
		}
	}

}
