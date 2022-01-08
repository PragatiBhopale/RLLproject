package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WalletDAO {
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
	
	public Wallet searchWallet(int walletId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Wallet where walletId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, walletId);
		ResultSet rs = pst.executeQuery();
		Wallet wallet = null;
		if (rs.next()) {
			wallet = new Wallet();
			wallet.setwalletId(rs.getInt("walletId"));
			wallet.setcustomerId(rs.getInt("customersId"));
			wallet.setwalletType(rs.getString("walletType"));
			wallet.setAmount(rs.getInt("Amount"));
		}
		return wallet;
	}
	
	public List<Wallet> showWallet() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Wallet";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Wallet> walletList = new ArrayList<Wallet>();
		Wallet wallet = null; 
		while(rs.next()) {
			wallet = new Wallet();
			wallet.setwalletId(rs.getInt("walletId"));
			wallet.setcustomerId(rs.getInt("customersId"));
			wallet.setwalletType(rs.getString("walletType"));
			wallet.setAmount(rs.getInt("Amount"));
			walletList.add(wallet);
		}
		return walletList;
	}

	
		
//-------------------------------------------------------
	public String deductBalance(int walletId, int billAmount) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "update wallet set amount=amount-? where walletId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, billAmount);
		pst.setInt(2, walletId);
		pst.executeUpdate();
		return "Amount Deducted...";
	}
	//--------------	
	}


