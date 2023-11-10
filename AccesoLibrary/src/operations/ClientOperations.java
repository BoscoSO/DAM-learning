package operations;


import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import basedatos.HibernateUtil;
import basedatos.*;

public class ClientOperations {
	private Session session;
	
	public void openSession() throws Exception {
		try {
			SessionFactory sesion = HibernateUtil.getSessionFactory();
			session= sesion.openSession();
		}catch(Exception erro) {
			throw new Exception("open session. //"+erro.getMessage());
			
		}
	}
	public Client getClient(int idClient) throws Exception {
		try{
			TypedQuery<Client> query1 = session.createQuery("select c from Client c where c.idClient=?1", Client.class);
			
			query1.setParameter(1, idClient);
			
			Client client = query1.getSingleResult();
			return client;
		}catch(Exception erro) {
			throw new Exception("Client no encontrado. //"+erro.getMessage());
			
		}
	}
	public void addClient(Client cl) throws Exception {
		try {
			Transaction tx = session.beginTransaction();
			session.save(cl);
			tx.commit();
		}catch(Exception erro) {
			throw new Exception("Client no añadido. //"+erro.getMessage());
			
		}
	}
	public void modifyClient(Client modificado) throws Exception {
		try{
			Transaction tx = session.beginTransaction();
			
			session.update(modificado);
			tx.commit(); 
		}catch(Exception erro) {
			throw new Exception("Client no modificado. //"+erro.getMessage());
			
		}
		
	}
	public void deleteClient(Client cl) throws Exception {
		if(cl.getLoans().isEmpty()) 
			try {
				Transaction tx = session.beginTransaction();
				session.delete(cl);
				tx.commit();
			}catch(Exception erro) {
				throw new Exception("Client no borrado. //"+erro.getMessage());
			}
		
		
	}
	public List<Client> clientsList() throws Exception {
		try {
			TypedQuery<Client> query = session.createQuery("from Client", Client.class);
			List<Client> listado = query.getResultList();
			return listado;
		}catch(Exception erro) {
			throw new Exception("clientList :/"+erro.getMessage());
			
		}
	}

	
	public void closeSession() throws Exception {
		try{
			session.close();
		}catch(Exception erro) {
			throw new Exception("Close operation. //"+erro.getMessage());
			
		}
	}
}

