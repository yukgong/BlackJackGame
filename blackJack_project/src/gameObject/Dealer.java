package gameObject;

import java.util.ArrayList;
import java.util.List;

public class Dealer implements Player {
	private List<Card> cards;
	private boolean turn;

	private static final int CAN_RECEIVE_POINT = 16;
	private static final String NAME = "Dealer";

	public Dealer() {
		cards = new ArrayList<Card>();
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	// 카드를 받을 수 있는지 체크하기
	public boolean isReceiveCard() {
		return getPointSum() <= CAN_RECEIVE_POINT;
	}

	// 받은 카드의 포인트 합 구하기
	public int getPointSum() {
		int sum = 0;
		for (Card card : cards) {
			sum += card.getPoint();
		}
		return sum;
	}

	@Override // 카드 받기
	public void receiveCard(Card card) {
		if (this.isReceiveCard()) {
			this.cards.add(card);
		} else {
			System.out.println("카드의 총 합이 17이 넘습니다. 딜러는 더이상 카드를 받을 수 없습니다.");
		}
	}

	@Override
	public void showCards() {
		StringBuilder sb = new StringBuilder();
		sb.append("+----" + NAME + "님의 현재 보유 카드 목록----+\n");

		for (Card card : cards) {
			sb.append(card.toString());
			sb.append("\n");
		}
		sb.append("+---------------------------------+\n");
		System.out.println(sb.toString());
	}

	@Override
	public List<Card> openCards() {
		return this.cards;
	}

	@Override
	public void turnOff() {
		this.setTurn(false);
	}

	@Override
	public void turnOn() {
		this.setTurn(true);
	}

	@Override
	public boolean isTurn() {
		return this.turn;
	}

	@Override
	public String getName() {
		return NAME;
	}
}
