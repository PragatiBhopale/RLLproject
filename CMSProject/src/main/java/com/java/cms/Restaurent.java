package com.java.cms;

public class Restaurent {
	private int rid;
	private String rname;
	private String city;
	private String branch;
	private String email;
	private String contactNo;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "Restaurent [rid=" + rid + ", rname=" + rname + ", city=" + city + ", branch=" + branch + ", email="
				+ email + ", contactNo=" + contactNo + "]";
	}
	

	
	

}
