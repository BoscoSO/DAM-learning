package dto;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;


public class Cliente {
	
	private String dni;
	private String nome;
	private String apelidos;
	private List<Enderezo> enderezos;

	public Cliente(String dni, String nome, String apelidos, List<Enderezo> enderezos) {
		this.dni = dni;
		this.nome = nome;
		this.apelidos = apelidos;
		this.enderezos = enderezos;
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
	public List<Enderezo> getEnderezos() {
		return enderezos;
	}
	public void setEnderezos(List<Enderezo> enderezos) {
		this.enderezos = enderezos;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nome=" + nome + ", apelidos=" + apelidos + ", enderezos=" + enderezos + "]";
	}
	
	public Document toDocument() {
		ArrayList<Document> dir =new ArrayList<Document>();
		for(Enderezo e:enderezos) {
			dir.add(e.toDocument());
		}
		Document client= new Document()
         		.append("dni", dni)
         		.append("nome",nome)
         		.append("apelidos", apelidos)
         		.append("enderezos", dir);
        
		return client;
	}
}
