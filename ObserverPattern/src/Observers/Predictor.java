package Observers;

import java.util.Random;

import Interfaces.Observer;

public class Predictor implements Observer {

	int homeScore;
	int awayScore;
	int homePrediction;
	int awayPrediction;
	int currQuarter;
	int correctGuesses;
	String awayTeam;
	String homeTeam;
	Random random = new Random();
	
	public Predictor(String home, String away) {
		this.awayTeam = away;
		this.homeTeam = home;
	}
	
	@Override
	public void update(int quarter, int home, int away) {
		this.homeScore = home;
		this.awayScore = away;
		this.currQuarter = quarter;
		
		
		if(currQuarter < 4) {
			homePrediction = homeScore + random.nextInt(10 - 2 * currQuarter) * currQuarter;
			awayPrediction = awayScore + random.nextInt(10 - 2 * currQuarter) * currQuarter;

			System.out.println("Current Prediction\n"
					+ homeTeam + ": " + homePrediction +"\n"
					+ awayTeam + ": " + awayPrediction +"\n");
			
			if(homePrediction == homeScore && awayPrediction == awayScore) {
				correctGuesses++;
			}
			
		} else {
			System.out.println("Final Prediction\n"
					+ homeTeam + ": " + homePrediction +"\n"
					+ awayTeam + ": " + awayPrediction +"\n");
			
			System.out.println("Correct Predictions: " + correctGuesses +"\n");
		}
		
	}

}
