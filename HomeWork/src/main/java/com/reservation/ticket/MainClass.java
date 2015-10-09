package com.reservation.ticket;

import com.reservation.ticket.impl.ServiceImpl;

public class MainClass {
	
	public static void main(String args[]) {
		
		MainClass mainClass = new MainClass();
		mainClass.menu() ;
						
		
	}
	
	public void menu () {
		
		ServiceImpl svcImpl = new ServiceImpl();		
		Stage stage = new Stage();
		UserOption user = new UserOption();
		
		try {
		do {
			stage.setChoice(user.getUserChoice());
			if (stage.getChoice().equals ("1")) {				
				stage.setvenueLevel(user.getUservenueLevel());
				if (stage.getvenueLevel() != 5)  {
					System.out.println("Following is the seat availability according to your preference \n");
					System.out.println("Number of Seats available at " + svcImpl.level[stage.getvenueLevel() - 1] + " = " + svcImpl.numSeatsAvailable(stage.getvenueLevel()) + "\n");
				}
					
				else
					stage.setquit(true);
				
			} else if (stage.getChoice().equals ("2")) {
				
				stage.setcustEmail(user.getUsercustEmail()); 
				stage.setnumSeat(user.getUsernumSeat());
				do {
					stage.setminLevel(user.getUserminLevel());
					stage.setmaxLevel(user.getUsermaxLevel());
				} while (stage.getminLevel() >= stage.getmaxLevel());
				SeatHold tkt =  null;
				tkt = svcImpl.findAndHoldSeats(stage.getnumSeat(), stage.getminLevel(), stage.getmaxLevel(), stage.getcustEmail());				
				if (null != tkt)  {
					stage.setconfirmKey(user.getUserconfirmKey());
					if (stage.getconfirmKey() == 1) {
						stage.setconfirmCode(svcImpl.reserveSeats(tkt.getSeatholdId(), tkt.getCustomerEmail()));
						if (stage.getconfirmCode().contains("-")) {
							System.out.println("The tickets have been booked with confirmation code " + stage.getconfirmCode());
	                		System.out.println("Thank You \n") ;    
						} else System.out.println("No enough Seats Available in the selected level");
						
					} else if (stage.getconfirmKey() == 2) {
						
						svcImpl.holdSeats(tkt);						
						System.out.println("The tickets are in hold for you for the next 1 minute");
	
						try { 
							System.out.println("Your Ticket Hold id is " + tkt.getSeatholdId());
						} catch(Exception ex) {
							System.out.println("The Email already exists in hold list and cannot be used to hold further tickets");
						}	
								
					} else stage.setquit(true);
				} else System.out.println("No enough Seats Available in the selected level");			
			} else if (stage.getChoice().equals ("3")) {
				stage.setcustEmailCheck(user.getUsercustEmailCheck());
					try {							
						if(null != Stage.getheldMapseatholdId(stage.getcustEmailCheck())) {
							SeatHold tkt = Stage.getheldMapseatholdId(stage.getcustEmailCheck());   
							stage.setconfirmCode(svcImpl.reserveSeats(tkt.getSeatholdId(), tkt.getCustomerEmail()));
							if (stage.getconfirmCode().contains("-")) {
								System.out.println("The tickets have been booked with confirmation code " + stage.getconfirmCode());
				        		System.out.println("Thank You \n");  
							} else System.out.println("No enough Seats Available");
							
						}
						else {
							
							System.out.println( "Held Tickets  are not availale");
						}
					} catch (Exception ex) {
						System.out.println("No hold exists for this Email id");
					}		
						
			}else if (stage.getChoice().equals ("4")) {
				stage.setcustEmailCheck(user.getUsercustEmailCheck());  
				SeatHold tkt =  null;
				tkt = svcImpl.checkReservedTickets(stage.getcustEmailCheck());
				
				if ( null !=  tkt) {
					System.out.println("The ticket details for Email " + tkt.getCustomerEmail() + " are below");
					System.out.println("Level Name : " + tkt.getLevelName());
					System.out.println("Number of Seats : " + tkt.getNoOfSeats());
					System.out.println("Total Price : " + tkt.getAmount());
					System.out.println("Confirmation Code : " + tkt.getConfirmcode());
				}
					
				else
					System.out.println("There is no ticket with this customer Email Id");
				
				
			}else if (stage.getChoice().equals ("5")) {
				
				stage.setquit(true);
			}
		} while (!stage.getquit()); 
		}
		
		catch (Exception e) {
			System.out.println(" There is some technical error. "); 
			System.out.println("Please enter the inputs again  ..");
			new MainClass().menu();
		}
		finally{
			System.out.println("Thank You!! Have a Nice Day.");
		}
		
	
	}
}
		

