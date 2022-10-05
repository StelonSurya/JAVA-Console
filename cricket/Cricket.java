package cricket;

import java.util.*;

public class Cricket {
	ArrayList<PlayerData> team1 = new ArrayList<>();
	ArrayList<PlayerData> team2 = new ArrayList<>();
	Teams t = new Teams();

	public static void main(String[] args) throws InterruptedException {
		Cricket cricket = new Cricket();
		cricket.start();

	}

	public void start() throws InterruptedException {

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		System.out.println("                   WELCOME TO INDIAN PREMIERE LEAGUE");
		t.m1();
		System.out.println("SELECT YOUR TEAM :");
		String[] you = t.teamSelection1();

		System.out.println("OPPONENT TEAM NAME");
		String[] opponent = t.teamSelection2();

		for (String s : you) {
			team1.add(new PlayerData(s));
		}
		for (String s : opponent) {
			team2.add(new PlayerData(s));
		}
		printPlaying11(you, opponent);
		System.out.println();
		System.out.println();
		System.out.println("HOW MANY  OVERS U WANNA PLAY");
		int overs = scanner.nextInt();
		System.out.println();
		System.out.println("LETS MOVE ON TO TOSS");
		System.out.println(" 0-for HEADS \n 1-for TAILS");
		System.out.println();
		int toss = scanner.nextInt();
		int fate = random.nextInt(2);
		Match match = new Match();
		if (toss != fate) {
			System.out.println(t.playingTeams[1].getName() + " WON THE TOSS ");
			int choice = random.nextInt(2) + 1;
			switch (choice) {
			case 1: {
				System.out.println("CHOOSE TO BAT FIRST ");
				System.out.println();
				swap(Teams.playingTeams);
				match.startInnings(team2, team1, overs);
			}
				break;
			case 2: {
				System.out.println("CHOOSE TO BOWL FIRST ");
				System.out.println();
				match.startInnings(team1, team2, overs);
			}
				break;
			}

		} else {
			System.out.println(" WON THE TOSS !!!!! \n 1-BAT FIRST \n 2-BOWL FIRST");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				match.startInnings(team1, team2, overs);
			}
				break;
			case 2: {
				swap(Teams.playingTeams);
				match.startInnings(team2, team1, overs);
			}
				break;
			}

		}
	}

	private void swap(TeamDetails[] playingTeams) {
		var temp = playingTeams[0];
		playingTeams[0] = playingTeams[1];
		playingTeams[1] = temp;
	}

	private void printPlaying11(String[] you, String[] opponent) {
		System.out.printf("%-17s %-15s", t.playingTeams[0].getName(), t.playingTeams[1].getName());

		System.out.println("\n---------------------------------------------");
		for (int index = 0; index < you.length; index++) {
			System.out.printf("%-17s %-15s", you[index], opponent[index]);
			System.out.println();
		}
	}

}