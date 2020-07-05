package gameObject;

import java.util.List;

public class GameRule {
	private int rule;

	public GameRule() {
	}

	// 점수 확인
	public int getScore(List<Card> cards) {
		int sum = 0;

		for (Card card : cards) {
			sum += card.getPoint();
		}
		return sum;
	}

	// 승자 판단하기
	public Player getWinner(List<Player> players) {
		Player winner = null;
		int winnerScore = 0;
		
		for (int i = 0; i < players.size()-1; i++) {
			for (int j = i + 1; j < players.size(); j++) {
				int gamerScore = getScore(players.get(i).openCards());
				int dealerScore = getScore(players.get(j).openCards());
				if (gamerScore == dealerScore) {
					return winner;
				} else {
					for (Player player : players) {
						int playerScoreSum = getScore(player.openCards());
						if (playerScoreSum > winnerScore && playerScoreSum <= 21) {
							winner = player;
							winnerScore = playerScoreSum;
						}
					}
				}
			}
		}

		return winner;
	}
}
