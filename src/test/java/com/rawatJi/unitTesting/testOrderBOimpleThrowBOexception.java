package com.rawatJi.unitTesting;

import java.sql.SQLException;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.Times;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testOrderBOimpleThrowBOexception {

	
	@Mock							//STEP 1: -mock an object 
	OrderDAO dao;
	
	OrderBOimpl bo; //setting object in child reference as GETTER and SETTER on implBO is not in interface. 
	
	Order ord;
	
	@BeforeTest
	public void testinitializer()
	{
		dao= new OrderDAOimpl();
		MockitoAnnotations.initMocks(this);						//STEP 2:   write this for mock the object in whole class
		bo=new OrderBOimpl();
		ord=new Order();
	}
	
	@Test(expectedExceptions=BOException.class	)
	public void testThrowBOexceptonCreateORDER() throws SQLException, BOException
	{
		
		bo.setObjDAO(dao);
		
		
			Mockito.when(dao.createOrder(ord)).thenThrow(SQLException.class);			//STEP 3:  when and then for mocking a call within the next written statements.
		
			bo.placeOrder(ord);
		
		//	Mockito.verify(dao).createOrder(ord);		//STEP 4:  This lets you verify if this mocked object call was there
		
		
			
			//HERE need to write whole method call
		  Mockito.verify(dao,Mockito.times(3)).createOrder(ord);		//All are mockito static method..either import mockito ..and then write method names directly.
		
		  
		  /*
		   * For throwing exception this count will not matter else for normal scenario.. this test will fail as expect 3 method calls
		   * 
		   * 
		   */
		  
	}
	
}
