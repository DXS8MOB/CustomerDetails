package com.example.customer.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.entity.Customers;
import com.example.customer.service.CustomerService;
import com.example.customer.entity.MessageResponse;
import com.example.customer.response.OrderResponse;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerservice;

	/* Find customer order list by customerId/orderId */
	@GetMapping(value = "/search")
	public List<OrderResponse> findCustomerOrderList(
			@RequestParam(value = "customerid", required = false) String customerId,
			@RequestParam(value = "orderid", required = false) String orderId) {
		return (List<OrderResponse>) this.customerservice.getCustomersOrderByCustomerId(customerId, orderId);
	}

	/* Get customer by customerId */
	@GetMapping(value = "/getCustomer/{customerid}")
	public List<Customers> getCustomersByCustomersId(@PathVariable("customerid") String customerId) {
		return this.customerservice.getCustomerByCustomerId(customerId);
	}

	/* Get all customer */
	@GetMapping(value = "/getAllCustomer")
	public List<Customers> getAllCustomer() {
		List<Customers> customer = customerservice.getAllCustomers();
		return customer;
	}

	/* Get customer by orderId */
	@GetMapping(value = "/getCustomer/orderId/{orderid}")
	public Customers getByOrderid(@PathVariable("orderid") String orderId) {
		return this.customerservice.getCustomerByOrderId(orderId);
	}

	/* Create new customer */
	@PostMapping(value = "/customer/save")
	public ResponseEntity<MessageResponse> addCustomer(@Valid @RequestBody Customers customer) {
		MessageResponse newCustomer = customerservice.createCustomer(customer);
		return new ResponseEntity<>(newCustomer, HttpStatus.OK);
	}

	/* Update customer */
	@PutMapping(value = "/updateCustomer")
	public List<Customers> updateCustomers(@RequestBody Customers customer) {
		return this.customerservice.updateCustomers(customer);
	}

	/* Delete customer by orderId */
	@DeleteMapping(value = "/deleteCustomer/{orderid}")
	public String deleteCustomer(@PathVariable("orderid") String orderId) {
		this.customerservice.deleteCustomerByOrderId(orderId);
		return "Deletion Successful";

	}
}
