import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab9 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String cont = "yes";
		ArrayList<String> itemsOrdered = new ArrayList();
		ArrayList<Double> itemPrices = new ArrayList();

		while (cont.equalsIgnoreCase("yes")) {

			Map<String, Double> items = new LinkedHashMap<>();
			items.put("Apples", 0.99);
			items.put("Banana", 0.59);
			items.put("Cauliflower", 1.59);
			items.put("DragonFruit", 2.19);
			items.put("Elderberry", 1.79);
			items.put("Figs", 2.09);
			items.put("GrapeFruit", 1.99);
			items.put("HoneyDew", 3.49);

			System.out.println("Welcome to Q's Market!");
			System.out.println();

			System.out.printf("%-30s", "Item");
			System.out.println("Price");
			System.out.println();
			System.out.println("=======================================");

			System.out.println(displayMenu(items));

			System.out.println("What item would you like to order?");
			String userItem = scan.nextLine();

			itemsOrdered.add(userItem);
			itemPrices.add(items.get(userItem));
			System.out.println("Adding " + userItem + " to cart at $" + itemPrices);

			System.out.println("Would you like to order anything else?");
			cont = scan.nextLine();

			// System.out.println(displayCart(itemsOrdered, itemPrices));
		}

		System.out.println("The highest priced item you bought today was $" + (max(itemPrices)));
		System.out.println("The lowest priced item you bought today was $" + (min(itemPrices)));
		System.out.println("Average price per items ordered was $" + (avgPrice(itemPrices)));

	}
	

	private static double avgPrice(ArrayList<Double> itemPrices) {
		double sum = 0;
		if (!itemPrices.isEmpty()) {
			for (Double mark : itemPrices) {
				sum += mark;
			}
			return sum / itemPrices.size();
		}
		return sum;
	}

	private static double max(ArrayList<Double> itemPrices) {
		double obj = Collections.max(itemPrices);

		return obj;
	}

	private static double min(ArrayList<Double> itemPrices) {
		double obj = Collections.min(itemPrices);

		return obj;
	}

	private static String displayMenu(Map<String, Double> items) {
		StringBuilder result = new StringBuilder();
		for (String key : items.keySet()) {

			result.append(key + " $" + items.get(key) + "\n");
		}
		return result.toString();
	}

}
