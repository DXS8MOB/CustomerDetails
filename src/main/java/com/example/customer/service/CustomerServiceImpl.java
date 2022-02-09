package com.example.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.customer.constants.Constants;
import com.example.customer.entity.Customers;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.response.OrderResponse;
import com.example.customer.entity.MessageResponse;
import com.example.customer.entity.Order;
import com.example.customer.exception.ResourceNotFoundException;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	RestTemplate restTemplate;

	public Order order;

	@Value("${users.url}")
	public String UsersUrl;

	/* Create new customer */
	@Override
	public MessageResponse createCustomer(Customers customer) {
		MessageResponse message = null;
		try {

			System.out.println(customer.getOrderid());
			getData(customer.getOrderid());
			System.out.println(order);
			String isactive = order.getIsActive();
			System.out.println(isactive);
			if (isactive.equals(Constants.IS_ACTIVE_VAL)) {
				customerRepository.save(customer);
				message = new MessageResponse(Constants.CREATE_CUSTOMER);
			}

		} catch (Exception e) {
			throw new ResourceNotFoundException(Constants.CREATION_NOT_ALLOWED);
		}
		if (Objects.isNull(message)) {
			throw new ResourceNotFoundException(Constants.CREATION_NOT_ALLOWED_CONST);
		} else {
			return message;
		}
	}

	/* Get all customer */
	@Override
	public List<Customers> getAllCustomers() {
		List<Customers> customers = customerRepository.findAll();
		if (customers.isEmpty()) {
			throw new ResourceNotFoundException(Constants.NO_CUSTOMER_FOUND_CONST_VAL);
		}
		return customers;
	}

	/* Get customer by customerId */
	@Override
	public List<Customers> getCustomerByCustomerId(String customerId) {
		List<Customers> customers = customerRepository.findCustomerByCustomerid(customerId);
		if (customers.isEmpty()) {
			throw new ResourceNotFoundException(Constants.NO_CUSTOMER_FOUND_CONST_VAL);
		}
		return customers;
	}

	private void getData(String orderId) throws ResourceNotFoundException {

		try {
			order = restTemplate.getForObject(UsersUrl + orderId, Order.class);
			System.out.println(order);
		} catch (RestClientException e) {
			throw new ResourceNotFoundException(Constants.NO_ORDER_FOUND);
		}
	}

	/* Find customer order list by customerId/orderId */
	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public List<OrderResponse> getCustomersOrderByCustomerId(String customerId, String orderId)
			throws ResourceNotFoundException {
		List<OrderResponse> customerOrderResponse = null;
		try {

			List<OrderResponse> response = new ArrayList<OrderResponse>();
			if (!StringUtils.isEmpty(customerId) && (StringUtils.isEmpty(orderId))) {
				List<Customers> customerList = customerRepository.getCustomerByCustomerid(customerId);
				customerList.forEach(cust -> {
					if (cust.getIsActive().equals(Constants.IS_ACTIVE_VAL)) {
						getData(cust.getOrderid());
						System.out.println(order);
						if (order.getIsActive().equals(Constants.IS_ACTIVE_VAL)) {
							response.add(new OrderResponse(cust.getCustomerid(), cust.getCustomer_name(),
									cust.getCustomer_contactNo(), cust.getCustomer_emailId(), cust.getCustomer_City(),
									cust.getCustomer_pinCode(), order.getOrderid(), order.getOrder_desc(),
									order.getPurchase_date(), order.getPurchase_price()));

						}
					}

				});
				customerOrderResponse = response;
			}

			else if (StringUtils.isEmpty(customerId)
					|| ((!StringUtils.isEmpty(orderId)) && (!StringUtils.isEmpty(customerId)))) {
				Customers customer = customerRepository.findByOrderid(orderId);
				if (customer.getIsActive().equals(Constants.IS_ACTIVE_VAL)) {
					getData(customer.getOrderid());
					if (order.getIsActive().equals(Constants.IS_ACTIVE_VAL)) {
						response.add(new OrderResponse(customer.getCustomerid(), customer.getCustomer_name(),
								customer.getCustomer_contactNo(), customer.getCustomer_emailId(),
								customer.getCustomer_City(), customer.getCustomer_pinCode(), order.getOrderid(),
								order.getOrder_desc(), order.getPurchase_date(), order.getPurchase_price()));
					}
				}
				customerOrderResponse = response;
			}

		} catch (Exception e) {
			throw new ResourceNotFoundException(Constants.PARAMETER_NOT_NULL);
		}
		if (customerOrderResponse.isEmpty()) {
			throw new ResourceNotFoundException(Constants.NO_VALUE_FOUND);
		} else {
			return customerOrderResponse;
		}

	}

	/* Update customer */
	@Override
	public List<Customers> updateCustomers(Customers customer) {
		List<Customers> newCustomers = new ArrayList<Customers>();
		try {
			if (!Objects.isNull(customer.getCustomerid())) {
				List<Customers> customers = customerRepository.getCustomerByCustomerid(customer.getCustomerid());
				if (customers.isEmpty()) {
					throw new ResourceNotFoundException(Constants.PARAMETER_NOT_NULL);
				}
				customers.forEach(cust -> {
					prepareBeforeUpdate(customer, cust);

					newCustomers.add(customerRepository.save(cust));

				});
			}

			else {
				throw new ResourceNotFoundException(Constants.CUSTOMERID_NOT_BLANK);
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException(Constants.PARAMETER_NOT_NULL);
		}

		return newCustomers;
	}

	private void prepareBeforeUpdate(Customers customer, Customers cust) {
		if (!Objects.isNull(customer.getCustomer_name())) {
			cust.setCustomer_name(customer.getCustomer_name());
		} else {
			cust.setCustomer_name(cust.getCustomer_name());
		}

		if (!Objects.isNull(customer.getCustomer_contactNo())) {
			cust.setCustomer_contactNo(customer.getCustomer_contactNo());
		} else {
			cust.setCustomer_contactNo(cust.getCustomer_contactNo());
		}

		if (!Objects.isNull(customer.getCustomer_emailId())) {
			cust.setCustomer_emailId(customer.getCustomer_emailId());
		} else {
			cust.setCustomer_emailId(cust.getCustomer_emailId());
		}

		if (!Objects.isNull(customer.getCustomer_City())) {
			cust.setCustomer_City(customer.getCustomer_City());
		} else {
			cust.setCustomer_City(cust.getCustomer_City());
		}

		if (!Objects.isNull(customer.getCustomer_pinCode())) {
			cust.setCustomer_pinCode(customer.getCustomer_pinCode());
		} else {
			cust.setCustomer_pinCode(cust.getCustomer_pinCode());
		}

		if (!Objects.isNull(customer.getIsActive())) {
			cust.setIsActive(customer.getIsActive());
		} else {
			cust.setIsActive(cust.getIsActive());
		}
		cust.setCustomerid(cust.getCustomerid());

		cust.setOrderid(cust.getOrderid());

	}

	/* Delete customer by orderId */
	@Transactional
	@Override
	public void deleteCustomerByOrderId(@Valid String orderId) {
		Optional<Customers> customerResponse = Optional.ofNullable(getCustomerByOrderId(orderId));
		System.out.println(customerResponse);
		if (!customerResponse.isPresent()) {
			throw new ResourceNotFoundException(Constants.NO_CUSTOMER_FOUND_CONST_VAL);
		} else {
			customerRepository.deleteCustomerByOrderid(orderId);
		}
	}

	/* Get customer by orderId */
	@Override
	public Customers getCustomerByOrderId(String orderId) {
		Customers customer = customerRepository.findByOrderid(orderId);
		if (Objects.isNull(customer)) {
			throw new ResourceNotFoundException(Constants.NO_ORDER_FOUND);
		}
		return customer;
	}

}
