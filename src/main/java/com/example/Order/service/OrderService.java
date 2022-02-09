package com.example.Order.service;

import java.util.List;

import javax.validation.Valid;

import com.example.Order.entity.MessageResponse;
import com.example.Order.entity.Order;
import com.example.Order.response.OrderResponse;

public interface OrderService {

	public List<Order> getAllOrder();

	public MessageResponse createOrder(@Valid Order order);

	public Order getOrderByOrderId(String orderId);

	public void deleteOrderByOrderId(String orderId);

	public Order updateOrders(OrderResponse newOrder);

}
