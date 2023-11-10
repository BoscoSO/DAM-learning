package ope;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import dto.Cliente;
import dto.Enderezo;
import dto.Libro;

public class Operacions {
	private MongoDatabase db ;
	private MongoClient mongoClient;
	private String nomeCollection;
	
	public void abrirConexion(String nomeDB) throws Exception{
      mongoClient = new MongoClient("192.168.56.101");
      db = mongoClient.getDatabase(nomeDB);
	}
	public void cerrarConexion() throws Exception{
        mongoClient.close();
        db=null;
        mongoClient=null;
	}
	
	public void createCollection(String nome) throws Exception{
		db.createCollection(nome);
		setNomeCollection(nome);
	}
	public void setNomeCollection(String nom) {
		this.nomeCollection=nom;
	}
	
	public void addDoc(Document doc) throws Exception{
		 db.getCollection(nomeCollection).insertOne(doc);
	}
	public Document getDoc(String argTag,Object argValue) throws Exception{
		return db.getCollection(nomeCollection).find(eq(argTag,argValue)).first();
	}
	public long delDoc(Document doc) throws Exception{
		 DeleteResult res= db.getCollection(nomeCollection).deleteOne(doc);
		 return res.getDeletedCount();
	}
	public long delDocs(String argTag,Object argValue) throws Exception{
		 DeleteResult res=db.getCollection(nomeCollection).deleteMany(eq(argTag,argValue));
		 return res.getDeletedCount();
	}
	
	public long modifyDoc(String argTag,Object argValue,String tagModified,Object newValue) throws Exception{
		UpdateResult resultado = db.getCollection(nomeCollection).updateOne(eq(argTag,argValue),combine(set(tagModified,newValue)));
		return resultado.getModifiedCount();
		
	}
	
	public List<Enderezo> getEnderezosFromDoc(List<Document> lst ) {
		List<Enderezo> enderezos=new ArrayList<Enderezo>();
		for(Document d:lst) {
			enderezos.add(getEnderezoFromDoc(d));
		}
		
		return enderezos;
	}	
	public Enderezo getEnderezoFromDoc(Document d) {
		return new Enderezo(d.getString("rua"), d.getInteger("numero"), d.getString("localidade"), d.getString("provincia"));
	}
	public Cliente getClienteFromDoc(Document cli) {
		return new Cliente(cli.getString("dni"), cli.getString("nome"), cli.getString("apelidos"), 
							getEnderezosFromDoc((List<Document>) cli.get("enderezos")));
	}
	public Libro getLibroFromDoc(Document lib) {
		return new Libro(lib.getString("isbn"), lib.getString("titulo"), (List<String>) lib.get("autores"));
	}
	
	
	public ArrayList<Document> list() throws Exception{
		return db.getCollection(nomeCollection).find().into(new ArrayList<Document>());
	}
	public ArrayList<Document> list(String tag,int i) throws Exception{
		if(i==1)
			return db.getCollection(nomeCollection)
					.find()
					.sort(Sorts.ascending(tag))
					.into(new ArrayList<Document>());
		else {
			return db.getCollection(nomeCollection)
					.find()
					.sort(Sorts.descending(tag))
					.into(new ArrayList<Document>());
		}
	}
	
	
}
