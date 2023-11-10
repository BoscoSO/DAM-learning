package modeloUtilities.dto;

import java.util.ArrayList;

import org.bson.Document;

public class Grupo {
	
	private String id;
	private String grupo;
	private String rexime;
	private ArrayList<Alumno> alumnos;
	
	public Grupo(String id, String grupo, String rexime, ArrayList<Alumno> alumnos) {
		super();
		this.id = id;
		this.grupo = grupo;
		this.rexime = rexime;
		this.alumnos = alumnos;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getRexime() {
		return rexime;
	}
	public void setRexime(String rexime) {
		this.rexime = rexime;
	}
	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	@Override
	public String toString() {
		return "Grupo [id=" + id + ", grupo=" + grupo + ", rexime=" + rexime + ", alumnos=" + alumnos + "]";
	}
	
	public Document toDocument() {
		ArrayList<Document> alumnosConv=new ArrayList<Document>();
		for(Alumno a:alumnos) {
			alumnosConv.add(a.toDocument());
		}
		Document grup= new Document()
         		.append("id", id)
         		.append("grupo",grupo)
         		.append("rexime", rexime)
         		.append("alumnos", alumnosConv);
        
		return grup;
	}
}
