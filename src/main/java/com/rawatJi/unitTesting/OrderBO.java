package com.rawatJi.unitTesting;

import java.sql.SQLException;

public interface OrderBO {
	
	public int placeOrder(Order ord) throws BOException	;
	
	public boolean cancelOrder(int ordID)  throws BOException;
	
	public boolean deleteOrder(int ordID) throws BOException;

}
