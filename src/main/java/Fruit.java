public enum Fruit {
    Apple(60),
    Orange(25);

    private int price;

    public int getPrice() {
        return this.price;
    }

    Fruit(int price) {
        this.price = price;
    }
}