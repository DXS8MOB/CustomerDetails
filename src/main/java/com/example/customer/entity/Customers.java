package com.example.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.example.customer.constants.Constants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "CUSTOMER")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "id")
	private long id;

	@NotNull
	@NotBlank(message = Constants.CUSTOMERID_NOT_BLANK)
	@Column(name = "customerid", updatable = false)
	private String customerid;

	@NotNull
	@NotBlank(message = Constants.CUSTOMERNAME_NOT_BLANK)
	@Pattern(regexp = "^[A-Za-z]*$", message = Constants.CUSTOMERNAME_VALIDATION_MSG)
	@Column(name = "customer_name")
	private String customer_name;

	@NotNull
	@NotBlank(message = Constants.ORDERID_NOT_BLANK)
	@Column(name = "orderid", unique = true, updatable = false)
	private String orderid;

	@NotNull
	@NotBlank(message = Constants.CONTACT_NOT_BLANK)
	@Pattern(regexp = "(^$|[0-9]{10})", message = Constants.CONTACT_VALIDATION_MSG)
	@Column(name = "customer_contactNo")
	private String customer_contactNo;

	@NotNull
	@NotBlank(message = Constants.CUSTOMEREMAIL_NOT_BLANK)
	@Email(message = Constants.CUSTOMEREMAIL_VALIDATION_MSG)
	@Column(name = "customer_emailId")
	private String customer_emailId;

	@NotNull
	@NotBlank(message = Constants.CITY_NOT_BLANK)
	@Column(name = "customer_City")
	private String customer_City;

	@NotNull
	@NotBlank(message = Constants.PINCODE_NOT_BLANK)
	@Pattern(regexp = "(^&|[0-9]{7})", message = Constants.PINCODE_VALIDATION_MSG)
	@Column(name = "customer_pinCode")
	private String customer_pinCode;

	@NotNull
	@Column(name = "isActive")
	private String isActive;

	public Customers(long id, String customerid, String customer_name, String orderid, String customer_contactNo,
			String customer_emailId, String customer_City, String customer_pinCode, String isActive) {
		super();
		this.id = id;
		this.customerid = customerid;
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
		return "customers [id=" + id + ", customerid=" + customerid + ", customer_name=" + customer_name + ", orderid="
				+ orderid + ", customer_contactNo=" + customer_contactNo + ", customer_emailId=" + customer_emailId
				+ ", customer_City=" + customer_City + ", customer_pinCode=" + customer_pinCode + ", isActive="
				+ isActive + "]";
	}
}