package com.java.cms;

import java.sql.SQLException;
import java.util.Scanner;

public class RestaurentSearch {
	public static void main(String[] args) {
		int restaurentId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Restaurent    ");
		restaurentId = sc.nextInt();
		RestaurentDAO dao = new RestaurentDAO();
		try {
			Restaurent restaurent = dao.searchRestaurent(restaurentId);
			if (restaurent!=null) {
				System.out.println(restaurent);
			} else {
				System.out.println("*** Record Not Found ***");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
