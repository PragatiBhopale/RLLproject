package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendorDAO {
	Connection connection;
	PreparedStatement pst;
	
//	public String addRestaurent(Restaurent restaurent) throws ClassNotFoundException, SQLException {
//		connection = ConnectionHelper.getConnection();
//		String cmd = "Insert into Restaurent(restaurentId,restaurentName,restaurentCity,restaurentBranch,restaurentEmail,restaurentContactNo) "
//				+ " values(?,?,?,?,?,?)";
//		pst = connection.prepareStatement(cmd);
//		pst.setInt(1, restaurent.getrestaurentId());
//		pst.setString(2, restaurent.getrestaurentName());
//		pst.setString(3, restaurent.getrestaurentCity());
//		pst.setString(4, restaurent.getrestaurentBranch());
//		pst.setString(5, restaurent.getrestaurentEmail());
//		pst.setString(6, restaurent.getrestaurentContactNo());
//		pst.executeUpdate();
//		return "Record Inserted...";
//	}
	
	public Vendor searchVendor(int vendorId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Vendor where vendorId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, vendorId);
		ResultSet rs = pst.executeQuery();
		Vendor vendor = null;
		if (rs.next()) {
			vendor = new Vendor();
			vendor.setvendorId(rs.getInt("vendorId"));
			vendor.setvendorName(rs.getString("vendorName"));
			vendor.setvendorState(rs.getString("vendorState"));
			vendor.setvendorCity(rs.getString("vendorCity"));
			vendor.setvendorEmail(rs.getString("vendorEmail"));
			vendor.setvendorContactNo(rs.getString("vendorContactNO"));	
		}
		return vendor;
	}
	
	public List<Vendor> showVendor() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Vendor";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Vendor> vendorList = new ArrayList<Vendor>();
		Vendor vendor = null; 
		while(rs.next()) {
			vendor = new Vendor();
			vendor.setvendorId(rs.getInt("vendorId"));
			vendor.setvendorName(rs.getString("vendorName"));
			vendor.setvendorState(rs.getString("vendorState"));
			vendor.setvendorCity(rs.getString("vendorCity"));
			vendor.setvendorEmail(rs.getString("vendorEmail"));
			vendor.setvendorContactNo(rs.getString("vendorContactNO"));
			vendorList.add(vendor);
		}
		return vendorList;
	}


}
