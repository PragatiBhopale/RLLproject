package com.java.cms;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CanteenMain {

	static Scanner sc =  new Scanner(System.in);
	
	public static void main(String[] args) {
		int choice;
		do {
			System.out.println("O P T I O N S");
			System.out.println("---------------");
			System.out.println("1. ADD Restaurant");
			System.out.println("2. Show Restaurant ");
			System.out.println("3. Search Restaurant");
			
			System.out.println("4. Show menu ");
			System.out.println("5. search menu ");
			System.out.println("6. show Customer ");
			System.out.println("7. search Customer ");
			System.out.println("8. show Vendor ");
			System.out.println("9. search Vendor ");
			System.out.println("10. show Wallet");
			System.out.println("11. Search Wallet");
			System.out.println("12. Place Order");
			System.out.println("13. Accept OR Reject Order");
			System.out.println("Enter Your Choice   ");
			choice = sc.nextInt();
			switch(choice) {
			case 1 : 
				addRestaurent();
			break;
			case 2 : 
				RestaurentShow();
			break;
			case 3 : 
				try {
					RestaurentSearch();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4 : 
				MenuShow();
			break;
			case 5 : 
				MenuSearch();
			break;
			case 6 : 
				CustomerShow();
			break;
			case 7 : 
				CustomerSearch();
			break;
			case 8 : 
				VendorShow();
			break;
			case 9 : 
				VendorSearch();
			break;
			case 10 : 
				WalletShow();
			break;
			case 11 : 
				WalletSearch();
			break;
			
			case 12 : 
				try {
					placeOrder();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
			case 13 : 
				AcceptOrRejectorder();
			break;
			case 14 : 
				return;
			}
		} while(choice!=14);
	}
	private static void WalletSearch() {
		int walletId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Wallet Id    ");
		walletId = sc.nextInt();
		WalletDAO dao = new WalletDAO();
		try {
			Wallet wallet = dao.searchWallet(walletId);
			if (wallet!=null) {
				System.out.println(wallet);
			} else {
				System.out.println("*** Record Not Found ***");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
	private static void WalletShow() {
		WalletDAO dao = new WalletDAO();
		try {
			List<Wallet> walletList = dao.showWallet();
			for (Wallet wallet : walletList) {
				System.out.println(wallet);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		
	}
	private static void AcceptOrRejectorder() {
		// TODO Auto-generated method stub
		
	}
	private static void placeOrder() throws ClassNotFoundException, SQLException {
		Orders order = new Orders();
		System.out.println("Enter Customer Id   ");
		order.setCustomerId(sc.nextInt());
		System.out.println("Enter Vendor Id  ");
		order.setVendorId(sc.nextInt());
		System.out.println("Enter Menu Id  ");
		order.setMenuId(sc.nextInt());
		System.out.println("Enter Wallet Id  ");
		order.setWalletId(sc.nextInt());
		System.out.println("Enter Quantity Ordered  ");
		order.setQuantityOrdered(sc.nextInt());
		System.out.println("Enter Comments  ");
		order.setOrderComments(sc.next());
		OrdersDAO dao = new OrdersDAO();
		System.out.println(dao.placeOrder(order));
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
	}
	private static void addRestaurent() {
		Scanner sc = new Scanner(System.in);
		Restaurent restaurent = new Restaurent();
		System.out.println("Enter RName   ");
		restaurent.setRname(sc.next());
		System.out.println("Enter City  ");
		restaurent.setCity(sc.next());
		System.out.println("Enter Branch   ");
		restaurent.setBranch(sc.next());
		System.out.println("Enter Email   ");
		restaurent.setEmail(sc.next());
		System.out.println("Enter ContactNo   ");
		restaurent.setContactNo(sc.next());
		RestaurentDAO dao = new RestaurentDAO();
		try {
			System.out.println(dao.addRestaurent(restaurent));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
	private static void VendorSearch() {
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
		// TODO Auto-generated method stub
	private static void VendorShow() {
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
		// TODO Auto-generated method stub
	private static void CustomerSearch() {
			int customerId;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter CustomerID=    ");
			customerId = sc.nextInt();
			CustomerDAO dao = new CustomerDAO();
			try {
				Customer customer = dao.searchCustomer(customerId);
				if (customer!=null) {
					System.out.println(customer);
				} else {
					System.out.println("*** Record Not Found ***");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
	public static void CustomerShow() {
			CustomerDAO dao = new CustomerDAO();
			try {
				List<Customer> customerList = dao.showCustomer();
				for (Customer customer : customerList) {
					System.out.println(customer);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
	public static void MenuShow() {
			MenuDAO dao = new MenuDAO();
			try {
				List<Menu> menuList = dao.showMenu();
				for (Menu menu : menuList) {
					System.out.println(menu);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// TODO Auto-generated method stub
	public static void RestaurentSearch() throws ClassNotFoundException, SQLException {
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
	public static void RestaurentShow() {
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
	public static void MenuSearch() {
		int menuId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Menu Id=    ");
		menuId = sc.nextInt();
		MenuDAO dao = new MenuDAO();
		try {
			Menu menu = dao.searchMenu(menuId);
			if (menu!=null) {
				System.out.println(menu);
			} else {
				System.out.println("*** Record Not Found ***");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
