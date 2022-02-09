package com.example.Order.entity;

public class Customers {

	private long id;

	private String customer_id;

	private String customer_name;

	private String orderid;

	private String customer_contactNo;

	private String customer_emailId;

	private String customer_City;

	private String customer_pinCode;

	private String isActive;

	public Customers(long id, String customer_id, String customer_name, String orderid, String customer_contactNo,
			String customer_emailId, String customer_City, String customer_pinCode, String isActive) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.orderid = orderid;
		this.customer_contactNo = customer_contactNo;
		this.customer_emailId = customer_emailId;
		this.customer_City = customer_City;
		this.customer_pinCode = customer_pinCode;
		this.isActive = isActive;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getCustomer_contactNo() {
		return customer_contactNo;
	}

	public void setCustomer_contactNo(String customer_contactNo) {
		this.customer_contactNo = customer_contactNo;
	}

	public String getCustomer_emailId() {
		return customer_emailId;
	}

	public void setCustomer_emailId(String customer_emailId) {
		this.customer_emailId = customer_emailId;
	}

	public String getCustomer_City() {
		return customer_City;
	}

	public void setCustomer_City(String customer_City) {
		this.customer_City = customer_City;
	}

	public String getCustomer_pinCode() {
		return customer_pinCode;
	}

	public void setCustomer_pinCode(String customer_pinCode) {
		this.customer_pinCode = customer_pinCode;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Customers() {
		super();
	}

	@Override
	public String toString() {
		return "Customers [id=" + id + ", customer_id=" + customer_id + ", customer_name=" + customer_name
				+ ", orderid=" + orderid + ", customer_contactNo=" + customer_contactNo + ", customer_emailId="
				+ customer_emailId + ", customer_City=" + customer_City + ", customer_pinCode=" + customer_pinCode
				+ ", isActive=" + isActive + "]";
	}

}
