package com.rawatJi.unitTesting;

import java.sql.SQLException;

public class OrderBOimpl implements OrderBO {

	OrderDAO objDAO;
	
	
	
	public OrderDAO getObjDAO() {
		return objDAO;
	}

	public void setObjDAO(OrderDAO objDAO) {
		this.objDAO = objDAO;
	}

	public int placeOrder(Order ord) throws BOException {
		
		int orderID=-1;
	
		//WE are not throwing SQL exception instead throwing Business exception
		
		try {
			orderID = objDAO.createOrder(ord);
		} catch (SQLException e) {
			throw new BOException();
		}
		return orderID;
	}

	public boolean cancelOrder(int ordID) throws BOException {
		
		boolean flag=false;
		
		try {
			
			if((objDAO.deleteOrder(ordID))==ordID)
			{
				flag=true;
			}
			else{
				
				flag=false;
			}
			
		} catch (SQLException e) {
			new BOException();
		}
		
		return flag;
	}

	public boolean deleteOrder(int ordID) throws BOException {
		
		boolean flag;
		
		try {
			if(objDAO.deleteOrder(ordID)==ordID)
			{
			flag=true;	
			}
			else{
				flag=false;
			}
		} catch (SQLException e) {
			
			throw new BOException();
		}
		
		
		return flag;
	}

}
