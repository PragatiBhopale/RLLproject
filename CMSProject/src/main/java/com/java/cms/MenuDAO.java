package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {
	Connection connection;
	PreparedStatement pst;
	
	public String addMenu(Menu menu) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert into menu(menuId,RId ,ItemName,menuType,price,) "
				+ " values(?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, menu.getmenuId());
		pst.setInt(2, menu.getRId());
		pst.setString(3, menu.getItemName());
		pst.setString(4, menu.getmenuType());
		pst.setInt(5, menu.getprice());
		pst.executeUpdate();
		return "Record Inserted...";
	}
	
//	public Menu searchMenu(int menuId) throws ClassNotFoundException, SQLException {
//		connection = ConnectionHelper.getConnection();
//		String cmd = "select * from menu where menuId=?";
//		pst = connection.prepareStatement(cmd);
//		pst.setInt(1, menuId);
//		ResultSet rs = pst.executeQuery();
//		Menu menu = null;
//		if (rs.next()) {
//			menu = new Menu();
//			menu.setmenuId(rs.getInt("menuId"));
//			menu.setRId(rs.getInt("RId"));
//			menu.setItemName(rs.getString("ItemName"));
//			menu.setmenuType(rs.getString("menuType"));
//			menu.setprice(rs.getInt("price"));
//			
//		}
//		return menu;
//	}
	
//	public List<Menu> showMenu() throws ClassNotFoundException, SQLException {
//		connection = ConnectionHelper.getConnection();
//		String cmd = "select * from menu";
//		pst = connection.prepareStatement(cmd);
//		ResultSet rs = pst.executeQuery();
//		List<Menu> menuList = new ArrayList<Menu>();
//		Menu menu = null; 
//		while(rs.next()) {
//			menu = new Menu();
//			menu.setmenuId(rs.getInt("menuId"));
//			menu.setRId(rs.getInt("RId"));
//			menu.setItemName(rs.getString("ItemName"));
//			menu.setmenuType(rs.getString("menuType"));
//			menu.setprice(rs.getInt("menuprice"));
//		}
//		return menuList;
//	}

	
	//-----------show menu-------
	
	public List<Menu> showMenu() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Menu";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Menu> menuList = new ArrayList<Menu>();
		Menu menu = null; 
		while(rs.next()) {
			menu = new Menu();
			menu.setmenuId(rs.getInt("menuId"));
			menu.setRId(rs.getInt("RId"));
			menu.setItemName(rs.getString("ItemName"));
			menu.setmenuType(rs.getString("menuType"));
			menu.setprice(rs.getInt("menuprice"));
			menuList.add(menu);
		}
		return menuList;
	}
	//-----------------------------
	public Menu searchMenu(int menuId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Menu where menuId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, menuId);
		ResultSet rs = pst.executeQuery();
		Menu menu = null;
		if (rs.next()) {
			menu = new Menu();
			menu.setmenuId(rs.getInt("menuId"));
			menu.setRId(rs.getInt("RId"));
			menu.setItemName(rs.getString("ItemName"));
			menu.setmenuType(rs.getString("menuType"));
			menu.setprice(rs.getInt("menuprice"));	
		}
		return menu;
	}
	
}
