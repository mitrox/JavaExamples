import java.util.ArrayList;
import java.util.List; 
import java.util.Random;
import java.util.Scanner;

public class Poker {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		List<Integer> deck = new ArrayList<>();
		for (int i = 0; i < 52; i++)
			deck.add(i);
		System.out.print("Колко играча ще участват? (2-8) ");
		int numPlayers = Integer.parseInt(input.nextLine());

		drawFor("Вашата ръка:", 2, deck);
		for (int i = 0; i < numPlayers - 1; i++)
			drawFor("\nРъка на Противник" + " " + (i + 1) + ": ", 2, deck);
		System.out.println();
		drawFor("Флоп:", 3, deck);
		drawFor("Търн:", 1, deck);
		drawFor("Ривър:", 1, deck);
	}

	// теглене на карта и показването и
	public static void drawFor(String label, int n, List<Integer> deck) {
		System.out.print(label + " ");
		for (int i = 0; i < n; i++) {
			int card = drawCard(deck);
			System.out.print(asString(card));
			if (i < n - 1)
				System.out.print(", ");
		}
		System.out.println();
	}

	// теглене на карта, премахване от тестето и изтриване
	public static int drawCard(List<Integer> deck) {
		Random rng = new Random();
		int r = rng.nextInt(deck.size());
		int card = deck.get(r);
		deck.remove(r);
		return card;
	}

	// integer ( за картите [0...52] ) към string
	public static String asString(int card) {
		String[] suits = new String[] { "Пика", "Спатия", "Каро", "Купа" };
		String[] ranks = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Вале", "Дама", "Поп", "Асо" };
		return ranks[card % 13]+ " "  + suits[card / 13];
	}
}