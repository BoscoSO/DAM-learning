package test0;

import java.util.ArrayList;

import modeloUtilities.Operacions;
import modeloUtilities.dto.Alumno;
import modeloUtilities.dto.Grupo;

public class TestAlumnos {

	public static void main(String[] args) {
		TestUtilities test=new TestUtilities();
		Operacions op=new Operacions();
		String nomCol="grupoAlumnos";
		try {
			op.abrirConexion("miDB");
			
			//engadir una coleccion grupos			
			op.setNomeCollection(nomCol);
			
			
			Grupo grupo1=new Grupo("1", "DAM", "ordinario", getAlumnos(1));
			Grupo grupo2=new Grupo("2", "ASIR", "extraordinario", getAlumnos(2));
			//engadir dos grupos de alumnos
			
			op.addDoc(grupo1.toDocument());
			op.addDoc(grupo2.toDocument());
			
			//consultar contido
			op.list().forEach(System.out::println);
		
			
			//cerrar conexion
			op.cerrarConexion();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static ArrayList<Alumno> getAlumnos(int i) {
		
		ArrayList<Alumno> lista=new ArrayList<Alumno>();
		if(i==1) {
			lista.add(new Alumno("4592462D", "Antonio", "Martinez", 18));
			lista.add(new Alumno("4592462D", "Luis", "Suarez", 19));
			lista.add(new Alumno("4592462D", "Ana", "Garcia", 18));
		}else {
			lista.add(new Alumno("4592462D", "Pedro", "Perez", 24));
			lista.add(new Alumno("5135134S", "Juan", "Pazos", 23));
			lista.add(new Alumno("5624587A", "Maria", "Zapatero", 25));
			lista.add(new Alumno("8654216K", "Teresa", "Lagos", 23));
		}
		return lista;
	}
}
