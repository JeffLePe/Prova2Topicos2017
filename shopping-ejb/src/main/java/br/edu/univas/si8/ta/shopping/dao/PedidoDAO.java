package br.edu.univas.si8.ta.shopping.dao;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.univas.si8.ta.shopping.entities.Pedido;

@Stateless
public class PedidoDAO {
	
	@PersistenceContext(unitName = "shopping")
	private EntityManager em;
	
	public void insert(Pedido pedido) {
		em.persist(pedido);
	}
	
	public List<Pedido> listAll() {
		return em.createQuery("from pedidos p", Pedido.class).getResultList();
	}

}
