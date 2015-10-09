package com.reservation.ticket;
import java.util.Scanner;

public class UserOption {
	private String Choice = null;
	private int venueLevel;
	private String custEmail = null;
	private String custEmailCheck = null;
	private int numSeat;
	private int minLevel;
	private int maxLevel;
	private int confirmKey;
	
	Scanner sca = new Scanner(System.in);
	Stage stage = new Stage();
	
	public String getUserChoice() {
		do {
	    	System.out.println("##########################");
	    	System.out.println("  ARENA SEAT RESERVATION  ");
	    	System.out.println("##########################");
	    	System.out.println("Enter your Choices As Below");
	        System.out.println("1.Check Seat Availability ");
	        System.out.println("2.Make Reservation");
	        System.out.println("3.Reserve your held seats");
	        System.out.println("4.Check your reserved seats");
	        System.out.println("5.Quit");
	        while (!sca.hasNext("[12345]")) {
	            System.out.println("Please provide valid input!");
	            sca.next(); 
	        }
	        Choice = sca.next();
	        return Choice;
	    	} while (Choice.equals(null));
	}
	
	public int getUservenueLevel() {
		do {
	    	System.out.println("Enter the preferred venue Level from the below options");
	        System.out.println("1 for Orchestra");
	        System.out.println("2 for Main");
	        System.out.println("3 for Balcony1");
	        System.out.println("4 for Balcony2");
	        System.out.println("5 To Quit");
	        while (!sca.hasNext("[12345]")) {
	            System.out.println("Please provide valid input!");
	            sca.next(); 
	        }
	        venueLevel = Integer.parseInt(sca.next());
	        return venueLevel;
	    	} while (venueLevel == 0); 
	}
	
	public String getUsercustEmail() {
		do {
	    	System.out.println("Enter customer Email Id");
	        while (sca.hasNext(" ")) {
	            System.out.println("Please provide valid Email!");
	            sca.next(); 
	        }
	        custEmail = sca.next();
	        if (!(custEmail.contains("@"))) {
	        	custEmail = null;
	        	System.out.println("Please provide valid Email!");
	        }
	        		
	        else if (!(Stage.getreservedMapseatholdId(custEmail) == null)) {
	        	custEmail = null;
	        	System.out.println("Reservation already exists with this Email id");
	        	System.out.println("Please Enter different Email id \n");
	        }
	        
	        else if (!(Stage.getheldMapseatholdId(custEmail) == null)) {
	        	custEmail = null;
	        	System.out.println("Ticket Hold already exists with this Email id");
	        	System.out.println("Please Enter different Email id \n");
	        }
	        return custEmail;		
	    	} while (custEmail == null) ;
	}
	
	public int getUsernumSeat() {
		do {
	    	System.out.println("Enter the number of seats to be booked");                    
            while (!sca.hasNextInt()) {
	            System.out.println("Please provide a number");
	            sca.nextInt(); 
	        }
	        numSeat = sca.nextInt();
	        return numSeat;
	    	} while (numSeat <= 0) ;
	}
	
	public int getUserminLevel() {
		do {
	    	System.out.println("Enter the preferred minimum and maximum levels from the below options");
	    	System.out.println("Please Note: Maximum level shuld be greater than Minimum level");
        	System.out.println("1 for Orchestra");
        	System.out.println("2 for Main");
        	System.out.println("3 for Balcony1");
        	System.out.println("4 for Balcony2");
        	System.out.println("Enter the preferred minimum level");                    
        	while (!sca.hasNext("[1234]"))  {
	            System.out.println("Please provide valid Level");
	            sca.next(); 
	        }
        	minLevel = Integer.parseInt(sca.next()); 
        	return minLevel;
	    	} while (minLevel == 0);
	}
	
	public int getUsermaxLevel() {
		do {
	    	System.out.println("Enter the preferred maximum level");
        	while (!(sca.hasNext("[1234]"))) {
	            System.out.println("Please provide valid Level");
	            sca.next(); 
	        }
	        maxLevel = Integer.parseInt(sca.next());
	        return maxLevel;
	    	} while (maxLevel == 0);	
	}
	
	public int getUserconfirmKey() {
		do {
	    	System.out.println("Please press '1' to confirm and reserve the tickets" );
	    	System.out.println("Please press '2' to Hold Tickets and go  back to main menu" );
	    	System.out.println("Please press '3' to quit" );
            while (!sca.hasNextInt()) {
	            System.out.println("Please provide a number");
	            sca.nextInt(); 
	        }
	        confirmKey = sca.nextInt();
	        return confirmKey;
	    	} while (!((confirmKey == 1) || (confirmKey == 2) || (confirmKey == 3)));
	}
	
	public String getUsercustEmailCheck() {
		do {
	    	System.out.println("Enter customer Email Id");
	        while (sca.hasNext(" ")) {
	            System.out.println("Please provide valid Email!");
	            sca.next(); 
	        }
	        custEmailCheck = sca.next();
	        if (!(custEmailCheck.contains("@"))) {
	        	custEmailCheck = null;
	        	System.out.println("Please provide valid Email!");
	        }
	        return custEmailCheck;		
	    	} while (custEmailCheck == null) ;
	}
}



	