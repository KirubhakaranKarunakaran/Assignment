package com.reservation.ticket;

import org.junit.Assert;
import org.junit.Test;

import com.reservation.ticket.impl.ServiceImpl;


public class SeatHoldTest {


	@Test
	public void test1Hold() {
		
		ServiceImpl svcImpl = new ServiceImpl();		
		svcImpl.holdSeats(svcImpl.findAndHoldSeats(100, 1, 2, "1@com"));
		Assert.assertEquals(true, svcImpl.isSeatHeld());
	}	
	
	@Test
	public void test2Hold() {
		
		ServiceImpl svcImpl = new ServiceImpl();		
		svcImpl.holdSeats(svcImpl.findAndHoldSeats(200, 2, 3, "2@com"));
		Assert.assertEquals(true, svcImpl.isSeatHeld());
	}	
	
	@Test
	public void test3Hold() {
		
		ServiceImpl svcImpl = new ServiceImpl();		
		svcImpl.holdSeats(svcImpl.findAndHoldSeats(300, 3, 4, "3@com"));
		Assert.assertEquals(true, svcImpl.isSeatHeld());
	}	
}
