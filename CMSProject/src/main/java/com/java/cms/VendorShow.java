package com.java.cms;

import java.sql.SQLException;
import java.util.List;

public class VendorShow {
	public static void main(String[] args) {
		VendorDAO dao = new VendorDAO();
		try {
			List<Vendor> vendorList = dao.showVendor();
			for (Vendor vendor : vendorList) {
				System.out.println(vendor);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
