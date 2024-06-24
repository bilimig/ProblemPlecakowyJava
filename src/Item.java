
public class Item {
    public int weight;
    public int value;
    public double ratio;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.ratio = (double) value / weight;
    }

    public double getRatio() {
        return ratio;
    }

    public int getWeight() {
        return weight;
    }
}