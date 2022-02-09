package com.example.Order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Order.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

	public Order findOrderByOrderid(String orderid);

	public void deleteOrderByOrderid(String orderid);

}
