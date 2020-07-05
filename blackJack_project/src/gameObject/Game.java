package gameObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

	public void play() {

		// 게임 생성시 클래스 인스턴스 생성
		Scanner sc = new Scanner(System.in);
		System.out.println("+---------BlackJack Game---------+\n");
		System.out.println("블랙잭은 딜러와 플레이어중 카드의 합이 21 또는");
		System.out.println("그에 준하는 숫자를 가지는 쪽이 이기는 게임입니다.\n");
		GameRule rule = new GameRule();
		CardDeck cardDeck = new CardDeck();

		// 게임 플레이시
		List<Player> players = Arrays.asList(new Gamer("Gamer"), new Dealer());
		List<Player> initAfterPlayers = initPhase(cardDeck, players);
		List<Player> playingAfterPlayers = receiveCardAllPlayers(sc, cardDeck, initAfterPlayers);

		Player winner = rule.getWinner(playingAfterPlayers);
		System.out.println("===================================");
		System.out.println("Winner : " + winner.getName());
		System.out.println("===================================");
	}

	// Player면 hit시 카드를 한장 뽑고 카드 연산하기
	private List<Player> receiveCardAllPlayers(Scanner sc, CardDeck cardDeck, List<Player> players) {
		boolean playtrue[] = new boolean[2];

		for (int i = 0; i < playtrue.length; i++) {
			playtrue[i] = true;
		}

		int w = 0;
		for (Player player : players) {
			String name = player.getName();

			while (true) {
				System.out.println(player.getName() + "님 차례입니다.");

				if (player instanceof Dealer) {
					Card card = cardDeck.draw();
					if (getScore(player.openCards()) > 17) {
						System.out.println("카드의 총 합이 17이 넘습니다. 더이상 카드를 받을 수 없습니다.");
						player.showCards();
						break;
					} else if (getScore(player.openCards()) < 17) {
						System.out.println("카드의 총 합이 17이 넘지 않아 새로운 카드를 뽑습니다.\n");
						player.receiveCard(card);
						player.showCards();
						player.turnOn();

						if (getScore(player.openCards()) > 21) {
							int score = getScore(player.openCards());
							System.out.println("BUST!");
							System.out.println(player.getName() + "님의 카드의 합은 " + score + "점으로 21점이 넘었습니다.\n");
							return players;

						} else if (getScore(player.openCards()) == 21) {
							System.out.println("BLACK JACK!!!");
							System.out.println("축하합니다. " + player.getName() + "님의 승리입니다.\n");
							return players;
						}
						continue;
					}
				}

				// hit면 카드를 한장 뽑기
				if (player instanceof Gamer && isReceiveCard(sc)) {
					Card card = cardDeck.draw();
					player.receiveCard(card);
					player.showCards();
					player.turnOn();

					if (getScore(player.openCards()) > 21) {
						int score = getScore(player.openCards());
						System.out.println("BUST!");
						System.out.println(player.getName() + "님의 카드의 합은 " + score + "점으로 21점이 넘었습니다.\n");
						return players;

					} else if (getScore(player.openCards()) == 21) {
						System.out.println("BLACK JACK!!!");
						System.out.println("축하합니다. " + player.getName() + "님의 승리입니다.\n");
						return players;
					}
					continue;
					// stay면 각자의 턴을 true로 바꾸고 턴 종료
				} else {
					player.turnOff();
					playtrue[w] = false;
					break;
				}
			}
			if (!playtrue[0] && !playtrue[1]) {
				break;
			}
			w++;
			continue;
		}

		return players;
	}

	// 최초에 카드 2장 세팅하기
	private static final int INIT_RECEIVE_CARD_COUNT = 2;

	private List<Player> initPhase(CardDeck cardDeck, List<Player> players) {
		Card card;

		System.out.println("그럼, 각자 처음 2장의 카드를 뽑겠습니다.\n");
		for (int i = 0; i < INIT_RECEIVE_CARD_COUNT; i++) {
			for (Player player : players) {
				card = cardDeck.draw();
				player.receiveCard(card);
			}
		}

		for (Player player : players) {
			if (player instanceof Dealer) {
				System.out.println("test");
			}
			player.showCards();
		}
		return players;
	}

	// Method for Method ---------------------------------------------

	// 점수 확인
	public int getScore(List<Card> cards) {
		int sum = 0;

		for (Card card : cards) {
			sum += card.getPoint();
		}
		return sum;
	}

	// hit or stay 물어보기
	private static final String STOP_RECEIVE_CARD = "2";

	private boolean isReceiveCard(Scanner sc) {
		String playerInput;

		while (true) {
			// hit or stay 물어보기
			System.out.print("1.HIT or 2.STAY? : ");

			playerInput = sc.nextLine();
			System.out.println();

			if (!(playerInput.equals("1") || playerInput.equals("2"))) {
				System.out.println("잘못입력했습니다. 숫자 1과 2만 입력가능합니다.");
				continue;
			}
			break;
		}
		return !STOP_RECEIVE_CARD.equals(playerInput);
	}

}
