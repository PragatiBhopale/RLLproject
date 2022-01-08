package com.java.cms;
import java.sql.SQLException;
import java.sql.SQLException;
import java.util.List;

public class RestaurentShow {
	public static void main(String[] args) {
		RestaurentDAO dao = new RestaurentDAO();
		try {
			List<Restaurent> restaurentList = dao.showRestaurent();
			for (Restaurent restaurent : restaurentList) {
				System.out.println(restaurent);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
