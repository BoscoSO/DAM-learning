package operations;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dto.Cliente2;
import dto.HibernateUtil;
import dto.LineaPedido2;
import dto.Pedido2;
import dto.Produto2;

public class Operations {
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
	
	public List<Pedido2> ordersList() throws Exception {
		try {
			TypedQuery<Pedido2> query = session.createQuery("from Pedido2", Pedido2.class);
			List<Pedido2> listado = query.getResultList();
			return listado;
		}catch(Exception erro) {
			throw new Exception("ordersList :/"+erro.getMessage());
		}
	}
	public void addOrder(Pedido2 order) throws Exception {
		try {
			Transaction tx = session.beginTransaction();
			session.save(order);
			tx.commit();
		}catch(Exception erro) {
			throw new Exception("Pedido no añadido. //"+erro.getMessage());
		}
	}
	public void modifyOrder(Pedido2 modificado) throws Exception {
		try{
			Transaction tx = session.beginTransaction();
			session.update(modificado);
			tx.commit(); 
		}catch(Exception erro) {
			throw new Exception("Pedido no modificado. //"+erro.getMessage());
		}
	}

	public void deleteOrder(Pedido2 order) throws Exception {
		try {
			for(LineaPedido2 l: order.getLineaPedido2s()) {
				deleteLineas(l);
			}
			Transaction tx = session.beginTransaction();
			session.delete(order);
			tx.commit();
		}catch(Exception erro) {
			throw new Exception("Pedido no borrado. //"+erro.getMessage());
		}
	}
	private void deleteLineas(LineaPedido2 linea) throws Exception {
		try {
			Transaction tx = session.beginTransaction();
			session.delete(linea);
			tx.commit();
		}catch(Exception erro) {
			throw new Exception("Lineas no borrado. //"+erro.getMessage());
		}
	}
	public void addLinea(LineaPedido2 linea) throws Exception {
		try {
			Transaction tx = session.beginTransaction();
			session.save(linea);
			tx.commit();
		}catch(Exception erro) {
			throw new Exception("Linea no añadido. //"+erro.getMessage());
		}
	}
	public Produto2 getProducto(int idProduto2) throws Exception {
		try{
			Produto2 prdc=session.get(Produto2.class,idProduto2);
			return prdc;
		}catch(Exception erro) {
			throw new Exception("Produto2 no encontrado. //"+erro.getMessage());
		}
	}
	public Cliente2 getCliente(int idCliente2) throws Exception {
		try{
			Cliente2 cli=session.get(Cliente2.class,idCliente2);
			return cli;
		}catch(Exception erro) {
			throw new Exception("Cliente2 no encontrado. //"+erro.getMessage());
		}
	}
	public List<Produto2> productsList() throws Exception {
		try {
			TypedQuery<Produto2> query = session.createQuery("from Produto2", Produto2.class);
			List<Produto2> listado = query.getResultList();
			return listado;
		}catch(Exception erro) {
			throw new Exception("productsList :/"+erro.getMessage());
		}
	}
}
