package movie;

public class Movies {

	private int seatNumber;
 
	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public boolean isIs3D() {
		return is3D;
	}

	public void setIs3D(boolean is3d) {
		is3D = is3d;
	}

	public int getAvailableTickets() {
		return availableTickets;
	}

	public void setAvailableTickets(int availableTickets) {
		this.availableTickets = availableTickets;
	}
private String name;
   private boolean is3D;
  private int availableTickets;
	Movies(String name,boolean is3D){
		this.name=name;
		availableTickets=100;
		this.is3D=is3D;
		seatNumber=1;
	}
}
