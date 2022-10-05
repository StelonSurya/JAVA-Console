package movie;
import java.util.*;
public class Booking {
	static List <Booking> details=new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	Shows show=new Shows();
	static int num=0;
    int id=0;
	int tickets;
	String movie;
	String name;
	Booking(String name){
		this.name=name;
	    this.id=id++;
		
	}
	Booking(){}
public void bookTicket() {
	int ind=0;
	System.out.println("ENTER YOUR NAME :");
	String name=scanner.next();
	if(name.length()>9)name=name.substring(0,9);
	Booking current=new Booking(name);
	current.id=++num;	
	System.out.println("1.VENTHU THANINTHATHU KAAADU \n 2.PONNIYIN SELVAN (TAMIL) \n 3.AVATAR-THE WAY OF WATER(ENGLISH) \n 4.NAANE VARUVEN");
	
	int movieIndex=scanner.nextInt();
	current.movie=show.movies.get(movieIndex-1);
	System.out.println("how many tickets ???");
	int ticket=scanner.nextInt();
	if(ticket>show.movieDetails.get(current.movie).getAvailableTickets()) {
		System.out.println("YOUR DEMAND IS GREATER THAN AVAILABLE TICKETS");
		id--;
	}else {
		int set=show.movieDetails.get(current.movie).getAvailableTickets();
		show.movieDetails.get(current.movie).setAvailableTickets(set-ticket);
		current.tickets=ticket;
		System.out.println("YOUR ID IS  :" +current.id);
		System.out.println("Tickets booked successfully!!!!");
		ind++;
		details.add(current);
		printDetails(current);
	}
	
  }
private void printDetails(Booking obj) {
	System.out.printf("%-5s %-10s %15s %20s","ID","NAME","MOVIE","TICKETS");
	System.out.println();
	System.out.println("--------------------------------------------------------");
	System.out.printf("%-5s %-10s %-18s %6s",obj.id,obj.name,obj.movie,obj.tickets);
	System.out.println();
	System.out.println("--------------------------------------------------------");
}
public void printDetails() {
	System.out.printf("%-5s %-10s %15s %20s","ID","NAME","MOVIE","TICKETS");
	System.out.println();
	System.out.println("--------------------------------------------------------");
	for(Booking obj:details) {
	System.out.printf("%-5s %-10s %-18s %6s",obj.id,obj.name,obj.movie,obj.tickets);
		System.out.println();
	System.out.println("-------------------------------------------------------");
	}
	
}
}
 