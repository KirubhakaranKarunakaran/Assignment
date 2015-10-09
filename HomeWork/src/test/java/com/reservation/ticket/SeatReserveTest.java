package com.reservation.ticket;

import org.junit.Assert;
import org.junit.Test;

import com.reservation.ticket.impl.ServiceImpl;


public class SeatReserveTest {


	@Test
	public void test1Reserve() {
		
		ServiceImpl svcImpl = new ServiceImpl();
		SeatHold tkt = new SeatHold();
		
		tkt = svcImpl.findAndHoldSeats(100, 1, 2, "1@com");
		svcImpl.reserveSeats(tkt.getSeatholdId(), tkt.getCustomerEmail());
		Assert.assertEquals(true, svcImpl.isSeatReserved());
	}	
	
	@Test
	public void test2Reserve() {
		
		ServiceImpl svcImpl = new ServiceImpl();
		SeatHold tkt = new SeatHold();
		
		tkt = svcImpl.findAndHoldSeats(200, 2, 3, "2@com");
		svcImpl.reserveSeats(tkt.getSeatholdId(), tkt.getCustomerEmail());
		Assert.assertEquals(true, svcImpl.isSeatReserved());
	}	
	
	@Test
	public void test3Reserve() {
		
		ServiceImpl svcImpl = new ServiceImpl();
		SeatHold tkt = new SeatHold();
		
		tkt = svcImpl.findAndHoldSeats(300, 3, 4, "3@com");
		svcImpl.reserveSeats(tkt.getSeatholdId(), tkt.getCustomerEmail());
		Assert.assertEquals(true, svcImpl.isSeatReserved());
	}	
}
