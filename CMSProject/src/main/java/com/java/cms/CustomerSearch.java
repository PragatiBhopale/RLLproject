package com.java.cms;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerSearch {
	public static void main(String[] args) {
		int customerId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter CustomerID=    ");
		customerId = sc.nextInt();
		CustomerDAO dao = new CustomerDAO();
		try {
			Customer customer = dao.searchCustomer(customerId);
			if (customer!=null) {
				System.out.println(customer);
			} else {
				System.out.println("*** Record Not Found ***");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
