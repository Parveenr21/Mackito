package com.rawatJi.unitTesting;

import java.sql.SQLException;

import org.apache.tools.ant.taskdefs.Length.When;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import net.bytebuddy.asm.Advice.Return;

public class testOrderBOimpl {

	@Mock
	OrderDAO dao;
	Order order;
	
	
	@BeforeMethod
	public void testinitializer()
	{
		MockitoAnnotations.initMocks(this);
		
	}
	
	
	@Test ( timeOut = 500 )

	public void createOrder_usingBO() throws BOException, SQLException{
		//we can test the dao without using BO but we have to test using BO .. as in real world
		
		OrderBOimpl bo = new OrderBOimpl();
		bo.setObjDAO(dao);
		
		//System.gc();
	//	Runtime.getRuntime().gc();
		//WRITE mocking statements before actual call
		
		try {
			//Mockito.when(dao.createOrder(order)).thenReturn(Mockito.anyInt());  returning 0 always
			Mockito.when(dao.createOrder(order)).thenReturn(new Integer(10));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int OrderID=bo.placeOrder(order);
		
		
		
		
		
				/*
				 * Commenting the mocking resulting in OrderID=0
				 * Or simply implementation hiding can result in test failure
				 * 
				 */
		System.out.println(OrderID);
		Assert.assertNotNull(Integer.valueOf(OrderID));
	//	Mockito.verify(dao).createOrder(order);
		
		
	//HERE need to write whole method call
	Mockito.verify(dao,Mockito.times(1)).createOrder(order);
	}
	
}
