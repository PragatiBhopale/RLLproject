package com.java.cms;

public class Customer {
	private int customerId;
	private String customername;
	private String customerState;
	private String customerCity;
	private String customerEmail;
	private String customerMob;
	
	
	public int getcustomerId() {
		return customerId;
	}
	public void setcustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getcustomername() {
		return customername;
	}
	public void setcustomername(String customername) {
		this.customername = customername;
	}
	public String getcustomerState() {
		return customerState;
	}
	public void setcustomerState(String customerState) {
		this.customerState = customerState;
	}
	public String getcustomerCity() {
		return customerCity;
	}
	public void setcustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}
	public String getcustomerEmail() {
		return customerEmail;
	}
	public void setcustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	public String getcustomerMob() {
		return customerMob;
	}
	public void setcustomerMob(String customerMob) {
		this.customerMob = customerMob;
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, String customername, String customerState,String customerCity, String customerEmail,String customerMob) {
		this.customerId = customerId;
		this.customername = customername;
		this.customerState = customerState;
		this.customerCity=customerCity;
		this.customerEmail = customerEmail;
		this.customerMob=customerMob;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customername=" + customername + ", customerState=" + customerState + ",  customerCity=" + customerCity + ", customerEmail=" + customerEmail + " , customerMob=" + customerMob + "]";
	}


}
