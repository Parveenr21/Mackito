package com.rawatJi.unitTesting;

import java.sql.SQLException;

public interface OrderDAO {
	
	
	public int createOrder(Order ord) throws SQLException;
	
	
	public int updateOrder(Order ord) throws SQLException;
	
	
	public Order readOrder(int OrderID) throws SQLException;
	
	public int deleteOrder(int OrderID) throws SQLException;
	
	

}
