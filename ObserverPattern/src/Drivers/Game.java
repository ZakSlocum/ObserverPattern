package Drivers;

import java.util.ArrayList;
import java.util.Iterator;

import Interfaces.Observer;
import Interfaces.Subject;

public class Game implements Subject {
	
	ArrayList<Observer> observerList;
	
	public Game() {
		
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
			observer.update();
		}

	}

}
