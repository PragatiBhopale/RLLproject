package com.java.cms;

import java.sql.SQLException;
import java.util.List;

public class CustomerShow {
	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAO();
		try {
			List<Customer> customerList = dao.showCustomer();
			for (Customer customer : customerList) {
				System.out.println(customer);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
