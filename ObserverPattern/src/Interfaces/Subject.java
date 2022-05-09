package Interfaces;

public interface Subject {

	public void registerObserver(Observer observer);
	public void deregisterObserver(Observer observer);
	public void notifyObservers();
	
}
