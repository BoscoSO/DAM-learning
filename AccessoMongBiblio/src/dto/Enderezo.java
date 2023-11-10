package dto;

import org.bson.Document;

public class Enderezo {

	private String rua;
	private int numero;
	private String localidade;
	private String provincia;

	public Enderezo(String rua, int numero, String localidade, String provincia) {
		this.rua = rua;
		this.numero = numero;
		this.localidade = localidade;
		this.provincia = provincia;
	}

	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Enderezo [rua=" + rua + ", numero=" + numero + ", localidade=" + localidade + ", provincia=" + provincia
				+ "]";
	}

	public Document toDocument() {
		Document enderezo= new Document()
         		.append("rua", rua)
         		.append("numero", numero)
         		.append("localidade", localidade)
         		.append("provincia", provincia);
        
		return enderezo;
	}
	
	
}
