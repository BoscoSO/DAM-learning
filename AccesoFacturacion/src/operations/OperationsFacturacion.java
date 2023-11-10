package operations;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dto.Clientes;
import dto.Facturas;
import dto.HibernateUtil;
public class OperationsFacturacion {
private Session session;
	
	public void openSession() throws Exception {
		try {
			SessionFactory sesion = HibernateUtil.getSessionFactory();
			session= sesion.openSession();
		}catch(Exception erro) {
			throw new Exception("open session. //"+erro.getMessage());
		}
	}
	public void closeSession() throws Exception {
		try{
			session.close();
		}catch(Exception erro) {
			throw new Exception("Close operation. //"+erro.getMessage());
		}
	}
	public List<Facturas> facturasList() throws Exception {
		try {
			TypedQuery<Facturas> query = session.createQuery("from Facturas", Facturas.class);
			List<Facturas> listado = query.getResultList();
			return listado;
		}catch(Exception erro) {
			throw new Exception("facturasList :/"+erro.getMessage());
		}
	}
	
	public void addFactura(Facturas factura) throws Exception {
		try {
			Transaction tx = session.beginTransaction();
			session.save(factura);
			tx.commit();
		}catch(Exception erro) {
			throw new Exception("Factura no añadida. //"+erro.getMessage());
		}
	}
	
	public void modifyFactura(Facturas modificado) throws Exception {
		try{
			Transaction tx = session.beginTransaction();
			session.update(modificado);
			tx.commit(); 
		}catch(Exception erro) {
			throw new Exception("Factura no modificada. //"+erro.getMessage());
		}
	}

	private Facturas getFactura(int idFactura) throws Exception {
		try{
			Facturas f=session.get(Facturas.class,idFactura);
			return f;
		}catch(Exception erro) {
			throw new Exception("Factura no encontrada. //"+erro.getMessage());
		}
	}
	public void deleteFactura(Integer idFactura) throws Exception {
		try {
			Transaction tx = session.beginTransaction();
			session.delete(getFactura(idFactura));
			tx.commit();
		}catch(Exception erro) {
			throw new Exception("Pedido no borrado. //"+erro.getMessage());
		}
	}

	public Clientes getCliente(int idCliente) throws Exception {
		try{
			Clientes c=session.get(Clientes.class,idCliente);
			return c;
		}catch(Exception erro) {
			throw new Exception("Cliente no encontrado. //"+erro.getMessage());
		}
	}
}
