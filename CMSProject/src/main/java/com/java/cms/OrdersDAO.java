package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersDAO {

	Connection connection;
	PreparedStatement pst;
	
	public String placeOrder(Orders order) throws SQLException, ClassNotFoundException {
		int oid = generateOrderId();
		order.setOrderStatus("PENDING");
		java.util.Date today = new Date();
		java.sql.Date dbDate = new java.sql.Date(today.getTime());
		order.setOrderDate(dbDate);
		Menu menu = new MenuDAO().searchMenu(order.getMenuId());
		int price = menu.getprice();
		int  billAmount = order.getQuantityOrdered() * price;
		Wallet wallet = new WalletDAO().searchWallet(order.getWalletId());
		int Amount = wallet.getAmount();
		if (Amount - billAmount > 0) {
			order.setBillAmount(billAmount);
			order.setOrderId(oid);
			String cmd = "insert into Orders(orderId,VendorId,MenuID,"
					+ "WalletId,OrderDate,QUNTITYORDERED,OrderStatus,BillAmount,Comments,CustomerId) "
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, order.getOrderId());
			pst.setInt(2, order.getVendorId());
			pst.setInt(3, order.getMenuId());
			pst.setInt(4, order.getWalletId());
			pst.setDate(5, order.getOrderDate()); 
			pst.setInt(6, order.getQuantityOrdered());
			pst.setString(7, order.getOrderStatus());
			pst.setInt(8, order.getBillAmount());
			pst.setString(9, order.getOrderComments());
			pst.setInt(10, order.getCustomerId());
			pst.executeUpdate();
			new WalletDAO().deductBalance(order.getWalletId(), billAmount);
			return "Order Placed Successfully...Wallet Balance Deducted...";
		}
		return "Insufficient Funds...";
		//order.setBillAmount(billAmount);
	}
	
	public int generateOrderId() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select case when max(ORDERID) is NULL THEN 1"
				+ " else max(ORDERID)+1 end oid from orders";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int id = rs.getInt("oid");
		return id;
	}
	//--------------------------------------------------Accept or reject Order---------
	public String acceptOrRejectOrder(int orderId, int vendorId, String status) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		Orders order = searchOrder(orderId);
		if (order.getVendorId()==vendorId) {
			if (status.toUpperCase().equals("accepted")) {
				String cmd = "Update Orders set orderStatus='ACCEPTED' "
						+ " WHERE orderId=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, orderId);
				pst.executeUpdate();
				return "Order Approved Successfully...";
			} else {
				String cmd = "Update Orders set orderStatus='REJECTED' "
						+ " WHERE orderId=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, orderId);
				pst.executeUpdate();
				cmd = "Update Wallet set Amount=Amount+? where walletId=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, order.getBillAmount());
				pst.setInt(2, order.getWalletId());
				pst.executeUpdate();
				return "Order Rejected Amount Refunded...";
			}
		} 
		return "You are unauthorized vendor...";
	}
	//-------------------------------------------------showOrder-----------------------------------------------------------------------
	public List<Orders> showOrder() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Orders";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Orders> orderList = new ArrayList<Orders>();
		Orders order = null; 
		while(rs.next()) {
			order = new Orders();
			order.setOrderId(rs.getInt("orderId"));
			order.setVendorId(rs.getInt("vendorId"));
			order.setCustomerId(rs.getInt("customerId"));
			order.setMenuId(rs.getInt("menuId"));
			order.setWalletId(rs.getInt("walletId"));
			order.setOrderDate(rs.getDate("orderDate"));
			order.setQuantityOrdered(rs.getInt("quantityOrdered"));
			order.setOrderStatus(rs.getString("orderStatus"));
			order.setBillAmount(rs.getInt("billAmount"));
			order.setOrderComments(rs.getString("comments"));
			orderList.add(order);
		}
		return orderList;
	}
	
	//------------------------search Order-------
	
	public Orders searchOrder(int orderId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Orders where orderId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, orderId);
		ResultSet rs = pst.executeQuery();
		Orders order = null;
		if (rs.next()) {
			order = new Orders();
			order.setOrderId(rs.getInt("orderId"));
			order.setVendorId(rs.getInt("vendorId"));
			order.setCustomerId(rs.getInt("customerId"));
			order.setMenuId(rs.getInt("menuId"));
			order.setWalletId(rs.getInt("walletId"));
			order.setOrderDate(rs.getDate("orderDate"));
			order.setQuantityOrdered(rs.getInt("quantityOrdered"));
			order.setOrderStatus(rs.getString("orderStatus"));
			order.setBillAmount(rs.getInt("billAmount"));
			order.setOrderComments(rs.getString("comments"));
		}
		return order;
	}
	
	//---------------
}
