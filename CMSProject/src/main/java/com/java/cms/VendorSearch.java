package com.java.cms;

import java.sql.SQLException;
import java.util.Scanner;

public class VendorSearch {
	public static void main(String[] args) {
		int vendorId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter VendorID=    ");
		vendorId = sc.nextInt();
		VendorDAO dao = new VendorDAO();
		try {
			Vendor vendor = dao.searchVendor(vendorId);
			if (vendor!=null) {
				System.out.println(vendor);
			} else {
				System.out.println("*** Record Not Found ***");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
