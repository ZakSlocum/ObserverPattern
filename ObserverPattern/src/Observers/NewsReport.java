package Observers;

import Interfaces.Observer;

public class NewsReport implements Observer {

	int homeScore;
	int awayScore;
	int currQuarter;
	String awayTeam;
	String homeTeam;
	
	public NewsReport(String home, String away) {
		this.awayTeam = away;
		this.homeTeam = home;
	}
	
	@Override
	public void update(int quarter, int home, int away) {
		this.homeScore = home;
		this.awayScore = away;
		this.currQuarter = quarter;
		
		if(currQuarter >= 4) {
			System.out.println("BREAKING NEWS\n");
			if(homeScore > awayScore) {
				System.out.println(homeTeam + " snags the win from " + awayTeam + " by " + (homeScore - awayScore) +" points, really showing that home advantage!");
			} else {
				System.out.println(awayTeam + " secures victory against " + homeTeam + " by " + (awayScore - homeScore) +" points, shutting them down on their home turf!");
			}
		}

	}

}
