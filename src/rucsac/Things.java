package rucsac;

public class Things {
    private int weight;
    private int price;

    public Things(int weight, int pret) {
        this.weight = weight;
        this.price = pret;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
