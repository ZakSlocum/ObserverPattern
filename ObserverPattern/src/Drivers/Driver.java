package Drivers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Observers.NewsReport;
import Observers.Predictor;
import Observers.ScoreTracker;

public class Driver {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter Home Team: ");
		String homeName = br.readLine();
		System.out.println("Enter Away Team: ");
		String awayName = br.readLine();
		System.out.println("Enter quarter length in minutes: ");
		int quarterLength = Integer.parseInt(br.readLine());
		
		ScoreTracker scoreTracker = new ScoreTracker(homeName, awayName);
		Predictor predictor = new Predictor(homeName, awayName);
		NewsReport newsReport = new NewsReport(homeName, awayName);
		
		Game game = new Game(homeName, awayName, quarterLength);
		
		game.registerObserver(scoreTracker);
		game.registerObserver(predictor);
		game.registerObserver(newsReport);
		
		game.startGame();
		

	}

}
