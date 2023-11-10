package modeloUtilities.dto;

import org.bson.Document;

public class Alumno {
	private String dni;
	private String nome;
	private String apelidos;
	private int idade;

	public Alumno(String dni, String nome, String apelidos, int idade) {
		this.dni = dni;
		this.nome = nome;
		this.apelidos = apelidos;
		this.idade = idade;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelidos() {
		return apelidos;
	}
	public void setApelidos(String apelidos) {
		this.apelidos = apelidos;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nome=" + nome + ", apelidos=" + apelidos + ", idade=" + idade + "]";
	}
	
	public Document toDocument() {
		Document alumno= new Document()
         		.append("dni", dni)
         		.append("nome", nome)
         		.append("apelidos", apelidos)
         		.append("idade", idade);
        
		return alumno;
	}
}
