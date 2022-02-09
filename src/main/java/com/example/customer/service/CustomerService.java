package com.example.customer.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.example.customer.entity.Customers;
import com.example.customer.entity.MessageResponse;
import com.example.customer.exception.ResourceNotFoundException;
import com.example.customer.response.OrderResponse;

@Component
public interface CustomerService {

	public MessageResponse createCustomer(Customers customer);

	public List<Customers> getAllCustomers();

	public List<Customers> updateCustomers(Customers customer);

	public List<Customers> getCustomerByCustomerId(String customerId);

	public Customers getCustomerByOrderId(String orderId);

	public List<OrderResponse> getCustomersOrderByCustomerId(String customerId, String orderId)
			throws ResourceNotFoundException;

	public void deleteCustomerByOrderId(@Valid String orderId);

}
