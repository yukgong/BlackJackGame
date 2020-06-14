package gameObject;

import java.util.ArrayList;

public class Card {
	// 멤버 변수
//	private String cardNum[][] = new String[13][2]; // 1 ~ 13
	
	private ArrayList<Card> card = new ArrayList<Card>();
	private int cardValue; // 카드가 가지는 값
	private String cardChar; // 카드 구분용 숫자 혹은 알파벳
	private String cardPattern; // 카드 무늬

	public Card(int cardValue, String cardChar, String cardPattern) {
		super();
		this.cardPattern = cardPattern;
		this.cardValue = cardValue;
		this.cardChar = cardChar;
	}
	
	public ArrayList<Card> cardSetting() {

		for (int i = 0; i < 52; i++) {
			cardValue = i % 13 + 1;
			cardChar = i % 13 + 1 + "";

			// 카드 값, 구분 포인트 셋팅
			if (cardChar.equals("1")) {
				cardChar = "A";
			} else if (cardChar.equals("11")) {
				cardValue = 10;
				cardChar = "J";
			} else if (cardChar.equals("12")) {
				cardValue = 10;
				cardChar = "Q";
			} else if (cardChar.equals("13")) {
				cardValue = 10;
				cardChar = "K";
			}

			// 카드 무늬 셋팅
			int num = i / 13; // 0~3
			if (num == 0) {
				cardPattern = "스페이드";
			} else if (num == 1) {
				cardPattern = "다이아";
			} else if (num == 2) {
				cardPattern = "하트";
			} else if (num == 3) {
				cardPattern = "클로버";
			}

			card.add(new Card(cardValue, cardChar, cardPattern));
			
//			for(Card inte : card) {
//				System.out.println(inte);
//			}
		}
		return card;
	}

	//----- setter & getter------
	
	public String getCardChar() {
		return cardChar;
	}

	public void setCardChar(String cardChar) {
		this.cardChar = cardChar;
	}

	public Card() {
	}

	public int getCardValue() {
		return cardValue;
	}

	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}

	public String getCardPattern() {
		return cardPattern;
	}

	public void setCardPattern(String cardPattern) {
		this.cardPattern = cardPattern;
	}

	@Override
	public String toString() {
		return "[cardValue=" + cardValue + ", cardChar=" + cardChar + ", cardPattern="
				+ cardPattern + "]";
	}
	
	
}
