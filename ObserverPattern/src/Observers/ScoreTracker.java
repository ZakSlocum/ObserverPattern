package Observers;

import Interfaces.Observer;

public class ScoreTracker implements Observer {
	
	int homeScore;
	int awayScore;
	int currQuarter;
	String awayTeam;
	String homeTeam;
	
	public ScoreTracker(String home, String away) {
		this.awayTeam = away;
		this.homeTeam = home;
	}
	
	@Override
	public void update(int quarter, int home, int away) {
		this.homeScore = home;
		this.awayScore = away;
		this.currQuarter = quarter;
		
		System.out.println("Quarter: " + currQuarter + ", Current Score\n"
				+ homeTeam + ": " + homeScore + "\n"
				+ awayTeam + ": " +awayScore +"\n");

	}

}
