package com.example.Order.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.Order.constants.Constants;
import com.example.Order.entity.Customers;
import com.example.Order.entity.MessageResponse;
import com.example.Order.entity.Order;
import com.example.Order.exception.ResourceNotFoundException;
import com.example.Order.repository.OrderRepository;
import com.example.Order.response.OrderResponse;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${users.url}")
	public String UsersUrl;

	private Customers getData(String orderId) throws ResourceNotFoundException {
		Customers customers;
		try {
			customers = restTemplate.getForObject(UsersUrl + orderId, Customers.class);
		} catch (RestClientException e) {
			customers = null;
		}
		return customers;
	}

	/* Creating new order */
	@Override
	public MessageResponse createOrder(Order order) {
		Order newOrder = new Order();
		newOrder.setOrderid(order.getOrderid());
		newOrder.setId(order.getId());
		newOrder.setOrder_desc(order.getOrder_desc());
		newOrder.setPurchase_date(order.getPurchase_date());
		newOrder.setPurchase_price(order.getPurchase_price());
		newOrder.setIsActive(order.getIsActive());
		orderRepository.save(newOrder);

		return new MessageResponse(Constants.ORDER_CREATE);
	}

	/* Get all order */
	@Override
	public List<Order> getAllOrder() {
		List<Order> orders = orderRepository.findAll();
		if (orders.isEmpty()) {
			throw new ResourceNotFoundException(Constants.ORDER_DETAILS_NOT_FOUND);
		}
		return orders;
	}

	/* Update order */
	@Override
	public Order updateOrders(OrderResponse newOrder) {
		Order updateOrder = new Order();
		if (!Objects.isNull(newOrder.getOrderid())) {
			Order currentOrder = orderRepository.findOrderByOrderid(newOrder.getOrderid());
			if (Objects.isNull(currentOrder)) {
				throw new ResourceNotFoundException(Constants.ORDER_DETAILS_NOT_FOUND);
			} else {
				compareBeforeUpdate(newOrder, currentOrder);
				updateOrder = orderRepository.save(currentOrder);
			}
		} else {
			throw new ResourceNotFoundException(Constants.ORDERID_NOT_NULL);
		}
		return updateOrder;
	}

	private void compareBeforeUpdate(OrderResponse newOrder, Order currentOrder) {
		if (!Objects.isNull(newOrder.getOrder_desc())) {
			currentOrder.setOrder_desc(newOrder.getOrder_desc());
		} else {
			currentOrder.setOrder_desc(currentOrder.getOrder_desc());
		}
		if (!Objects.isNull(newOrder.getPurchase_date())) {
			currentOrder.setPurchase_date(newOrder.getPurchase_date());
		} else {
			currentOrder.setPurchase_date(currentOrder.getPurchase_date());
		}
		if (!Objects.isNull(newOrder.getPurchase_price())) {
			currentOrder.setPurchase_price(newOrder.getPurchase_price());
		} else {
			currentOrder.setPurchase_price(currentOrder.getPurchase_price());
		}
		if (!Objects.isNull(newOrder.getIsActive())) {
			currentOrder.setIsActive(newOrder.getIsActive());
		} else {
			currentOrder.setIsActive(currentOrder.getIsActive());
		}
		currentOrder.setOrderid(currentOrder.getOrderid());
	}

	/* Get order by order id */
	@Override
	public Order getOrderByOrderId(String orderId) {
		Order order = orderRepository.findOrderByOrderid(orderId);
		if (Objects.isNull(order)) {
			throw new ResourceNotFoundException(Constants.ORDER_DETAILS_NOT_FOUND);
		}
		return order;
	}

	/* Delete order by order id */
	@Transactional
	@Override
	public void deleteOrderByOrderId(String orderId) {
		Optional<Customers> customer = Optional.ofNullable(getData(orderId));
		Order order = orderRepository.findOrderByOrderid(orderId);
		if (customer.isPresent()) {
			throw new ResourceNotFoundException(Constants.DELETE_NOT_ALLOWED);
		} else if (Objects.isNull(order)) {
			throw new ResourceNotFoundException(Constants.ORDER_NOT_PRESENT);
		} else {
			orderRepository.deleteOrderByOrderid(orderId);
		}
	}

}
