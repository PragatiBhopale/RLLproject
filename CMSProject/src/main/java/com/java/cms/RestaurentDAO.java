package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.cms.ConnectionHelper;
import com.java.cms.Restaurent;

public class RestaurentDAO {
	private static final int RId = 0;
	Connection connection;
	PreparedStatement pst;
	
//	public String addRestaurent(Restaurent restaurent) throws ClassNotFoundException, SQLException {
//		connection = ConnectionHelper.getConnection();
//		String cmd = "Insert into Restaurent(RId,RName,City,Branch,Email,ContactNo) "
//				+ " values(?,?,?,?,?,?)";
//		pst = connection.prepareStatement(cmd);
//		pst.setInt(1, restaurent.getRid());
//		pst.setString(2, restaurent.getRname());
//		pst.setString(3, restaurent.getCity());
//		pst.setString(4, restaurent.getBranch());
//		pst.setString(5, restaurent.getEmail());
//		pst.setString(6, restaurent.getContactNo());
//		pst.executeUpdate();
//		return "Record Inserted...";
//	}
	//------------------------------------------------------------------------------------------Add Restaurent-----------------
	
	public String addRestaurent(Restaurent restaurent) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		int restaurentId = generaterestaurentId();
		restaurent.setRid(restaurentId);
		String cmd = "Insert into Restaurent(RId,RName,City,Branch,Email,ContactNo) values(?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, restaurentId);
		pst.setString(2, restaurent.getRname());
		pst.setString(3, restaurent.getCity());
		pst.setString(4, restaurent.getBranch());
		pst.setString(5, restaurent.getEmail());
		pst.setString(6, restaurent.getContactNo());
		pst.executeUpdate();
		return "Restaurent Added...";
	}
	
	public int generaterestaurentId() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select case when max(RId) IS NULL then 1 "
				+ " else Max(RId)+1 end RId from Restaurent";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int RId = rs.getInt("RId");
		return RId;
	}
	
	//--------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	public Restaurent searchRestaurent(int RId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Restaurent where RId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, RId);
		ResultSet rs = pst.executeQuery();
		Restaurent restaurent = null;
		if (rs.next()) {
			restaurent = new Restaurent();
			restaurent.setRid(rs.getInt("RId"));
			restaurent.setRname(rs.getString("RName"));
			restaurent.setCity(rs.getString("City"));
			restaurent.setBranch(rs.getString("Branch"));
			restaurent.setEmail(rs.getString("Email"));
			restaurent.setContactNo(rs.getString("ContactNo"));	
		}
		return restaurent;
	}

	public List<Restaurent> showRestaurent() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from RESTAURENT";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Restaurent> restaurentList = new ArrayList<Restaurent>();
		Restaurent restaurent = null; 
		while(rs.next()) {
			restaurent = new Restaurent();
			restaurent.setRid(rs.getInt("RId"));
			restaurent.setRname(rs.getString("RName"));
			restaurent.setCity(rs.getString("City"));
			restaurent.setBranch(rs.getString("Branch"));
			restaurent.setEmail(rs.getString("Email"));
			restaurent.setContactNo(rs.getString("ContactNo"));
			restaurentList.add(restaurent);
		}
		return restaurentList;
	}

}
