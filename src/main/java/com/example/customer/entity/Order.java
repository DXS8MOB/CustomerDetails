package com.example.customer.entity;

public class Order {

	private long id;

	private String orderid;

	private String order_desc;

	private String purchase_date;

	private String purchase_price;

	private String isActive;

	public Order(long id, String orderid, String order_desc, String purchase_date, String purchase_price,
			String isActive) {
		super();
		this.id = id;
		this.orderid = orderid;
		this.order_desc = order_desc;
		this.purchase_date = purchase_date;
		this.purchase_price = purchase_price;
		this.isActive = isActive;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getOrder_desc() {
		return order_desc;
	}

	public void setOrder_desc(String order_desc) {
		this.order_desc = order_desc;
	}

	public String getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

	public String getPurchase_price() {
		return purchase_price;
	}

	public void setPurchase_price(String purchase_price) {
		this.purchase_price = purchase_price;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Order() {
		super();

	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderid=" + orderid + ", order_desc=" + order_desc + ", purchase_date="
				+ purchase_date + ", purchase_price=" + purchase_price + ", isActive=" + isActive + "]";
	}

}