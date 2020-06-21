package gameObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CardDeck {
	private static final int CARD_COUNT = 13; // 카드 한 묶음의 갯수
	private static final String[] PATTERNS = { "스페이드", "하트", "다이아몬드", "클로버" }; // 카드모양

	private List<Card> cards;

	// 카드덱이 생성되는 시점에 랜덤으로 섞인 중복되지 않은 카드가 만들어진다
	public CardDeck() {
		cards = this.generateCards();
	}

	public Card getCard() {
		return null;
	}
	
	// 카드 리스트 생성
	private List<Card> generateCards(){
		List<Card> cards = new LinkedList<>();

		// 카드의 무늬와, 끗수, 점수 생성
		for (String pattern : PATTERNS) {
			for (int i = 1; i <= CARD_COUNT; i++) {
				Card card = new Card(pattern, i);
				cards.add(card);
			}
		}
		return cards;
	}
	
	
	//남아 있는 카드 중 1개를 뽑는다.
	public Card draw() {
		Card selectedCard = getRandomCard();
		cards.remove(selectedCard);
		return selectedCard;
	}
	
	private Card getRandomCard() {
		int size = cards.size();
		int select = (int)(Math.random()*size);
		return cards.get(select);
	}
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (Card card : cards) {
			sb.append(card.toString());
			sb.append("\n");
		}
		return sb.toString();
	}

	
}
