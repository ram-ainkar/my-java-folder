
import java.util.Scanner;

class Item {

    int weight;
    int value;

    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class FractionalKnapsack {

    // Function to get the maximum value in the knapsack
    public static double getMaxValue(Item[] items, int capacity) {
        // Sort items by value/weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

        double totalValue = 0.0;  // Total value accumulated
        int currentWeight = 0;    // Current weight in knapsack

        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                // Take the whole item
                currentWeight += item.weight;
                totalValue += item.value;
            } else {
                // Take only a fraction of the item
                int remaining = capacity - currentWeight;
                totalValue += item.value * ((double) remaining / item.weight);
                break; // Knapsack is full
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        System.out.println("Enter weight and value for each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " - Weight: ");
            int weight = sc.nextInt();
            System.out.print("Item " + (i + 1) + " - Value: ");
            int value = sc.nextInt();
            items[i] = new Item(weight, value);
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        double maxValue = getMaxValue(items, capacity);
        System.out.printf("\nMaximum value that can be obtained = %.2f\n", maxValue);

        sc.close(); // Close scanner
    }
}
