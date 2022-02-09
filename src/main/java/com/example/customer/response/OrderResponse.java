package com.example.customer.response;

public class OrderResponse {

	private String customerid;
	private String customer_name;
	private String customer_contactNo;
	private String customer_emailId;
	private String customer_City;
	private String customer_pinCode;
	private String orderid;
	private String order_desc;
	private String purchase_date;
	private String purchase_price;

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
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

	public OrderResponse(String customerid, String customer_name, String customer_contactNo, String customer_emailId,
			String customer_City, String customer_pinCode, String orderid, String order_desc, String purchase_date,
			String purchase_price) {
		super();
		this.customerid = customerid;
		this.customer_name = customer_name;
		this.customer_contactNo = customer_contactNo;
		this.customer_emailId = customer_emailId;
		this.customer_City = customer_City;
		this.customer_pinCode = customer_pinCode;
		this.orderid = orderid;
		this.order_desc = order_desc;
		this.purchase_date = purchase_date;
		this.purchase_price = purchase_price;

	}

	public OrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderResponse [customerid=" + customerid + ", customer_name=" + customer_name + ", customer_contactNo="
				+ customer_contactNo + ", customer_emailId=" + customer_emailId + ", customer_City=" + customer_City
				+ ", customer_pinCode=" + customer_pinCode + ", orderid=" + orderid + ", order_desc=" + order_desc
				+ ", purchase_date=" + purchase_date + ", purchase_price=" + purchase_price + "]";
	}

}
