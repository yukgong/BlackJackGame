package gameObject;

import java.util.List;

public interface Player {
	void receiveCard(Card card);
	void showCards();
	List<Card> openCards();
	
	String getName();
	
	void turnOff();
	void turnOn();
	boolean isTurn();
}
