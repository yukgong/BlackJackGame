package gameObject;

public class Card {
	// 멤버 변수
	private String cardNum[][] = new String[13][2]; // 1 ~ 13
	private int cardPattern; // 카드 무늬

	public void cardNumberSet() {
		for (int i = 0; i < 13; i++) {
			cardNum[i][0] = (i + 1) + ""; // 카드는 인덱스 번호를 가진다.
		}
		
		//예외 카드 셋팅
		for (int i = 1; i < cardNum.length+1; i++) {
			if(cardNum[i][0].equals("1")) { // A
				cardNum[i][1] = "A";
			} else if (cardNum[i][0].equals("1")) {
				cardNum[i][1] = "J";
			} else if (cardNum[i][0].equals("1")) {
				cardNum[i][1] = "J";
			}
		}

		
	}

}
