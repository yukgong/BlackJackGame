package gameObject;

import java.util.ArrayList;

public class CardDeck {
	private ArrayList<Card> randomCard = new ArrayList<Card>();
	boolean rSwitch[] = new boolean[52]; // 중복 체크
	
	public CardDeck() {
		Card card = new Card();
		card.cardSetting();
		
		//랜덤하게 카드 섞기
		for (int i = 0; i < rSwitch.length; i++) {
			rSwitch[i] = false;
		}
		
		for (int i = 0; i < rSwitch.length; i++) {
			int r = (int)(Math.random()*52);
			if(rSwitch[i] == false) {
				rSwitch[i] = true;
				randomCard.add(i, card.cardSetting().get(r));
			}
		}
		
		//test 출
		for(int i = 0; i < randomCard.size(); i++) {
			System.out.println(i + ":"+ randomCard.get(i));
		}
	}
}
