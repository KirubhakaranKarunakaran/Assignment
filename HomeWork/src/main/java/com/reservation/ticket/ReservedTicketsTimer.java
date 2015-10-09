package com.reservation.ticket;

import com.reservation.ticket.impl.ServiceImpl;

import java.lang.Runnable;

public class ReservedTicketsTimer  implements  Runnable{

	String customerEmail;
	
	public ReservedTicketsTimer() {
		
		
	}
	public  ReservedTicketsTimer(String customerEmail) {
		// TODO Auto-generated constructor stub
		this.customerEmail =  customerEmail;
		
	}
	public void run() {
		// TODO Auto-generated method stub
		SeatHold tkt = new SeatHold();
//		System.out.println("Entered the Thread"); 
		try {
			Thread.currentThread();
			Thread.sleep(60*1000);
			if (null !=  Stage.getheldMapseatholdId(customerEmail)) {
				tkt = Stage.getheldMapseatholdId(customerEmail) ;   
				ServiceImpl.seats[tkt.getLevelId() -1] =  ServiceImpl.seats[tkt.getLevelId() -1] +   tkt.getNoOfSeats();  
				
				Stage.removeheldMapseatholdId(customerEmail); 
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		  
//		System.out.println("End  of the Thread");
//		System.out.println("The reserved tickets for " + customerEmail + "removed ");
	}
}