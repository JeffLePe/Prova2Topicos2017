package br.edu.univas.si8.ta.shopping.impl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.edu.univas.si8.ta.shopping.api.OrderService;
import br.edu.univas.si8.ta.shopping.interfaces.Order;

@RequestScoped
public class OrderServiceImpl implements OrderService{
	
	@EJB(mappedName = "java:app/hello-rest-ejb-0.1-SNAPSHOT/InventoryBean!br.edu.univas.si8.ta.hello.ejb.interfaces.InventoryRemote")
	private Order order;

	@Override
	public String[] listPedidos() {
		return order.listPedidos();
	}

	@Override
	public String saveNewPedido(String description) {
		order.createNewPedido(description);
		return "{\"message\": \"Success\"}";
	}
	
	

}
