package com.reservation.ticket;

import org.junit.Assert;
import org.junit.Test;

import com.reservation.ticket.impl.ServiceImpl;

public class SeatAvailabilityTest {

	@Test
	public void test1Availability() {
		
		ServiceImpl svcImpl = new ServiceImpl();
		
		Assert.assertEquals(svcImpl.numSeatsAvailable(1), 1250);
	}	
	
	@Test
	public void test2Availability() {

		ServiceImpl svcImpl = new ServiceImpl();
		
		Assert.assertEquals(svcImpl.numSeatsAvailable(2), 2000);
	}
	
	@Test
	public void test3Availability() {
		
		ServiceImpl svcImpl = new ServiceImpl();
		
		Assert.assertEquals(svcImpl.numSeatsAvailable(3), 1500);
	}
	
	@Test
	public void test4Availability() {
		
		ServiceImpl svcImpl = new ServiceImpl();
		
		Assert.assertEquals(svcImpl.numSeatsAvailable(4), 1500);
	}

}
