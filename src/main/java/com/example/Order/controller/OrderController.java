package com.example.Order.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Order.entity.MessageResponse;
import com.example.Order.entity.Order;
import com.example.Order.response.OrderResponse;
import com.example.Order.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	/* Get all order */
	@GetMapping(value = "/getAllOrder")
	public List<Order> getAllOrders() {
		List<Order> order = orderService.getAllOrder();
		return order;
	}

	/* Get order by Order id */
	@GetMapping(value = "/getOrder/{orderid}")
	public Order getOrderByOrderId(@PathVariable("orderid") String orderId) {
		return this.orderService.getOrderByOrderId(orderId);
	}

	/* Create new order */
	@PostMapping(value = "/order/save")
	public ResponseEntity<MessageResponse> addOrder(@Valid @RequestBody Order order) {
		MessageResponse newOrder = orderService.createOrder(order);
		return new ResponseEntity<>(newOrder, HttpStatus.OK);
	}

	/* Update order */
	@PutMapping(value = "/updateOrder")
	public Order updateOrder(@RequestBody @Valid OrderResponse order) {
		return this.orderService.updateOrders(order);
	}

	/* Delete order by order id */
	@DeleteMapping(value = "/deleteOrder/{orderid}")
	public String deleteOrder(@PathVariable("orderid") String orderId) {
		this.orderService.deleteOrderByOrderId(orderId);
		return "Deletion Successful";
	}
}