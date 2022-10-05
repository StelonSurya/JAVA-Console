package cricket;

import java.util.*;

public class Teams {
	static TeamDetails[] playingTeams = new TeamDetails[2];
	int index = 0;
	int selectedTeam;
	Scanner scanner = new Scanner(System.in);

	ArrayList<String[]> teamName;
	public String[] RCB = { "Dekock", "Faf", "Kholi", "Maxwell", "Abd", "DK", "Patidar", "Hasaranga", "Shabaz",
			"Harshal", "Siraj" };
	public String[] MI = { "Rohith", "Sky", "Hardik", "Krunal", "Pollard", "kishan", "Tare", "Lynn", "Bravis",
			"Kulkarni", "Bumrah" };
	public String[] CSK = { "Dhoni", "Raina", "Sam", "Jadeja", "Dchahar", "Bravo", "Watson", "Gaikwad", "Uthappa",
			"Moeenali", "Rayudu" };
	public String[] KKR = { "Finch", "Rahane", "Russel", "Cummins", "Billings", "Mavi", "Narine", "Southee", "Varun",
			"Iyer", "Umesh" };
	public String[] PBKS = { "Mayank", "Gayle", "Bairtow", "Rabada", "Simran", "RahulChahar", "Shahrukh", "Sandeep",
			"KLrahul", "rishi", "Dhawan" };
	public String[] SRH = { "warner", "Willianson", "Bhuvi", "Samad", "Tyagi", "Sundar", "Pooran", "Markram",
			"Abisheik", "Tripati", "Nattu" };
	public String[] DD = { "Pant", "Warner", "Sakaria", "Iyer", "Mandeep", "PrithviShaw", "Sarafaraz", "Ngidi", "Takur",
			"Axar", "Marsh" };
	public String[] RR = { "Buttler", "Samson", "Padikal", "Chahal", "Ryan parag", "Stokes", "Boult", "Ashwin",
			"Hetmyer", "Kuldeep", "Saini" };
	public String[] names = { "RCB", "MI", "CSK", "KKR", "PBKS", "SRH", "DD", "RR" };
	public String[] teamSelection = { "1.RCB", "2.MI", "3.CSK", "4.KKR", "5.PBKS", "6.SRH", "7.DD", "8.RR" };

	public void m1() {
		teamName = new ArrayList<>();
		teamName.add(RCB);
		teamName.add(MI);
		teamName.add(CSK);
		teamName.add(KKR);
		teamName.add(PBKS);
		teamName.add(SRH);
		teamName.add(DD);
		teamName.add(RR);
	}

	public String[] teamSelection1() {
		for (int i = 0; i < teamSelection.length; i++)
			System.out.println(teamSelection[i]);
		int you = scanner.nextInt();
		selectedTeam = you;
		playingTeams[index++] = new TeamDetails(names[you - 1]);

		return teamName.get(you - 1);
	}

	public String[] teamSelection2() {
		for (int i = 0; i < teamSelection.length; i++) {
			if (i == (selectedTeam - 1))
				continue;
			System.out.println(teamSelection[i]);
		}
		int you = scanner.nextInt();
		playingTeams[index++] = new TeamDetails(names[you - 1]);

		return teamName.get(you - 1);
	}

}
