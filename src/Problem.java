import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Problem {
    private int n;
    public List<Item> items = new ArrayList<>();
    private int capacity;
    public List<Item> sortedItems = new ArrayList<>();
    public Result result;
    public List<Integer> resultItems = new ArrayList<>();
    public int endWeight;
    public int endValue;

    public Problem(int seed, int n) {
        this.n = n;
        Random random = new Random(seed);
        for (int i = 0; i < n; i++) {
            int v = random.nextInt(9) + 1;
            int w = random.nextInt(9) + 1;
            Item tempItem = new Item(w, v);
            items.add(tempItem);
        }
    }

    public boolean isFitting(Item item) {
        if (item.weight <= capacity) {
            capacity -= item.weight;
            return true;
        }
        return false;
    }

    public Result solve(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative.");
        }

        this.capacity = capacity;
        if (items == null) {
            throw new NullPointerException("List of items cannot be null.");
        }
        sortedItems = new ArrayList<>(items);
        sortedItems.sort(Comparator.comparingDouble(Item::getRatio)
                .reversed()
                .thenComparing(Item::getWeight, Comparator.reverseOrder()));

        int i = 0;
        for (Item item : sortedItems) {
            if (this.capacity == 0) {
                break;
            }
            if (isFitting(item)) {
                resultItems.add(i);
            }
            i++;
        }
        for (int index : resultItems) {
            endValue += sortedItems.get(index).value;
            endWeight += sortedItems.get(index).weight;
        }

        return new Result(resultItems);
    }

    public List<String> getResults() {
        List<String> results = new ArrayList<>();
        for (int index : resultItems) {
            results.add(String.format("no: %d   v: %d   w: %d",
                    index,
                    sortedItems.get(index).value,
                    sortedItems.get(index).weight));
        }
        return results;
    }

    public void seeResult() {
        for (int index : resultItems) {
            System.out.printf("Item number: %d has value: %d and weight: %d%n",
                    index,
                    sortedItems.get(index).value,
                    sortedItems.get(index).weight);
        }
        System.out.printf("Total value: %d, Total weight: %d%n", endValue, endWeight);
    }
}
