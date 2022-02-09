package com.example.customer.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.customer.entity.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, String> {

	public List<Customers> findCustomerByCustomerid(String customerid);

	public List<Customers> findCustomersByCustomerid(String customerid);

	public void deleteCustomerByCustomerid(String customerid);

	public List<Customers> getCustomerByCustomerid(String customerid);

	public Customers findByOrderid(String orderid);

	public void deleteCustomerByOrderid(@Valid String orderid);

}
