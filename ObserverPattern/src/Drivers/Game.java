package Drivers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import Interfaces.Observer;
import Interfaces.Subject;

public class Game implements Subject {
	
	private String awayTeam;
	private String homeTeam;
	private int homeScore = 0;
	private int awayScore = 0;
	private int currQuarter;
	private int quarterLength;
	private ArrayList<Observer> observerList;
	private Random rand = new Random();
	
	public Game(String homeTeam, String awayTeam, int quarterLength) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.quarterLength = quarterLength;
		observerList  = new ArrayList<Observer>();
	}
	
	public void startGame() {
		for(int q = 1; q < 5; q++) {
			currQuarter = q;
			homeScore += createScore(q);
			awayScore += createScore(q);
			notifyObservers();
		}
	}

	private int createScore(int q) {
		
		return (int) rand.nextInt(10 - q) * q;
	}

	@Override
	public void registerObserver(Observer observer) {
		observerList.add(observer);

	}

	@Override
	public void deregisterObserver(Observer observer) {
		observerList.remove(observerList.indexOf(observer));

	}

	@Override
	public void notifyObservers() {
		for (Iterator<Observer> iter = observerList.iterator(); iter.hasNext();) {
			Observer observer = iter.next();
			observer.update(currQuarter, homeScore, awayScore);
		}

	}

}
