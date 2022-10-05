package cricket;

public class PlayerData {
	private String name;
	private int ballFaced;
	private int fours;
	private int six;
	private int runsScored;
	private int wickets;
	private int overBowled;

	public int getFours() {
		return fours;
	}

	public void setFours(int fours) {
		this.fours = fours;
	}

	public int getSix() {
		return six;
	}

	public void setSix(int six) {
		this.six = six;
	}

	public PlayerData(String s) {
		this.name = s;
	}

	public int getBallFaced() {
		return ballFaced;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBallFaced(int ballFaced) {
		this.ballFaced = ballFaced;
	}

	public int getRunsScored() {
		return runsScored;
	}

	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public int getOverBowled() {
		return overBowled;
	}

	public void setOverBowled(int overBowled) {
		this.overBowled = overBowled;
	}

}