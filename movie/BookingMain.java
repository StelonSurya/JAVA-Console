package movie;

import java.util.*;

public class BookingMain {
	Scanner scanner = new Scanner(System.in);
	Booking object = new Booking();
	
	public static void main(String[] args) {
	 BookingMain objectt = new BookingMain();
		objectt.start();
		
	}

	private void start() {
		Shows show=new Shows();
		show.addMovies();
		boolean loop = true;
		System.out.println("--------------------------------------------------------------------");
		System.out.println(" \n                   WELCOME TO VETTRI CINEMAS \n ");
		System.out.println("-------------------------------------------------------------------- \n  ");
	
			while (loop) {
				
				
					System.out.println(" 1.BOOK TICKETS  \n 2.SHOW MOVIES AND TICKETS \n 3.BOOKED PERSONS DETAILS \n 4.EXIT");
					int choice = scanner.nextInt();
				switch (choice) {
				case 1: {
					     
					object.bookTicket();
					break;
				}
				case 2: {
					show.printMovies();
					break;
				}
				case 3: {
					
					object.printDetails();
					break;
				}
					
				case 4: {
					System.out.println("THANK YOU FOR COMMING VISIT AGAIN :)");
					loop = false;
					break;
				}
		
				default:
					System.out.println("ENTER  CORRECT INPUT !!!");
				}
			}
	
				
			
	}

}
