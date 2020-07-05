package gameObject;

public class Card {
	private String pattern;
	private String cardNum;
	private int point;

	public Card() {
	}

	public Card(String pattern, int index) {
		super();
		this.pattern = pattern;
		this.cardNum = this.numberToCardNum(index);
		this.point = this.numToPoint(index);
	}

	// 카드 점수 세팅
	private int numToPoint(int num) {
		if (num >= 11) {
			return 10;
		}
		return num;
	}

	// 끗수 셋팅
	private String numberToCardNum(int num) {
		if (num == 1) {
			return "A";
		} else if (num == 11) {
			return "J";
		} else if (num == 12) {
			return "Q";
		} else if (num == 13) {
			return "K";
		}
		return num + "";
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	@Override
	public String toString() {
		return "| Card = "+ cardNum + ", " + pattern + "\t\t\t  |";
	}

}
