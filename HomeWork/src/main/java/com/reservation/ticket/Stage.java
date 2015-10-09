package com.reservation.ticket;
import java.util.HashMap;
import java.util.Scanner;

import com.reservation.ticket.impl.ServiceImpl;

public class Stage {
	ServiceImpl svcImpl = new ServiceImpl();
	Scanner sca = new Scanner(System.in);
	static private HashMap<String,SeatHold> heldMap = new HashMap<String,SeatHold>();
	static private HashMap<String,SeatHold> reservedMap = new HashMap<String,SeatHold>(); 
	static private HashMap<Integer,SeatHold> seatHoldIdMap = new HashMap<Integer,SeatHold>();
	private String Choice = null;
	private String custEmail = null;
	private String custEmailCheck = null;
	private String confirmCode = null;
	private int numSeat;
	private int confirmKey;
	private int venueLevel;
	private int minLevel;
	private int maxLevel;
	private boolean quit = false;
	
	public boolean getquit() {
		return quit;
	}
	public void setquit(boolean quit) {
		this.quit = quit;
	}
	public String getChoice() {
		return Choice;
	}
	public void setChoice(String Choice) {
		this.Choice = Choice;
	}
	public String getconfirmCode() {
		return confirmCode;
	}
	public void setconfirmCode(String confirmCode) {
		this.confirmCode = confirmCode;
	}
	public static SeatHold getheldMapseatholdId(String custEmail) {
		return heldMap.get(custEmail);		
	}
	public static void removeheldMapseatholdId(String custEmail) {
		heldMap.remove(custEmail);		
	}
	public static void setheldMapseatholdId(String custEmail, SeatHold tkt) {
		heldMap.put(custEmail, tkt);				
	}
	public static SeatHold getreservedMapseatholdId(String custEmail) {
		return reservedMap.get(custEmail);		
	}
	public static  void setreservedMapseatholdId(String custEmail, SeatHold tkt) {
		reservedMap.put(custEmail, tkt);				
	}

	public static SeatHold getSeatHoldIdMap(Integer seatHoldId) {
		return seatHoldIdMap.get(seatHoldId);
	}
	public static void setSeatHoldIdMap(Integer seatHoldId,SeatHold tkt) {
		seatHoldIdMap.put(seatHoldId, tkt);
	}
	public String getcustEmail() {
		return custEmail;
	}
	public void setcustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	
	public String getcustEmailCheck() {
		return custEmailCheck;
	}
	public void setcustEmailCheck(String custEmailCheck) {
		this.custEmailCheck = custEmailCheck;
	}
	public int getnumSeat() {
		return numSeat;
	}
	public void setnumSeat(int numSeat) {
		this.numSeat = numSeat;
	}
	public int getconfirmKey() {
		return confirmKey;
	}
	public void setconfirmKey(int confirmKey) {
		this.confirmKey = confirmKey;
	}
	public int getvenueLevel() {
		return venueLevel;
	}
	public void setvenueLevel(int venueLevel) {
		this.venueLevel = venueLevel;
	}
	public int getminLevel() {
		return minLevel;
	}
	public void setminLevel(int minLevel) {
		this.minLevel = minLevel;
	}
	public int getmaxLevel() {
		return maxLevel;
	}
	public void setmaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}
		
}
