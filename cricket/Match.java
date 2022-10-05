package cricket;

import java.util.*;

public class Match {
	public ArrayList<ArrayList<String>> summary1;
	public ArrayList<ArrayList<String>> summary2;
	int index;
	int score;
	int wickets;
	int target = Integer.MAX_VALUE;
	int position = 0;
	boolean chase=false;
	PlayerData[] batsmanOnField = new PlayerData[2];
	ArrayList<String> overStatus;
	Scanner scanner = new Scanner(System.in);
	Random r = new Random();

	public void startInnings(ArrayList<PlayerData> battingTeam, ArrayList<PlayerData> bowlingTeam, int overs) throws InterruptedException {
		summary1 = new ArrayList<ArrayList<String>>();
		summary2 = new ArrayList<ArrayList<String>>();
		overStatus = new ArrayList<>();
		index = 0;
		score = 0;
		wickets = 0;
		batsmanOnField[0] = battingTeam.get(index++);
		batsmanOnField[1] = battingTeam.get(index++);

		//FIRST INNINGS..........
		
		for (int over = 0; over < overs; over++) {
			if (wickets == 10) {
				print(score, wickets);
				break;
			}
			print(score, wickets);
			printCurrentUpdate(batsmanOnField[0], batsmanOnField[1]);
			PlayerData currentBowler = bowlingTeam.get(r.nextInt(bowlingTeam.size()));
			runUpdater(currentBowler, batsmanOnField, battingTeam);
			swap(batsmanOnField);
			ArrayList<String> clone=(ArrayList<String>)overStatus.clone();
			summary1.add(clone);

			overStatus.clear();

		}
		System.out.println("\n");
		Teams.playingTeams[0].setScore(score);
		Teams.playingTeams[0].setWickets(wickets);
		

		
		index = 0;
		score = 0;
		wickets = 0;
		System.out.println("\n end of the first innings");
		System.out.println("-----------------------------");
	
		target=Teams.playingTeams[0].getScore();
		System.out.println("TARGET IS :" + (Teams.playingTeams[0].getScore() + 1));
		batsmanOnField[0] = bowlingTeam.get(index++);
		batsmanOnField[1] = bowlingTeam.get(index++);
		swapp(Teams.playingTeams);
		System.out.println("Second Innings Will Begin IN");
		for(int i=5;i>0;i--) {
			System.out.println(i+" secs");
			Thread.sleep(1500);
		}
		print(score, wickets);
		
		//SECOND  INNINGS.......
		
		for (int over = 0; over < overs; over++) {
			if(chase)break;
			if (wickets == 10) {
				print(score, wickets);
				break;
			}
			PlayerData currentBowler = battingTeam.get(r.nextInt(battingTeam.size()));
			runUpdater(currentBowler, batsmanOnField, bowlingTeam);
			swap(batsmanOnField);
			ArrayList<String> clone=(ArrayList<String>)overStatus.clone();
			summary2.add(clone);

			overStatus.clear();
		}
		Teams.playingTeams[0].setScore(score);
		Teams.playingTeams[0].setWickets(wickets);
		if(Teams.playingTeams[0].getScore()<Teams.playingTeams[1].getScore()) {
			System.out.println(Teams.playingTeams[1].getName()+"  Won By  "+(Teams.playingTeams[1].getScore()-Teams.playingTeams[0].getScore())+"  Runs ");
		}
		System.out.println("\n End Of The Second Innings");
		System.out.println("----------------------------- \n \n");
		
		System.out.println("Innings Summary Will Be Displayed IN :");
		for(int i=5;i>0;i--) {
			System.out.println(i+" secs");
			Thread.sleep(1500);
		}
		System.out.println("Ist Innings : "+Teams.playingTeams[1].getName()+" - "+Teams.playingTeams[1].getScore()+"/"+Teams.playingTeams[1].getWickets());
		
		printSummary(summary1);
		System.out.println("\n \n");
		System.out.println("2nd Innings   :    "+Teams.playingTeams[0].getName()+" - "+Teams.playingTeams[0].getScore()+"/"+Teams.playingTeams[0].getWickets());
		printSummary(summary2);

	}

	private void runUpdater(PlayerData currentBowler, PlayerData[] batsmanOnField, ArrayList<PlayerData> battingTeam) {
		int count = 1;
		while (count <= 6) {
			System.out.println("update current ball status (0,1,2,3,4,6,WD,W,NB):");
			String current_ball = scanner.next().toUpperCase();
			switch (current_ball) {
			case "0": {
				overStatus.add(current_ball);
				count++;
				batsmanOnField[0].setBallFaced((batsmanOnField[0].getBallFaced()) + 1);
				print(score, wickets);
				printCurrentUpdate(batsmanOnField[0], batsmanOnField[1]);
				printThisOver(overStatus);
			}
				break;
			case "1": {
				score += 1;
				if (score > target) {
					System.out.println(Teams.playingTeams[0].getName() + "  WON BY  " + (12 - index ) + "  WICKETS ");
					chase=true;
					return;
				}
				overStatus.add(current_ball);
				count++;
				
				batsmanOnField[0].setBallFaced((batsmanOnField[0].getBallFaced()) + 1);
				batsmanOnField[0].setRunsScored((batsmanOnField[0].getRunsScored()) + 1);
				swap(batsmanOnField);
				print(score, wickets);
				printCurrentUpdate(batsmanOnField[0], batsmanOnField[1]);
				printThisOver(overStatus);
			}
				break;
			case "2": {
				score += 2;
				if (score > target) {
					System.out.println(Teams.playingTeams[0].getName() + "  WON BY  " + (12 - index ) + "  WICKETS ");
					chase=true;
					return;
				}
				overStatus.add(current_ball);
				count++;
				
				batsmanOnField[0].setBallFaced((batsmanOnField[0].getBallFaced()) + 1);
				batsmanOnField[0].setRunsScored((batsmanOnField[0].getRunsScored()) + 2);
				print(score, wickets);
				printCurrentUpdate(batsmanOnField[0], batsmanOnField[1]);
				printThisOver(overStatus);
			}
				break;
			case "3": {
				score += 3;
				if (score > target) {
					System.out.println(Teams.playingTeams[0].getName() + "  WON BY  " + (12 - index ) + "  WICKETS ");
					chase=true;
					return;
				}
				overStatus.add(current_ball);
				count++;
				batsmanOnField[0].setBallFaced((batsmanOnField[0].getBallFaced()) + 1);
				batsmanOnField[0].setRunsScored((batsmanOnField[0].getRunsScored()) + 3);
				swap(batsmanOnField);
				print(score, wickets);
				printCurrentUpdate(batsmanOnField[0], batsmanOnField[1]);
				printThisOver(overStatus);
			}
				break;
			case "4": {
				score += 4;
				if (score > target) {
					System.out.println(Teams.playingTeams[0].getName() + "  WON BY  " + (12 - index ) + "  WICKETS ");
					chase=true;
					return;
				}
				overStatus.add(current_ball);
				count++;
			
				batsmanOnField[0].setBallFaced((batsmanOnField[0].getBallFaced()) + 1);
				batsmanOnField[0].setRunsScored((batsmanOnField[0].getRunsScored()) + 4);
				batsmanOnField[0].setFours((batsmanOnField[0].getFours()) + 1);
				print(score, wickets);
				printCurrentUpdate(batsmanOnField[0], batsmanOnField[1]);
				printThisOver(overStatus);

			}
				break;
			case "6": {
				score += 6;
				if (score > target) {
					System.out.println(Teams.playingTeams[0].getName() + "  WON BY  " + (12 - index ) + "  WICKETS ");
					chase=true;
					return;
				}
				overStatus.add(current_ball);
				count++;
			
				batsmanOnField[0].setBallFaced((batsmanOnField[0].getBallFaced()) + 1);
				batsmanOnField[0].setRunsScored((batsmanOnField[0].getRunsScored()) + 6);
				batsmanOnField[0].setSix((batsmanOnField[0].getSix()) + 1);
				print(score, wickets);
				printCurrentUpdate(batsmanOnField[0], batsmanOnField[1]);
				printThisOver(overStatus);
			}
				break;
			case "WD": {
				score += 1;
				if (score > target) {
					System.out.println(Teams.playingTeams[0].getName() + "  WON BY  " + (12 - index ) + "  WICKETS ");
					chase=true;
					return;
				}
				overStatus.add(current_ball);
				
				print(score, wickets);
				printCurrentUpdate(batsmanOnField[0], batsmanOnField[1]);
				printThisOver(overStatus);
			}
				break;
			case "NB": {
				score+=1;
				if (score > target) {
					System.out.println(Teams.playingTeams[0].getName() + "  WON BY  " + (12 - index ) + "  WICKETS ");
					chase=true;
					return;
				}
			}
				break;
			case "W": {
				overStatus.add(current_ball);
				count++;
				if (index < battingTeam.size()) {
					batsmanOnField[0].setBallFaced((batsmanOnField[0].getBallFaced()) + 1);
					batsmanOnField[0] = battingTeam.get(index++);
					print(score, ++wickets);
					printCurrentUpdate(batsmanOnField[0], batsmanOnField[1]);
					printThisOver(overStatus);
				} else {
					print(score, ++wickets);
					printCurrentUpdate(batsmanOnField[0], batsmanOnField[1]);
					printThisOver(overStatus);
					return;
				}
			}
				break;
			default:
				System.out.println("enter correct input");

			}

		}

	}

	private void printCurrentUpdate(PlayerData striker, PlayerData nonStriker) {
		System.out.printf("%-10s %-5s %-5s %-5s %-5s", "name", "runs", "balls", "fours", "six");
		System.out.println();
		System.out.printf("%-10s %-5s %-5s %-5s %-5s", striker.getName(), striker.getRunsScored(),
				striker.getBallFaced(), striker.getFours(), striker.getSix());
		System.out.println();
		System.out.printf("%-10s %-5s %-5s %-5s %-5s", nonStriker.getName(), nonStriker.getRunsScored(),
				nonStriker.getBallFaced(), nonStriker.getFours(), nonStriker.getSix());
		System.out.println();
	}

	private void printThisOver(List<String> overStatus) {
		System.out.print("THIS OVER :  ");
		for (String s : overStatus)
			System.out.print(s + " ");
		System.out.println();
	}

	private void print(int score2, int wickets) {
		System.out.println(Teams.playingTeams[0].getName() + "   " + score2 + "/" + wickets);
	}

	private void swapp(TeamDetails[] playingTeams) {
		var temp = playingTeams[0];
		playingTeams[0] = playingTeams[1];
		playingTeams[1] = temp;
	}

	// method for printing summary
	public void printSummary(ArrayList<ArrayList<String>> summary) {
        int over=1;
		for (int i = 0; i < summary.size(); i++) {
			
			// printMatchSummary(list);
			ArrayList<String> temp = summary.get(i);
			System.out.print("Over "+ over+"   ");
			for (String s : temp) {
				System.out.print(s + " ");
			}over++;
			System.out.println();
		}
	}

	private void swap(Object[] batsmanOnField) {
		var temp = batsmanOnField[0];
		batsmanOnField[0] = batsmanOnField[1];
		batsmanOnField[1] = temp;
	}

}