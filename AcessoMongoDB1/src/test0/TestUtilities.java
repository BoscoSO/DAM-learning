package test0;

import java.util.ArrayList;

import org.bson.Document;

import modeloUtilities.Operacions;

public class TestUtilities {

	public static void main(String[] args) {
		TestUtilities test=new TestUtilities();
		Operacions op=new Operacions();
		String nomCol="empregados";
		try {
			op.abrirConexion("miDB");
			
			op.setNomeCollection(nomCol);
			
			op.list().forEach(System.out::println);
			
			//op.createCollection(nomCol);
			
			//Document grupo=test.getEjemplo();
            //op.addDoc(nomCol, grupo);
			
			System.out.println("Busqueda de alumno de nome Pedro ");
			Document doc=op.getDoc("empNo", 3);

			System.out.println("Busqueda finalizada: \n\t"+doc);
			
			op.modifyDoc("empNo", 3, "salario", 1700);
			
			doc=op.getDoc("empNo", 3);

			System.out.println("Busqueda finalizada: \n\t"+doc);
			
			op.cerrarConexion();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Document getEjemplo() {
		
		ArrayList<Document> alumnos =new ArrayList<Document>();
        Document alumno1= new Document()
        		.append("dni", "23452111A")
        		.append("nome", "Pedro")
        		.append("apelidos", "Suarez")
        		.append("idade", 33);
        alumnos.add(alumno1);
        Document alumno2= new Document()
        		.append("dni", "2352235S")
        		.append("nome", "Carlos")
        		.append("apelidos", "Barro")
        		.append("idade", 23);
        alumnos.add(alumno2);
        
	    //GrupoAlumnos
	    Document grupo= new Document()
	    		.append("id", 13)
	    		.append("Grupo", "2DAM")
	    		.append("mesas", "4")
	    		.append("alumnos", alumnos);
	return grupo;
	}
}
