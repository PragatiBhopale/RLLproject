package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
	Connection connection;
	PreparedStatement pst;
	
	public String addRestaurent(Customer customer) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert into Customers(customerId,customername,customerState,customerCity,customerEmail,customerMob) "
				+ " values(?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, customer.getcustomerId());
		pst.setString(2, customer.getcustomername());
		pst.setString(3, customer.getcustomerState());
		pst.setString(4, customer.getcustomerCity());
		pst.setString(5, customer.getcustomerEmail());
		pst.setString(6, customer.getcustomerMob());
		pst.executeUpdate();
		return "Record Inserted...";
	}
	
	public Customer searchCustomer(int customerId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Customer where customerId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, customerId);
		ResultSet rs = pst.executeQuery();
		Customer customer = null;
		if (rs.next()) {
			customer = new Customer();
			customer.setcustomerId(rs.getInt("customerId"));
			customer.setcustomername(rs.getString("customername"));
			customer.setcustomerState(rs.getString("customerState"));
			customer.setcustomerCity(rs.getString("customerCity"));
			customer.setcustomerEmail(rs.getString("customerEmail"));
			customer.setcustomerMob(rs.getString("customerMob"));	
		}
		return customer;
	}
	
	public List<Customer> showCustomer() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Customer";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Customer> customerList = new ArrayList<Customer>();
		Customer customer = null; 
		while(rs.next()) {
			customer = new Customer();
			customer.setcustomerId(rs.getInt("customerId"));
			customer.setcustomername(rs.getString("customername"));
			customer.setcustomerState(rs.getString("customerState"));
			customer.setcustomerCity(rs.getString("customerCity"));
			customer.setcustomerEmail(rs.getString("customerEmail"));
			customer.setcustomerMob(rs.getString("customerMob"));
			customerList.add(customer);
		}
		return customerList;
	}


}
