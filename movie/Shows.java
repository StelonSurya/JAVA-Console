package movie;
import java.util.*;
public class Shows {
	Scanner scanner=new Scanner(System.in);
	static List <String> movies=new ArrayList<>();
	static Map <String ,Movies> movieDetails=new LinkedHashMap<>();
	
	public void addMovies() {
		movies.add("VENTHU THANINTHATHU KAAADU");
		movies.add("PONNIYIN SELVAN (TAMIL)");
		movies.add("AVATAR-THE WAY OF WATER(ENGLISH)");
		movies.add("NAANE VARUVEN");
		for(String name:movies) {
			if(name.equals("AVATAR-THE WAY OF WATER(ENGLISH)"))movieDetails.put(name, new Movies(name,true));
			else movieDetails.put(name, new Movies(name,false));
		}
		
		
		
	}
	 void printMovies() {
		System.out.printf("%15s %23s %22s ","NAME","3D","AVAILABLE TICKETS");
		System.out.println();
		System.out.println("----------------------------------------------------------------");
		for(Map.Entry<String, Movies> map : movieDetails.entrySet()) {
			System.out.printf("%-35s %-12s %-5s ",map.getKey(),map.getValue().isIs3D(),map.getValue().getAvailableTickets());
		System.out.println();
		System.out.println("----------------------------------------------------------------");
		}
		System.out.println("\n \n \n TYPE SOMETHING TO GO BACK");
		String back=scanner.nextLine();
	}
}
