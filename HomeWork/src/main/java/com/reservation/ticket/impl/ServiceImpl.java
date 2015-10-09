package com.reservation.ticket.impl;

import java.util.Random;

import com.reservation.ticket.InterfaceClass;
import com.reservation.ticket.ReservedTicketsTimer;
import com.reservation.ticket.Stage;
import com.reservation.ticket.SeatHold;
public class ServiceImpl implements InterfaceClass {
	public final int price[] = {100,75,50,40};
    public static int seats[] = {1250,2000,1500,1500};
    public final String level[] = {"Orchestra","Main","Balcony 1", "Balcony 2"};
    private boolean seatHeld = false;
    private boolean seatReserved = false;
    
	public int numSeatsAvailable(int venueLevel) {
		// TODO Auto-generated method stub
		return seats[venueLevel - 1];
	}
	
	public SeatHold findAndHoldSeats(int numSeats, int minLevel, int maxLevel, String customerEmail) {
		// TODO Auto-generated method stub
		SeatHold tkt = new SeatHold();
		int i;		
		int j = 0;
		
		for (i=minLevel;i<=maxLevel;) {
		
			if (seats[i-1] >= numSeats) {
				System.out.println("The requested " + numSeats + " seat(s) are available in level " + level[i -1]);
		        System.out.println("The ticket price at this level is " + price[i-1]);
		        System.out.println("The total price would be " + price[i-1] * numSeats);
		        j = 1;
		        break;			
			} else i++;			
		} 
		
		if (((i == 1) || (i ==2) || (i ==3) || (i==4) ) && (j == 1)) {
			
			tkt.setLevelId(i);
			tkt.setLevelName(level[i-1]);
			tkt.setNoOfSeats(numSeats);
			tkt.setCustomerEmail(customerEmail); 
			tkt.setAmount(price[i-1] *  numSeats);
			
			Random rand = new Random();
			int seatHoldId = rand.nextInt(999999);
			tkt.setSeatholdId(seatHoldId);
			Stage.setSeatHoldIdMap(tkt.getSeatholdId(),tkt);
			
			return  tkt;	
		}
		
		else 
			return null;
	}
	
	public void holdSeats(SeatHold tkt) {
		
		    ReservedTicketsTimer  reserve = new ReservedTicketsTimer(tkt.getCustomerEmail()) ; 
		
			Stage.setheldMapseatholdId(tkt.getCustomerEmail(), tkt); 
			seats [tkt.getLevelId() -1] = seats[tkt.getLevelId() -1] -  tkt.getNoOfSeats();
			setSeatHeld(true);
			Thread t = new Thread(reserve);
			t.start();

	}
	
	public String reserveSeats(int seatHoldId, String customerEmail) {
		// TODO Auto-generated method stub
		SeatHold tkt = new SeatHold();
		
		
		if(null != Stage.getheldMapseatholdId(customerEmail)) {				
			tkt = Stage.getheldMapseatholdId(customerEmail); 
			Stage.removeheldMapseatholdId(customerEmail);		
			
		} else 
			tkt = Stage.getSeatHoldIdMap(seatHoldId);
					
		if (seats[tkt.getLevelId() -1] >= tkt.getNoOfSeats()) {
			tkt.setLevelName(level[tkt.getLevelId() - 1]);
			tkt.setNoOfSeats(tkt.getNoOfSeats());
			tkt.setCustomerEmail(customerEmail);
			tkt.setAmount(price[tkt.getLevelId() -1] * tkt.getNoOfSeats());
			tkt.setConfirmcode(tkt.getLevelId() + "-" + tkt.getSeatholdId());
			Stage.setreservedMapseatholdId(customerEmail, tkt);
			
			setSeatReserved(true);
			seats[tkt.getLevelId() -1] = seats[tkt.getLevelId() -1] - tkt.getNoOfSeats();
			return tkt.getConfirmcode();	
			
		} else return "No Seats";
	}
	
	public SeatHold checkReservedTickets (String customerEmail ) {
		
		SeatHold  tkt =  null ; 
		if ( null !=  Stage.getreservedMapseatholdId(customerEmail))
			tkt =  Stage.getreservedMapseatholdId(customerEmail);
		
		if ( null != tkt)
			return  tkt;
		else
			return   null;
		
	}

	public boolean isSeatHeld() {
		return seatHeld;
	}

	public void setSeatHeld(boolean seatHeld) {
		this.seatHeld = seatHeld;
	}

	public boolean isSeatReserved() {
		return seatReserved;
	}

	public void setSeatReserved(boolean seatReserved) {
		this.seatReserved = seatReserved;
	}
}
	
