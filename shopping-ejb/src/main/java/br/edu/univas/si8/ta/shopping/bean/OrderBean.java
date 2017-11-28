package br.edu.univas.si8.ta.shopping.bean;

import java.sql.Timestamp;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.edu.univas.si8.ta.shopping.dao.PedidoDAO;
import br.edu.univas.si8.ta.shopping.entities.Pedido;
import br.edu.univas.si8.ta.shopping.interfaces.OrderLocal;
import br.edu.univas.si8.ta.shopping.interfaces.OrderRemote;

@Stateless
@Local(OrderLocal.class)
@Remote(OrderRemote.class)
public class OrderBean implements OrderLocal, OrderRemote{
	
	@EJB
	private PedidoDAO dao;

	@Override
	public void createNewPedido(String description) {
		Pedido pedido = new Pedido();
		pedido.setDescription(description);
		pedido.setDate(new Timestamp(System.currentTimeMillis()));
		dao.insert(pedido);
		
	}

	@Override
	public String[] listPedidos() {
		return dao.listAll()
				.stream()
				.map(Pedido::getDescription)
				.collect(Collectors.toList())
				.toArray(new String[0]);
	}
	
}
