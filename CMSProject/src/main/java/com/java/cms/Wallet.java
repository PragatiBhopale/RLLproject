package com.java.cms;

public class Wallet {
	private int walletId;
	private int customerId;
	private String walletType;
	private int Amount;
	
	public int getwalletId() {
		return walletId;
	}
	public void setwalletId(int walletId) {
		this.walletId = walletId;
	}
	public int getcustomerId() {
		return customerId;
	}
	public void setcustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getwalletType() {
		return walletType;
	}
	public void setwalletType(String walletType) {
		this.walletType = walletType;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int Amount) {
		this.Amount = Amount;
	}
	
	public Wallet() {
		// TODO Auto-generated constructor stub
	}

	public Wallet(int walletId, int customerId, String walletType,int Amount) {
		this.walletId = walletId;
		this.customerId = customerId;
		this.walletType = walletType;
		this.Amount=Amount;
	}
	@Override
	public String toString() {
		return "Wallet [walletId=" + walletId + ", customerId=" + customerId + ", walletType=" + walletType + ",  Amount=" + Amount + "]";
	}


}
