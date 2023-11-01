package StoreApp.StoreApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import StoreApp.StoreApp.entity.Order;
import StoreApp.StoreApp.repository.OrderRepository;
import StoreApp.StoreApp.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepository;
	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}
	@Override
	public List<Order> getAllOrderByUser_Id(String id) {
		// TODO Auto-generated method stub
		return orderRepository.findAllByUser_id(id);
	}
	@Override
	public Order findById(int id) {
		return orderRepository.findById(id);
	}
	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}
	@Override
	public Page<Order> findAll(Pageable pageable) {
		return orderRepository.findAll(pageable);
	}


	@Override
	public void deleteById(int id) {
		orderRepository.deleteById(id);
	}
	@Override
	public List<Order> findAllByPayment_Method(String payment_Method, String user_id) {
		return orderRepository.findAllByPayment_Method(payment_Method, user_id);
	}
	
	@Override
	public List<Order> findAllByPayment_Method(String payment_Method) {
		return orderRepository.findAllByPayment_Method(payment_Method);
	}

	@Override
	public void approveOrder(int orderId) {
		Order order = orderRepository.findById(orderId);
		if (order != null) {
			order.setStatus("Approved");
			orderRepository.save(order);
		}
	}

	@Override
	public void cancelOrder(int orderId) {
		Order order = orderRepository.findById(orderId);
		if (order != null) {
			order.setStatus("Cancelled");
			orderRepository.save(order);
		}
	}
}
